//package game.gui.main.mainmenu.demo1;
//
//import game.gui.main.Game.EasyMode;
//import game.gui.main.Game.GameController;
//import game.gui.main.Game.gameSceneH;
//import javafx.application.Application;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.scene.Group;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.layout.VBox;
//import javafx.scene.media.Media;
//import javafx.scene.media.MediaPlayer;
//import javafx.scene.text.Text;
//import javafx.stage.Stage;
//
//import java.io.File;
//import java.io.IOException;
//
//public class lostScene extends Application {
//    private Scene scene;
//    private GameController gameController;
//    private int score;
//   // private static ScoreHolder instance = null;
//    private mainMenu mainMenuInstance;
//
//private EasyMode EsceneInstance;
//
//private gameSceneH HsceneInstance;
//
//    public lostScene(EasyMode sceneInstance, GameController gameController) throws IOException {
//        this.EsceneInstance = sceneInstance;
//        this.gameController = gameController;
//    }
//    public lostScene(gameSceneH sceneInstance, GameController gameController) throws IOException{
//        this.HsceneInstance = sceneInstance;
//        this.gameController = gameController;
//    }
//
//    @Override
//    public void start(Stage stage) throws Exception {
//        GameController gameControllerE = new GameController(true);
//        //i////////////////////////////////////f (gameControllerE =new GameController(true)) {
//
//        //////////}
//      //  this.score= EsceneInstance.realScore(); ////////////fix this
//        VBox vbox = new VBox(10);
//        // Create a text node to display the "loser" message
//        Text loserText = new Text("Loser\nBalaBIzo KBERA");
//        loserText.setStyle("-fx-font-size: 24;"); // Set font size (optional)
//
//        // Get the final score from the game controller
//          // Replace this with the actual score from the game controller
//            // Display the final score
//             Label scoreLabel = new Label("Score: " + score);
//            scoreLabel.setStyle("-fx-font-size: 24;"); // Set font size (optional)
//            // You can replace the above line with code to display the score in your GUI
//        GameController gameControllerH = new GameController(false);
//        if (EsceneInstance != null|| gameController.isEasyScene()) {
//            this.score =   gameController.getScore();     //EsceneInstance.realScore();
//        } else if (HsceneInstance != null|| !gameController.isEasyScene()) {
//            this.score = gameControllerE.getFinalScore();                 //HsceneInstance.gameControl.getscore();
//        }
//
//        // Create a label to display the score
//        Button returnButton = new Button("Return");
//        returnButton.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                mainMenu mainMenuInstance = new mainMenu();
//                try {
//                    mainMenuInstance.start(stage);
//                } catch (Exception e) {
//                    System.out.println("Error starting mainMenu: " + e.getMessage());
//                }
//            }
//        });
//
//        // Create "Play Again" button
//        Button playAgainButton = new Button("Play Again");
//
//        // Set the button's action
//        playAgainButton.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event)  {
//                if (stage.isFullScreen()) {
//                    stage.setFullScreen(true);
//                }
//                try {
//                    GameController easyGame = new GameController(true);
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//                try {
//                    GameController hardGame = new GameController(false);
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//                if (gameControllerE.isEasyScene()) {
//                    // EasyMode easyMode = null;
//                    EasyMode easyMode = null;
//                    try {
//                        easyMode = new EasyMode();
//                    } catch (IOException e) {
//                        System.out.println("Error initializing game state in the Easy battel: " + e.getMessage());
//                    }
//                    // Assuming stage is the current Stage object
//                    stage.setScene(easyMode.getScene());
//                } else if (!gameControllerH.isEasyScene()) {
//                    gameSceneH hardGame = null;
//                    try {
//                        hardGame = new gameSceneH();
//                    } catch (IOException e) {
//                        throw new RuntimeException(e);
//                    }
////                    try {
////                        hardGame = new gameSceneH();
////                    } //catch (IOException e) {
//                        //throw new RuntimeException(e);
//                    //}
//                    stage.setScene(hardGame.getScene());
//                }
//            }
//            });
//
//        vbox.getChildren().addAll(loserText, scoreLabel, returnButton, playAgainButton);
//
//        // Create the scene with the root group
//        scene = new Scene(vbox, 800, 600); // Adjust dimensions as needed
//
//        stage.setScene(scene);
//        stage.show();
//
//    }
//
//
//    public  void playSound(String soundFilePath){
//        Media sound = new Media(new File(soundFilePath).toURI().toString());
//        // Create a MediaPlayer object with the Media
//        MediaPlayer mediaPlayer = new MediaPlayer(sound);
//        // Play the sound
//        mediaPlayer.play();
//    }
//
//    public Scene getScene() {
//        return scene;
//    }
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//}
package game.gui.main.mainmenu.menu;

