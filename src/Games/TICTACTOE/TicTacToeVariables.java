package Games.TICTACTOE;

import javax.swing.*;

public class TicTacToeVariables {
    int boardWidth = 800;
    int boardHeight = 800;
    JLabel textLabel = new JLabel();
    JPanel textPanel = new JPanel();
    JPanel boardPanel = new JPanel();
    JButton[][] board = new JButton[3][3]; // 3x3 grid for Tic-Tac-Toe
    String playerX = "X";
    String playerO = "O";
    String currentPlayer = playerX;
    Boolean gameOver = false;
    int turns = 0 ;
}
