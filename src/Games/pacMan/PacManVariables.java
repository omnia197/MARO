package Games.pacMan;

import javax.swing.*;
import java.awt.*;
import java.util.HashSet;
import java.util.Random;

public class PacManVariables {
    final int rowCount = 21;
    final int columnCount = 19;
    final int tileSize = 32;
    final int boardWidth = columnCount * tileSize;
    final int boardHeight = rowCount * tileSize;

    //X = wall, O = skip, P = pac man, ' ' = food
    //Ghosts: b = blue, o = orange, p = pink, r = red
    String[] tileMap = {
            "XXXXXXXXXXXXXXXXXXX",
            "X        X        X",
            "X XX XXX X XXX XX X",
            "X                 X",
            "X XX X XXXXX X XX X",
            "X    X       X    X",
            "XXXX XXXX XXXX XXXX",
            "OOOX X       X XOOO",
            "XXXX X XXrXX X XXXX",
            "O       bpo       O",
            "XXXX X XXXXX X XXXX",
            "OOOX X       X XOOO",
            "XXXX X XXXXX X XXXX",
            "X        X        X",
            "X XX XXX X XXX XX X",
            "X  X     P     X  X",
            "XX X X XXXXX X X XX",
            "X    X   X   X    X",
            "X XXXXXX X XXXXXX X",
            "X                 X",
            "XXXXXXXXXXXXXXXXXXX"
    };
    Timer gameLoop;
    char[] directions = {'U', 'D', 'L', 'R'}; //up down left right
    Random random = new Random();
    int score = 0;
    int lives = 3;
    boolean gameOver = false;
    HashSet<Block> walls;
    HashSet<Block> foods;
    HashSet<Block> ghosts;
   Image pacmanRightImage = new ImageIcon(getClass().getResource("/media/pacman/pacmanRight.png")).getImage();
    Block pacman  = new Block(pacmanRightImage, 9*tileSize, 15*tileSize, tileSize, tileSize);;

}
