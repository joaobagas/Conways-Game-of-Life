package viewmodel;

import model.GameOfLifeLogic;

public class ViewModelFactory {
    private MainWindowViewModel mainWindowViewModel;

    public ViewModelFactory(GameOfLifeLogic model) {
        mainWindowViewModel = new MainWindowViewModel(model);
    }

    public MainWindowViewModel getMainWindowViewModel() { return mainWindowViewModel; }
}