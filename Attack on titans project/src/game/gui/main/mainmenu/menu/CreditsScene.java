package game.gui.main.mainmenu.menu;
import game.gui.main.mainmenu.menu.mainMenu;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class CreditsScene {
    private Scene scene;

    public CreditsScene(Stage stage, mainMenu mainMenuInstance) {
        VBox vbox = new VBox();
        vbox.setSpacing(20);
        vbox.setAlignment(Pos.CENTER);
        mainMenuInstance.playRandomMusic();
        // Get screen dimensions
        double screenWidth = Screen.getPrimary().getBounds().getWidth();
        double screenHeight = Screen.getPrimary().getBounds().getHeight();
        Image image = new Image("file:src/game/gui/main/mainmenu/demo1/mainmenuFiles/Images/mainMenu/Credit/team.png");
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(screenWidth, screenHeight, false, false, false, false));
// Set the background for the VBox
        vbox.setBackground(new Background(backgroundImage));

StackPane stackPane = new StackPane();
        Label label = new Label("Credits: \nYoussef Ashraf solo dev " );
        label.setFont(Font.font("Tahoma", FontWeight.BOLD, 30));
        AnchorPane anchorPane = new AnchorPane();
        AnchorPane.setTopAnchor(label, 0.0);
        AnchorPane.setLeftAnchor(label, 0.0);
        anchorPane.getChildren().add(label);

        stackPane.getChildren().add(anchorPane);
        vbox.getChildren().add(stackPane);

        Button returnButton = new Button("Back");
        returnButton.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
       // returnButton.setStyle("-fx-font-size: 20px; -fx-font-family: 'Lagom'; -fx-text-fill: #3750cd; -fx-font-weight: bold; -fx-background-color: rgba(179,179,179,0.42);-fx-background-size: 50px 50px;");
        //returnButton.setMaxSize(200, 50);
        returnButton.setOnAction(event -> {
            mainMenuInstance.playSound();
            mainMenuInstance.start(stage);

        });
        returnButton.setOnMouseEntered(event -> {
            //mainMenuInstance.playSound();
            returnButton.setStyle("-fx-font-size: 20px; -fx-font-family: 'Lagom'; -fx-text-fill: #d6001d; -fx-font-weight: bold; -fx-background-color: rgb(55,48,48);-fx-background-size: 50px 50px;");
        });
        returnButton.setOnMouseExited(event -> {
            returnButton.setStyle("-fx-font-size: 20px; -fx-font-family: 'Lagom'; -fx-text-fill: #d82b43; -fx-font-weight: bold; -fx-background-color: rgba(179,179,179,0.15);-fx-background-size: 50px 50px;");
        });
        HBox buttonBox = new HBox();
        buttonBox.setAlignment(Pos.CENTER);

        returnButton.setStyle("-fx-font-size: 20px; -fx-font-family: 'Lagom'; -fx-text-fill: #c51f37; -fx-font-weight: bold; -fx-background-color: rgba(179,179,179,0.15);-fx-background-size: 50px 50px;");




        vbox.getChildren().add(returnButton);

        Button noteButton = new Button("Dev Note");
        noteButton.setFont(Font.font("Verdana", FontWeight.EXTRA_BOLD, 22));
        noteButton.setOnAction(event -> {
            Note noteScene = new Note(stage,this);
            stage.setScene(noteScene.getScene());
        });
        vbox.getChildren().add(noteButton);
        this.scene = new Scene(vbox, stage.getHeight(), stage.getWidth());
    }

    public Scene getScene() {
        return this.scene;
    }
}
