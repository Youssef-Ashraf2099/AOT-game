package game.gui.main.mainmenu.demo1;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Arrays;
import java.util.List;

public class Intro extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("AOT");

        // Create a list of texts to display
        List<String> texts = Arrays.asList("Welcome to the game!", "COOL JOE present ...", "ATTACK ON TITAN SAVE UTOPIA");

        // Create a Text node to display the texts
        Text introText = new Text();
        StackPane root = new StackPane(introText);
        Scene introScene = new Scene(root, 800, 600);

        primaryStage.setScene(introScene);
        primaryStage.show();

        // Create a Timeline to control when the text changes
        Timeline timeline = new Timeline();

        // For each text in the list, create a KeyFrame with a delay and an action that changes the text
        for (int i = 0; i < texts.size(); i++) {
            String text = texts.get(i);
            KeyFrame keyFrame = new KeyFrame(Duration.seconds(i * 3), event -> introText.setText(text));
            timeline.getKeyFrames().add(keyFrame);
        }

        // Add an action to the last KeyFrame to transition to the next scene
        KeyFrame lastKeyFrame = new KeyFrame(Duration.seconds(texts.size() * 3), event -> {
            try {
                new pressToGo().start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        timeline.getKeyFrames().add(lastKeyFrame);

        // Start the Timeline
        timeline.play();
    }

    public static void main(String[] args) {
        launch(args);
    }
}