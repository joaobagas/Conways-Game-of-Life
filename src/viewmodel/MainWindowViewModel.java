package viewmodel;

import javafx.beans.property.BooleanProperty;
import model.GameOfLifeLogic;
import model.GameOfLifeModel;

public class MainWindowViewModel {
    private GameOfLifeModel model;
    private BooleanProperty[][] booleanProperties;

    public MainWindowViewModel(GameOfLifeLogic model) { this.model = model; }

    public void startSimulationButtonPressed() { model.startSimulationButtonPressed(); }

    public void resetButtonPressed() { model.resetButtonPressed(); }

    public void exitButtonPressed() { model.exitButtonPressed(); }
}
