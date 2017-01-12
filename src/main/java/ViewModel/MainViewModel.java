package ViewModel;

import de.saxsys.mvvmfx.ViewModel;
import javafx.stage.Stage;

/**
 * Created by L T on 2017/1/10.
 */
public class MainViewModel implements ViewModel {
    private static Stage mainStage;

    /**
     * @return 静态全局主界面 Stage
     */
    synchronized
    public static Stage getMainStage() {
        if (mainStage == null) {
            mainStage = new Stage();
        }
        return mainStage;
    }
}
