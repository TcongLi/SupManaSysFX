package Model.DTO;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by L T on 2017/1/12.
 */
public class SaleOrderDTO {
    StringProperty orderId = new SimpleStringProperty();
    Timestamp date;
    CustomerDTO customer;
    List<SaleOrderItemDTO> items;

    public SaleOrderDTO(){

    }
    public SaleOrderDTO(StringProperty orderId, Timestamp date, CustomerDTO customer, List<SaleOrderItemDTO> items) {
        this.orderId = orderId;
        this.date = date;
        this.customer = customer;
        this.items = items;
    }

    public SaleOrderDTO(String orderId, Timestamp date, CustomerDTO customer, List<SaleOrderItemDTO> items) {
        this.orderId.set(orderId);
        this.date = date;
        this.customer = customer;
        this.items = items;
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

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }

    public List<SaleOrderItemDTO> getItems() {
        return items;
    }

    public void setItems(List<SaleOrderItemDTO> items) {
        this.items = items;
    }
}
