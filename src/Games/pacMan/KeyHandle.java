package Games.pacMan;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandle implements KeyListener {
    private final Block pacman;
    private final PacManVariables pacManVariables;
    private final Pacman pacmanPaint;

    public KeyHandle(Block pacman, PacManVariables pacManVariables, Pacman pacmanPaint) {
        this.pacman = pacman;
        this.pacManVariables = pacManVariables;
        this.pacmanPaint = pacmanPaint;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // No implementation needed here
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // No implementation needed here
    }

    @Override
    public void keyReleased(KeyEvent e) {

//        if (pacManVariables.gameOver) {
//            pacmanPaint.loadMap();
//            pacmanPaint.resetPositions();
//            lives = 3;
//            score = 0;
//            gameOver = false;
//            gameLoop.start();
//        }
         //System.out.println("KeyEvent: " + e.getKeyCode());
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            pacman.updateDirection(pacManVariables,'U');
        }
        else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            pacman.updateDirection(pacManVariables,'D');
        }
        else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            pacman.updateDirection(pacManVariables,'L');
        }
        else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            pacman.updateDirection(pacManVariables,'R');
        }

        if (pacman.direction == 'U') {
            pacman.image = pacmanPaint.pacmanUpImage;
        }
        else if (pacman.direction == 'D') {
            pacman.image = pacmanPaint.pacmanDownImage;
        }
        else if (pacman.direction == 'L') {
            pacman.image = pacmanPaint.pacmanLeftImage;
        }
        else if (pacman.direction == 'R') {
            pacman.image = pacmanPaint.pacmanRightImage;
        }
    }
}
