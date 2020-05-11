package view;

import javafx.scene.layout.Region;
import viewmodel.MainWindowViewModel;

public class MainWindowController {
    private ViewHandler viewHandler;
    private MainWindowViewModel viewModel;
    private Region root;

    public MainWindowController() {}

    public void init(ViewHandler viewHandler, MainWindowViewModel viewModel, Region root) {
        this.viewHandler = viewHandler;
        this.viewModel = viewModel;
        this.root = root;
    }

    public Region getRoot() { return root; }
}
