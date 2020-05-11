package oldcode;

public class Board {
    private boolean[][] board;
    private int numberOfCells;

    public Board() {
        board = new boolean[][]{{false,true ,false,false,false,false},
                                {false,false,true ,false,false,false},
                                {true ,true ,true ,false,false,false},
                                {false,false,false,false,false,false},
                                {false,false,false,false,false,false},
                                {false,false,false,false,false,false}};
        numberOfCells = 6; /*If it's 6x6 then numberOfCells is 5*/
    }

    public int checkNumberOfNeighbors(int x, int y) {
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

    public boolean isAlive (int x, int y) {
        if (board[y][x]) {
            if      (checkNumberOfNeighbors(x,y) < 2) { return false; }
            else if (checkNumberOfNeighbors(x,y) > 3) { return false; }
            else                                      { return true;  }
        }
        else { if (checkNumberOfNeighbors(x,y) == 3)  {  return true; } }
        return false;
    }

    public void refreshBoard(boolean[][] tempBoard) { // Transfers the values from the temporary board to the real one
        for (int i = 0; i < numberOfCells; i++) {
            for (int j = 0; j < numberOfCells; j++) {
                board[i][j] = tempBoard[i][j];
            }
        }
    }

    public void newGeneration() {
        boolean[][] tempBoard = new boolean[][]{{false,false,false,false,false,false},
                                                {false,false,false,false,false,false},
                                                {false,false,false,false,false,false},
                                                {false,false,false,false,false,false},
                                                {false,false,false,false,false,false},
                                                {false,false,false,false,false,false}};
        for (int i = 0; i < numberOfCells; i++) { for (int j = 0; j < numberOfCells; j++) { tempBoard[j][i] = isAlive(i,j); } }
        refreshBoard(tempBoard);
    }

    public String toString() {
        String s = "|---|---|---|---|---|---|\n";
        for (int i = 0; i < numberOfCells; i++) {
            for (int j = 0; j < numberOfCells; j++) {
                if (board[i][j]) { s += "| O "; }
                else             { s += "|   "; }
            }
            s += "|\n|---|---|---|---|---|---|\n";
        }
        return s;
    }
}
