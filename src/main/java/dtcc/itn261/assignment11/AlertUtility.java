package dtcc.itn261.assignment11;

import javafx.scene.control.Alert;

public class AlertUtility {
    public static void showFileNotFoundAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("File Error");
        alert.setHeaderText("File Not Found");
        alert.setContentText("The file you are trying to access does not exist.");
        alert.showAndWait();
    }

    public static void showIOAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("IO Error");
        alert.setHeaderText("Error Writing File");
        alert.setContentText("An error occurred while writing the file");
        alert.showAndWait();
    }

    public static void pathNotFound() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("IO Error");
        alert.setHeaderText("Error locating File");
        alert.setContentText("An error occurred while locating the file");
        alert.showAndWait();
    }

    public static void missingInformationAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText("Missing Information\nPlease fill in all required fields.");
        alert.show();
    }

    public static void fileCreatedAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Confirmation");
        alert.setContentText("File created in java project file path: \nsrc/main/resources");
        alert.showAndWait();
    }

    public static void fileSavedAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("File saved");
        alert.showAndWait();
    }

    public static void invalidEmailAlert() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setContentText("Invalid Email\nPlease enter a valid email address.");
        alert.show();
    }

    public static void invalidPhoneAlert() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setContentText("Invalid Phone Number\nPlease enter a valid phone number.");
        alert.show();
    }

    public static void invalidZipCodeAlert() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setContentText("Invalid Zip Code\nPlease enter a valid Zip Code.");
        alert.show();
    }

    public static void invalidDateAlert() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setContentText("Invalid Date\nPlease enter a valid day MM/dd/yyyy.");
        alert.show();
    }

    public static void helpMenu() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("I will add this one day");
        alert.show();
    }
}
