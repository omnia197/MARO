package userManagement.UI.signUpUI;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import userManagement.UI.loginUI.LoginUI;

import static userInterface.GameDesignButton.GeneralButton;

public class SignUpUI extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Background GIF
        String gifPath = "/media/stars.gif";
        Image gifImage = new Image(gifPath);
        ImageView gifView = new ImageView(gifImage);
        gifView.setFitWidth(800);
        gifView.setFitHeight(800);
        gifView.setPreserveRatio(false);

        // title
        Text title = new Text("MARO Games");
        title.setFont(Font.font("Verdana", FontWeight.BOLD, 30));
        title.setStyle("-fx-fill: white;");
        title.setTranslateX(-270);
        title.setTranslateY(-350);

        // Title Subject
        Text subject = new Text("Destination of Playing Games");
        subject.setFont(Font.font("Arial", FontWeight.BOLD, 13));
        subject.setStyle("-fx-fill: white;");
        subject.setTranslateX(-270);
        subject.setTranslateY(-330);

        // Background
        StackPane overlay = new StackPane();
        overlay.setStyle("-fx-background-color: rgba(0, 0, 0, 0.5);");
        overlay.setPrefSize(800, 800);

        // Title for the screen
        Text screenTitle = new Text("Sign Up");
        screenTitle.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        screenTitle.setStyle("-fx-fill: white;");

        // Input Fields
        TextField usernameField = new TextField();
        usernameField.setPromptText("Enter your username");
        usernameField.setMaxWidth(300);
        usernameField.setStyle("-fx-background-radius: 15; -fx-padding: 10;");

        TextField emailField = new TextField();
        emailField.setPromptText("Enter your email");
        emailField.setMaxWidth(300);
        emailField.setStyle("-fx-background-radius: 15; -fx-padding: 10;");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Enter your password");
        passwordField.setMaxWidth(300);
        passwordField.setStyle("-fx-background-radius: 15; -fx-padding: 10;");

        PasswordField confirmPasswordField = new PasswordField();
        confirmPasswordField.setPromptText("Confirm your password");
        confirmPasswordField.setMaxWidth(300);
        confirmPasswordField.setStyle("-fx-background-radius: 15; -fx-padding: 10;");

        // Sign-Up Button
        Button signUpButton = GeneralButton("Sign Up");
        //Sign-Up Clicked
        signUpButton.setOnMouseClicked(event -> {
           SignUpController controller = new SignUpControllerImpl();
           controller.handleRegister(usernameField.getText(),passwordField.getText(),confirmPasswordField.getText(),emailField.getText(),primaryStage);
        });

        // Go to Login Text
        Text loginText = new Text("Already have an account? Login here!");
        loginText.setFont(Font.font("Arial", FontWeight.NORMAL, 12));
        loginText.setFill(Color.LIGHTGRAY);
        loginText.setOnMouseEntered(e -> loginText.setFill(Color.WHITE));
        loginText.setOnMouseExited(e -> loginText.setFill(Color.LIGHTGRAY));

        loginText.setOnMouseClicked(e -> {
            LoginUI loginUI = new LoginUI();
            try {
                loginUI.LogInUI(primaryStage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        // Layout for Input Fields, Title, and Button
        VBox signUpBox = new VBox(15, screenTitle, usernameField, emailField, passwordField, confirmPasswordField, signUpButton, loginText);
        signUpBox.setAlignment(Pos.CENTER);

        // Stack Background and Sign-Up Box
        StackPane root = new StackPane();
        root.getChildren().addAll(gifView, title, subject, overlay, signUpBox);

        // Scene and Stage
        Scene scene = new Scene(root, 800, 800);
        primaryStage.setTitle("MARO GAMES - Sign Up");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
}
