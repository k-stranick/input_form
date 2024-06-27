package dtcc.itn261.assignment11;

import javafx.scene.control.ChoiceBox;

public class StatesChoiceBox extends ChoiceBox<String> {

    public StatesChoiceBox() { // constructs a choice box with State information
        super();
        populateStateList();
    }

    public void populateStateList() {
        this.getItems().clear(); // Clear existing items if necessary.
        for (States state : States.values()) {
            this.getItems().add(state.toString());
        }
        this.setValue(States.SELECTION.toString()); // Set default value
    }
}
