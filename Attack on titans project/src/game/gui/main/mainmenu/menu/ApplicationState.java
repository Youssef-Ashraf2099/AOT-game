package game.gui.main.mainmenu.menu;

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
