package game.gui.main.mainmenu.demo1;

//transelator class

public class ApplicationState {
    private static mainMenu menuInstance;

    public static mainMenu getMenuInstance() {
        if (menuInstance == null) {
            menuInstance = new mainMenu();
        }
        return menuInstance;
    }
}
