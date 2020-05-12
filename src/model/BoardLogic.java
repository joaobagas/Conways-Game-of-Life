package model;

public class BoardLogic {
    public boolean[][] resetBoard() {
        boolean[][] board;
        board = new boolean[][]{{false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},
                                {false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},
                                {false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},
                                {false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},
                                {false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},
                                {false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},
                                {false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},
                                {false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},
                                {false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},
                                {false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},
                                {false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},
                                {false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},
                                {false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},
                                {false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},
                                {false,false,false,false,false,false,false,false,false,false,false,false,false,false,false}};
        return board;
    }

    private boolean[][] newGeneration(int numberOfCells, boolean[][] board) {
        boolean[][] tempBoard = resetBoard();
        for (int i = 0; i < numberOfCells; i++) { for (int j = 0; j < numberOfCells; j++) { tempBoard[j][i] = isAlive(i, j, numberOfCells, board); } }
        return tempBoard;
    }

    private boolean isAlive (int x, int y, int numberOfCells, boolean[][] board) {
        if (board[y][x]) {
            if      (checkNumberOfNeighbors(x, y, numberOfCells, board) < 2) { return false; }
            else if (checkNumberOfNeighbors(x, y, numberOfCells, board) > 3) { return false; }
            else                                      { return true;  }
        }
        else { if (checkNumberOfNeighbors(x, y, numberOfCells, board) == 3)  {  return true; } }
        return false;
    }

    private int checkNumberOfNeighbors(int x, int y, int numberOfCells, boolean[][] board) {
        int count = 0;
        if (y > 0 && x > 0)                             { if (board[y-1][x-1]) { count++; } }
        if (y > 0)                                      { if (board[y-1][x])   { count++; } }
        if (x > 0)                                      { if (board[y][x-1])   { count++; } }
        if (y < numberOfCells-1 && x < numberOfCells-1) { if (board[y+1][x+1]) { count++; } }
        if (y < numberOfCells-1)                        { if (board[y+1][x])   { count++; } }
        if (x < numberOfCells-1)                        { if (board[y][x+1])   { count++; } }
        if (y < numberOfCells-1 && x > 0)               { if (board[y+1][x-1]) { count++; } }
        if (y > 0 && x < numberOfCells-1)               { if (board[y-1][x+1]) { count++; } }
        return count;
    }

    public void startSimulation(int numberOfCells, boolean[][] board) throws InterruptedException {
        while (true) {
            newGeneration(numberOfCells, board);
            Thread.sleep(5000);
        }
    }
}
