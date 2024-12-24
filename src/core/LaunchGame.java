package core;

import Games.FlappyBirdGame.FlappyBird;
import Games.MemoryCard.MemoryGame;
import Games.MineSweeperGame.MineSweeper;
import Games.PingPong.PingPong;
import Games.Snake.snake;
import Games.SpaceInvaders.SpaceInvaders;
import Games.TICTACTOE.TicTacToeGame;
import Games.pacMan.Pacman;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class LaunchGame {

  private static int currentGame = -1;

  public static Scene GameScene(Stage primaryStage, int id) {
    currentGame = id;
    GeneralFrame object = null;

    switch (id) {
      case 1:
        object = new TicTacToeGame(primaryStage);
        break;

      case 2:
        object = new FlappyBird(primaryStage);
        break;

      case 3:
        object = new MineSweeper(primaryStage);
        break;

      case 4:
        object = new Pacman(primaryStage);
        break;

      case 5:
        object = new snake(primaryStage);
        break;

      case 6:
        object = new MemoryGame(primaryStage);
        break;

      case 7:
        object = new SpaceInvaders(primaryStage);
        break;

      case 8:
        object = new PingPong(primaryStage);
        break;

    }

    javafx.embed.swing.SwingNode swingNode = new javafx.embed.swing.SwingNode();
    swingNode.setContent(object);
    StackPane gameRoot = new StackPane();
    gameRoot.getChildren().add(swingNode);
    gameRoot.setStyle("-fx-background-color: black;");
    return new Scene(gameRoot, 800, 800);
  }

  public static int currentGame() {
    return currentGame;
  }
}
