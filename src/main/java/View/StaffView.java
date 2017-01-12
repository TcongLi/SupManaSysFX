package View;

import Model.DTO.StaffDTO;
import ViewModel.StaffViewModel;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
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
public class StaffView implements FxmlView<StaffViewModel>, Initializable {

    /**
     * 被选中的 Staff 的 id.
     */
    private StringProperty id = new SimpleStringProperty();

    @FXML
    private JFXTextField name;

    @FXML
    private JFXTextField address;

    @FXML
    private JFXTextField dept;

    @FXML
    private JFXComboBox<String> genderComboBox;

    @FXML
    private TableView<StaffDTO> staffTable;

    @FXML
    private TableColumn<StaffDTO, String> userCol;

    @FXML
    private TableColumn<StaffDTO, String> genderCol;

    @FXML
    private TableColumn<StaffDTO, String> addressCol;

    @FXML
    private TableColumn<StaffDTO, String> deptCol;

    @FXML
    void deleteStaff(ActionEvent event) {
        //当前没有行被选中时,拦截此事件.
        if (id == null) {
            return;
        }
        viewModel.deleteStaffByPK();
    }

    @FXML
    void insertStaff(ActionEvent event) {
        viewModel.insertStaff();
    }

    @FXML
    void updateStaff(ActionEvent event) {
        if (id == null) {
            return;
        }
        viewModel.updateStaff();
    }

    @FXML
    void selectStaff(ActionEvent event) {
        viewModel.selectStaff();
    }


    @InjectViewModel
    StaffViewModel viewModel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /*
         * 绑定属性
         */
        id.bindBidirectional(viewModel.idProperty());

        name.textProperty().bindBidirectional(viewModel.nameProperty());
        genderComboBox.valueProperty().bindBidirectional(viewModel.genderProperty());
        address.textProperty().bindBidirectional(viewModel.addressProperty());
        dept.textProperty().bindBidirectional(viewModel.deptProperty());

        genderComboBox.getItems().add("男");
        genderComboBox.getItems().add("女");

        userCol.setCellValueFactory(c -> c.getValue().nameProperty());
        genderCol.setCellValueFactory(c -> c.getValue().genderProperty());
        addressCol.setCellValueFactory(c -> c.getValue().addressProperty());
        deptCol.setCellValueFactory(c -> c.getValue().deptProperty());

        /*
         * 监听表格选中事件,把选中的 Staff 属性动态添加到左侧框,**并更新其id**.
         */
        staffTable.getSelectionModel().selectedItemProperty().addListener((o, ov, nv) -> {
            if (nv == null) {
                return;
            }
            id.set(nv.getId());
            name.setText(nv.getName());
            genderComboBox.setValue(nv.getGender());
            address.setText(nv.getAddress());
            dept.setText(nv.getDept());
        });
        staffTable.setItems(viewModel.getStaffDTOS());
        viewModel.selectAllStaff();
    }
}
