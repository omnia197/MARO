package Games.TICTACTOE;

import core.Games;
import core.GeneralFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import javafx.stage.Stage;

public class TicTacToeGame extends GeneralFrame {
    TicTacToeVariables ticTacToeVariables = new TicTacToeVariables();
    TicTacToeLogic ticTacToeLogic = new TicTacToeLogic(ticTacToeVariables);
    Stage stage;
    public TicTacToeGame(Stage stage) {
        super(Games.TicTacToe, stage);
        this.stage = stage;
        // Panel setup
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(ticTacToeVariables.boardWidth, ticTacToeVariables.boardHeight));

        // Title label
        ticTacToeVariables.textLabel.setBackground(Color.DARK_GRAY);
        ticTacToeVariables.textLabel.setForeground(Color.WHITE);
        ticTacToeVariables.textLabel.setFont(new Font("Arial", Font.BOLD, 40));
        ticTacToeVariables.textLabel.setHorizontalAlignment(JLabel.CENTER);
        ticTacToeVariables.textLabel.setText("Tic-Tac-Toe");
        ticTacToeVariables.textLabel.setOpaque(true);

        // Text panel
        ticTacToeVariables.textPanel.setLayout(new BorderLayout());
        ticTacToeVariables.textPanel.add(ticTacToeVariables.textLabel);
        this.add(ticTacToeVariables.textPanel, BorderLayout.NORTH);

        // Board panel
        ticTacToeVariables.boardPanel.setLayout(new GridLayout(3, 3));
        ticTacToeVariables.boardPanel.setBackground(Color.DARK_GRAY);
        this.add(ticTacToeVariables.boardPanel, BorderLayout.CENTER);

        startGame();
    }

    public void startGame() {
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                JButton tile = new JButton();
                ticTacToeVariables.board[r][c] = tile;
                ticTacToeVariables.boardPanel.add(tile);
                tile.setBackground(Color.DARK_GRAY);
                tile.setForeground(Color.WHITE);
                tile.setFont(new Font("Arial", Font.BOLD, 120));
                tile.setFocusable(true);

                tile.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (ticTacToeVariables.gameOver) return;
                        if (Objects.equals(tile.getText(), "")) {
                            JButton tile = (JButton) e.getSource();
                            tile.setText(ticTacToeVariables.currentPlayer);
                            ++ticTacToeVariables.turns;
                            ticTacToeLogic.checkWinner();
                            if (!ticTacToeVariables.gameOver) {
                                ticTacToeVariables.currentPlayer = Objects.equals(ticTacToeVariables.currentPlayer, ticTacToeVariables.playerX)
                                        ? ticTacToeVariables.playerO
                                        : ticTacToeVariables.playerX;
                                ticTacToeVariables.textLabel.setText(ticTacToeVariables.currentPlayer + "'s turn.");
                            }
                        }
                    }
                });
            }
        }

    }
}
