
package Games.Snake;

import java.awt.Color;
import java.util.Random;
import javax.swing.Timer;

public class snakeVariables {
   
     final int width = 800;
     final int height = 800;
     final int unit = 25;
     final int value = (1000 * 1000) / 25;
     int delay = 125;
     Color color;
     char direction = SnakeKeyHandle.direction;
     int snakeBody = 6;
     int[] x = new int[value];
     int[] y = new int[value];
     int applesEaten;
     int applex, appley;
     Random rand;
     Timer time;
     boolean moving = true;
    boolean isGameOver = false;
     
      
}
