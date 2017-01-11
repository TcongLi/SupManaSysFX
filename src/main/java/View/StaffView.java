package View;

import Model.DTO.StaffDTO;
import ViewModel.StaffViewModel;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

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
        viewModel.deleteStaffByPK(staffTable.getSelectionModel().selectedItemProperty().get().getId());
        loadData();
    }

    @FXML
    void insertStaff(ActionEvent event) {
        viewModel.insertStaff();
        loadData();
    }

    @FXML
    void updateStaff(ActionEvent event) {
        viewModel.updateStaff(staffTable.getSelectionModel().selectedItemProperty().get().getId());
        loadData();
    }

    @FXML
    void selectStaff(ActionEvent event){
        viewModel.selectStaff();
        staffTable.setItems(viewModel.selectStaff());
    }

    @InjectViewModel
    StaffViewModel viewModel;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        name.textProperty().bindBidirectional(viewModel.nameProperty());
        genderComboBox.valueProperty().bindBidirectional(viewModel.genderProperty());
        address.textProperty().bindBidirectional(viewModel.addressProperty());
        dept.textProperty().bindBidirectional(viewModel.deptProperty());

        genderComboBox.getItems().add("男");
        genderComboBox.getItems().add("女");

        userCol.setCellValueFactory(new PropertyValueFactory<StaffDTO, String>("name"));
        genderCol.setCellValueFactory(new PropertyValueFactory<StaffDTO, String>("gender"));
        addressCol.setCellValueFactory(new PropertyValueFactory<StaffDTO, String>("address"));
        deptCol.setCellValueFactory(new PropertyValueFactory<StaffDTO, String>("dept"));

        staffTable.getSelectionModel().selectedItemProperty().addListener((o,ov,nv)->{
            if(nv == null){
                return;
            }
            name.setText(nv.getName());
            genderComboBox.setValue(nv.getGender());
            address.setText(nv.getAddress());
            dept.setText(nv.getDept());
        });

        loadData();
    }

    private void loadData(){
        staffTable.setItems(viewModel.loadData());
    }
}
