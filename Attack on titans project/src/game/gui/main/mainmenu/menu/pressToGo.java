package game.gui.main.mainmenu.menu;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class pressToGo extends Application { ///do we neeed to display many photos i guss no

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("AOT");
        BorderPane root = new BorderPane();
        root.setPrefSize(800, 600); // Set the preferred size of the BorderPane
        Image image = new Image("file:src/game/gui/main/mainmenu/demo1/mainmenuFiles/Images/pressEnterMenu/ComeIn.jpeg");

        // Create a BackgroundImage
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.ROUND, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, true, false));

        // Create a Background
        Background background = new Background(backgroundImage);

        Text instructionText = new Text("Press Enter to start."); /////make it more cool
        Text gameName = new Text("Attack on Titan SAVE Utopia");
        gameName.setFont(javafx.scene.text.Font.font("Tahoma", javafx.scene.text.FontWeight.BOLD, 30));
        gameName.setFill(Color.WHITE); // Set the color of the text to white //teemprarury xxxxx
        instructionText.setFill(Color.WHITE); // Set the color of the text to whitexxxxxxxxxxxxxx
        instructionText.setFont(javafx.scene.text.Font.font("Tahoma", javafx.scene.text.FontWeight.BOLD, 15));
        GridPane grid = new GridPane();
        grid.add(instructionText, 0, 0);
        grid.add(gameName, 0, 1);
        grid.setAlignment(javafx.geometry.Pos.CENTER); // Center the GridPane


        grid.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE); // Allow the VBox to expand
        root.setBackground(background);
        root.setCenter(grid);

        root.setPrefSize(800, 600);
        Scene introScene = new Scene(root, 800, 600);

        introScene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                new mainMenu().start(stage);
            }
        });

        stage.setScene(introScene);
        stage.show();
    }
}