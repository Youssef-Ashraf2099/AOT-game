package game.gui.main.mainmenu.menu;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class OptionsScene {
    private Scene scene;
    public String selectedDifficultyLevel;
    public ChoiceBox<String> difficultyChoice = new ChoiceBox<>();
    private Stage primaryStage;


    public OptionsScene(Stage stage, mainMenu mainMenuInstance) {
        difficultyChoice.getItems().addAll("Easy", "Hard");
        difficultyChoice.setValue("Easy");

        VBox vbox = new VBox();
        vbox.setSpacing(30);
        vbox.setAlignment(Pos.TOP_LEFT);
        double screenWidth = Screen.getPrimary().getBounds().getWidth();
        double screenHeight = Screen.getPrimary().getBounds().getHeight();
        Image image = new Image("file:src/game/gui/main/mainmenu/demo1/mainmenuFiles/Images/mainMenu/Option/optionIcon.jpeg");
        //Background background = mainMenuInstance.createBackground(image);
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(screenWidth, screenHeight, false, false, false, false));
// Set the background for the VBox
        vbox.setBackground(new Background(backgroundImage));

        if (!stage.isFullScreen())
            stage.setFullScreen(true);
        Label labeloption = new Label("Options:");
        labeloption.setAlignment(Pos.TOP_CENTER);
        labeloption.setStyle("-fx-font-size: 30px; -fx-font-family: 'Arial'; -fx-text-fill: #c3a902; -fx-font-weight: bold;-fx-background-color: #000000;");

        Label labelvolume = new Label(" Adjust Volume:");
        //check the background size is too big please fix it
        labelvolume.setStyle("-fx-font-size: 25px; -fx-font-family: 'Arial'; -fx-text-fill: #fffdfd; -fx-font-weight: bold;-fx-background-color: #000000;-fx-background-size: 50px 50px;");

        Slider volumeSlider = new Slider();
        volumeSlider.setStyle("-fx-control-inner-background: #b3b3b3;-fx-pref-width: 100px; -fx-control-inner-background-alt: #9e9e9e; -fx-accent: #4059ff; -fx-focus-color: #4060ff;");
        volumeSlider.setMin(0);
        volumeSlider.setMax(100);
        volumeSlider.setValue(50);
        volumeSlider.setPrefWidth(100); // Set the preferred width to 300px
        volumeSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            mainMenuInstance.getMediaPlayer().setVolume(newValue.doubleValue() / 100.0);
        });
      //  volumeSlider.valueProperty().bindBidirectional(mainMenuInstance.getMediaPlayer().volumeProperty());
        vbox.getChildren().addAll(labelvolume, volumeSlider);

//        Label labelDifficulty = new Label("Select Difficulty:");
//        labelDifficulty.setStyle("-fx-font-size: 25px; -fx-font-family: 'Arial'; -fx-text-fill: #fffdfd; -fx-font-weight: bold;-fx-background-color: #000000;");


//        difficultyChoice.setStyle("-fx-font-size: 16px; -fx-font-family: 'Arial'; -fx-text-fill: #c0ff00; -fx-font-weight: bold; -fx-background-color: #b3b3b3;");
//        //  difficultyChoice.getItems().addAll("Easy", "Hard");
//        // difficultyChoice.setValue("Hard");
//        difficultyChoice.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
//            System.out.println("New difficulty level selected from the lsitener: " + newValue); // Print the new difficulty level
//        });
//        vbox.getChildren().add(labelDifficulty);
//        vbox.getChildren().add(difficultyChoice);
//
//        CheckBox autoPlayCheckbox = new CheckBox("Enable AutoPlay");
//        autoPlayCheckbox.setStyle("-fx-font-size: 16px; -fx-font-family: 'Arial'; -fx-text-fill: rgba(123,248,124,0.89); -fx-font-weight: bold; -fx-background-color: #b3b3b3;");
//        autoPlayCheckbox.setOnAction(event -> {
//            if (autoPlayCheckbox.isSelected()) {
//                // Handle enabling of AutoPlay feature when it is selected it will have amny if conditions
//            } else {
//                // Handle disabling of AutoPlay feature when it is deselected as normal life
//            }
//        });
       // vbox.getChildren().add(autoPlayCheckbox);

        Button returnButton = new Button("Back");
        returnButton.setOnAction(event -> {
            mainMenuInstance.playSound();
            if (stage.isFullScreen()) {
                stage.setFullScreen(true);
            }
            mainMenuInstance.start(stage);


        });
        returnButton.setOnMouseEntered(event -> {
            //mainMenuInstance.playSound();
            returnButton.setStyle("-fx-font-size: 20px; -fx-font-family: 'Lagom'; -fx-text-fill: #d6001d; -fx-font-weight: bold; -fx-background-color: rgb(55,48,48);-fx-background-size: 50px 50px;");
        });
        returnButton.setOnMouseExited(event -> {
            returnButton.setStyle("-fx-font-size: 20px; -fx-font-family: 'Lagom'; -fx-text-fill: #cd374b; -fx-font-weight: bold; -fx-background-color: rgba(179,179,179,0.15);-fx-background-size: 50px 50px;");
        });
        HBox buttonBox = new HBox();
        buttonBox.setAlignment(Pos.CENTER);

        returnButton.setStyle("-fx-font-size: 20px; -fx-font-family: 'Lagom'; -fx-text-fill: #cd374b; -fx-font-weight: bold; -fx-background-color: rgba(179,179,179,0.15);-fx-background-size: 50px 50px;");
        //returnButton.setMaxSize(200, 50);
        //buttonBox,setAlignment(Pos.CENTER);
        //  mainMenuInstance.playRandomMusic();
        buttonBox.getChildren().add(returnButton);
        vbox.getChildren().add(buttonBox);
        this.scene = new Scene(vbox, 600, 800);
        stage.setScene(this.scene);
        if (stage.isFullScreen())
            stage.setFullScreen(true);
    }

    public Scene getScene() {
        return this.scene;
    }
}
