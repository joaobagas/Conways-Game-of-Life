package view;


import javafx.scene.control.Button;

public class Tile extends Button {
    private boolean Alive;
    private int x, y;

    public Tile(int x, int y) {
        this.setPrefSize(25, 25);
        this.setStyle("-fx-background-color: #d7d7d7; -fx-border-color: black;");
    }

    public boolean isAlive() { return Alive; }

    public void activate() {
        Alive = true;
        this.setStyle("-fx-background-color: #4b4b4b; -fx-border-color: black;");
    }

    public void deactivate() {
        Alive = false;
        this.setStyle("-fx-background-color: #d7d7d7; -fx-border-color: black;");
    }
}
