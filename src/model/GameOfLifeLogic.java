package model;

public class GameOfLifeLogic {
    private BoardLogic boardLogic;
    private boolean[][] board;
    private int numberOfCells;

    public GameOfLifeLogic() {
        resetBoard();
        numberOfCells = 15; // Because the grid will be 15*15
    }

    public void resetBoard() { board = boardLogic.resetBoard(); }

    public void newGeneration() { board = boardLogic.newGeneration(numberOfCells, board); }
}
