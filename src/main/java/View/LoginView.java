package View;

import ViewModel.LoginViewModel;
import com.jfoenix.controls.*;
import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by L T on 2017/1/10.
 */
public class LoginView implements FxmlView<LoginViewModel>,Initializable {

    @FXML
    private Pane rootScene;

    @FXML
    private JFXTextField userName;

    @FXML
    private JFXPasswordField passWord;

    @FXML
    private JFXButton btnLogin;

    @FXML
    private JFXButton btnExit;

    @FXML
    private JFXComboBox<String> identity;

    @FXML
    private Hyperlink githubLinkTL;

    @FXML
    private javafx.scene.control.Label errorLabel;


    @FXML
    void onClickGithubLinkTL(ActionEvent event) {
        try {
            Desktop.getDesktop().browse(new URI("https://github.com/TcongLi"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onExit(ActionEvent event) {
        new Thread(()->{
            try {
                Thread.sleep(150);
                System.exit(0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    @FXML
    void onLogin(ActionEvent event) {
        viewModel.onLogin();
    }

    @InjectViewModel
    private LoginViewModel viewModel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        userName.requestFocus();

        viewModel.subscribe(LoginViewModel.INVALIDPSW,(k,p)->{
            userName.setText("");
            passWord.setText("");
            errorLabel.setText("用户名或密码错误");
        });

        viewModel.subscribe(LoginViewModel.IDENTITYNOTSELECT,(k,p)->{
            errorLabel.setText("请选择登陆类型");
        });

        viewModel.subscribe(LoginViewModel.VALID,(k,p)->{
            errorLabel.setText("");
            rootScene.getScene().getWindow().hide();
        });

        userName.textProperty().bindBidirectional(viewModel.userNameProperty());
        passWord.textProperty().bindBidirectional(viewModel.passWordProperty());

        identity.getItems().add("管理员");
        identity.getItems().add("员工");

        identity.valueProperty().bindBidirectional(viewModel.identityProperty());
    }

}
