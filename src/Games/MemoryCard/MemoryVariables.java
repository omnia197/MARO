package Games.MemoryCard;

import javax.swing.*;
import java.util.ArrayList;

public class MemoryVariables {
    final int rows = 4;
    final int columns = 5;
    ArrayList<Card> cardSet = new ArrayList<>();
    ArrayList<JButton> buttons = new ArrayList<>();
    JButton card1Selected = null;
    JButton card2Selected = null;
    int errorCount = 0;
    boolean gameReady = false;
    ImageIcon cardBackIcon;
    JPanel textPanel;
    JPanel boardPanel;
    JPanel restartPanel;
    JLabel errorLabel;
    JButton restartButton;

    public MemoryVariables() {
        loadImages();
    }

    private void loadImages() {
        try {
            cardBackIcon = new ImageIcon(getClass().getResource("/media/MemoryCard/back.jpg"));
            cardBackIcon = new ImageIcon(cardBackIcon.getImage().getScaledInstance(90, 120, java.awt.Image.SCALE_SMOOTH));
        } catch (Exception e) {
            System.err.println("Error loading back image: " + e.getMessage());
            cardBackIcon = new ImageIcon(); // Empty icon as fallback
        }
    }
}
