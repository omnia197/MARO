package userManagement.Business.registerService;


import userInterface.MainHome;
import userInterface.UserAccountGUI;
import javafx.stage.Stage;
import userManagement.storage.DAOImp;
import userManagement.storage.UserDTO;
import userManagement.storage.UserDAO;

public class RegistrationBAOImp implements RegisterBAO {

    UserDTO userDTO;
    String confirmPassword ;
    Stage stage ;

    public RegistrationBAOImp(String userName , String password , String confirmPassword , String email, Stage stage){
        userDTO = new UserDTO( userName, password, email);
        this.confirmPassword = confirmPassword;
        this.stage = stage;
    }


    public boolean confirmPassword() {

        return this.confirmPassword.equals(userDTO.getPassword());
    }


    public boolean userNameIsValid(String username) {

       if (username!=null && username.trim().length()>1 && username.trim().length()<8) {
           userDTO.setUserName(username.trim());
           return true ;
       }
       else return false ;
    }


    public boolean emailIsValid(String email) {

        if(email==null) return false ;
        return email.substring(0, email.indexOf("@")).length() > 1
                && !email.startsWith("0") && !email.startsWith("1") && !email.startsWith("2") && !email.startsWith("3")
                && !email.startsWith("4") && !email.startsWith("5") && !email.startsWith("6") && !email.startsWith("7")
                && !email.startsWith("8") && !email.startsWith("9") && email.substring(email.indexOf("@") + 1).equals("gmail.com");

    }



    public void registrationIsValid() {
        if(confirmPassword() && userNameIsValid(userDTO.getUserName()) && emailIsValid(userDTO.getEmail()) ){
            addNewUser(userDTO);
            System.out.println("the registration is done");
            UserAccountGUI.email = userDTO.getEmail();
            UserAccountGUI.userNamedb= userDTO.getUserName();

            try {
                 MainHome.HomeGUI(stage);
            } catch (Exception e) {
                e.printStackTrace();
            }


        }
        else {
            System.out.println("the registration failed");
        }
    }

    public void addNewUser(UserDTO newUserDTO){
        UserDAO userDAO = new DAOImp("users.ser");
        userDAO.saveUsers(newUserDTO);
    }

}
