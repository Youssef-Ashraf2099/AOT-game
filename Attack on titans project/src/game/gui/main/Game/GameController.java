package game.gui.main.Game;

import game.engine.Battle;
import game.engine.exceptions.GameActionException;
import game.engine.exceptions.InsufficientResourcesException;
import game.engine.exceptions.InvalidLaneException;
import game.engine.lanes.Lane;
import game.engine.titans.Titan;
import game.engine.titans.TitanRegistry;
import game.engine.weapons.factory.WeaponFactory;
import game.gui.main.mainmenu.demo1.lostSceneE;
import game.engine.*;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import game.gui.main.mainmenu.demo1.mainMenu;


public class GameController {
    private lostSceneE loser;

    private Battle battle;
    private EasyMode easyScene;
    private gameSceneH hardScene;

    private mainMenu mainMenu;
    private Stage stage=new Stage();
    private Lane lane;

    //private mainMenu mainMenu = new mainMenu();
    public GameController(boolean easy) throws IOException {
        if (easy){
            try {
                this.battle= new Battle(1,0,80,3,250);
            } catch (IOException e) {
                System.out.println("Error initializing game state in the battel: " + e.getMessage());
            }
        }
        else if (!easy){
            try {
                this.battle= new Battle(1,0,80,5,125);
            } catch (IOException e) {
                System.out.println("Error initializing game state in the battel: " + e.getMessage());
            }
        }        //this.easyScene = g;
    }
    public GameController(Battle battle, gameSceneH HgameScene) {
        this.battle = battle;
        this.hardScene = HgameScene;
    }

    public void startGame() {
        // Initialize game state

//        try {
//            this.battle= new Battle(1,0,10,3,250);
//        } catch (IOException e) {
//            System.out.println("Error initializing game state in the battel: " + e.getMessage());
//        }


        // Update UI based on game state
        // ...
    }
    public void playTurn(boolean purchaseWeapon, int weaponCode, Lane lane) throws GameActionException, IOException {
        // Player's turn
        if (purchaseWeapon) {
            // Player chooses to purchase a weapon
            this.purchaseWeapon(weaponCode, lane);
            // Update lanes with the chosen weapon and update resources
        }
        // If the player chooses to pass, go directly to titan move action
          passTurn();
        // Titan move action
//        this.moveTitans();
//
//        // Weapons attack action
//        this.performWeaponsAttacks();
//
//        // Titans attack the wall
//        this.performTitansAttacks();
//
//        // Add from approaching titans to lanes
//        this.addTurnTitansToLane();
//
//        // Finalize turn (update phase, turns, etc.)
//        this.finalizeTurns();
        if (isGameOver()) {
            // Game over
            // Update UI to show game over screen
            loser = new lostSceneE(easyScene,this);
            stage.setScene(loser.getScene());
         //   loser.dispalyGameOverLose();
        }
    }


    public int getNumberOfTurns() {
        return battle.getNumberOfTurns();
    }

    public void setNumberOfTurns(int numberOfTurns) {

        if (!isGameOver()) {
            battle.setNumberOfTurns(numberOfTurns);
        }

        }


    public int getResourcesGathered() {
        return battle.getResourcesGathered();
    }

    public void setResourcesGathered(int resourcesGathered) {
        battle.setResourcesGathered(resourcesGathered);
    }

    public BattlePhase getBattlePhase() {
        return battle.getBattlePhase();
    }

    public void setBattlePhase(BattlePhase battlePhase) {
        battle.setBattlePhase(battlePhase);
    }

    public int getNumberOfTitansPerTurn() {
        return battle.getNumberOfTitansPerTurn();
    }

    public void setNumberOfTitansPerTurn(int numberOfTitansPerTurn) {
        battle.setNumberOfTitansPerTurn(numberOfTitansPerTurn);
    }

    public int getScore() {
        return battle.getScore();
    }

    public void setScore(int score) {
        battle.setScore(score);
    }

    public int getTitanSpawnDistance() {
        return battle.getTitanSpawnDistance();
    }

    public void setTitanSpawnDistance(int titanSpawnDistance) {
        battle.setTitanSpawnDistance(titanSpawnDistance);
    }

    public int[][] getPHASES_APPROACHING_TITANS() {
        return battle.getPHASES_APPROACHING_TITANS();
    }

    public int getWALL_BASE_HEALTH() {
        return battle.getWALL_BASE_HEALTH();
    }

    public WeaponFactory getWeaponFactory() {
        return battle.getWeaponFactory();
    }

    public HashMap<Integer, TitanRegistry> getTitansArchives() {
        return battle.getTitansArchives();
    }

    public ArrayList<Titan> getApproachingTitans() {
        return battle.getApproachingTitans();
    }

    public PriorityQueue<Lane> getLanes() {
        return battle.getLanes();
    }

    public ArrayList<Lane> getOriginalLanes() {
        return battle.getOriginalLanes();
    }



//    public void refillApproachingTitans() {
//        battle.refillApproachingTitans();
//    }

    public void purchaseWeapon(int weaponCode, Lane lane) throws GameActionException, IOException {

        try {
            battle.purchaseWeapon(weaponCode, lane);
        }


        catch (InvalidLaneException e1) {
            // add play sound method for alert box
            Alert alertSuff = new Alert(AlertType.ERROR);
            Alert alertLane = new Alert(AlertType.ERROR);
            alertLane.setTitle("Invalid Lane");
            alertLane.setHeaderText("The Lane is actually destroyed");
            alertLane.setContentText(e1.getMessage());
            alertSuff.setTitle("Game Action Exception");
            alertSuff.setHeaderText("Insufficient Resources");
            alertSuff.setContentText(e1.getMessage());
            alertLane.showAndWait();

            System.out.println(e1.getMessage());


        }
        catch (InsufficientResourcesException e2){
        Alert alertSuff = new Alert(AlertType.ERROR);
            // add play sound method for alert box
            alertSuff.setTitle("Game Action Exception");
            alertSuff.setHeaderText("Insufficient Resources");
            alertSuff.setContentText(e2.getMessage());
            System.out.println(e2.getMessage());
            alertSuff.showAndWait();
        }
    }


    public void passTurn() {
        battle.passTurn();
    }



    public boolean isGameOver() {
        return battle.isGameOver();
    }

    public boolean isEasyScene() {

        return easyScene != null;
    }

    public int getFinalScore() {
        if (isGameOver()) {
            return getScore();
        }
        return -1; // return -1 or any invalid score when the game is not over
    }

    public Battle getBattle() throws IOException {
        if (isEasyScene())
            return  battle= new Battle(1,0,80,3,250);
        else
            return battle= new Battle(1,0,75,5,125);
    }
    // Other methods to handle game events
    // ...
    public boolean islaneLost(Lane lane){
        return lane.isLaneLost();
    }
    public Titan getFirstApproachingTitan(){
        return battle.getApproachingTitans().get(0);
    }

}
