package Model.DTO;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by L T on 2017/1/12.
 */
public class ProductDTO {
    //id name price info
    StringProperty prodId = new SimpleStringProperty();
    StringProperty prodName = new SimpleStringProperty();
    DoubleProperty prodPrice = new SimpleDoubleProperty();
    StringProperty prodInfo = new SimpleStringProperty();


    public ProductDTO(){}
    public ProductDTO(StringProperty prodId, StringProperty prodName, DoubleProperty prodPrice, StringProperty prodInfo) {
        this.prodId = prodId;
        this.prodName = prodName;
        this.prodPrice = prodPrice;
        this.prodInfo = prodInfo;
    }
    public ProductDTO(String prodId, String prodName, Double prodPrice, String prodInfo) {
        this.prodId.set(prodId);
        this.prodName.set(prodName);
        this.prodPrice.set(prodPrice);
        this.prodInfo.set(prodInfo);
    }

    public String getProdId() {
        return prodId.get();
    }

    public StringProperty prodIdProperty() {
        return prodId;
    }

    public void setProdId(String prodId) {
        this.prodId.set(prodId);
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

    public double getProdPrice() {
        return prodPrice.get();
    }

    public DoubleProperty prodPriceProperty() {
        return prodPrice;
    }

    public void setProdPrice(double prodPrice) {
        this.prodPrice.set(prodPrice);
    }

    public String getProdInfo() {
        return prodInfo.get();
    }

    public StringProperty prodInfoProperty() {
        return prodInfo;
    }

    public void setProdInfo(String prodInfo) {
        this.prodInfo.set(prodInfo);
    }
}
