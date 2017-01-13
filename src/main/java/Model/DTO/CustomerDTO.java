package Model.DTO;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by L T on 2017/1/12.
 */
public class CustomerDTO {
    //id phone name gender address mail
    StringProperty customerId = new SimpleStringProperty();
    StringProperty phone = new SimpleStringProperty();
    StringProperty name = new SimpleStringProperty();
    StringProperty gender = new SimpleStringProperty();
    StringProperty address = new SimpleStringProperty();
    StringProperty mail = new SimpleStringProperty();

    public CustomerDTO(){

    }
    public CustomerDTO(StringProperty customerId, StringProperty phone, StringProperty name, StringProperty gender, StringProperty address, StringProperty mail) {
        this.customerId = customerId;
        this.phone = phone;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.mail = mail;
    }
    public CustomerDTO(String customerId, String phone, String name, String gender, String address, String mail) {
        this.customerId.set(customerId);
        this.phone.set(phone);
        this.name.set(name);
        this.gender.set(gender);
        this.address.set(address);
        this.mail.set(mail);
    }

    public String getCustomerId() {
        return customerId.get();
    }

    public StringProperty customerIdProperty() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId.set(customerId);
    }

    public String getPhone() {
        return phone.get();
    }

    public StringProperty phoneProperty() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone.set(phone);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getGender() {
        return gender.get();
    }

    public StringProperty genderProperty() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender.set(gender);
    }

    public String getAddress() {
        return address.get();
    }

    public StringProperty addressProperty() {
        return address;
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public String getMail() {
        return mail.get();
    }

    public StringProperty mailProperty() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail.set(mail);
    }
}
