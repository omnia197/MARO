package Games.MineSweeperGame;

import javax.swing.*;
import java.util.ArrayList;

public class MineSweeperVariables {

    int tileSize = 100;
    int numRows = 8;
    int numCols = numRows;
    int boardWidth = numCols * tileSize;
    int boardHeight = numRows * tileSize;
    int score = 0 ;

    JFrame frame = new JFrame("Minesweeper");
    JLabel textLabel = new JLabel();
    JPanel textPanel = new JPanel();
    JPanel boardPanel = new JPanel();

    int mineCount = 10;
    MineTile[][] board = new MineTile[numRows][numCols];
    ArrayList<MineTile> mineList;

    int tilesClicked = 0; //goal is to click all tiles except the ones containing mines
    boolean gameOver = false;
    
}
