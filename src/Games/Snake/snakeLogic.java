package Games.Snake;

import gameOver.GameOverLogic;
import javafx.application.Platform;
import javafx.stage.Stage;

public class snakeLogic {
    private final snakeVariables variables;
    Stage stage;
    public snakeLogic(snakeVariables variables,Stage stage) {
        this.variables = variables;
        this.stage = stage;
    }

    public void newApple() {
        boolean inside;
        do {
            variables.applex = variables.rand.nextInt(variables.width / variables.unit) * variables.unit;
            variables.appley = variables.rand.nextInt(variables.height / variables.unit) * variables.unit;
            inside = false;

            for (int i = 0; i < variables.snakeBody; i++) {
                if (variables.x[i] == variables.applex && variables.y[i] == variables.appley) {
                    inside = true;
                    break;
                }
            }
        } while (inside);
    }

    public void checkApples() {
        if (variables.x[0] == variables.applex && variables.y[0] == variables.appley) {
            variables.snakeBody++;
            variables.applesEaten++;
            newApple();
        }
    }

    public void checkCollisions() {

        for (int i = variables.snakeBody; i > 0; i--) {
            if (variables.x[0] == variables.x[i] && variables.y[0] == variables.y[i]) {
                variables.moving = false;
                variables.time.stop();
                variables.isGameOver = true;
                Platform.runLater(() -> GameOverLogic.showGameOverScreen(variables.applesEaten,stage));
                break;
            }
        }

        if (variables.x[0] < 0 || variables.x[0] >= variables.width || variables.y[0] < 0
                || variables.y[0] >= variables.height) {
            variables.moving = false;
            variables.time.stop();
            variables.isGameOver = true;
            Platform.runLater(() -> GameOverLogic.showGameOverScreen(variables.applesEaten,stage));

        }
    }

}
