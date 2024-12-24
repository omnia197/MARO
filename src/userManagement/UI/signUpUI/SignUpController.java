package userManagement.UI.signUpUI;

import javafx.stage.Stage;

public interface SignUpController {

    void handleRegister(String userName, String password, String confirmPassword, String email, Stage stage);

}
