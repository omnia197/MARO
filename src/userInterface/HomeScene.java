package userInterface;

import javafx.embed.swing.SwingNode;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class HomeScene {

    public static Scene createHomeScene(Stage primaryStage) {
        StackPane snakeGameRoot = new StackPane();
        SwingNode node = new SwingNode();

        SwingUtilities.invokeLater(() -> {
            JPanel panel = new JPanel();
            panel.setBackground(java.awt.Color.BLACK);
            node.setContent(panel);
        });

        snakeGameRoot.getChildren().add(node);
        snakeGameRoot.setStyle("-fx-background-color: black;");

        return new Scene(snakeGameRoot, 800, 800);
    }
}
