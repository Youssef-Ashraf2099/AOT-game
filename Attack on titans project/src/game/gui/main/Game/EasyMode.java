/*package com.example.lasttrying;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        //Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        //stage.setTitle("Hello!");
        //stage.setScene(scene);
        Group root=new Group();
        Scene scene=new Scene(root,600,600,Color.LIGHTSKYBLUE);
        Stage stage1=new Stage();
        Text text=new Text();
        text.setText("Hi fellos");
        text.setX(150);
        text.setY(150);
        text.setFont(Font.font("Verdana",50));
        text.setFill(Color.GREEN);
        Line line=new Line();
        line.setStartX(200);
        line.setStartY(200);
        line.setEndX(500);
        line.setEndY(200);
        line.setStrokeWidth(5);
        line.setOpacity(0.5);
        line.setRotate(45);
        line.setStroke(Color.RED);

        Rectangle rectangle=new Rectangle();
        rectangle.setX(100);
        rectangle.setY(100);
        rectangle.setWidth(100);
        rectangle.setHeight(100);
        rectangle.setFill(Color.YELLOW);
        rectangle.setStrokeWidth(5);
        rectangle.setStroke(Color.RED);
        Polygon triangle=new Polygon();
        triangle.getPoints().setAll(200.0,200.0,300.0,300.0,200.0,300.0);
        triangle.setStrokeWidth(10);
        triangle.setStroke(Color.PINK);
        triangle.setFill(Color.GREEN);
        Image icon = new Image(getClass().getResourceAsStream("/icon.png"));
        ImageView imageView=new ImageView(icon);
        imageView.setX(400);
        imageView.setY(400);
        Circle circle=new Circle();
        circle.setCenterX(350);
        circle.setCenterY(350);
        circle.setRadius(50);
        circle.setFill(Color.ORANGE);
        root.getChildren().add(text);
        root.getChildren().add(line);
        root.getChildren().add(rectangle);
        root.getChildren().add(triangle);
        root.getChildren().add(circle);
        root.getChildren().add(imageView );
        //Image icon = new Image(getClass().getResourceAsStream("/icon.png"));
        //stage.getIcons().add(icon);
        //this method sets the stage with a title
        //stage.setTitle("welcome to learning javafx");
        //stage.setWidth(500);
        //stage.setHeight(500);
        //stage.setResizable(false);
        //stage.setX(50);
        //stage.setY(50);
        //stage.setFullScreen(true);
        //stage.setFullScreenExitHint("You cannot escape unless you write n");
        //stage.setFullScreenExitKeyCombination(KeyCombination.valueOf("n"));
        stage.setScene(scene);
        //this method is needed at the end of the start method
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}*/
package game.gui.main.Game;

