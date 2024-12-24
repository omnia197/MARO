package Games.MemoryCard;

import core.MainFramePaintInterface;
import core.Games;
import javafx.stage.Stage;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class MemoryGame extends MemoryCardGameFrame implements MainFramePaintInterface {
    private MemoryVariables variables;
    private MemoryLogic logic;
    private CardSet cardSet;

    public MemoryGame(Stage primaryStage) {
        super(Games.MEMORY_CARD, primaryStage);
        this.variables = new MemoryVariables();
        this.cardSet = new CardSet(variables);
        this.logic = new MemoryLogic(variables);
        // this.cardSet = new CardSet(variables);
        startGame();
        setupUI();
    }

    void setupUI() {
        setLayout(new BorderLayout());
        setBackground(Color.BLACK);

        variables.textPanel = new JPanel();
        variables.textPanel.setBackground(Color.BLACK);

        variables.boardPanel = new JPanel(new GridLayout(variables.rows, variables.columns));
        variables.boardPanel.setBackground(Color.BLACK);

        variables.restartPanel = new JPanel();
        variables.restartPanel.setBackground(Color.BLACK);

        variables.errorLabel = new JLabel("Errors: 0");
        variables.errorLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        variables.errorLabel.setForeground(Color.WHITE);
        variables.textPanel.add(variables.errorLabel);

        setupCards();

        variables.restartButton = new JButton("Restart Game");
        variables.restartButton.setFont(new Font("Arial", Font.PLAIN, 16));

        variables.restartButton.setForeground(Color.WHITE);
        variables.restartButton.setFocusPainted(false);
        variables.restartButton.setBorderPainted(false);
        variables.restartButton.setEnabled(true);
        variables.restartButton.addActionListener(e -> restartGame());
        variables.restartPanel.add(variables.restartButton);

        add(variables.textPanel, BorderLayout.NORTH);
        add(variables.boardPanel, BorderLayout.CENTER);
        add(variables.restartPanel, BorderLayout.SOUTH);
    }

    private void setupCards() {
        for (int i = 0; i < variables.cardSet.size(); i++) {
            JButton tile = new JButton();
            tile.setPreferredSize(new Dimension(90, 120));
            tile.setIcon(variables.cardBackIcon);
            final int index = i;
            tile.addActionListener(e -> logic.handleCardClick(tile, index));
            variables.buttons.add(tile);
            variables.boardPanel.add(tile);
        }
    }

    @Override
    public void startGame() {
        variables.gameReady = true;
        cardSet.shuffleCards();
        hideAllCards();
    }

    private void hideAllCards() {
        for (JButton button : variables.buttons) {
            button.setIcon(variables.cardBackIcon);
        }
    }

    private void restartGame() {
        variables.errorCount = 0;
        variables.errorLabel.setText("Errors: 0");
        variables.card1Selected = null;
        variables.card2Selected = null;
        cardSet.shuffleCards();
        hideAllCards();
        variables.gameReady = true;
    }

    @Override
    public void draw(Graphics g) {

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}