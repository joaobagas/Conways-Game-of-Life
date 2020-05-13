package view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import viewmodel.MainWindowViewModel;

public class MainWindowController {
    private ViewHandler viewHandler;
    private MainWindowViewModel viewModel;
    private Region root;
    private Tile[][] tiles;
    @FXML private GridPane boardGridPane;

    public MainWindowController() {}

    public void init(ViewHandler viewHandler, MainWindowViewModel viewModel, Region root) {
        this.viewHandler = viewHandler;
        this.viewModel = viewModel;
        this.root = root;
        this.tiles = new Tile[15][15];

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                Tile t = new Tile(i, j);
                tiles[i][j] = t;
                boardGridPane.add(t, i, j);
            }
        }

        viewModel.addTiles(tiles);
    }

    public Region getRoot() { return root; }

    @FXML public void startSimulationButtonPressed() { viewModel.startSimulationButtonPressed(); }

    @FXML public void resetButtonPressed() { viewModel.resetButtonPressed(); }

    @FXML public void exitButtonPressed() { viewModel.exitButtonPressed(); }
}
