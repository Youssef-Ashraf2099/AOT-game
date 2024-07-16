package game.gui.main.mainmenu.demo1;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HelloController extends Application {
     private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Attack on Titan: Utopia");

        // Create root layout
        BorderPane root = new BorderPane();
        root.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, null, null)));

        // Create title
        Text title = new Text("Attack on Titan: Utopia");
        title.setFont(Font.font("Verdana", FontWeight.BOLD, 40));

        // Create menu options
        VBox menuOptions = new VBox(20);
        menuOptions.setAlignment(Pos.CENTER);
        menuOptions.setSpacing(20);



        Button optionsButton = new Button("Options");
        optionsButton.setPrefWidth(200);
        optionsButton.setOnAction(event -> displayOptions(primaryStage));
        menuOptions.getChildren().add(optionsButton);

        Button startButton = new Button("Start Game");
        startButton.setPrefWidth(200);
        startButton.setOnAction(event -> startGame(primaryStage));

        Button instructionsButton = new Button("Instructions");
        instructionsButton.setPrefWidth(200);
        instructionsButton.setOnAction(event -> displayRules(primaryStage));

        Button exitButton = new Button("Exit");
        exitButton.setPrefWidth(200);
        exitButton.setOnAction(event -> System.exit(0));

        menuOptions.getChildren().addAll(startButton, instructionsButton, exitButton);

        // Add title and menu options to the root layout
        StackPane titlePane = new StackPane(title);
        titlePane.setAlignment(Pos.CENTER);
        root.setTop(titlePane);
        root.setCenter(menuOptions);
        //credits
        Button creditButton = new Button("Credits");
        creditButton.setPrefWidth(200);
        creditButton.setOnAction(event -> displayCredits(primaryStage));
        menuOptions.getChildren().add(creditButton);

        // Create scene and set it to the stage
        Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void startGame(Stage primaryStage) {
        Button instructionsButton = new Button("Instructions");
        instructionsButton.setPrefWidth(200);
        instructionsButton.setOnAction(event -> displayRules(primaryStage));

        // ... existing code ...
    }


    private String rules = "Game Rules: \n" +
            "1. Rule 1\n" +
            "2. Rule 2\n" +
            "3. Rule 3\n" +
            "4. Rule 4\n" +
            "5. Rule 5";


    public void displayRules(Stage stage) {
        VBox vbox = new VBox();
        Label label = new Label(rules);
        vbox.getChildren().add(label);

        Button returnButton = new Button("back");
        returnButton.setOnAction(event -> start(stage));
        vbox.getChildren().add(returnButton);

        Scene scene = new Scene(vbox, 800, 600);
        stage.setScene(scene);
        stage.show();
    }
    public void displayCredits(Stage stage) {
        VBox vbox = new VBox();
        Label label = new Label("Credits: \nYoussef Ashraf \nAmr Khaled" );
        label.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        label.setAlignment(Pos.CENTER);
        vbox.getChildren().add(label);
        Button returnButton = new Button("back");
        returnButton.setAlignment(Pos.BOTTOM_CENTER);
        returnButton.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        returnButton.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, null, null)));
        returnButton.setOnAction(event -> start(stage));
        vbox.getChildren().add(returnButton);
        Scene scene = new Scene(vbox, 800, 600);
        stage.setScene(scene);
        stage.show();
    }
    public void displayOptions(Stage stage) {
        VBox vbox = new VBox();
        Label label = new Label("Options: \nAdjust Volume");
        Slider volumeSlider = new Slider();
        volumeSlider.setMin(0);
        volumeSlider.setMax(100);
        volumeSlider.setValue(50); // Default volume level
        vbox.getChildren().addAll(label, volumeSlider);

        Button returnButton = new Button("Return to Main Menu");
        returnButton.setOnAction(event -> start(stage));
        vbox.getChildren().add(returnButton);

        Scene scene = new Scene(vbox, 800, 600);
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }


    public void displayRules(ActionEvent actionEvent) {
        displayRules(new Stage());
    }


    public void startGame(ActionEvent actionEvent) {
        startGame(new Stage());
    }

    public void displayOptions(ActionEvent actionEvent) {
        displayOptions(new Stage());
    }

    public void displayCredits(ActionEvent actionEvent) {
        displayCredits(new Stage());
    }

    public void exitGame(ActionEvent actionEvent) {
        System.exit(0);
    }
}