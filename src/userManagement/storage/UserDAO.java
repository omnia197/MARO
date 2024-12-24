package userManagement.storage;

import java.util.List;

public interface UserDAO {
    void saveUsers(UserDTO users);
    List<UserDTO> loadUsers();
    UserDTO getUserByEmail(String email);


    Boolean findUser(String email , String password);
}
