package Model.DTO;

import javafx.beans.property.*;

/**
 * Created by L T on 2017/1/12.
 */
public class SaleOrderItemDTO {
    StringProperty itemID = new SimpleStringProperty();
    IntegerProperty amount = new SimpleIntegerProperty();
    ProductDTO product;


    public SaleOrderItemDTO(){}
    public SaleOrderItemDTO(StringProperty itemID, IntegerProperty amount,ProductDTO product ) {
        this.itemID = itemID;
        this.product = product;
        this.amount = amount;
    }
    public SaleOrderItemDTO(String itemID,Integer amount,ProductDTO product) {
        this.itemID.set(itemID);
        this.product = product;
        this.amount.set(amount);
    }


    public String getItemID() {
        return itemID.get();
    }

    public StringProperty itemIDProperty() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID.set(itemID);
    }



    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }

    public int getAmount() {
        return amount.get();
    }

    public IntegerProperty amountProperty() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount.set(amount);
    }
}
