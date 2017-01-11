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

    StringProperty name = new SimpleStringProperty();
    StringProperty gender = new SimpleStringProperty();
    StringProperty address = new SimpleStringProperty();
    StringProperty dept = new SimpleStringProperty();

    ObservableList<StaffDTO> staffDTOS = FXCollections.observableArrayList();

    public ObservableList<StaffDTO> loadData(){
        staffDTOS.clear();
        staffDTOS.addAll(new StaffDAO(){}.getAllStaffs());
        return staffDTOS;
    }

    public void insertStaff(){
        if(gender.get()==null){
            return;
        }
        new StaffDAO(){}.insertStaff(new StaffDTO(null,name,gender,address,dept));
        clear();
    }

    public void clear(){
        name.set("");
        gender.set("");
        address.set("");
        dept.set("");
    }

    public void deleteStaffByPK(String id){
        new StaffDAO(){}.deleteStaffbyPK(id);
    }

    public ObservableList<StaffDTO> selectStaff(){
        staffDTOS.clear();
        staffDTOS.addAll(new StaffDAO(){}.selectStaff(new StaffDTO(name,gender,address,dept)));
        return staffDTOS;
    }

    public void updateStaff(String id){
        if(gender.get()==null){
            return;
        }
        new StaffDAO(){}.updateStaff(new StaffDTO(new SimpleStringProperty(id),name,gender,address,dept));
        clear();
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
