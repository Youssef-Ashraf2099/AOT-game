package game.gui.main.mainmenu.menu;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class InstructionsScene {
    private Scene scene;

    public InstructionsScene(Stage stage, mainMenu mainMenuInstance) {
        VBox vbox = new VBox();
        StackPane stackPane = new StackPane();
        StackPane stackPane2 = new StackPane();
            StackPane stackPane3 = new StackPane();
        vbox.setSpacing(20);
        vbox.setAlignment(Pos.CENTER);
        mainMenuInstance.playRandomMusic();
        double screenWidth = Screen.getPrimary().getBounds().getWidth();
        double screenHeight = Screen.getPrimary().getBounds().getHeight();
        Image image = new Image("file:src/game/gui/main/mainmenu/demo1/mainmenuFiles/Images/mainMenu/Instruction/wise.jpeg");
        //Background background = mainMenuInstance.createBackground(image);
     //   background.getFills().add(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY));
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(screenWidth, screenHeight, false, false, false, false));
// Set the background for the VBox
        vbox.setBackground(new Background(backgroundImage));


        String rules = "Joe's Tips: \n" +
                "Rule 1-No place for the noobs or weak your mission is to save utopia from the titans\n" +
                "Rule 2-Save your resources and do not spend it all once \n" +
                "Rule 3-be prescriver and wise as much as you can for the weapons choice and take care for the lanes danger levels\n" +
                "Rule 4-Do not be like me and go and watch the series of the game\n" +
                "Rule 5-Do not make the game take much time of your study or work\n" +
                "Rule 6- for real instruction related to the game go and check  the tutorial button\n" +
                "Rule 7-Enjoy the game and have fun";


        Label label = new Label(rules);
        label.setTextFill(Color.GOLD);
        label.setFont(new javafx.scene.text.Font("Arial", 30));
        stackPane.setAlignment(label,Pos.TOP_LEFT);

        stackPane.getChildren().add(label);
        vbox.getChildren().add(stackPane);

        Button returnButton = new Button("Back");
       // returnButton.setStyle("-fx-font-size: 20px; -fx-font-family: 'Lagom'; -fx-text-fill: #23c344; -fx-font-weight: bold; -fx-background-color: rgba(179,179,179,0.42);-fx-background-size: 50px 50px;");
        //returnButton.setMaxSize(200, 50);
        returnButton.setOnAction(event -> {
          //  mainMenuInstance.playSound();
            mainMenuInstance.start(stage);

        });
        returnButton.setOnMouseEntered(event -> {
            //mainMenuInstance.playSound();
            returnButton.setStyle("-fx-font-size: 20px; -fx-font-family: 'Lagom'; -fx-text-fill: #27d600; -fx-font-weight: bold; -fx-background-color: rgb(55,48,48);-fx-background-size: 50px 50px;");
        });
        returnButton.setOnMouseExited(event -> {
            returnButton.setStyle("-fx-font-size: 20px; -fx-font-family: 'Lagom'; -fx-text-fill: #37cd61; -fx-font-weight: bold; -fx-background-color: rgba(179,179,179,0.15);-fx-background-size: 50px 50px;");
        });
        HBox buttonBox = new HBox();
        buttonBox.setAlignment(Pos.CENTER);

        returnButton.setStyle("-fx-font-size: 20px; -fx-font-family: 'Lagom'; -fx-text-fill: #27d600; -fx-font-weight: bold; -fx-background-color: rgba(179,179,179,0.15);-fx-background-size: 50px 50px;");
        //returnButton.setMaxSize(200, 50);
        //buttonBox,setAlignment(Pos.CENTER);
        //  mainMenuInstance.playRandomMusic();

        returnButton.setAlignment(Pos.BOTTOM_CENTER);
        vbox.getChildren().add(returnButton);
        Button newSceneButton = new Button("Real instructions ");
        newSceneButton.setOnAction(event -> {
           Tut newScene = new Tut(stage,this);
            stage.setScene(newScene.getScene());
        });
        stackPane2.setAlignment(returnButton,Pos.BOTTOM_CENTER);
        stackPane2.getChildren().add(returnButton);
        stackPane3.setAlignment(newSceneButton,Pos.BOTTOM_CENTER);
        stackPane3.getChildren().add(newSceneButton);
        //newSceneButton.setAlignment(Pos.BOTTOM_CENTER);
        vbox.getChildren().add(stackPane2);
        vbox.getChildren().add(stackPane3);

        this.scene = new Scene(vbox, 600, 500);
    }

    public Scene getScene() {
        return this.scene;
    }
}