import game.gui.main.Game.EasyMode;
import game.gui.main.Game.GameController;
import game.gui.main.Game.gameSceneH;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class lostSceneE extends Application {
    private Scene scene;
    private GameController gameController;
    private int score;
    // private static ScoreHolder instance = null;
    private mainMenu mainMenuInstance;

    private EasyMode EsceneInstance;
    private gameSceneH HsceneInstance;

    public lostSceneE(EasyMode sceneInstance, GameController gameController) throws IOException {
        this.EsceneInstance = sceneInstance;
        this.gameController = gameController;
    }
    public lostSceneE(gameSceneH sceneInstance, GameController gameController) throws IOException{
        this.HsceneInstance = sceneInstance;
        this.gameController = gameController;
    }

    @Override
    public void start(Stage stage) throws Exception {
        GameController gameControllerE = new GameController(true);
        this.score= EsceneInstance.realScore();
        VBox vbox = new VBox(10);
        // Create a text node to display the "loser" message
        Text loserText = new Text("Loser\nBalaBIzo KBERA");
        loserText.setStyle("-fx-font-size: 24;"); // Set font size (optional)

        // Get the final score from the game controller
        // Replace this with the actual score from the game controller
        // Display the final score
        Label scoreLabel = new Label("Score: " + score);
        scoreLabel.setStyle("-fx-font-size: 24;"); // Set font size (optional)
        // You can replace the above line with code to display the score in your GUI
        GameController gameControllerH = new GameController(true);
        //  this.score= HsceneInstance.realScore();  //////////////////////////////////////// creat real score method in hard scene
        // Create a text node to display the "loser" message


        // Create a label to display the score
        Button returnButton = new Button("Return as a NOOB");
        returnButton.setStyle("-fx-font-size: 20px; -fx-font-family: 'Lagom'; -fx-text-fill: #36a616; -fx-font-weight: bold; -fx-background-color: rgba(179,179,179,0.42);-fx-background-size: 50px 50px;");
        //returnButton.setMaxSize(200, 50);
        returnButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mainMenu mainMenuInstance = new mainMenu();
                try {
                    mainMenuInstance.start(stage);
                } catch (Exception e) {
                    System.out.println("Error starting mainMenu: " + e.getMessage());
                }
            }
        });

        // Create "Play Again" button
        Button playAgainButton = new Button("Play Again");

        // Set the button's action
        playAgainButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)  {
                if (stage.isFullScreen()) {
                    stage.setFullScreen(true);
                }
                try {
                    GameController easyGame = new GameController(true);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                try {
                    GameController hardGame = new GameController(false);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                if (gameControllerE.isEasyScene()) {
                    // EasyMode easyMode = null;
                    EasyMode easyMode = null;
                    try {
                        easyMode = new EasyMode();
                    } catch (IOException e) {
                        System.out.println("Error initializing game state in the Easy battel: " + e.getMessage());
                    }
                    // Assuming stage is the current Stage object
                    stage.setScene(easyMode.getScene());
                } else if (!gameControllerH.isEasyScene()) {
                    gameSceneH hardGame = null;
                    EasyMode easyMode = null;
                    try {
                        easyMode = new EasyMode();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        hardGame = new gameSceneH();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
//                    try {
//                        hardGame = new gameSceneH();
//                    } //catch (IOException e) {
                    //throw new RuntimeException(e);
                    //}
                    stage.setScene(easyMode.getScene());
                }
            }
        });

        vbox.getChildren().addAll(loserText, scoreLabel, returnButton, playAgainButton);

        // Create the scene with the root group
        scene = new Scene(vbox, 800, 600); // Adjust dimensions as needed

        stage.setScene(scene);
        stage.show();

    }


    public  void playSound(String soundFilePath){
        Media sound = new Media(new File(soundFilePath).toURI().toString());
        // Create a MediaPlayer object with the Media
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        // Play the sound
        mediaPlayer.play();
    }

    public Scene getScene() {
        return scene;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
