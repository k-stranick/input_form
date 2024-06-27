package dtcc.itn261.assignment11;

import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FormDataCollector {
    public FormData collectFormData(TextField nameTextField, TextField phoneTextField, DatePicker birthdayDatePicker, TextField emailTextField,
                                    TextField streetAddressTextField, TextField cityTextField, StatesChoiceBox statesChoiceBox, TextField zipCodeField,
                                    TextArea notesTextArea) {
        FormData formData = new FormData();

        formData.setName(nameTextField.getText());
        formData.setPhone(phoneTextField.getText());
        formData.setBirthday(birthdayDatePicker.getValue()); // And so on for other fields
        formData.setEmail(emailTextField.getText());
        formData.setAddress(streetAddressTextField.getText());
        formData.setCity(cityTextField.getText());
        formData.setState(statesChoiceBox.getValue());
        formData.setZipCode(zipCodeField.getText());
        formData.setNotes(notesTextArea.getText());

        return formData;
    }
}
