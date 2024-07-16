package game.gui.main.mainmenu.demo1;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Tut {
    private Scene scene;
   private InstructionsScene instructionsScene;
//private     mainMenu mainMenuInstance;

    public Tut(Stage stage, InstructionsScene instructionsScene) {
//        mainMenuInstance = new mainMenu();
//        instructionsScene = new InstructionsScene(stage, mainMenuInstance);
        this.instructionsScene = instructionsScene;;
        VBox vbox = new VBox();
        vbox.setSpacing(20);
        vbox.setAlignment(Pos.CENTER);

        // Create a Label to display a string
        Label label = new Label("Attack on Titan: Utopia is a one-player, endless \n" +
                ", tower defense game , strategic game\n" +
                "inspired by the hit anime Attack on Titan. The story of the anime revolves around how titans, gigantic humanoid creatures, emerged one day and wiped out most of humanity. The few surviving humans fled and hid behind 3 great walls that provided safe haven from the titan threats. Wall Maria is the outer wall, Wall Rose is the middle wall and Wall Sina is the inside wall.\n" +
                "This game takes place in an imaginary scenario where the titans breached their way throughout Wall Maria and reached the northern border of Wall Rose at the Utopia District. The human forces stationed in Utopia engage the titans in battle for one last hope of preventing the titans from breaching Wall Rose. The humans fight by deploying different types of Anti-Titan weapons in order to stop the Titan’s onslaught and keep Utopia’s (and Wall Rose’s) walls safe.\n" +
                "1 Tower Defense Games: is a type of game where the player controls a\n" +
                "base and the objective is to continue defending this base from incoming enemies by deploying some weapons/tools to get rid of these enemies. In our case the base we need to protect is the Utopia District Walls.\n" +"Endless: it means that the game will have no winning condition and the player will keep playing and defeat as many enemies as possible\n"+"will have a starting HP (health points) that decreases after being attacked.\n" +
                "Each lane will have a danger level that can be calculated based on the number and types of titans inside this lane.\n" +
                "In the player’s base, the player will have the option to see all the available types of weapons and can choose to buy and deploy them into their choice of an active lane. The player should be able to view the currently gathered resources and acquired score as well as the remaining HPs of all walls and titans as well as each titan’s distance from the wall. The player can also see the approaching titans in order, these approaching titans will be added to the lanes in the upcoming turns.\n" +
                "The Battle has 3 phases depending on the number of turns that already passed: Early, Intense, Grumbling.There are multiple types of titans in this game. However, all the titans will have some attributes in common. Each titan will have the following stats:\n" +
                "1. HP: The health points of the titan. 2. Damage: The amount of damage the titan does when attacking a wall.\n" +
                "3. Height: The height of the titan in meters, doesn’t affect the gameplay.\n" +
                "4. Distance from walls: How far the titan is from the walls in “Distance Unit” 3\n" +
                ".\n" +
                "5. Speed: The distance that the titan moves per turn in “Distance Unit”. 6. Resources value: The amount of resources that the player gains by defeating this titan\n" +
                "7. Danger level: How much this titan affects a lane’s danger level.\n" +
                "3 “Distance Unit” : A special distance unit used for the sake of this game (does not necessarily translate to any realistic distance unit)\n" +"There are multiple types of weapons in this game. However, all the weapons will have some attributes in common. Each weapon will have the following stats:\n" +
                "1. Damage: The amount of damage the weapon does when attacking a Titan.\n" +
                "2. Price: The amount of resources needed to purchase and deploy a weapon of this type.\n" +
                "A specific type of weapons, called the “Volley Spread Cannon” will have a couple of extra stats:\n" +
                "1. Min Range: The minimum range of the weapon from the wall in “Distance Unit”.\n" +
                "2. Max Range: The maximum range of the weapon from the wall in “Distance Unit");
        vbox.getChildren().add(label);

        //return button
      Button returnButton = new Button("Return to Instructions");
        returnButton.setOnAction(event -> stage.setScene(this.instructionsScene.getScene()));
        vbox.getChildren().add(returnButton);


        this.scene = new Scene(vbox, 600, 500);
    }

    public Scene getScene() {
        return this.scene;
    }
}
