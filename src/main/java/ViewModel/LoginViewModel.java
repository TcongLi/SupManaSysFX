package ViewModel;

import View.MainView;
import de.saxsys.mvvmfx.FluentViewLoader;
import de.saxsys.mvvmfx.ViewModel;
import de.saxsys.mvvmfx.ViewTuple;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

/**
 * Created by L T on 2017/1/10.
 */
public class LoginViewModel implements ViewModel {
    public static final String VALID = "VALID";
    public static final String IDENTITYNOTSELECT = "IDENTITYNOTSELECT";
    public static final String INVALIDPSW = "INVALIDPSW";
    public static final int STAFF = 0;
    public static final int MANAGER = 1;
    private StringProperty userName = new SimpleStringProperty();
    private StringProperty passWord = new SimpleStringProperty();

    private StringProperty identity = new SimpleStringProperty();

    public void onLogin(){
        if(Objects.equals(userName.get(), "sa") && Objects.equals(passWord.get(), "123456")){
            if(identity.get()==null||identity.get().isEmpty()){
                publish(IDENTITYNOTSELECT,null);
            }else{
                publish(VALID,null);
                launchMainStage();
            }
        }else{
            publish(INVALIDPSW,null);
        }
    }

    /**
     * 主界面入口.
     *
     */
    private void launchMainStage(){
        ViewTuple<MainView,MainViewModel> vt = FluentViewLoader.fxmlView(MainView.class).load();
        Stage mainStage = MainViewModel.getMainStage();
        mainStage.setTitle("供应管理系统");
        mainStage.setScene(new Scene(vt.getView()));
        mainStage.sizeToScene();
        mainStage.show();
    }

    public String getUserName() {
        return userName.get();
    }

    public StringProperty userNameProperty() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName.set(userName);
    }

    public String getPassWord() {
        return passWord.get();
    }

    public StringProperty passWordProperty() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord.set(passWord);
    }

    public String getIdentity() {
        return identity.get();
    }

    public StringProperty identityProperty() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity.set(identity);
    }
}
