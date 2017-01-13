package View;

import ViewModel.MainViewModel;
import com.jfoenix.controls.JFXButton;
import de.saxsys.mvvmfx.FluentViewLoader;
import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by L T on 2017/1/10.
 */
public class MainView implements FxmlView<MainViewModel>, Initializable {
    @FXML
    private JFXButton staffManager;

    @FXML
    private JFXButton repoManager;

    @FXML
    private JFXButton saleOrderManager;

    @FXML
    private JFXButton productManager;

    @FXML
    void productManagerClicked(ActionEvent event) {

    }

    @FXML
    void repoManagerClicked(ActionEvent event) {

    }

    @FXML
    void saleOrderManagerClicked(ActionEvent event) {
        Stage orderStage = new Stage();
        orderStage.setScene(new Scene(FluentViewLoader.fxmlView(OrderView.class).load().getView()));
        orderStage.setTitle("订单管理");
        orderStage.sizeToScene();
        orderStage.show();
    }

    @FXML
    void staffManagerClicked(ActionEvent event) {
        Stage staffStage = new Stage();
        staffStage.setScene(new Scene(FluentViewLoader.fxmlView(StaffView.class).load().getView()));
        staffStage.setTitle("员工管理");
        staffStage.sizeToScene();
        staffStage.show();
    }

    @InjectViewModel
    MainViewModel viewModel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


}
