package dtcc.itn261.assignment11;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class FormController {

    @FXML
    public TextField zipCodeField;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField phoneTextField;
    @FXML
    private DatePicker birthdayDatePicker;
    @FXML
    private TextField emailTextField;
    @FXML
    private TextField streetAddressTextField;
    @FXML
    private TextField cityTextField;
    @FXML
    private StatesChoiceBox statesChoiceBox;
    @FXML
    private TextArea notesTextArea;
    @FXML
    private CustomButtons clearButton;
    @FXML
    private CustomButtons submitButton;
    private UtilityFunctions utilityLogic;

    @FXML
    protected void initialize() {
        List<Object> textFields = Arrays.asList(nameTextField, phoneTextField, birthdayDatePicker, emailTextField, streetAddressTextField,
                cityTextField, zipCodeField, notesTextArea
        );// moving text fields into an array only works like this not when its collection why can't it pass the method??

        this.utilityLogic = new UtilityFunctions(statesChoiceBox, textFields);

        clearButton.setOnAction(e -> utilityLogic.clearForm());

        submitButton.setOnAction(e -> {
            if (validateFormData()) {
                try {
                    utilityLogic.saveForm(returnFormData());
                    AlertUtility.fileSavedAlert();
                    utilityLogic.clearForm();
                } catch (IOException ex) {
                    AlertUtility.pathNotFound(); // Instead of throwing RuntimeException
                }
            }
        });
    }

    protected FormData returnFormData() {
        FormDataCollector collectionOfInputData = new FormDataCollector();

        return collectionOfInputData.collectFormData(nameTextField, phoneTextField, birthdayDatePicker, emailTextField,
                streetAddressTextField, cityTextField, statesChoiceBox, zipCodeField, notesTextArea);
    }

    private boolean isValidDate(LocalDate birthdayDatePicker) { //STILL MESSING UP
        return birthdayDatePicker != null;
    }


    private boolean isValidEmail(String email) {
        String emailRegex = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}";
        return email.matches(emailRegex);
    }

    private boolean isValidPhone(String phone) {
        String phoneRegex = "\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\) \\d{3}-\\d{4}";
        return phone.matches(phoneRegex);
    } //"^((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$"); try this

    private boolean isValidZipCode(String zipCode) { // works
        String zipRegex = "^\\d{5}[-\\s]?(?:\\d{4})?$";
        return zipCode.matches(zipRegex);
    }

    private boolean isEmpty(String input) {
        return input == null || input.trim().isEmpty();
    }

    private boolean isNotSelected(String states) {
        return Objects.equals(states, "Select A State");
    }

    // trace date picker
    private boolean validateFormData() {
        if (isEmpty(nameTextField.getText()) || isEmpty(streetAddressTextField.getText()) || isEmpty(cityTextField.getText()) ||
                isEmpty(zipCodeField.getText()) || isNotSelected(statesChoiceBox.getValue()) || isEmpty(phoneTextField.getText())) { // missing any?
            AlertUtility.missingInformationAlert();
            return false;
        } else if (!isValidEmail(emailTextField.getText())) {
            AlertUtility.invalidEmailAlert();
            return false;
        } else if (!isValidDate(birthdayDatePicker.getValue())) { //will not show alert for invalid date but will save with empty
            AlertUtility.invalidDateAlert(); // Show an alert for invalid date format
            return false;
        } else if (!isValidPhone(phoneTextField.getText())) {
            AlertUtility.invalidPhoneAlert();
            return false;
        } else if (!isValidZipCode(zipCodeField.getText())) {
            AlertUtility.invalidZipCodeAlert();
            return false;
        } else {
            return true;  //switch statement???
        }
    }

    public void closeProgram() {
        Platform.exit();
    }

    public void showHelp() {
        AlertUtility.helpMenu();
    }
}

