module org.example.demo1 {
  requires javafx.controls;
    requires javafx.fxml;
requires javafx.graphics;
    requires javafx.base;
    requires javafx.media;
   // requires jdk.internal.vm.compiler.management;
    requires junit;



    //requires javafx.controls;
    //requires javafx.fxml;

    // Add this line to export the package to javafx.graphics
    exports game.gui.main.mainmenu.demo1 to javafx.graphics;

    opens game.gui.main.mainmenu.demo1;
}

