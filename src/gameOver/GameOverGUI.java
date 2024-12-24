package gameOver;

import static userInterface.GameDesignButton.GeneralButton;
import userInterface.MainHome;
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
import javafx.scene.transform.Shear;
import javafx.stage.Stage;

public class GameOverGUI {

    public static void GameOverGUI(Stage primaryStage, int score) {
        Image background = new Image("/media/stars.gif");
        ImageView backgroundGIF = new ImageView(background);
        backgroundGIF.setFitWidth(800);
        backgroundGIF.setFitHeight(800);
        backgroundGIF.setPreserveRatio(false);

        Image iconImage = new Image("/media/gameOver.gif");
        ImageView gameOverIcon = new ImageView(iconImage);
        gameOverIcon.setFitWidth(200);
        gameOverIcon.setFitHeight(200);
        gameOverIcon.setPreserveRatio(true);
        gameOverIcon.setTranslateY(-200);

        Text gameOver = new Text("Game Over");
        gameOver.setFont(Font.font("Verdana", FontWeight.BOLD, 60));
        gameOver.setFill(Color.WHITE);

        Text scoreText = new Text("Score: " + score);
        scoreText.setFont(Font.font("Verdana", 30));
        scoreText.setFill(Color.WHITE);

        Shear shear = new Shear(-0.3, 0);
        gameOver.getTransforms().add(shear);

        Button returnHomeButton = GeneralButton("Home");
        returnHomeButton.setOnAction(event -> {
            MainHome.HomeGUI(primaryStage);

        });

        VBox vbox = new VBox(20, gameOver, scoreText, returnHomeButton);
        vbox.setStyle("-fx-alignment: center;");

        StackPane root = new StackPane();
        root.setStyle("-fx-background-color: black;");
        root.getChildren().addAll(backgroundGIF, gameOverIcon, vbox);

        Scene scene = new Scene(root, 800, 800);
        primaryStage.setTitle("Game Over");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    }


