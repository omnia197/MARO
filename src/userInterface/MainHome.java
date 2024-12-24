package userInterface;

import core.LaunchGame;
import static userInterface.GameDesignButton.GeneralButton;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainHome {

    public static void HomeGUI(Stage primaryStage) {

        String[] gameImagePaths = {

                "/media/GamesIcons/Tic2.jpg",
                "/media/GamesIcons/FlappyBird.jpg",
                "/media/GamesIcons/MineSweeper.jpg",
                "/media/GamesIcons/PacMan.jpg",
                "/media/GamesIcons/Snake.jpg",
                "/media/GamesIcons/MemoryCard.jpg",
                "/media/GamesIcons/space.jpg",
                "/media/GamesIcons/PingPong.jpg",
                "/media/GamesIcons/another.jpg"
        };

        String[] gameNames = {
                "TicTacToe",
                "FlappyBird",
                "MineSweeper",
                "PacMan",
                "Snake",
                "MemoryCard",
                "SpaceInvaders",
                "PingPong",
                ""
        };

        String gifPath = "/media/stars.gif";
        Image gifImage = new Image(gifPath);
        ImageView gifView = new ImageView(gifImage);
        gifView.setFitWidth(800);
        gifView.setFitHeight(800);
        gifView.setPreserveRatio(false);

        // Desktop title
        Text title = new Text("MARO Games");
        title.setFont(Font.font("Verdana", FontWeight.BOLD, 30));
        title.setStyle("-fx-fill: white;");
        title.setTranslateX(-270);
        title.setTranslateY(-350);

        // Title Subject --> slogan
        Text subject = new Text("Destination of Playing Games");
        subject.setFont(Font.font("Arial", FontWeight.BOLD, 13));
        subject.setStyle("-fx-fill: white;");
        subject.setTranslateX(-270);
        subject.setTranslateY(-330);

        // Icon for account manage
        String iconPath = "/media/accountImage.gif";
        Image iconImage = new Image(iconPath);
        ImageView iconView = new ImageView(iconImage);
        iconView.setFitWidth(100);
        iconView.setFitHeight(100);
        iconView.setPreserveRatio(true);
        iconView.setTranslateX(350);
        iconView.setTranslateY(-350);

        iconView.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            try {
                UserAccountGUI.UserGUI(primaryStage);
            } catch (Exception ex) {
                Logger.getLogger(MainHome.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        Text account = new Text("Account");
        account.setFont(Font.font("Verdana", FontWeight.BOLD, 13));
        account.setStyle("-fx-fill: white;");
        account.setTranslateX(350);
        account.setTranslateY(-300);

        // Create the grid with 3 rows and 3 columns
        GridPane gameGrid = new GridPane();
        gameGrid.setVgap(30);
        gameGrid.setHgap(50);
        gameGrid.setTranslateY(110);
        gameGrid.setTranslateX(30);

        for (int i = 0; i < 9; i++) {
            StackPane gameContainer = new StackPane();

            Image gameImage = new Image(gameImagePaths[i]);
            ImageView gameBackground = new ImageView(gameImage);
            gameBackground.setFitWidth(200);
            gameBackground.setFitHeight(200);
            gameBackground.setPreserveRatio(true);

            Rectangle clip = new Rectangle(200, 200);
            clip.setArcWidth(50);
            clip.setArcHeight(50);
            gameBackground.setClip(clip);

            ColorAdjust colorAdjust = new ColorAdjust();
            colorAdjust.setBrightness(-0.2);
            gameBackground.setEffect(colorAdjust);

            Button gameButton = GeneralButton("Play");
            gameButton.setOpacity(0);
            gameButton.setTranslateY(50);

            gameButton.setOnMouseEntered(event -> {
                gameContainer.setScaleX(1.2);
                gameContainer.setScaleY(1.2);
                colorAdjust.setBrightness(-0.6);
                gameButton.setOpacity(1);
            });

            gameButton.setOnMouseExited(event -> {
                gameContainer.setScaleX(1);
                gameContainer.setScaleY(1);
                colorAdjust.setBrightness(-0.2);
                gameButton.setOpacity(0);
            });

            final int gameId = i + 1;
            gameButton.setOnMouseClicked((MouseEvent event) -> {
                Scene GameScene = LaunchGame.GameScene(primaryStage, gameId);
                primaryStage.setScene(GameScene);
            });

            gameContainer.getChildren().addAll(gameBackground, gameButton);

            Text gameTitle = new Text(gameNames[i]);
            gameTitle.setFont(Font.font("Verdana", FontWeight.BOLD, 27));
            gameTitle.setStyle("-fx-fill: white;");
            gameContainer.getChildren().add(gameTitle);

            gameContainer.setStyle("-fx-background-radius: 30px; -fx-border-radius: 20px;");

            gameGrid.add(gameContainer, i % 3, i / 3);
        }

        StackPane root = new StackPane();
        root.getChildren().addAll(gifView, title, iconView, account, subject, gameGrid);

        StackPane.setAlignment(gameGrid, javafx.geometry.Pos.CENTER);

        Scene scene = new Scene(root, 800, 800);
        primaryStage.setTitle("MARO GAMES");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
