package Games.pacMan;

import core.Games;
import core.GeneralFrame;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;

public class Pacman extends GeneralFrame implements ActionListener{
    Stage stage;
    PacManVariables pacManVariables = new PacManVariables();
    MovePacMan movePacMan ;


     Image wallImage;
     Image blueGhostImage;
     Image orangeGhostImage;
     Image pinkGhostImage;
     Image redGhostImage;

     Image pacmanUpImage;
     Image pacmanDownImage;
     Image pacmanLeftImage;
    Image pacmanRightImage;


    public Pacman(Stage stage) {
        super(Games.PAC_MAN, stage);
        this.stage = stage;
        movePacMan = new MovePacMan(pacManVariables,this,pacManVariables.pacman,stage);
        startGame();
        setPreferredSize(new Dimension(pacManVariables.boardWidth, pacManVariables.boardHeight));
        setBackground(Color.BLACK);

        KeyHandle keyHandle = new KeyHandle(pacManVariables.pacman, pacManVariables, this);


        addKeyListener(keyHandle);
        setFocusable(true);
        requestFocusInWindow();


        //load images
        wallImage = new ImageIcon(getClass().getResource("/media/pacman/wall.png")).getImage();
        blueGhostImage = new ImageIcon(getClass().getResource("/media/pacman/blueGhost.png")).getImage();
        orangeGhostImage = new ImageIcon(getClass().getResource("/media/pacman/orangeGhost.png")).getImage();
        pinkGhostImage = new ImageIcon(getClass().getResource("/media/pacman/pinkGhost.png")).getImage();
        redGhostImage = new ImageIcon(getClass().getResource("/media/pacman/redGhost.png")).getImage();

        pacmanUpImage = new ImageIcon(getClass().getResource("/media/pacman/pacmanUp.png")).getImage();
        pacmanDownImage = new ImageIcon(getClass().getResource("/media/pacman/pacmanDown.png")).getImage();
        pacmanLeftImage = new ImageIcon(getClass().getResource("/media/pacman/pacmanLeft.png")).getImage();
        pacmanRightImage = new ImageIcon(getClass().getResource("/media/pacman/pacmanRight.png")).getImage();
        pacManVariables.walls = new HashSet<>();
        pacManVariables.foods = new HashSet<>();
        pacManVariables.ghosts = new HashSet<>();

        loadMap();

        for (Block ghost : pacManVariables.ghosts) {
            char newDirection = pacManVariables.directions[pacManVariables.random.nextInt(4)];
            ghost.updateDirection(pacManVariables,newDirection);
        }

       //  this.movePacMan = new MovePacMan(pacManVariables,pacman);
    }
    public void loadMap() {


        for (int r = 0; r < pacManVariables.rowCount; r++) {
            for (int c = 0; c < pacManVariables.columnCount; c++) {
                String row = pacManVariables.tileMap[r];
                char tileMapChar = row.charAt(c);

                int x = c*pacManVariables.tileSize;
                int y = r*pacManVariables.tileSize;

                if (tileMapChar == 'X') { //block wall
                    Block wall = new Block(wallImage, x, y, pacManVariables.tileSize, pacManVariables.tileSize);
                    pacManVariables.walls.add(wall);
                }
                else if (tileMapChar == 'b') { //blue ghost
                    Block ghost = new Block(blueGhostImage, x, y, pacManVariables.tileSize, pacManVariables.tileSize);
                    pacManVariables.ghosts.add(ghost);
                }
                else if (tileMapChar == 'o') { //orange ghost
                    Block ghost = new Block(orangeGhostImage, x, y, pacManVariables.tileSize, pacManVariables.tileSize);
                    pacManVariables.ghosts.add(ghost);
                }
                else if (tileMapChar == 'p') { //pink ghost
                    Block ghost = new Block(pinkGhostImage, x, y, pacManVariables.tileSize, pacManVariables.tileSize);
                    pacManVariables.ghosts.add(ghost);
                }
                else if (tileMapChar == 'r') { //red ghost
                    Block ghost = new Block(redGhostImage, x, y, pacManVariables.tileSize, pacManVariables.tileSize);
                    pacManVariables.ghosts.add(ghost);
                }
                else if (tileMapChar == 'P') { //pacman
                    pacManVariables.pacman.x = x ;
                    pacManVariables.pacman.y = y;
                }
                else if (tileMapChar == ' ') { //food
                    Block food = new Block(null, x + 14, y + 14, 4, 4);
                    pacManVariables.foods.add(food);
                }
            }
        }
    }

    @Override
    public void startGame() {
        pacManVariables.gameLoop = new Timer(50, this); //20fps (1000/50)
        pacManVariables.gameLoop.start();

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        g.drawImage(pacManVariables.pacman.image, pacManVariables.pacman.x, pacManVariables.pacman.y, pacManVariables.pacman.width, pacManVariables.pacman.height, null);

        for (Block ghost : pacManVariables.ghosts) {
            g.drawImage(ghost.image, ghost.x, ghost.y, ghost.width, ghost.height, null);
        }

        for (Block wall : pacManVariables.walls) {
            g.drawImage(wall.image, wall.x, wall.y, wall.width, wall.height, null);
        }

        g.setColor(Color.WHITE);
        for (Block food : pacManVariables.foods) {
            g.fillRect(food.x, food.y, food.width, food.height);
        }
        //score
        g.setFont(new Font("Arial", Font.PLAIN, 18));
        if (pacManVariables.gameOver) {
            g.drawString("Game Over: " + String.valueOf(pacManVariables.score), pacManVariables.tileSize/2, pacManVariables.tileSize/2);
        }
        else {
            g.drawString("Lives:" + String.valueOf(pacManVariables.lives) + " Score: " + String.valueOf(pacManVariables.score), pacManVariables.tileSize/2, pacManVariables.tileSize/2);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e)
   {
          movePacMan.move();
          repaint();
        if (pacManVariables.gameOver) {
            pacManVariables.gameLoop.stop();
        }
    }
}
