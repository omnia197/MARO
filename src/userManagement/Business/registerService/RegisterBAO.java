package userManagement.Business.registerService;

public interface RegisterBAO {

    public boolean emailIsValid(String email);

    public void registrationIsValid();

    public boolean confirmPassword();

    public boolean userNameIsValid(String username);

}