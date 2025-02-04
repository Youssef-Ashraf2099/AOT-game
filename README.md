hello and welcome i am thrilled to write this instruction to try one of my best projects in my university time and at the first part i will illustrate how to run the project and the point of the game.

## How to run
You must adjust your screen display to 100%. I know it's annoying, but it was a mistake ;) After setting up JavaFX on your IDE, choose the "Intro" class to start the game.

## Setting Up JavaFX

### Setting Up JavaFX in Eclipse

1. **Download JavaFX SDK**:
   - Go to the [Gluon website](https://gluonhq.com/products/javafx/) and download the JavaFX SDK for your operating system.
   - Extract the downloaded SDK to a convenient location on your computer.

2. **Configure Eclipse**:
   - Open Eclipse and go to `Window` > `Preferences`.
   - Navigate to `Java` > `Build Path` > `User Libraries` and click `New`.
   - Name the new library `JavaFX` and click `OK`.
   - Select the newly created `JavaFX` library and click `Add External JARs`.
   - Add all the JAR files from the `lib` folder of the extracted JavaFX SDK.
   - Click `OK` to save the changes.

3. **Create a JavaFX Project**:
   - Create a new Java project in Eclipse.
   - Right-click on the project, select `Properties`, and go to `Java Build Path`.
   - Click on the `Libraries` tab and then `Add Library`.
   - Select `User Library` and add the `JavaFX` library you created earlier.
   - Click `Apply and Close`.

4. **Set VM Arguments**:
   - Right-click on your project, select `Run As` > `Run Configurations`.
   - Under the `Arguments` tab, add the following to `VM arguments`:
     ```
     --module-path "path-to-javafx-sdk/lib" --add-modules javafx.controls,javafx.fxml
     ```
   - Replace `path-to-javafx-sdk` with the actual path to your extracted JavaFX SDK.

### Setting Up JavaFX in IntelliJ

1. **Download JavaFX SDK**:
   - Go to the [Gluon website](https://gluonhq.com/products/javafx/) and download the JavaFX SDK for your operating system.
   - Extract the downloaded SDK to a convenient location on your computer.

2. **Configure IntelliJ**:
   - Open IntelliJ and create a new Java project.
   - Go to `File` > `Project Structure` > `Libraries` and click `+`.
   - Select `Java` and add all the JAR files from the `lib` folder of the extracted JavaFX SDK.
   - Click `OK` to save the changes.

3. **Add VM Options**:
   - Go to `Run` > `Edit Configurations`.
   - Under `VM options`, add the following:
     ```
     --module-path "path-to-javafx-sdk/lib" --add-modules javafx.controls,javafx.fxml
     ```
   - Replace `path-to-javafx-sdk` with the actual path to your extracted JavaFX SDK.

## How to play

Attack on Titan: Utopia is a one-player, endless tower defense game inspired by the hit anime Attack on Titan. The story of the anime revolves around how titans, gigantic humanoid creatures, attack the walls protecting humanity.

- A part of the wall to be defended. This wall part will have a starting HP (health points) that decreases after being attacked and if this part of the wall is destroyed, this lane will no longer be defended.
- The weapons that the player has already deployed into this lane.
- The titans that are on their way to attack the part of the wall at the end of the lane. The titans can be at different distances from the walls depending on how much they have already moved. Each titan has the following stats:
  - HP: The health points of the titan.
  - Damage: The amount of damage the titan does when attacking a wall.
  - Height: The height of the titan in meters, doesn’t affect the gameplay.
  - Distance from walls: How far the titan is from the walls in “Distance Unit”.
  - Speed: The distance that the titan moves per turn in “Distance Unit”.
  - Resources value: The amount of resources that the player gains by defeating this titan.
  - Danger level: How much this titan affects a lane’s danger level.
  - A special distance unit used for the sake of this game (does not necessarily translate to any realistic distance).

- The different types of weapons will have a different set of starting stats according to their type, including:
  - Weapon Type
  - Price
  - Damage
  - Minimum Range
  - Maximum Range

Enjoy defending humanity from the titans!
