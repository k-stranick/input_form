module dtcc.itn.assignment {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens dtcc.itn261.assignment11 to javafx.fxml;
    exports dtcc.itn261.assignment11;
}