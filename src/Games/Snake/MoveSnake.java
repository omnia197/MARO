package Games.Snake;

import java.awt.Color;

public class MoveSnake {
    
   private final snakeVariables variables;

    public MoveSnake(snakeVariables variables) {
        this.variables = variables;
    }

    
        public void move() {
         
        for (int i = variables.snakeBody; i > 0; i--) {
            variables.x[i] = variables.x[i - 1];
            variables.y[i] = variables.y[i - 1];
        }
        
        switch (SnakeKeyHandle.direction) {
            case 'U':
                variables.y[0] = variables.y[0] - variables.unit;
                variables.color = Color.green;
                break;
            case 'D':
                variables.y[0] = variables.y[0] + variables.unit;
                variables.color = Color.white;
                break;
            case 'L':
                variables.x[0] = variables.x[0] - variables.unit;
                variables.color = Color.red;
                break;
            case 'R':
                variables.x[0] = variables.x[0] + variables.unit;
                variables.color = Color.yellow;
                break;
        }
    }
    
}
