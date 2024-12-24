package userManagement.UI.signUpUI;


import javafx.stage.Stage;
import userManagement.Business.registerService.RegistrationBAOImp;

public class SignUpControllerImpl implements SignUpController {


    public  SignUpControllerImpl(){

    }
    @Override
    public void handleRegister(String userName, String password, String confirmPassword, String email, Stage stage) {
        RegistrationBAOImp registrationBAOImp = new RegistrationBAOImp(userName,password,confirmPassword,email,stage);
        registrationBAOImp.registrationIsValid();



    }
}
