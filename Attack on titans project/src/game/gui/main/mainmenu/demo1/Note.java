package game.gui.main.mainmenu.demo1;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Note {
    private final Scene scene;
    private final CreditsScene creditsScene;
    public Note(Stage stage,CreditsScene creditsScene) {
        VBox vbox = new VBox();
        vbox.setSpacing(20);
        vbox.setAlignment(Pos.CENTER);
        this.creditsScene = creditsScene;

        // Create a Label to display a string
        Label label = new Label("This text is written by one of the developer from his heart\n"+"Although we met the basic requirment of the project\n"+"But we still have a lot of things to do\n"+"We hope that we can continue this project and make it better\n"+"We hope that we can add more features to the game\n"+"We hope that we can make the game more fun\n"+"We hope that we can make the game more challenging\n"+"We hope that we can make the game more enjoyable\n"+"We hope that we can make the game more interesting\n"+"We hope that we can make the game more addictive\n"+"We hope that we can make the game more popular\n"+"We hope that we can make the game more successful\n"+"We hope that we can make the game more beautiful\n"
        +"we hope to delever the best game we can\n"+"We hope that we can make the game more fun\n"+"We hope that we can make the game more challenging\n"+"We hope that we can make the game more enjoyable\n"+"We hope that we can make the game more interesting\n"+"We hope that we can make the game more addictive\n"+"We hope that we can make the game more popular\n"+"We hope that we can make the game more successful\n"+"Althogh the framework we are using is not for games\n"+
                "But we will try to plan for a remake in the future and glad that i worked on this project\n"+ "Special thanks for all of the programing staff for their support and we hope to make a better projects in the future and looking for another collaborations in the future\n "+"THANKS FOR READING AND STAY TUNED ;)");

        vbox.getChildren().add(label);

        // Create a return button
        Button returnButton = new Button("Return to Credits");
        returnButton.setOnAction(event -> stage.setScene(this.creditsScene.getScene()));
        vbox.getChildren().add(returnButton);

        this.scene = new Scene(vbox, 600, 500);
    }

public Scene getScene() {
    return this.scene;
}
}
