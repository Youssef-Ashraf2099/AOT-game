
package game.gui.main.mainmenu.menu;

import game.engine.Battle;
//import game.gui.main.Game.gameSceneE;
import game.gui.main.Game.GameController;
import game.gui.main.Game.gameSceneH;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.Screen;
import javafx.geometry.Rectangle2D;
import javafx.css.PseudoClass;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class mainMenu extends Application {
    //A ChoiceBox for selecting difficulty(Easy or Hard)
    private Scene scene;
    private ChoiceBox<String> difficultyChoice;
    //instance of the battle class
   // Battle battel;
    //Instances of MediaPlayer for handling sound.
 private MediaPlayer navigationSoundPlayer;
    //Instances of MediaPlayer for handling sound.
 private MediaPlayer mediaPlayer;
 //A slider for adjusting volume
    private Slider volumeSlider;
    //An instance of the OptionsScene class.
    private OptionsScene optionsScene;
    private GameController gameController;
    //A Rectangle2D representing the screen dimensions.
    Rectangle2D screenSize = Screen.getPrimary().getVisualBounds();
//A list of image file paths.
    private List<String> imagePaths = Arrays.asList(
            "file:src/game/gui/main/mainmenu/demo1/mainmenuFiles/Images/mainMenu/OuterCover/IncomingTitan.jpeg",
            "file:src/game/gui/main/mainmenu/demo1/mainmenuFiles/Images/mainMenu/OuterCover/LastBreath.jpeg",
            "file:src/game/gui/main/mainmenu/demo1/mainmenuFiles/Images/mainMenu/OuterCover/disco.jpeg",
              "file:src/game/gui/main/mainmenu/demo1/mainmenuFiles/Images/mainMenu/OuterCover/GameOver.jpeg",
              "file:src/game/gui/main/mainmenu/demo1/mainmenuFiles/Images/mainMenu/OuterCover/weiter.jpeg",
            "file:src/game/gui/main/mainmenu/demo1/mainmenuFiles/Images/mainMenu/OuterCover/Ready.jpeg",
            "file:src/game/gui/main/mainmenu/demo1/mainmenuFiles/Images/mainMenu/OuterCover/dex.jpeg",
            "file:src/game/gui/main/mainmenu/demo1/mainmenuFiles/Images/mainMenu/OuterCover/I.png",
            "file:src/game/gui/main/mainmenu/demo1/mainmenuFiles/Images/mainMenu/OuterCover/greatScene.png",
            "file:src/game/gui/main/mainmenu/demo1/mainmenuFiles/Images/mainMenu/OuterCover/utopiaFight.png"
            // Add more image file paths as needed

    );

    // List of music file paths
    private List<String> musicFiles = Arrays.asList(
            "src/game/gui/main/mainmenu/demo1/mainmenuFiles/Music/Attack on Titan - Original Soundtrack Mix (Best of Shingeki no Kyojin Music - HQ).mp3",
            "src/game/gui/main/mainmenu/demo1/mainmenuFiles/Music/SymphonicSuite.mp3",
            "src/game/gui/main/mainmenu/demo1/mainmenuFiles/Music/Avatar_ The Last Airbender Theme  EPIC VERSION.mp3",
          "src/game/gui/main/mainmenu/demo1/mainmenuFiles/Music/Epic Version - Batman_ Arkham City Theme.mp3",
          "src/game/gui/main/mainmenu/demo1/mainmenuFiles/Music/Hoist The Colours x He's a Pirate  EPIC VERSION (feat. @ColmRMcGuinness).mp3",
          "src/game/gui/main/mainmenu/demo1/mainmenuFiles/Music/Sonne.mp3",
          "src/game/gui/main/mainmenu/demo1/mainmenuFiles/Music/The Batman Theme  EPIC VERSION (feat. Mask of The Phantasm Theme x Imperial March).mp3"
    );
    //This instance variable represents the main menu scene.
    private Scene mainMenuScene;
    private Battle battle;

    @Override
        public void start(Stage primaryStage) {
        //The title of the stage is set to “AOT” (presumably “Attack on Titan”)
            primaryStage.setTitle("AOT");
            //An icon image for the title bar is added using the specified file path.
            Image iconTitle = new Image("file:src/game/gui/main/mainmenu/demo1/mainmenuFiles/Images/GameCover/gameIcon.jpeg");
             primaryStage.getIcons().add(iconTitle);
            // Set the size of the stage to match the screen size
            primaryStage.setWidth(screenSize.getWidth());
            primaryStage.setHeight(screenSize.getHeight());

            //A BorderPane named root is created.
            BorderPane root = new BorderPane();
            // Select a random image file path
            Random random = new Random();
            String selectedImagePath = imagePaths.get(random.nextInt(imagePaths.size()));

            // Create image background
        //The image is used as the background for the root layout.
            Image image = new Image(selectedImagePath);
            //BackgroundSize is used to define the size of the background image.
        //The constructor parameters are:
        //1080: The desired width of the background image.
        //1920: The desired height of the background image.
        //true, true, true, false: These boolean values indicate whether the background size should be relative to the scene, whether it should preserve the aspect ratio, whether it should be clipped to the scene, and whether it should be positioned relative to the center.
            BackgroundSize backgroundSize = new BackgroundSize(1080, 1920, true, true, true, false);
            //BackgroundImage is created using the image (loaded from the selected image path) and the specified backgroundSize.
        //BackgroundRepeat.ROUND means the image will be repeated in a rounded pattern.
        //BackgroundRepeat.NO_REPEAT means the image won’t be repeated in any direction.
        //BackgroundPosition.CENTER means the image will be centered within the scene.
            BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.ROUND, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
            root.setBackground(new Background(backgroundImage));

// Set the background of the root layout to the new BackgroundImage
            root.setBackground(new Background(backgroundImage));
            // Create title
          // Text title = new Text("Attack on Titan: Save Utopia"); //should be transfred to intro
        //The title font is set to “Lucida Calligraphy” with a bold weight and a size of 40.
            //title.setFont(Font.font("Lucida Calligraphy", FontWeight.BOLD, 40));

            //An HBox named menuOptions is created to hold buttons.
        //The alignment is set to the bottom center, and spacing between buttons is specified.
        //This line creates an HBox (horizontal box) named menuOptions.
        //The 20 inside the constructor specifies the spacing (in pixels) between the child nodes (buttons) within the HBox.
        //The HBox is used to arrange buttons horizontally.
            HBox menuOptions = new HBox(20);
            menuOptions.setAlignment(Pos.BOTTOM_CENTER);
            menuOptions.setSpacing(20);
          //A “Start Game” button is created:
        //Its width is set to 200.
        //Mouse events (enter and exit) trigger sound effects.
        //When clicked, it plays a sound, stops background music, and starts the selectDiff scene.
        //Plays a sound (playSound()).
        //Stops the background music (stopBackgroundMusic()).
        //Creates an instance of selectDiff (presumably a scene or game logic class).
        //Attempts to start the selectDiff scene using selectDiff.start(primaryStage).
        //If an exception occurs during scene startup, it prints an error message.
            Button startButton = new Button("Start Game");
            startButton.setPrefWidth(200);
            startButton.setOnMouseExited(event -> {
                stopNavigateSound();
            });
            startButton.setOnMouseEntered(event -> {
                playNavigateSound();
            });
            startButton.setOnAction(event -> {

                playSound();
                stopBackgroundMusic();
                //start the new scence by making an object of the selectDiff
                selectDiff selectDiff = new selectDiff();
                try {
                    selectDiff.start(primaryStage);
                } catch (Exception e) {
                    System.out.println("Error starting selectDiff: " + e.getMessage());
                }

            });
            menuOptions.getChildren().add(startButton);
//option button
            Button optionsButton = new Button("Options");
            optionsButton.setPrefWidth(200);
            optionsButton.setOnMouseEntered(event -> {

                playNavigateSound();
            });
            optionsButton.setOnMouseExited(event -> {
                stopNavigateSound();
            });

            optionsButton.setOnAction(event -> {


                playSound();
                 optionsScene = new OptionsScene(primaryStage, this); //go to option
                //optionsScene = new OptionsScene();
                primaryStage.setScene(optionsScene.getScene()); // it d does not save scene
            });
            menuOptions.getChildren().add(optionsButton);
            // Create volume slider
        //A Slider named volumeSlider is created.
        //Its maximum value is set to 100, and the initial value is 50.



            Button instructionsButton = new Button("Instructions");
            instructionsButton.setPrefWidth(200);
            instructionsButton.setOnMouseEntered(event -> {
                playNavigateSound();
            });
            instructionsButton.setOnMouseExited(event -> {
                stopNavigateSound();
            });
            instructionsButton.setOnAction(event -> {

                playSound();
                InstructionsScene instructionsScene = new InstructionsScene(primaryStage, this);
                primaryStage.setScene(instructionsScene.getScene());
            });
            menuOptions.getChildren().add(instructionsButton);

            Button exitButton = new Button("Exit");
            exitButton.setPrefWidth(200);
            exitButton.setOnMouseEntered(event -> {
                playNavigateSound();
            });
            exitButton.setOnMouseExited(event -> {
                stopNavigateSound();
            });
            exitButton.setOnAction(event -> {

                playSound();
                //Exits the application by calling System.exit(0).
                System.exit(0);
            });
            menuOptions.getChildren().add(exitButton);

// Add title and menu options to the root layout
        //A StackPane named titlePane is created to hold the title text.
        //The title text is centered within the titlePane.
        //The root layout is configured:
        //The title pane is set at the top.
        //The menu options (buttons) are set at the center.
           // StackPane titlePane = new StackPane(title);
            //titlePane.setAlignment(Pos.CENTER);
           //root.setTop(titlePane);
            root.setCenter(menuOptions); /////buttons place nu

//credits
            Button creditButton = new Button("Credits");
            creditButton.setPrefWidth(200);
            creditButton.setOnMouseEntered(event -> {
                playNavigateSound();
            });
            creditButton.setOnMouseExited(event -> {
                stopNavigateSound();
            });
            creditButton.setOnAction(event -> {

               // playNavigateSound();
                //Plays a sound (playSound()).
                //Creates an instance of CreditsScene (presumably related to game credits).
                //Sets the primary stage’s scene to the creditsScene.
                playSound();
                //primaryStage represents the main window of your JavaFX application.
                //this refers to the current instance of the class where the snippet is located.(the mainMenu class)
                CreditsScene creditsScene = new CreditsScene(primaryStage, this);
                primaryStage.setScene(creditsScene.getScene());
            });
            menuOptions.getChildren().add(creditButton);
            // Create scene and set it to the stage
            Scene scene = new Scene(root, 600, 800);
            //customize button
            scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
 // to select from arrow
            PseudoClass hover = PseudoClass.getPseudoClass("hover");
            Button[] buttons = {startButton, optionsButton, instructionsButton, exitButton, creditButton};
            int[] buttonIndex = {0};
            scene.setOnKeyPressed(event -> {
                buttons[buttonIndex[0]].pseudoClassStateChanged(hover, false);
                if (event.getCode() == KeyCode.UP) {
                    buttonIndex[0] = (buttonIndex[0] - 1 + buttons.length) % buttons.length;
                    playNavigateSound();
                } else if (event.getCode() == KeyCode.DOWN) {
                    buttonIndex[0] = (buttonIndex[0] + 1) % buttons.length;
                    playNavigateSound();
                } else if (event.getCode() == KeyCode.ENTER) {
                    playNavigateSound();
                    buttons[buttonIndex[0]].fire();
                }
                buttons[buttonIndex[0]].pseudoClassStateChanged(hover, true);
            });

            // Add key listener to the scene make it full screen
            scene.setOnKeyPressed(event -> {
                if (event.getCode() == KeyCode.F11) {
                    primaryStage.setFullScreen(true);
                } else if (event.getCode() == KeyCode.ESCAPE) {
                    primaryStage.setFullScreen(false);
                }
            });
        volumeSlider = new Slider();
        volumeSlider.setMax(100);
        volumeSlider.setValue(50);

            // Play a random music file
            playRandomMusic();

            primaryStage.setScene(scene);
            primaryStage.show();



        }



        private void startGame(Stage primaryStage) { //revise on this
            // Stop the music
            if (mediaPlayer != null) {
                mediaPlayer.pause();
            }
            Button instructionsButton = new Button("Instructions");
            instructionsButton.setPrefWidth(200);
            instructionsButton.setOnAction(event ->{
                    playSound();
            startGame(primaryStage);
        });

            // ... existing code ...to be continue
        }

    public MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }
        public void playNavigateSound() {
            String musicFile = "src\\game\\gui\\main\\mainmenu\\demo1\\mainmenuFiles\\selctionEffect\\navigate.mp3"; // For example
            File file = new File(musicFile);
            if (file.exists()) {
                Media sound = new Media(file.toURI().toString());
                MediaPlayer mediaPlayer = new MediaPlayer(sound);

                mediaPlayer.play();
            } else {
                System.out.println("File " + musicFile + " does not exist");
            }
        }
    public void stopNavigateSound() {
        if (navigationSoundPlayer != null) {
            navigationSoundPlayer.stop();
        }
    }


    public void playSound() {
        String musicFile = "src\\game\\gui\\main\\mainmenu\\demo1\\mainmenuFiles\\selctionEffect\\Realselect.mp3"; // path to the sound file
        File file = new File(musicFile);
        if (file.exists()) {
            Media sound = new Media(file.toURI().toString());
            MediaPlayer mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.play();
        } else {
            System.out.println("File " + musicFile + " does not exist");
        }
    }

        public static void main(String[] args) {
            launch(args);
        }

    public Background createBackground(Image image) {
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        return new Background(backgroundImage);
    }

    //returns the value of the difficultyChoice (presumably a choice box for selecting difficulty).
    public String getSelectedDifficultyLevel() {
        return difficultyChoice.getValue();
    }
    public void playRandomMusic() {
        // Only start a new music track if one isn't already playing
        if (mediaPlayer == null || mediaPlayer.getStatus() != MediaPlayer.Status.PLAYING) {
            // Stop the current music if it's playing
            // Stop the current music if it's playing
            if (mediaPlayer != null) {
                mediaPlayer.stop();
            }

            // Randomly select a music file
            Random random = new Random();
            String selectedMusicFile = musicFiles.get(random.nextInt(musicFiles.size()));



            // Create Media and MediaPlayer objects
            Media media = new Media(new File(selectedMusicFile).toURI().toString());
            mediaPlayer = new MediaPlayer(media);

            // Set the volume
            mediaPlayer.setVolume(volumeSlider.getValue() / 100.0);

            // Play the music
            mediaPlayer.play();

            // Play a new random music file when the current one ends
            mediaPlayer.setOnEndOfMedia(this::playRandomMusic);
        }
    }
    public void stopBackgroundMusic() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
    }

    public Scene getScene() {
        return this.scene;
    }


}

