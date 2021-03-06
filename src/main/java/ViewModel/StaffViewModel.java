package ViewModel;

import DAO.StaffDAO;
import Model.DTO.StaffDTO;
import de.saxsys.mvvmfx.ViewModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Created by L T on 2017/1/11.
 */
public class StaffViewModel implements ViewModel {

    /**
     * 当前 Staff 的 id,用于 删改.
     */
    StringProperty id = new SimpleStringProperty();

    StringProperty name = new SimpleStringProperty();
    StringProperty gender = new SimpleStringProperty();
    StringProperty address = new SimpleStringProperty();
    StringProperty dept = new SimpleStringProperty();

    ObservableList<StaffDTO> staffDTOS = FXCollections.observableArrayList();

    public void selectAllStaff() {
        staffDTOS.setAll(new StaffDAO() {
        }.getAllStaffs());
    }

    public void selectStaff() {
        staffDTOS.setAll(new StaffDAO() {
        }.selectStaff(new StaffDTO(name, gender, address, dept)));
        clear();
    }

    public void deleteStaffByPK() {
        new StaffDAO() {
        }.deleteStaffByPK(id.get());
        selectAllStaff();
        clear();
    }


    public void insertStaff() {
        // 性别未选中时,拦截该事件.
        if (gender.get() == null) {
            return;
        }
        new StaffDAO() {
        }.insertStaff(new StaffDTO(null, name, gender, address, dept));
        selectAllStaff();
        clear();
    }

    public void updateStaff() {
        if (gender.get() == null) {
            return;
        }
        new StaffDAO() {
        }.updateStaff(new StaffDTO(id, name, gender, address, dept));
        selectAllStaff();
        clear();
    }

    public void clear() {
        name.set("");
        gender.set("");
        address.set("");
        dept.set("");
    }


    //getter and setter------------------------

    public String getId() {
        return id.get();
    }

    public StringProperty idProperty() {
        return id;
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public ObservableList<StaffDTO> getStaffDTOS() {
        return staffDTOS;
    }

    public void setStaffDTOS(ObservableList<StaffDTO> staffDTOS) {
        this.staffDTOS = staffDTOS;
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
