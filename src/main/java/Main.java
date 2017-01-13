import Util.SqlSessionFactoryProvider;
import View.LoginView;
import ViewModel.LoginViewModel;
import de.saxsys.mvvmfx.FluentViewLoader;
import de.saxsys.mvvmfx.ViewTuple;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.apache.ibatis.session.SqlSession;

/**
 * Created by L T on 2017/1/8.
 */
public class Main extends Application {
    /**
     * 程序入口点
     *
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
        //Main m = new Main();
        //m.test();
    }

    @Override
    public void start(Stage primaryStage) {
        //开启登陆界面
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setTitle("SupManaSysFx");
        ViewTuple<LoginView, LoginViewModel> viewTuple = FluentViewLoader.fxmlView(LoginView.class).load();
        primaryStage.setScene(new Scene(viewTuple.getView()));
        primaryStage.sizeToScene();
        primaryStage.show();
    }

    public void test() {

        SqlSession session = SqlSessionFactoryProvider.getInstance().openSession();

        //String uuid = UUID.randomUUID().toString();
        //session.getMapper(StaffMapper.class).insert(new Staff(uuid, "zhang", "男", "M78", "EE"));
        //session.commit();

        //List<Staff> staffs = session.getMapper(StaffMapper.class).selectAll();
        //staffs.forEach(staff -> System.out.println(staff.getId()));
        //session.close();
        //List<SaleOrderDTO>  s = session.getMapper(SaleOrderMapper.class).selectAllSaleOrder();
        //s.forEach(i-> System.out.println(i.getDate()));


    }
}
