package Games.FlappyBirdGame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class FlappyBirdKeyHandle implements KeyListener {
    Variables vars ;
    Bird bird;

    FlappyBirdKeyHandle(Variables vars , Bird bird){
        this.vars=vars;
        this.bird=bird;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            vars.velocityY = -9 ;
            if(vars.gameOver){
                //restart the game resetting the conditions
                bird.y= vars.birdy;
                vars.velocityY = 0 ;
                vars.pipes.clear();
                vars.score = 0 ;
                vars.gameOver = false ;
                vars.gameLoop.start();
                vars.placePipesTimer.start();
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}
}
