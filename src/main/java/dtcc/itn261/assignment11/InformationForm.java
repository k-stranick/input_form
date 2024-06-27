/**==================================================
 Author: Kyle Stranick
 Class: ITN261
 Class Section: 201
 4/6/24
 Assignment: 11 - Data Entry Form
 Notes:
 need to go back over this summer
 expand menu bar
 fix time issue
 split logic better
 =====================================================

 Code adapted from: check resources

 ===================================================== */


package dtcc.itn261.assignment11;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
// TODO: move menu logic
// TODO: write exceptions to logger
// TODO: get date working correctly

public class InformationForm extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(InformationForm.class.getResource("information-form.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 601, 545);
        stage.setTitle("Information Form");
        stage.setScene(scene);
        stage.show();

    }
}