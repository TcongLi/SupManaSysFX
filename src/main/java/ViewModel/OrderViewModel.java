package ViewModel;

import Model.DTO.CustomerDTO;
import Model.DTO.ProductDTO;
import Model.DTO.SaleOrderDTO;
import Model.DTO.SaleOrderItemDTO;
import Service.SaleOrderService;
import de.saxsys.mvvmfx.ViewModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by L T on 2017/1/12.
 */
public class OrderViewModel implements ViewModel {

    /**
     * 服务接口,处理业务逻辑.
     */
    SaleOrderService service = new SaleOrderService() {
    };

    /**
     * 所有订单
     */
    ObservableList<SaleOrderDTO> saleOrderList = FXCollections.observableArrayList();

    /**
     * 所有顾客
     */
    ObservableList<String> customerList = FXCollections.observableArrayList();

    /**
     * 所有产品
     */
    ObservableList<String> productList = FXCollections.observableArrayList();

    /**
     * 选中的订单,订单号,顾客
     */
    SaleOrderDTO saleOrderDTO = new SaleOrderDTO("",null,new CustomerDTO(),null);
    StringProperty orderId = new SimpleStringProperty();
    StringProperty cusName = new SimpleStringProperty();

    /**
     * 选中订单的所有项
     */
    ObservableList<SaleOrderItemDTO> itemList = FXCollections.observableArrayList();

    /**
     * 选中的订单中的一项
     */
    SaleOrderItemDTO saleOrderItemDTO = new SaleOrderItemDTO();
    StringProperty prodName = new SimpleStringProperty();
    StringProperty prodAmount = new SimpleStringProperty();

    /**
     * cusComboBox 中选中的顾客
     */
    CustomerDTO customerDTO = new CustomerDTO();

    /**
     * prodComboBox 中选中的产品
     */
    ProductDTO productDTO = new ProductDTO();

    public OrderViewModel(){
        selectAllOrder();

        List<String> ls = service.getAllCustomers()
                .stream()
                .map(i->i.getName())
                .collect(Collectors.toList());
        customerList.setAll(ls);

        List<String> ls2 = service.getAllProducts()
                .stream()
                .map(i->i.getProdName())
                .collect(Collectors.toList());
        productList.setAll(ls2);
    }

    public void selectAllOrder(){
        saleOrderList.setAll(service.getAllOrderDetails());
    }

    public void clear(){
        prodName.set("");
        prodAmount.set("");
        itemList.clear();
    }


    public void onAddItem() {
        service.insertItem(orderId,prodName,Integer.parseInt(prodAmount.get()));
        selectAllOrder();
        clear();
    }

    public void onAddOrder() {
        String id = service.insertOrder(cusName);
        selectAllOrder();
        orderId.set(id);
    }

    public void onDeleteItem() {
        service.deleteItem(saleOrderItemDTO.itemIDProperty());
        selectAllOrder();
        clear();
    }

    public void onDeleteOrder() {
        service.deleteOrder(orderId);
        selectAllOrder();
    }

    public void onUpdateItem() {
        service.updateItem(orderId,saleOrderItemDTO.itemIDProperty(),prodName,Integer.parseInt(prodAmount.get()));
        selectAllOrder();
        clear();
    }


    public String getOrderId() {
        return orderId.get();
    }

    public StringProperty orderIdProperty() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId.set(orderId);
    }

    public String getCusName() {
        return cusName.get();
    }

    public StringProperty cusNameProperty() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName.set(cusName);
    }

    public SaleOrderService getService() {
        return service;
    }

    public void setService(SaleOrderService service) {
        this.service = service;
    }

    public ObservableList<SaleOrderDTO> getSaleOrderList() {
        return saleOrderList;
    }

    public String getProdAmount() {
        return prodAmount.get();
    }

    public StringProperty prodAmountProperty() {
        return prodAmount;
    }

    public void setProdAmount(String prodAmount) {
        this.prodAmount.set(prodAmount);
    }

    public void setSaleOrderList(ObservableList<SaleOrderDTO> saleOrderList) {
        this.saleOrderList = saleOrderList;
    }

    public SaleOrderDTO getSaleOrderDTO() {
        return saleOrderDTO;
    }

    public void setSaleOrderDTO(SaleOrderDTO saleOrderDTO) {
        this.saleOrderDTO = saleOrderDTO;
    }

    public ObservableList<SaleOrderItemDTO> getItemList() {
        return itemList;
    }

    public String getProdName() {
        return prodName.get();
    }

    public StringProperty prodNameProperty() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName.set(prodName);
    }

    public void setItemList(ObservableList<SaleOrderItemDTO> itemList) {
        this.itemList = itemList;
    }
    public void setItemList(List<SaleOrderItemDTO> ls){
        this.itemList.setAll(ls);
    }

    public SaleOrderItemDTO getSaleOrderItemDTO() {
        return saleOrderItemDTO;
    }

    public void setSaleOrderItemDTO(SaleOrderItemDTO saleOrderItemDTO) {
        this.saleOrderItemDTO = saleOrderItemDTO;
    }

    public CustomerDTO getCustomerDTO() {
        return customerDTO;
    }

    public void setCustomerDTO(CustomerDTO customerDTO) {
        this.customerDTO = customerDTO;
    }

    public ProductDTO getProductDTO() {
        return productDTO;
    }

    public void setProductDTO(ProductDTO productDTO) {
        this.productDTO = productDTO;
    }

    public ObservableList<String> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(ObservableList<String> customerList) {
        this.customerList = customerList;
    }

    public ObservableList<String> getProductList() {
        return productList;
    }

    public void setProductList(ObservableList<String> productList) {
        this.productList = productList;
    }
}
