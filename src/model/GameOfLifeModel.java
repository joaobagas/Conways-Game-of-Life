package model;

import view.Tile;

public interface GameOfLifeModel extends Runnable {
    void startSimulationButtonPressed();
    void stopSimulationButtonPressed();
    void resetButtonPressed();
    void exitButtonPressed();
    void addTiles(Tile[][] tiles);
}