import game.engine.exceptions.GameActionException;
import game.engine.exceptions.InvalidLaneException;
import game.engine.lanes.Lane;
import game.engine.titans.*;
import game.gui.main.mainmenu.demo1.lostSceneE;
import game.gui.main.mainmenu.demo1.mainMenu;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class EasyMode {
    private double healthPercentage1;
    private double healthPercentage2;
    private double healthPercentage3;
    private mainMenu mainMenu;
    private HashMap<Rectangle, Lane> laneMap;
    private Scene scene;
    private Titan titan;
    private mainMenu menu;
    private static Stage stage=new Stage();
    private GameController GameControl;
    private Text titanName;
    private GridPane root;
    private GridPane titanSpawner;
    private static int WeaponCode;
    private static CheckBox AI=new CheckBox();
    private Label[] healthLabels = new Label[3]; // Assuming there are 3 lanes
private ArrayList<Lane>lanes=new ArrayList<>();

private  Tooltip n;

private lostSceneE loser;
    private TextArea healthLaneTextArea;

    public EasyMode() throws IOException {


// Create the scene with the screen bounds
         this.root = new GridPane();

         this.titanSpawner=new GridPane();
        titanSpawner.setPrefSize(1200,800);

        GameControl = new GameController(true);

        Label gamePhaseLabel = new Label("Game Phase : "+GameControl.getBattlePhase());
        gamePhaseLabel.setLayoutX(20); // Position to the left with a margin of 20
       // gamePhaseLabel.setLayoutY(10); // Position at the top with a margin of 20
        gamePhaseLabel.setMinHeight(40); // Set minimum height to 30
        gamePhaseLabel.setStyle("-fx-border-color: black; -fx-border-width: 2; -fx-padding: 2;"); // Add a border around the label
        Label resourcesLabel = new Label("Gathered resources : "+GameControl.getResourcesGathered());
        resourcesLabel.setStyle("-fx-border-color: black; -fx-border-width: 2; -fx-padding: 2;");
        resourcesLabel.setLayoutX(10); // Position to the left with a margin of 20
       // resourcesLabel.setLayoutY(70); // Position below the gamePhaseLabel with a margin of 10
        resourcesLabel.setMaxHeight(40);
        // Create a new label "Number of Turns : " and position it next to the previous labels
        Label turnsLabel = new Label("Number of Turns : "+GameControl.getNumberOfTurns());
        turnsLabel.setStyle("-fx-border-color: black; -fx-border-width: 2; -fx-padding: 2;"); // Add a border around the label
        turnsLabel.setLayoutX(10); // Position to the left with a margin of 20
       // turnsLabel.setLayoutY(130); // Position below the resourcesLabel with a margin of 10
        turnsLabel.setMinHeight(40); // Set minimum height to 30
        Label scoreLabel = new Label("Score : "+ GameControl.getScore());
        scoreLabel.setStyle("-fx-border-color: black; -fx-border-width: 2; -fx-padding: 2;"); // Add a border around the label
        //double totalLabelWidth = gamePhaseLabel.getWidth() + resourcesLabel.getWidth() + turnsLabel.getWidth() + scoreLabel.getWidth();
        //double spacing = (screenBounds.getWidth() - totalLabelWidth) / 5; // Divide by 5 because there are 4 labels and we want to have spacing on both ends

// Add all labels to an HBox
        HBox labelBox = new HBox(350); // Use the calculated spacing
        // Add both labels to an HBox
        labelBox.getChildren().addAll(gamePhaseLabel, resourcesLabel, turnsLabel, scoreLabel,AI);
        // Define the width and height of the lanes
        double laneWidth = 70;
        double laneHeight = 220;
        labelBox.setLayoutX(10); // Position to the left with a margin of 20
        labelBox.setLayoutY(20); // Position at the top with a margin of 20

        root.getChildren().add(labelBox);
        root.getChildren().add(titanSpawner);
        titanSpawner.setTranslateX(70);
        titanSpawner.setTranslateY(200);

        // Calculate starting positions to stack lanes
        double startX = 0;
        double startY = 70;
String health1,health2,health3;



            String[] laneNames = {"L1" , "L2" , "L3" };



        ProgressBar[] healthBars = new ProgressBar[3];
        for (int i = 0; i < 3; i++) {
            Rectangle lane = new Rectangle(laneWidth, laneHeight);
            Tooltip t = updateLaneTooltip(GameControl, i);
            Tooltip.install(lane,t);
            lane.setFill(Color.GRAY);
            lane.setLayoutX(startX);
            lane.setLayoutY(startY + i * laneHeight);
            root.getChildren().add(lane);
            lane.setTranslateY(i*220-100);


            Text laneText = new Text(laneNames[i]);
            laneText.setLayoutX(lane.getLayoutX() + laneWidth / 2);
            laneText.setLayoutY(lane.getLayoutY() + laneHeight / 2);
            root.getChildren().add(laneText);
            laneText.setTranslateY(i*200);




           int x=i;








        } //////////////////////////////////////////////////////////////////////////////      EEEEEEEEEEEENNNNNNNNNNNNNNNNNDDDDDDDDDDDDDDDDDDD

        // Create buttons
        String[] buttonNames = {"Piercing Cannon\nprice:25\n Damage:10 ", "Sniper Cannon\nprice:25\nDamage:35", "VolleySpread\nprice:100\nDamage:5", "WallTrap\nprice:75\nDamage:100", "PassTurn", "return"};
        HBox buttonBox = new HBox(0);
        buttonBox.setAlignment(Pos.CENTER);

        Button lane1Button = new Button("Lane1");
        Button lane2Button = new Button("Lane2");
        Button lane3Button = new Button("Lane3");

// Initially, lane buttons are invisible
        lane1Button.setVisible(false);
        lane2Button.setVisible(false);
        lane3Button.setVisible(false);

// Add lane buttons to the button box
        buttonBox.getChildren().addAll(lane1Button, lane2Button, lane3Button);

        buttonBox.setPadding(new Insets(10, 0, 10, 0));
        for(int i=0;i<buttonNames.length;i++){
            String name = buttonNames[i];
            Button button = new Button(name);
            button.setPrefWidth(170);
            button.setPrefHeight(100); // Set preferred height to 50
            int finalI = i;
            button.setOnAction(event -> {
                if ("Piercing Cannon\nprice:25\n Damage:10 ".equals(name)) {
                    WeaponCode = 1;
                    //lane1.setSelected(true);
                    lane1Button.setVisible(true);
                    lane2Button.setVisible(true);
                    lane3Button.setVisible(true);
                    lane1Button.setOnMouseEntered(event1 -> {
                        Tooltip n = updateLaneTooltip(GameControl, 0);
                        Tooltip.install(root,n);
                    });
                    lane1Button.setOnMouseExited(event1 -> {
                        Tooltip n = updateLaneTooltip(GameControl, 0);
                        n.hide();
                    });
                    lane1Button.setOnAction(event1 -> {
                        try {
                            GameControl.purchaseWeapon(WeaponCode, GameControl.getOriginalLanes().get(0));
                            generateTitan();
                            UpdateLabels(labelBox,root);

                            System.out.println("Piercing Cannon");
                            if (GameControl.isGameOver()){

                                loser = new lostSceneE(this,GameControl);

                                loser.playSound("src/game/gui/main/mainmenu/demo1/mainmenuFiles/selctionEffect/select.mp3"); /// change it to balabizo

                                try {
                                    // Start the lostScene
                                    loser.start(stage);
                                } catch (Exception e) {
                                    System.out.println("Error starting lostScene: " + e.getMessage());
                                }
                                // Show the current stage with the new scene
                                stage.show();
                            }
                        } catch (GameActionException e) {
                      //      displayLaneLostMessage(lane1,1, stage);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        lane1Button.setVisible(false);
                        lane2Button.setVisible(false);
                        lane3Button.setVisible(false);
                    });
                    lane2Button.setOnMouseEntered(event1 -> {
                        Tooltip n = updateLaneTooltip(GameControl, 1);
                        Tooltip.install(root,n);
                    });
                    lane2Button.setOnMouseExited(event1 -> {
                        Tooltip n = updateLaneTooltip(GameControl, 1);
                        n.hide();

                    });
                    lane2Button.setOnAction(event1 -> {
                        try {
                            GameControl.purchaseWeapon(WeaponCode, GameControl.getOriginalLanes().get(1));
                            generateTitan();
                            UpdateLabels(labelBox,root);
//                            Tooltip n = updateLaneTooltip(GameControl, 1);
//                            Tooltip.install(root,n); /////////////////////////////////
                            System.out.println("Piercing Cannon");
                            if (GameControl.isGameOver()){

                                loser = new lostSceneE(this,GameControl);
                                // Set the scene of the current stage
                               // stage.setScene(loser.dispalyGameOverLose());
                                // play sound loser
                                loser.playSound("src/game/gui/main/mainmenu/demo1/mainmenuFiles/selctionEffect/select.mp3"); /// change it to balabizo
                                try {
                                    // Start the lostScene
                                    loser.start(stage);
                                } catch (Exception e) {
                                    System.out.println("Error starting lostScene: " + e.getMessage());
                                }

                                // Show the current stage with the new scene
                                stage.show();
                            }
                        } catch (InvalidLaneException e) {
                      //      displayLaneLostMessage(lane1,2, stage);
                        } catch (IOException | GameActionException e) {
                            throw new RuntimeException(e);
                        }
                        lane1Button.setVisible(false);
                        lane2Button.setVisible(false);
                        lane3Button.setVisible(false);
                    });
                    lane3Button.setOnMouseEntered(event1 -> {
                        Tooltip n = updateLaneTooltip(GameControl, 2);
                        Tooltip.install(root,n);
                    });
                    lane3Button.setOnMouseExited(event1 -> {
                        Tooltip n = updateLaneTooltip(GameControl, 2);
                        n.hide();
                    });
                    lane3Button.setOnAction(event1 -> {
                       // if (GameControl)//lost lane exception will be added for all the buttons of the weapons XXX
                        try {
                            GameControl.purchaseWeapon(WeaponCode, GameControl.getOriginalLanes().get(2));
                            generateTitan();
                            UpdateLabels(labelBox,root);
//
                            System.out.println("Piercing Cannon");
                        }
                        catch (InvalidLaneException e){
                      //      displayLaneLostMessage(lane1,3, stage);
                        }
                        catch (IOException | GameActionException e) {
                            throw new RuntimeException(e);
                        }
                        lane1Button.setVisible(false);
                        lane2Button.setVisible(false);
                        lane3Button.setVisible(false);
                    });
                } else if ("Sniper Cannon\nprice:25\nDamage:35".equals(name)) {
                    WeaponCode = 2;
               //     lane1.setSelected(true);
                    lane1Button.setVisible(true);
                    lane2Button.setVisible(true);
                    lane3Button.setVisible(true);
                    lane1Button.setOnMouseEntered(event1 -> {
                        Tooltip n = updateLaneTooltip(GameControl, 0);
                        Tooltip.install(root,n);
                    });
                    lane1Button.setOnMouseExited(event1 -> {
                        Tooltip n = updateLaneTooltip(GameControl, 0);
                        n.hide();
                    });
                    lane1Button.setOnAction(event1 -> {
                        try {
                            GameControl.purchaseWeapon(WeaponCode, GameControl.getOriginalLanes().get(0));
                            generateTitan();
                            UpdateLabels(labelBox,root);


                            System.out.println("Sniper Cannon");
                            if (GameControl.isGameOver()){

                                loser = new lostSceneE(this,GameControl);
                                // Set the scene of the current stage
                             //   stage.setScene(loser.dispalyGameOverLose());
                                // play sound loser
                                loser.playSound("src/game/gui/main/mainmenu/demo1/mainmenuFiles/selctionEffect/select.mp3"); /// change it to balabizo
                              //  loser.displayScene();
                                try {
                                    // Start the lostScene
                                    loser.start(stage);
                                } catch (Exception e) {
                                    System.out.println("Error starting lostScene: " + e.getMessage());
                                }
                                // Show the current stage with the new scene
                                stage.show();
                            }
                        } catch (GameActionException e) {
                            throw new RuntimeException(e);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        lane1Button.setVisible(false);
                        lane2Button.setVisible(false);
                        lane3Button.setVisible(false);
                    });

                    lane2Button.setOnMouseEntered(event1 -> {
                        Tooltip n = updateLaneTooltip(GameControl, 1);
                        Tooltip.install(root,n);

                    });
                    lane2Button.setOnMouseExited(event1 -> {
                        Tooltip n = updateLaneTooltip(GameControl, 1);
                        n.hide();
                    });
                    lane2Button.setOnAction(event1 -> {
                        try {
                            GameControl.purchaseWeapon(WeaponCode, GameControl.getOriginalLanes().get(1));
                            generateTitan();
                            UpdateLabels(labelBox,root);

                            //Tooltip n = updateLaneTooltip(GameControl, 1);
                            //Tooltip.install(root,n); //////////////////////////////////////////////////////////
                            System.out.println("Sniper Cannon");
                            if (GameControl.isGameOver()){

                                loser = new lostSceneE(this,GameControl);
                                // Set the scene of the current stage
                             //   stage.setScene(loser.dispalyGameOverLose());
                                // play sound loser
                                loser.playSound("src/game/gui/main/mainmenu/demo1/mainmenuFiles/selctionEffect/select.mp3"); /// change it to balabizo
                           //     loser.displayScene();
                                try {
                                    // Start the lostScene
                                    loser.start(stage);
                                } catch (Exception e) {
                                    System.out.println("Error starting lostScene: " + e.getMessage());
                                }
                                // Show the current stage with the new scene
                                stage.show();
                            }
                        } catch (GameActionException e) {
                            throw new RuntimeException(e);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        lane1Button.setVisible(false);
                        lane2Button.setVisible(false);
                        lane3Button.setVisible(false);
                    });

                    lane3Button.setOnMouseEntered(event1 -> {
                        Tooltip n = updateLaneTooltip(GameControl, 2);
                        Tooltip.install(root,n);
                    });
                    lane3Button.setOnMouseExited(event1 -> {
                        Tooltip n = updateLaneTooltip(GameControl, 2);
                        n.hide();
                    });
                    lane3Button.setOnAction(event1 -> {
                        try {
                            GameControl.purchaseWeapon(WeaponCode, GameControl.getOriginalLanes().get(2));
                            generateTitan();
                            UpdateLabels(labelBox,root);
//                            for(int j = 0; j < 3; j++) {
//                                Tooltip n = updateLaneTooltip(GameControl, j);
//                                Tooltip.install(root,n);
//                            }
                            //Tooltip.install(root,n);
                            System.out.println("Sniper Cannon");
                            if (GameControl.isGameOver()){

                                loser = new lostSceneE(this, GameControl);
                                // Set the scene of the current stage
                                //stage.setScene(loser.dispalyGameOverLose());
                                // play sound loser
                                loser.playSound("src/game/gui/main/mainmenu/demo1/mainmenuFiles/selctionEffect/select.mp3"); /// change it to balabizo
                                try {
                                    // Start the lostScene
                                    loser.start(stage);
                                } catch (Exception e) {
                                    System.out.println("Error starting lostScene: " + e.getMessage());
                                }
                            //    loser.displayScene();
                            // Show the current stage with the new scene
                                stage.show();
                            }
                        } catch (GameActionException e) {
                            throw new RuntimeException(e);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        lane1Button.setVisible(false);
                        lane2Button.setVisible(false);
                        lane3Button.setVisible(false);
                    });
                } else if ("VolleySpread\nprice:100\nDamage:5".equals(name)) {
                    WeaponCode = 3;
               //     lane1.setSelected(true);
                    lane1Button.setVisible(true);
                    lane2Button.setVisible(true);
                    lane3Button.setVisible(true);

                    lane1Button.setOnMouseEntered(event1 -> {
                        Tooltip n = updateLaneTooltip(GameControl, 0);
                        Tooltip.install(root,n);
                    });
                    lane1Button.setOnMouseExited(event1 -> {
                        Tooltip n = updateLaneTooltip(GameControl, 0);
                        n.hide();
                    });
                    lane1Button.setOnAction(event1 -> {
                        try {
                            GameControl.purchaseWeapon(WeaponCode, GameControl.getOriginalLanes().get(0));
                            generateTitan();
                            UpdateLabels(labelBox,root);
//                            for(int j = 0; j < 3; j++) {
//                                Tooltip n = updateLaneTooltip(GameControl, j);
//                                Tooltip.install(root,n);
//                            }
                           // Tooltip n = updateLaneTooltip(GameControl, 1);
                            //Tooltip.install(root,n); /////////////////////////////////v
                            System.out.println("VolleySpread");
                            if (GameControl.isGameOver()){

                                loser = new lostSceneE(this, GameControl);
                                // Set the scene of the current stage
                              //  stage.setScene(loser.dispalyGameOverLose());
                                // play sound loser
                                loser.playSound("src/game/gui/main/mainmenu/demo1/mainmenuFiles/selctionEffect/select.mp3"); /// change it to balabizo
                           //     loser.displayScene();
                                try {
                                    // Start the lostScene
                                    loser.start(stage);
                                } catch (Exception e) {
                                    System.out.println("Error starting lostScene: " + e.getMessage());
                                }
                                // Show the current stage with the new scene
                                stage.show();
                            }
                        } catch (GameActionException e) {
                            throw new RuntimeException(e);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        lane1Button.setVisible(false);
                        lane2Button.setVisible(false);
                        lane3Button.setVisible(false);
                    });
                    lane2Button.setOnMouseEntered(event1 -> {
                        Tooltip n = updateLaneTooltip(GameControl, 1);
                        Tooltip.install(root,n);
                    });
                    lane2Button.setOnMouseExited(event1 -> {
                        Tooltip n = updateLaneTooltip(GameControl, 1);
                        n.hide();
                    });
                    lane2Button.setOnAction(event1 -> {
                        try {
                            GameControl.purchaseWeapon(WeaponCode, GameControl.getOriginalLanes().get(1));
                            generateTitan();
                            UpdateLabels(labelBox,root);

                           // Tooltip n = updateLaneTooltip(GameControl, 1);
                            //Tooltip.install(root,n); /////////////////////////////////
                            System.out.println("VolleySpread");
                            if (GameControl.isGameOver()){

                                loser = new lostSceneE(this, GameControl);
                                // Set the scene of the current stage
                               // stage.setScene(loser.dispalyGameOverLose());
                                // play sound loser
                                loser.playSound("src/game/gui/main/mainmenu/demo1/mainmenuFiles/selctionEffect/select.mp3"); /// change it to balabizo
                            //    loser.displayScene();
                                try {
                                    // Start the lostScene
                                    loser.start(stage);
                                } catch (Exception e) {
                                    System.out.println("Error starting lostScene: " + e.getMessage());
                                }
                                // Show the current stage with the new scene
                                stage.showAndWait();
                            }
                        } catch (GameActionException e) {
                            throw new RuntimeException(e);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        lane1Button.setVisible(false);
                        lane2Button.setVisible(false);
                        lane3Button.setVisible(false);
                    });
                    lane3Button.setOnMouseEntered(event1 -> {
                        Tooltip n = updateLaneTooltip(GameControl, 2);
                        Tooltip.install(root,n);
                    });
                    lane3Button.setOnMouseExited(event1 -> {
                        Tooltip n = updateLaneTooltip(GameControl, 2);
                        n.hide();
                    });
                    lane3Button.setOnAction(event1 -> {
                        try {
                            GameControl.purchaseWeapon(WeaponCode, GameControl.getOriginalLanes().get(2));
                            generateTitan();
                            UpdateLabels(labelBox,root);

                           // Tooltip n = updateLaneTooltip(GameControl, 1);
                            //Tooltip.install(root,n); /////////////////////////////////
                            System.out.println("VolleySpread");
                            if (GameControl.isGameOver()){

                                loser = new lostSceneE(this, GameControl);
                                // Set the scene of the current stage
                           //     stage.setScene(loser.dispalyGameOverLose());
                                // play sound loser
                                loser.playSound("src/game/gui/main/mainmenu/demo1/mainmenuFiles/selctionEffect/select.mp3"); /// change it to balabizo
                                try {
                                    // Start the lostScene
                                    loser.start(stage);
                                } catch (Exception e) {
                                    System.out.println("Error starting lostScene: " + e.getMessage());
                                }
                            //    loser.displayScene();
                                // Show the current stage with the new scene
                                stage.showAndWait();
                            }
                        } catch (GameActionException e) {
                            throw new RuntimeException(e);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        lane1Button.setVisible(false);
                        lane2Button.setVisible(false);
                        lane3Button.setVisible(false);
                    });
                } else if ("WallTrap\nprice:75\nDamage:100".equals(name)) {
                    WeaponCode = 4;
                    //lane1.setSelected(true);
                    lane1Button.setVisible(true);
                    lane2Button.setVisible(true);
                    lane3Button.setVisible(true);

                    lane1Button.setOnMouseEntered(event1 -> {
                        Tooltip n = updateLaneTooltip(GameControl, 0);
                        Tooltip.install(root,n);
                    });
                    lane1Button.setOnMouseExited(event1 -> {
                        Tooltip n = updateLaneTooltip(GameControl, 0);
                        n.hide();
                    });
                    lane1Button.setOnAction(event1 -> {
                        try {
                            GameControl.purchaseWeapon(WeaponCode, GameControl.getOriginalLanes().get(0));
                            generateTitan();
                            UpdateLabels(labelBox,root);
//                            for(int j = 0; j < 3; j++) {
//                                Tooltip n = updateLaneTooltip(GameControl, j);
//                                Tooltip.install(root,n);
//                            }
                            System.out.println("WallTrap");
                        } catch (GameActionException e) {
                            throw new RuntimeException(e);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        lane1Button.setVisible(false);
                        lane2Button.setVisible(false);
                        lane3Button.setVisible(false);
                    });

                    lane2Button.setOnMouseEntered(event1 -> {
                        Tooltip n = updateLaneTooltip(GameControl, 1);
                        Tooltip.install(root,n);
                    });
                    lane2Button.setOnMouseExited(event1 -> {
                        Tooltip n = updateLaneTooltip(GameControl, 1);
                        n.hide();
                    });
                    lane2Button.setOnAction(event1 -> {
                        try {
                            GameControl.purchaseWeapon(WeaponCode, GameControl.getOriginalLanes().get(1));
                            generateTitan();
                            UpdateLabels(labelBox,root);
//                            for(int j = 0; j < 3; j++) {
//                                Tooltip n = updateLaneTooltip(GameControl, j);
//                                Tooltip.install(root,n);
//                            }
                            //Tooltip n = updateLaneTooltip(GameControl, 1);
                            //Tooltip.install(root,n); /////////////////////////////////
                            System.out.println("WallTrap");
                            if (GameControl.isGameOver()){

                                loser = new lostSceneE(this, GameControl);
                             //   stage.setScene(loser.dispalyGameOverLose());
                                // play sound loser
                                loser.playSound("src/game/gui/main/mainmenu/demo1/mainmenuFiles/selctionEffect/select.mp3"); /// change it to balabizo
                            //    loser.displayScene();
                                // Show the current stage with the new scene
                                try {
                                    // Start the lostScene
                                    loser.start(stage);
                                } catch (Exception e) {
                                    System.out.println("Error starting lostScene: " + e.getMessage());
                                }
                                stage.showAndWait();
                            }
                        } catch (GameActionException e) {
                            throw new RuntimeException(e);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        lane1Button.setVisible(false);
                        lane2Button.setVisible(false);
                        lane3Button.setVisible(false);
                    });

                    lane3Button.setOnMouseEntered(event1 -> {
                        Tooltip n = updateLaneTooltip(GameControl, 2);
                        Tooltip.install(root,n);
                    });
                    lane3Button.setOnMouseExited(event1 -> {
                        Tooltip n = updateLaneTooltip(GameControl, 2);
                        n.hide();
                    });
                    lane3Button.setOnAction(event1 -> {
                        try {
                            GameControl.purchaseWeapon(WeaponCode, GameControl.getOriginalLanes().get(2));
                            generateTitan();
                            UpdateLabels(labelBox,root);

                            //Tooltip n = updateLaneTooltip(GameControl, 1);
                            //Tooltip.install(root,n); /////////////////////////////////
                            System.out.println("WallTrap");
                        } catch (GameActionException | IOException e) {
                          //  displayLaneLostMessage(lane1,3, stage);
                        }
                        lane1Button.setVisible(false);
                        lane2Button.setVisible(false);
                        lane3Button.setVisible(false);
                    });
                } else if ("PassTurn".equals(name)) {
                    try {
                        performActionBasedOnAI();
                        GameControl.passTurn();
                        generateTitan();
                        UpdateLabels(labelBox,root);

//                        for(int j = 0; j < 3; j++) {
//                            Tooltip n = updateLaneTooltip(GameControl, j); /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//                            Tooltip.install(root,n);
//                        }
                        if (GameControl.isGameOver()){

                            loser = new lostSceneE(this, GameControl);
                            // Set the scene of the current stage
                            // stop turn

                          //  stage.setScene(loser.dispalyGameOverLose());
                            // play sound loser
                            loser.playSound("src/game/gui/main/mainmenu/demo1/mainmenuFiles/selctionEffect/select.mp3"); /// change it to balabizo
                            try {
                                // Start the lostScene
                                loser.start(stage);
                            } catch (Exception e) {
                                System.out.println("Error starting lostScene: " + e.getMessage());
                            }
                        //   loser.displayScene();
                            // Show the current stage with the new scene
                            stage.showAndWait();
                        }
                    } catch (NullPointerException e) {
                        throw new RuntimeException(e);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                } else if ("return".equals(name)) {
                    try {
                        loser = new lostSceneE(this, GameControl);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
//                   loser.dispalyGameOverLose();
                  //  stage.setScene(loser.getScene());
                    try {
                        // Start the lostScene
                        loser.start(stage);
                    } catch (Exception e) {
                        System.out.println("Error starting lostScene: " + e.getMessage());
                    }
                    //loser.displayScene();
                    stage.showAndWait();    //throw exception
                }


        });

            buttonBox.getChildren().add(button);
///////////////////////////////////////////////////////////////////////////////////////////////       EEEEEEEEEEEEEEEEEENNNNNNNNNNNNNNNNNDDDDDDDDDDDDDDDDDD      MMMMMMMMMMODDDDDDDDDDDDDDDDDD
        }


        // Create a TextArea and add it to the HBox
         healthLaneTextArea = new TextArea();
        healthLaneTextArea.setPrefWidth(170); // Set preferred width to match the weapon buttons
        healthLaneTextArea.setPrefHeight(100); // Set preferred height to match the weapon buttons
        healthLaneTextArea.setMaxWidth(170); // Set maximum width to match the weapon buttons
        healthLaneTextArea.setMaxHeight(100); // Set maximum height to match the weapon buttons
        healthLaneTextArea.setEditable(false); // Make the text area read-only
        buttonBox.getChildren().add(healthLaneTextArea);
       // buttonBox.getChildren().add(textArea);
        // Position the HBox at the bottom left of the screen
        buttonBox.setLayoutX(20);
        buttonBox.setLayoutY(120);//screenBounds.getHeight() - 150);
        //health text area for the wall
        //healthTextArea = new TextArea();
        //healthTextArea.setPrefWidth( 170); // Set preferred width to 170
        //healthTextArea.setPrefHeight(100); // Set preferred height to 50
        //healthTextArea.setEditable(false); // Make the text area read-onl
        root.getChildren().add(buttonBox);
        buttonBox.setTranslateY(550);
        // draw titan
        generateTitan(); //pass turn
      //  this.scene = new Scene(root, 1400,1080);//screenBounds.getWidth(), screenBounds.getHeight());
//        root.setLayoutX(screenBounds.getWidth() / 2);
//        root.setLayoutY(screenBounds.getHeight() / 2);
        this.scene = new Scene(root, 1000, 800);
        lanes=new ArrayList<Lane>();
       // lanes.add(this.GameControl.getLanes())
        lanes.addAll(GameControl.getLanes());





    }
    public Lane selectLane(int laneNumber) {
        // Check if the lane number is valid
        if (laneNumber < 1 || laneNumber > lanes.size()) {
            System.out.println("Invalid lane number. Please enter a number between 1 and " + lanes.size());
            return null;
        }

        // Return the selected lane
        return lanes.get(laneNumber - 1);
    }

    public void performActionBasedOnAI() {
        if (AI.isSelected()) {
            // Perform some action when AI checkbox is selected
            int maxScore = -1;
            Lane bestLane = null;

            // Loop through each lane
            for (Lane lane : GameControl.getOriginalLanes()) {
                // Calculate a score for the lane
                int score = calculateLaneScore(lane);

                // If the score is higher than the current max score, update the max score and the best lane
                if (score > maxScore) {
                    maxScore = score;
                    bestLane = lane;
                }
            }

            // Perform an action based on the best lane
            if (bestLane != null) {
                performBestAction(bestLane);
            }
        }
    }



    private int calculateLaneScore(Lane lane) {
        // Calculate a score based on the danger level, the type of the approaching titan, and the available resources
        // This is a simple example and might need to be adjusted based on your game's specific rules and mechanics
        int score = 0;
        score += lane.getDangerLevel();
        score += GameControl.getFirstApproachingTitan().getDangerLevel();
        score += GameControl.getResourcesGathered();

        return score;
    }

    private void performBestAction(Lane lane) {
        // Decide which action to take based on the best lane
        // This is a simple example and might need to be adjusted based on your game's specific rules and mechanics
        if (GameControl.getResourcesGathered() >= 25) {
            try {
                GameControl.purchaseWeapon(1, lane); // Purchase a weapon if there are enough resources
            } catch (GameActionException | IOException e) {
                e.printStackTrace();
            }
        } else {
            GameControl.passTurn(); // Pass the turn if there are not enough resources
        }
    }














    public void generateTitan() {

        int c=0;
        this.titanSpawner.getChildren().clear();
        for (Lane lane:lanes ){
            for (Titan enemy:lane.getTitans() ) {
                if (lane.isLaneLost()) {
                    Text invalidSign = new Text("X");
                    invalidSign.setFont(new Font(50)); // Set the font size to 50
                    invalidSign.setFill(Color.RED); // Set the color to red

                    // Calculate the Y position of the "X" sign based on the lane's index
                    int laneIndex = lanes.indexOf(lane); // Get the index of the lane
                    if (laneIndex==0){
                        double signYPosition = 0*220-100; // Calculate the Y position
                        invalidSign.setTranslateY(signYPosition); // Position the sign at the calculated Y position
                    }
                    else if (laneIndex == 1) {
                        double signYPosition = 1*220-100; // Calculate the Y position
                        invalidSign.setTranslateY(signYPosition); // Position the sign at the calculated Y position
                    } else if (laneIndex==2) {
                        double signYPosition = 2*220-100; // Calculate the Y position
                        invalidSign.setTranslateY(signYPosition); // Position the sign at the calculated Y position
                    }
                    root.getChildren().add(invalidSign);
                }


                Circle titan=new Circle();

                // Create a label to display the titan's current health
                Label healthLabel = new Label("Health: " + enemy.getCurrentHealth() +"%");
                healthLabel.setTextFill(Color.GREEN);

                // Set the position of the health label to be above the titan
                healthLabel.setTranslateX(enemy.getDistance() * 20);
                healthLabel.setTranslateY(c * 220 + enemy.getHeightInMeters() - 20);



                if (enemy instanceof PureTitan) {

                    titan.setFill(Color.RED);
                    titan.setRadius(enemy.getHeightInMeters());

                    titan.setTranslateX(enemy.getDistance()*20); // Randomly position the Titan on the x-axis
                    titan.setTranslateY(c*220+enemy.getHeightInMeters()); // Randomly position the Titan on the y-axis


                } else if (enemy instanceof AbnormalTitan) {

                    titan.setFill(Color.BLUE);
                    titan.setRadius(enemy.getHeightInMeters());
                    titan.setTranslateX(enemy.getDistance()*20); // Randomly position the Titan on the x-axis
                    titan.setTranslateY(c*220+enemy.getHeightInMeters());// Randomly position the Titan on the y-axis

                } else if (enemy instanceof ArmoredTitan){

                    titan.setFill(Color.GOLD);
                    titan.setRadius(enemy.getHeightInMeters());
                    titan.setTranslateX(enemy.getDistance()*20);
                    titan.setTranslateY(c*220+enemy.getHeightInMeters());

                }
                else if (enemy instanceof ColossalTitan){

                    titan.setFill(Color.BLACK);
                    titan.setRadius(enemy.getHeightInMeters());
                    titan.setTranslateX(enemy.getDistance()*20); // Randomly position the Titan on the x-axis
                    titan.setTranslateY(c*220+enemy.getHeightInMeters()); // Randomly position the Titan on the y-axis

                }
                this.titanSpawner.getChildren().add(titan);
                this.titanSpawner.getChildren().add(healthLabel);

            }
            c++;

        }
    }
    ////////////////////////////////////hhhhhhhhhhhhhhhhhhh
    public void displayLaneHealth(int laneNumber) {

        // Check if the lanes list is not empty
        if (lanes.isEmpty()) {
            System.out.println("No lanes to display health for.");
            return;
        }

        // Check if the lane number is valid
        if (laneNumber < 0 || laneNumber >= lanes.size()) {
            System.out.println("Invalid lane number. Please enter a number between 0 and " + (lanes.size() - 1));
            return;
        }

        // Get the lane
        Lane lane = lanes.get(laneNumber);

        // Calculate the health percentage
        double healthPercentage = (double) lane.getLaneWall().getCurrentHealth() / lane.getLaneWall().getBaseHealth();

        // Update the text of the label for this lane
        healthLabels[laneNumber].setText("Lane " + (laneNumber + 1) + " Health: " + (healthPercentage * 100) + "%");
    }
public void titanMove(){
        for (Titan titan:GameControl.getApproachingTitans()) {
        int x_axis = titan.getDistance();
        int y_axis = titan.getDistance();
        titan.setDistance(x_axis-1);
    }


}


public void UpdateLabels(HBox labelBox, GridPane root) {
    // Create new labels with updated information
    Label gamePhaseLabel = new Label("Game Phase : " + GameControl.getBattlePhase());
    Label resourcesLabel = new Label("Gathered resources : " + GameControl.getResourcesGathered());
    Label turnsLabel = new Label("Number of Turns : " + GameControl.getNumberOfTurns());
    Label scoreLabel = new Label("Score : " + GameControl.getScore());

    // Style the labels
    gamePhaseLabel.setStyle("-fx-border-color: black; -fx-border-width: 3; -fx-padding: 2;");
    resourcesLabel.setStyle("-fx-border-color: black; -fx-border-width: 3; -fx-padding: 2;");
    turnsLabel.setStyle("-fx-border-color: black; -fx-border-width: 3; -fx-padding: 2;");
    scoreLabel.setStyle("-fx-border-color: black; -fx-border-width: 3; -fx-padding: 2;");



    // Clear the labelBox and add the new labels
    labelBox.getChildren().clear();
    labelBox.getChildren().addAll(gamePhaseLabel, resourcesLabel, turnsLabel, scoreLabel);
}

    public void displayInvalidLaneMessage(String message) {
        // Create a new Stage
        Stage popupWindow = new Stage();

        // Make it modal
        popupWindow.initModality(Modality.APPLICATION_MODAL);
        popupWindow.setTitle("Invalid Lane");

        // Create a label with the message
        Label messageLabel = new Label(message);

        // Create a layout and add the label
        VBox layout = new VBox(10);
        layout.getChildren().addAll(messageLabel);
        layout.setAlignment(Pos.CENTER);

        // Create a scene with the layout and add it to the window
        Scene scene = new Scene(layout, 300, 200);
        popupWindow.setScene(scene);

        // Show the window
        popupWindow.showAndWait();
    }
    public void displayLaneLostMessage(CheckBox lane, int n, Stage stage) {
                displayInvalidLaneMessage("Lane " +n+" is lost so it is invalid to be played on");
    }
        public Scene getScene() {
            return scene;
        }
        public int realScore(){
    return GameControl.getScore();
        }

    public Tooltip updateLaneTooltip(GameController battle, int i) {
        Tooltip t = new Tooltip("Lane" + (i + 1) +
                "\nDanger Level: " + GameControl.getOriginalLanes().get(i).getDangerLevel() +
                "\nPure Titans: " + GameControl.getOriginalLanes().get(i).getTitans().stream().filter(titan -> titan.getDangerLevel() == 1).count() +
                "\nAbnormal Titans: " + GameControl.getOriginalLanes().get(i).getTitans().stream().filter(titan -> titan.getDangerLevel() == 2).count() +
                "\nArmored Titans: " + GameControl.getOriginalLanes().get(i).getTitans().stream().filter(titan -> titan.getDangerLevel() == 3).count() +
                "\nColossal Titans: " + GameControl.getOriginalLanes().get(i).getTitans().stream().filter(titan -> titan.getDangerLevel() == 4).count() +
                "\nHealth: " + GameControl.getOriginalLanes().get(i).getLaneWall().getCurrentHealth() + "/" + GameControl.getOriginalLanes().get(i).getLaneWall().getBaseHealth() +
                "\nPiercing Cannon: x" + GameControl.getOriginalLanes().get(i).getWeapons().stream().filter(weapon -> weapon.getClass().getSimpleName().equals("PiercingCannon")).count() +
                "\nSniper Cannon: x" + GameControl.getOriginalLanes().get(i).getWeapons().stream().filter(weapon -> weapon.getClass().getSimpleName().equals("SniperCannon")).count() +
                "\nVolley Spread Cannon: x" + GameControl.getOriginalLanes().get(i).getWeapons().stream().filter(weapon -> weapon.getClass().getSimpleName().equals("VolleySpreadCannon")).count() +
                "\nWall Trap: x" + GameControl.getOriginalLanes().get(i).getWeapons().stream().filter(weapon -> weapon.getClass().getSimpleName().equals("WallTrap")).count());
        return t;
    }

    }

