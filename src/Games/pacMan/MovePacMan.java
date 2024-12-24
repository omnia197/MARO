package Games.pacMan;

import javafx.stage.Stage;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MovePacMan {
    PacManVariables pacManVariables;
    Pacman pacmanPaint ;
    Block pacman;
    Stage stage;

    MovePacMan(PacManVariables pacManV,Pacman paint , Block pacman , Stage stage) {
        this.pacManVariables = pacManV;
        this.pacmanPaint=paint;
        this.pacman=pacman;
        this.stage = stage;

    }

    public void move() {
        pacman.x += pacman.velocityX;
        pacman.y += pacman.velocityY;
        PacmanLogic pacmanLogic = new PacmanLogic(pacManVariables,pacman,pacmanPaint,stage);
        pacmanLogic.checkLogic();
    }


//    @Override
//    public void keyTyped(KeyEvent e) {
//
//    }
//
//    @Override
//    public void keyPressed(KeyEvent e) {
//
//    }
//
//    @Override
//    public void keyReleased(KeyEvent e) {
////        if (pacManVariables.gameOver) {
////            pacmanPaint.loadMap();
////            pacmanPaint.resetPositions();
////            lives = 3;
////            score = 0;
////            gameOver = false;
////            gameLoop.start();
////        }
//        // System.out.println("KeyEvent: " + e.getKeyCode());
//        if (e.getKeyCode() == KeyEvent.VK_UP) {
//            pacman.updateDirection(pacManVariables,'U');
//        }
//        else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
//            pacman.updateDirection(pacManVariables,'D');
//        }
//        else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
//            pacman.updateDirection(pacManVariables,'L');
//        }
//        else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
//            pacman.updateDirection(pacManVariables,'R');
//        }
//
//        if (pacman.direction == 'U') {
//            pacman.image = pacmanPaint.pacmanUpImage;
//        }
//        else if (pacman.direction == 'D') {
//            pacman.image = pacmanPaint.pacmanDownImage;
//        }
//        else if (pacman.direction == 'L') {
//            pacman.image = pacmanPaint.pacmanLeftImage;
//        }
//        else if (pacman.direction == 'R') {
//            pacman.image = pacmanPaint.pacmanRightImage;
//        }
//
//    }
}