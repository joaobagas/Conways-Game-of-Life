package view;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class Tile extends Button implements EventHandler {
    private boolean alive;
    private int x, y;

    public Tile(int x, int y) {
        this.setPrefSize(25, 25);
        this.setOnAction(this);
        this.setStyle("-fx-background-color: #d7d7d7; -fx-border-color: black;");
    }

    public boolean isAlive() { return alive; }

    private void activate() {
        alive = true;
        this.setStyle("-fx-background-color: #4b4b4b; -fx-border-color: black;");
    }

    private void deactivate() {
        alive = false;
        this.setStyle("-fx-background-color: #d7d7d7; -fx-border-color: black;");
    }

    public void setAlive(boolean alive) {
        if (alive) { activate(); }
        else { deactivate(); }
    }

    @Override
    public void handle(Event event) {
        if (isAlive()) { deactivate(); }
        else { activate(); }
    }
}
