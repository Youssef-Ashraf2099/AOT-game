package game.gui.main.mainmenu.demo1.demo1;

import game.gui.main.mainmenu.demo1.mainMenu;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class OptionsScene {
    private Scene scene;

    public OptionsScene(Stage stage, mainMenu mainMenuInstance) {
        VBox vbox = new VBox();
        vbox.setSpacing(30);
        vbox.setAlignment(Pos.TOP_LEFT);

        if (!stage.isFullScreen())
            stage.setFullScreen(true);

        Label labelvolume = new Label("Options: \nAdjust Volume");
        Slider volumeSlider = new Slider();
        volumeSlider.setMin(0);
        volumeSlider.setMax(100);
        volumeSlider.setValue(50);
        vbox.getChildren().addAll(labelvolume, volumeSlider);

        Label labelDifficulty = new Label("Select Difficulty:");
        ChoiceBox<String> difficultyChoice = new ChoiceBox<>();
        difficultyChoice.getItems().addAll("Easy", "Hard");
        difficultyChoice.setValue("Easy");
        difficultyChoice.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
                if (newValue.equals("Easy")) {
                    // Handle selection of easy mode in the milestone 3 description
                } else if (newValue.equals("Hard")) {
                    // Handle selection of hard mode in the milestone 3 description
                }
            });
        vbox.getChildren().add(labelDifficulty);
        vbox.getChildren().add(difficultyChoice);

        CheckBox autoPlayCheckbox = new CheckBox("Enable AutoPlay");
        autoPlayCheckbox.setOnAction(event -> {
                if (autoPlayCheckbox.isSelected()) {
                    // Handle enabling of AutoPlay feature when it is selected it will have amny if conditions
                } else {
                    // Handle disabling of AutoPlay feature when it is deselected as normal life
                }
            });
        vbox.getChildren().add(autoPlayCheckbox);

        Button returnButton = new Button("back");
        returnButton.setOnAction(event -> {
            mainMenuInstance.playSound();
            mainMenuInstance.start(stage);

        });
        vbox.getChildren().add(returnButton);

        this.scene = new Scene(vbox, 800, 600);
    }

    public Scene getScene() {
        return this.scene;
    }
}