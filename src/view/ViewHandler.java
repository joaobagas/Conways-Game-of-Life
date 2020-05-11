package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import viewmodel.ViewModelFactory;

import java.io.IOException;

public class ViewHandler {
    private ViewModelFactory viewModelFactory;
    private Scene currentScene;
    private Stage primaryStage;
    private MainWindowController mainWindowController;

    public ViewHandler(ViewModelFactory viewModelFactory) {
        this.viewModelFactory = viewModelFactory;
        this.currentScene = new Scene(new Region());
    }

    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        openView("Main");
    }

    public void openView(String id) {
        Region root = null;
        double width = 0;
        double height = 0;

        switch (id) {
            case "Main":
                mainWindowController = loadMainWindowView("/view/MainWindow.fxml", mainWindowController);
                root = mainWindowController.getRoot();
                break;
            default:
                System.out.println("ERROR NO CHOSEN WINDOW");
        }

        width = root.prefWidth(0);
        height = root.prefHeight(0);

        currentScene.setRoot(root);
        primaryStage.setTitle("Conway's Game of Life");
        primaryStage.setScene(currentScene);
        primaryStage.setWidth(width);
        primaryStage.setHeight(height);
        primaryStage.show();
    }

    public void closeView() { primaryStage.close(); }

    private MainWindowController loadMainWindowView(String fxmlFile, MainWindowController controller) {
        controller = null;
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(fxmlFile));
            Region root = loader.load();
            controller = loader.getController();
            controller.init(this, viewModelFactory.getMainWindowViewModel(), root);
        }
        catch (IOException e) { e.printStackTrace(); }
        return controller;
    }
}
