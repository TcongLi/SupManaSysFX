package Model.DTO;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by L T on 2017/1/11.
 */
public class StaffDTO {
    private StringProperty id = new SimpleStringProperty();
    private StringProperty name = new SimpleStringProperty();
    private StringProperty gender = new SimpleStringProperty();
    private StringProperty address = new SimpleStringProperty();
    private StringProperty dept = new SimpleStringProperty();

    public StaffDTO(StringProperty id, StringProperty name, StringProperty gender, StringProperty address, StringProperty dept) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.dept = dept;
    }

    public String getId() {
        return id.get();
    }

    public StringProperty idProperty() {
        return id;
    }

    public void setId(String id) {
        this.id.set(id);
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

    public String getDept() {
        return dept.get();
    }

    public StringProperty deptProperty() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept.set(dept);
    }
}
