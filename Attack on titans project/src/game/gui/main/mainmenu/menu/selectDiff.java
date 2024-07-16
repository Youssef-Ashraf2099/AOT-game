package game.gui.main.mainmenu.menu;

import game.engine.Battle;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import game.gui.main.Game.*;

import java.io.IOException;

public class selectDiff extends Application {
  //  private gameSceneE easyGame;
    private Scene scene ;
   // try {
    private Battle EasyBattel;   //= new Battle(1,0,10,3,250);
    private Battle HardBattel;  //= new Battle(1,0,10,5,125);

       // this.battle= new Battle(1,0,10,3,250);
    //} catch (IOException e)(
    // {
       // System.out.println("Error initializing game state in the battel: " + e.getMessage());
    //}
    private gameSceneH hardGame;
    @Override
    public void start(Stage stage) throws Exception {

        HBox root = new HBox();
        VBox vbox = new VBox();

        Label label = new Label("Select Difficulty");
        Button easy = new Button("Easy");
        easy.setOnAction(event -> {
            try {
                EasyBattel = new Battle(1,0,60,3,250);
            } catch (IOException e) {
                System.out.println("Error initializing game state in the Easy battel: " + e.getMessage());
            }
            EasyMode easyMode = null;
            try {
                easyMode = new EasyMode();
            } catch (IOException e) {
                System.out.println("Error initializing game state in the Easy battel: " + e.getMessage());
            }
            // Assuming stage is the current Stage object
            stage.setScene(easyMode.getScene());
        });
        Button hard = new Button("Hard");
        hard.setOnAction(event -> {
            try {
                HardBattel = new Battle(1,0,60,5,125);
            } catch (IOException e) {
                System.out.println("Error initializing game state in the Hard battel: " + e.getMessage());
            }
            try {
                hardGame = new gameSceneH();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            stage.setScene(hardGame.getScene());
        });
        mainMenu mainMenuInstance = new mainMenu();
        Button returnButton = new Button("back");
        returnButton.setOnAction(event -> {
            mainMenuInstance.playSound();
            if(stage.isFullScreen()) {
                stage.setFullScreen(true);
            }
            mainMenuInstance.start(stage);

        });

        vbox.getChildren().add(returnButton);
        vbox.setAlignment(Pos.BOTTOM_CENTER);
        root.getChildren().add(vbox);


root.getChildren().add(label);
        root.getChildren().add(easy);
        root.getChildren().add(hard);
        Scene scene = new Scene(root, 1300, 750);

        stage.setScene(scene);
        stage.show();

    }
public Scene getScene() {
    return this.scene;
}
    public static void main(String[] args) {

            System.setProperty("glass.win.uiScale", "1.0");
            launch(args);
        }
    }

