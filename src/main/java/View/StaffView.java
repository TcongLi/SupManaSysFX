package View;

import ViewModel.StaffViewModel;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import de.saxsys.mvvmfx.FxmlView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by L T on 2017/1/11.
 */
public class StaffView implements FxmlView<StaffViewModel>,Initializable {
    @FXML
    private JFXTextField name;

    @FXML
    private JFXTextField address;

    @FXML
    private JFXTextField dept;

    @FXML
    private JFXComboBox<String> genderComboBox;

    @FXML
    private TableView<?> staffTable;

    @FXML
    private TableColumn<?, ?> userCol;

    @FXML
    private TableColumn<?, ?> genderCol;

    @FXML
    private TableColumn<?, ?> addressCol;

    @FXML
    private TableColumn<?, ?> deptCol;

    @FXML
    void deleteStaff(ActionEvent event) {

    }

    @FXML
    void insertStaff(ActionEvent event) {

    }

    @FXML
    void updateStaff(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
