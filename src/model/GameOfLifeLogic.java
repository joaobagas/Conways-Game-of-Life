package model;

import view.Tile;

public class GameOfLifeLogic implements GameOfLifeModel {
    private BoardLogic boardLogic;
    private boolean[][] board;
    private Tile[][] tiles;
    private int numberOfTreads;
    private int numberOfCells;
    private Thread thread;

    public GameOfLifeLogic() {
        boardLogic = new BoardLogic();
        resetBoard();
        numberOfTreads = 0;
        numberOfCells = 15; // Because the grid will be 15*15
    }

    public void addTiles(Tile[][] tiles) { this.tiles = tiles; }

    public void resetBoard() { board = boardLogic.resetBoard();}

    @Override
    public void startSimulationButtonPressed() {
        if( numberOfTreads == 0 ) {
            thread = new Thread(this);
            thread.start();
            numberOfTreads += 1;
        }
    }

    @Override
    public void run() { try {boardLogic.startSimulation(numberOfCells, board, tiles);} catch (Exception e) {} }

    @Override
    public void stopSimulationButtonPressed() {
        if ( numberOfTreads == 1 ) {
            thread.interrupt();
            numberOfTreads -= 1;
        }
    }

    @Override
    public void resetButtonPressed() { resetBoard(); boardLogic.updateViewBoard(tiles, board);}

    @Override
    public void exitButtonPressed() { System.exit(0);}
}
