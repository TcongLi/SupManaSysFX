package View;

import ViewModel.MainViewModel;
import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by L T on 2017/1/10.
 */
public class MainView implements FxmlView<MainViewModel>,Initializable {
    @InjectViewModel
    MainViewModel viewModel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
