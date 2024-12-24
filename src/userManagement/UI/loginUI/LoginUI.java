package userManagement.UI.loginUI;

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
import userManagement.UI.signUpUI.SignUpUI;

import static userInterface.GameDesignButton.GeneralButton;

public class LoginUI {

    public static void LogInUI(Stage primaryStage) {

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
        Text screenTitle = new Text("Login");
        screenTitle.setFont(Font.font("Arial", FontWeight.BOLD,30));
        screenTitle.setStyle("-fx-fill: white;");

        // Input Fields Title
        TextField emailField = new TextField();
        emailField.setPromptText("Enter your email");
        emailField.setMaxWidth(300); // Fixed width for a balanced UI
        emailField.setStyle("-fx-background-radius: 15; -fx-padding: 10;");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Enter your password");
        passwordField.setMaxWidth(300); // Fixed width
        passwordField.setStyle("-fx-background-radius: 15; -fx-padding: 10;");

        // Login Button
        Button loginButton = GeneralButton("Login");
        //LoginClicked
        loginButton.setOnMouseClicked(event ->{
            LoginController controller = new LoginControllerImpl();
            controller.handleLogin(emailField.getText(),passwordField.getText(),primaryStage);
        });

        // Sign-Up Text Below the Button
        Text signUpText = new Text("Don't have an account?!");
        signUpText.setFont(Font.font("Arial", FontWeight.NORMAL, 12));
        signUpText.setFill(Color.LIGHTGRAY);
        signUpText.setOnMouseEntered(e -> signUpText.setFill(Color.WHITE));
        signUpText.setOnMouseExited(e -> signUpText.setFill(Color.LIGHTGRAY));

        signUpText.setOnMouseClicked(e -> {
            SignUpUI signUpUI = new SignUpUI();
            try {
                signUpUI.start(primaryStage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });


        // Layout for Input Fields, Title, and Button
        VBox loginBox = new VBox(15, screenTitle, emailField, passwordField, loginButton, signUpText);
        loginBox.setAlignment(Pos.CENTER);

        // Stack Background and Login Box
        StackPane root = new StackPane();
        root.getChildren().addAll(gifView,title,subject, overlay, loginBox);

        // Scene and Stage
        Scene scene = new Scene(root, 800, 800);
        primaryStage.setTitle("MARO GAMES");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
