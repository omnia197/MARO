package userManagement.Business.loginService;


import javafx.stage.Stage;
import userManagement.Business.loginService.LoginBAO;
import userManagement.storage.DAOImp;
import userManagement.storage.UserDAO;

public class LogInBAOImp implements LoginBAO {

    UserDAO userDAO = new DAOImp("users.ser");
    String email ;
    String password ;
    Stage stage;

    public LogInBAOImp(String email , String password , Stage stage){
        this.email = email ;
        this.password = password;
        this.stage = stage;
    }


    public boolean findUser(String email, String password) {
        return userDAO.findUser(email, password);
    }


    public boolean logIn() {
        boolean userFound = findUser(email, password);
        if (userFound) {
            System.out.println("LogIn is done");
            return true;
        } else {
            System.out.println("LogIn failed");
            return false;
        }
    }

}
