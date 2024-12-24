package userManagement.storage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DAOImp implements UserDAO {
    private final String filePath;

    public DAOImp(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void saveUsers(UserDTO userDTO) {
        List<UserDTO> userDTOS = loadUsers();
        userDTOS.add(userDTO);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(userDTOS);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<UserDTO> loadUsers() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return (List<UserDTO>) ois.readObject();
        } catch (FileNotFoundException e) {
            return new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public UserDTO getUserByEmail(String email) {
        List<UserDTO> userDTOS = loadUsers();
        for (UserDTO userDTO : userDTOS) {
            if (Objects.equals(userDTO.getEmail(), email)) {
                return userDTO;
            }
        }
        return null;
    }

    @Override
    public Boolean findUser(String email, String password) {
        List<UserDTO> userDTOS = loadUsers();
        for (UserDTO userDTO : userDTOS) {
            if (Objects.equals(userDTO.getEmail(), email) && Objects.equals(userDTO.getPassword(), password)) {
                return true;
            }
        }

        return false;
    }
}
