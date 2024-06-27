package dtcc.itn261.assignment11;

import javafx.scene.control.DatePicker;
import javafx.scene.control.TextInputControl;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class UtilityFunctions {
    private final File FILE_PATH = new File("src/main/resources/test.csv");
    private final StatesChoiceBox statesChoiceBox;
    private final List<Object> textFields;

    public UtilityFunctions(StatesChoiceBox statesChoiceBox, List<Object> textFields) {
        this.statesChoiceBox = statesChoiceBox;
        this.textFields = textFields;
    }

    private static String getFormattedCsvString(FormData formData) {
        String dateString = (formData.getBirthday() != null) ? formData.getBirthday().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) : "";

        String csvLine;
        csvLine = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s\n",
                formData.getName(),
                formData.getPhone(),
                dateString,
                formData.getEmail(),
                formData.getAddress(),
                formData.getCity(),
                formData.getState(),
                formData.getZipCode(),
                formData.getNotes());

        return csvLine;
    }

    public void clearForm() {
        statesChoiceBox.setValue(States.SELECTION.toString());
        for (Object textField : textFields) {
            if (textField instanceof TextInputControl) { //https://www.baeldung.com/java-instanceof
                ((TextInputControl) textField).clear();
            } else if (textField instanceof DatePicker) {
                ((DatePicker) textField).setValue(null);
            }
        }
    }

    // TODO: try with resources and pass array of field names to save lines
    public void saveForm(FormData formData) throws IOException {
        checkFileAvailability(FILE_PATH);
        String csvLine = getFormattedCsvString(formData);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) { // Append mode
            writer.write(csvLine); // Append the new line to the CSV
        } catch (IOException e) {
            AlertUtility.showIOAlert();
            // Handle exceptions (show error dialog or log)
        }
    }

    private void checkFileAvailability(File FILE_PATH) throws IOException {
        if (!FILE_PATH.exists()) {
            boolean fileCreated = FILE_PATH.createNewFile();
            if (!fileCreated) {
                AlertUtility.showFileNotFoundAlert();
            }
            AlertUtility.fileCreatedAlert();
        }

    }

}

