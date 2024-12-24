package userManagement.UI.loginUI;

import userInterface.UserAccountGUI;
import javafx.stage.Stage;
import userInterface.MainHome;
import userManagement.Business.loginService.LogInBAOImp;
import userManagement.storage.DAOImp;

public class LoginControllerImpl implements LoginController {

    public LoginControllerImpl() {
    }

    @Override
    public void handleLogin(String email, String password, Stage stage) {
        LogInBAOImp logIn = new LogInBAOImp(email, password, stage);
        if (logIn.logIn()) {
            UserAccountGUI.email = email;
            UserAccountGUI.userNamedb=new DAOImp("users.ser").getUserByEmail(email).getUserName();

            try {
               MainHome.HomeGUI(stage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Login failed");
        }
    }

}

