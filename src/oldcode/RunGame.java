package oldcode;

public class RunGame {
    public static void main(String[] args) {
        Board board = new Board();
        System.out.println("\nGeneration 1:\n" );
        System.out.println(board.toString());
        for (int i = 0; i < 10; i++) {
            board.newGeneration();
            System.out.println("\nGeneration " + (i+2) + ":\n" );
            System.out.println(board.toString());
        }
    }
}
