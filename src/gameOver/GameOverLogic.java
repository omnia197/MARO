package gameOver;

import static gameOver.GameOverGUI.GameOverGUI;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.stage.Stage;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class GameOverLogic {

    public static void showGameOverScreen(int score , Stage stage) {
        SwingUtilities.invokeLater(() -> {
            JFXPanel fxPanel = new JFXPanel();
            JPanel parentPanel = new JPanel();
            parentPanel.setLayout(new java.awt.BorderLayout());
            parentPanel.add(fxPanel);

            Platform.runLater(() -> {
                GameOverGUI(stage, score);
            });
        });
    }

}
