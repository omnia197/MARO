package Games.MineSweeperGame;
import gameOver.GameOverLogic;
import core.Games;
import core.GeneralFrame;
import javafx.application.Platform;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import javafx.stage.Stage;

public class MineSweeper extends GeneralFrame {
    MineSweeperVariables mineSweeperVariables = new MineSweeperVariables();
    MineSweeperLogic mineSweeperLogic = new MineSweeperLogic(mineSweeperVariables);
    Stage stage;

    public MineSweeper(Stage stage) {
        super(Games.MINE_SWEEPER,stage);
        this.stage=stage;
        drawGame();
        startGame();
        mineSweeperLogic.setMines();
    }

    public void drawGame(){
        mineSweeperVariables.textLabel.setFont(new Font("Arial", Font.BOLD, 25));
        mineSweeperVariables.textLabel.setHorizontalAlignment(JLabel.CENTER);
        mineSweeperVariables.textLabel.setText("Minesweeper: " + Integer.toString(mineSweeperVariables.mineCount));
        mineSweeperVariables.textLabel.setOpaque(true);

        mineSweeperVariables.textPanel.setLayout(new BorderLayout());
        mineSweeperVariables.textPanel.add(mineSweeperVariables.textLabel);
        this.add(mineSweeperVariables.textPanel, BorderLayout.NORTH);

        mineSweeperVariables.boardPanel.setLayout(new GridLayout(mineSweeperVariables.numRows, mineSweeperVariables.numCols)); //8x8
        this.add(mineSweeperVariables.boardPanel);
    }

    @Override
    public void startGame() {
        for (int r = 0; r < mineSweeperVariables.numRows; r++) {
            for (int c = 0; c < mineSweeperVariables.numCols; c++) {
                MineTile tile = new MineTile(r, c);
                mineSweeperVariables.board[r][c] = tile;

                tile.setFocusable(false);
                tile.setMargin(new Insets(0, 0, 0, 0));
                tile.setFont(new Font("Arial Unicode MS", Font.PLAIN, 45));
                tile.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        if (mineSweeperVariables.gameOver) {
                            return;
                        }
                        MineTile tile = (MineTile) e.getSource();

                        //left click
                        if (e.getButton() == MouseEvent.BUTTON1) {
                            if (tile.getText() == "") {
                                if (mineSweeperVariables.mineList.contains(tile)) {
                                    mineSweeperLogic.revealMines();
                                    Platform.runLater(() -> GameOverLogic.showGameOverScreen((int)mineSweeperVariables.score,stage));
                                }
                                else {
                                    mineSweeperLogic.checkMine(tile.r, tile.c);
                                }
                            }
                        }
                        //right click
                        else if (e.getButton() == MouseEvent.BUTTON3) {
                            if (tile.getText() == "" && tile.isEnabled()) {
                                tile.setText("🚩");
                            }
                            else if (tile.getText() == "🚩") {
                                tile.setText("");
                            }
                        }
                    }
                });

                mineSweeperVariables.boardPanel.add(tile);

            }
        }
    }

}
