package View;

import Model.DTO.SaleOrderDTO;
import Model.DTO.SaleOrderItemDTO;
import ViewModel.OrderViewModel;
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
 * Created by L T on 2017/1/12.
 */
public class OrderView implements FxmlView<OrderViewModel>,Initializable{



    @FXML
    private TableView<SaleOrderDTO> table1;

    @FXML
    private TableColumn<SaleOrderDTO, String> orderIdCol;

    @FXML
    private TableColumn<SaleOrderDTO, String> dateCol;

    @FXML
    private TableColumn<SaleOrderDTO, String> phoneCol;

    @FXML
    private TableColumn<SaleOrderDTO, String> cusNameCol;

    @FXML
    private TableColumn<SaleOrderDTO, String> genderCol;

    @FXML
    private TableColumn<SaleOrderDTO, String> addrCol;

    @FXML
    private TableColumn<SaleOrderDTO, String> mailCol;

    @FXML
    private TableView<SaleOrderItemDTO> table2;

    @FXML
    private TableColumn<SaleOrderItemDTO, String> prodNameCol;

    @FXML
    private TableColumn<SaleOrderItemDTO, Double> priceCol;

    @FXML
    private TableColumn<SaleOrderItemDTO, String> infoCol;

    @FXML
    private TableColumn<SaleOrderItemDTO, Integer> amountCol;

    @FXML
    private JFXComboBox<String> prodListComboBox;

    @FXML
    private JFXTextField amountInput;

    @FXML
    private JFXTextField orderIdInput;


    @FXML
    private JFXComboBox<String> cusNameListComboBox;

    @FXML
    void onAddItem(ActionEvent event) {
        vm.onAddItem();
    }

    @FXML
    void onAddOrder(ActionEvent event) {
        vm.onAddOrder();
    }

    @FXML
    void onDeleteItem(ActionEvent event) {
        vm.onDeleteItem();
    }

    @FXML
    void onDeleteOrder(ActionEvent event) {
        vm.onDeleteOrder();
    }

    @FXML
    void onUpdateItem(ActionEvent event) {
        vm.onUpdateItem();
    }
    @InjectViewModel
    OrderViewModel vm;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //绑定

        table1.setItems(vm.getSaleOrderList());

        orderIdCol.setCellValueFactory(c->c.getValue().orderIdProperty());
        dateCol.setCellValueFactory(new PropertyValueFactory<SaleOrderDTO,String>("date"));
        phoneCol.setCellValueFactory(c->c.getValue().getCustomer().phoneProperty());
        cusNameCol.setCellValueFactory(c->c.getValue().getCustomer().nameProperty());
        genderCol.setCellValueFactory(c->c.getValue().getCustomer().genderProperty());
        addrCol.setCellValueFactory(c->c.getValue().getCustomer().addressProperty());
        mailCol.setCellValueFactory(c->c.getValue().getCustomer().mailProperty());

        table1.getSelectionModel().selectedItemProperty().addListener((o,ov,nv)->{
            vm.setSaleOrderDTO(nv);
            vm.setCusName(nv.getCustomer().getName());
            vm.setOrderId(nv.getOrderId());
            vm.setItemList(nv.getItems());
        });


        //orderIdInput.textProperty().bindBidirectional(vm.getSaleOrderDTO().orderIdProperty());

        orderIdInput.textProperty().bindBidirectional(vm.orderIdProperty());

        cusNameListComboBox.setItems(vm.getCustomerList());
        cusNameListComboBox.valueProperty().bindBidirectional(vm.cusNameProperty());

        //---------------------------------详情--------------------------------------

        prodNameCol.setCellValueFactory(c->c.getValue().getProduct().prodNameProperty());
        priceCol.setCellValueFactory(c->c.getValue().getProduct().prodPriceProperty().asObject());
        infoCol.setCellValueFactory(c->c.getValue().getProduct().prodInfoProperty());
        amountCol.setCellValueFactory(c->c.getValue().amountProperty().asObject());

        table2.setItems(vm.getItemList());

        table2.getSelectionModel().selectedItemProperty().addListener((o,ov,nv)->{
            vm.setSaleOrderItemDTO(nv);
            vm.setProdName(nv.getProduct().getProdName());
            vm.setProdAmount(nv.getAmount()+"");
        });

        prodListComboBox.setItems(vm.getProductList());
        prodListComboBox.valueProperty().bindBidirectional(vm.prodNameProperty());

        amountInput.textProperty().bindBidirectional(vm.prodAmountProperty());
    }
}
