import javafx.application.Application;
import javafx.stage.Stage;
import model.GameOfLifeLogic;
import view.ViewHandler;
import viewmodel.ViewModelFactory;

public class Main extends Application {
    public static void main(String[] args) { launch(args); }

    @Override
    public void start(Stage stage) throws Exception {
        GameOfLifeLogic model = new GameOfLifeLogic();
        ViewModelFactory viewModelFactory = new ViewModelFactory(model);
        ViewHandler viewHandler = new ViewHandler(viewModelFactory);
        viewHandler.start(stage);
    }
}
