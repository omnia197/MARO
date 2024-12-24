package Games.Snake;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SnakeKeyHandle implements KeyListener {
 public static char direction = 'R';

    @Override
    public void keyPressed(KeyEvent e) {
       
         int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_UP:
                if (direction != 'D') {
                    direction = 'U';
                }
                break;
            case KeyEvent.VK_DOWN:
                if (direction != 'U') {
                    direction = 'D';
                }
                break;
            case KeyEvent.VK_RIGHT:
                if (direction != 'L') {
                    direction = 'R';
                }
                break;
            case KeyEvent.VK_LEFT:
                if (direction != 'R') {
                    direction = 'L';
                }
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
       
    }
}
