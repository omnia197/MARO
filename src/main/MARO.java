package main;

import javafx.application.Application;
import javafx.stage.Stage;
import static userManagement.UI.loginUI.LoginUI.LogInUI;

public class MARO extends Application {
    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        LogInUI(primaryStage);
    }

}
