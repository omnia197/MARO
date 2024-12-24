
package userInterface;

import static userInterface.GameDesignButton.GeneralButton;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class UserAccountGUI {
    public static String userNamedb;
    public static String email;

    public static void UserGUI(Stage primaryStage) {
        String path = "/media/stars.gif";
        Image background = new Image(path);
        ImageView backgroundGIF = new ImageView(background);
        backgroundGIF.setFitWidth(800);
        backgroundGIF.setFitHeight(800);
        backgroundGIF.setPreserveRatio(false);

        Image iconImage = new Image("/media/accountImage.gif");
        ImageView userIcon = new ImageView(iconImage);
        userIcon.setFitWidth(200);
        userIcon.setFitHeight(200);
        userIcon.setPreserveRatio(true);
        userIcon.setTranslateY(-200);

        Text userName = new Text(userNamedb);
        userName.setFont(Font.font("Verdana", FontWeight.BOLD, 40));
        userName.setFill(Color.WHITE);

        Text userEmail = new Text(email);
        userEmail.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        userEmail.setFill(Color.WHITE);

        Button returnHomeButton = GeneralButton("Home");
        returnHomeButton.setOnAction(event -> {
            MainHome.HomeGUI(primaryStage);
        });

        VBox vbox = new VBox(20, userName, userEmail, returnHomeButton);
        vbox.setStyle("-fx-alignment: center;");

        StackPane root = new StackPane();
        root.setStyle("-fx-background-color: black;");
        root.getChildren().addAll(backgroundGIF, userIcon, vbox);

        Scene scene = new Scene(root, 800, 800);
        primaryStage.setTitle("Account");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
