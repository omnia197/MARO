package userManagement.storage;

import java.io.Serializable;
import java.util.HashMap;

public class UserDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private static int idCounter = 0;
    private final int userId;
    private String userName;
    private String email;
    private String password;
    private HashMap<String, Integer> gameScores;


    public UserDTO(String userName, String password, String email) {
        this.userId = ++idCounter; // Assign a unique ID to this user
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.gameScores = new HashMap<>();
    }


    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public HashMap<String, Integer> getGameScores() {
        return gameScores;
    }

//    public void addGameScore(String game, int score) {
//        gameScores.put(game, Math.max(gameScores.getOrDefault(game, 0), score));
//    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", gameScores=" + gameScores +
                '}';
    }
}
