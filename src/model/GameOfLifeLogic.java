package model;

public class GameOfLifeLogic implements GameOfLifeModel {
    private BoardLogic boardLogic;
    private boolean[][] board;
    private int numberOfCells;

    public GameOfLifeLogic() {
        boardLogic = new BoardLogic();
        resetBoard();
        numberOfCells = 15; // Because the grid will be 15*15
    }

    public void resetBoard() { board = boardLogic.resetBoard(); }

    @Override
    public void startSimulationButtonPressed() { new Thread(this).start(); }

    @Override
    public void run() { try {boardLogic.startSimulation(numberOfCells, board);} catch (Exception e) {} }

    @Override
    public void resetButtonPressed() { resetBoard(); }

    @Override
    public void exitButtonPressed() { System.exit(0);}
}
