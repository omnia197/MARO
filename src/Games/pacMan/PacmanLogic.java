package Games.pacMan;

import gameOver.GameOverLogic;
import javafx.application.Platform;
import javafx.stage.Stage;

public class PacmanLogic {
    PacManVariables pacManVariables;
    Block pacman;
    Pacman pacmanPaint;
    Stage stage;

    public PacmanLogic(PacManVariables pacManVariables, Block pacman,Pacman pacmanPaint , Stage stage) {
        this.pacManVariables = pacManVariables;
        this.pacman = pacman;
        this.pacmanPaint = pacmanPaint;
        this.stage = stage;
    }
    public void checkLogic() {
        checkWallCollisions();
        checkGhostCollisions();
        checkFoodCollision();

    }
    //check wall collisions
   private void checkWallCollisions(){
        for (Block wall : pacManVariables.walls) {
            if (pacman.collision(pacman, wall)) {
                pacman.x -= pacman.velocityX;
                pacman.y -= pacman.velocityY;
                break;
            }
        }
    }
    //check ghost collisions
    private void checkGhostCollisions()
    {
        for (Block ghost : pacManVariables.ghosts) {
            if (ghost.collision(ghost, pacman)) {
                pacManVariables.lives -= 1;
                if (pacManVariables.lives == 0) {
                    pacManVariables.gameOver = true;
                    Platform.runLater(() -> GameOverLogic.showGameOverScreen(pacManVariables.score,stage));
                    return;
                }
                resetPositions(pacman);
            }

            if (ghost.y == pacManVariables.tileSize * 9 && ghost.direction != 'U' && ghost.direction != 'D') {
                ghost.updateDirection(pacManVariables, 'U');
            }
            ghost.x += ghost.velocityX;
            ghost.y += ghost.velocityY;
            for (Block wall : pacManVariables.walls) {
                if (pacman.collision(ghost, wall) || ghost.x <= 0 || ghost.x + ghost.width >= pacManVariables.boardWidth) {
                    ghost.x -= ghost.velocityX;
                    ghost.y -= ghost.velocityY;
                    char newDirection = pacManVariables.directions[pacManVariables.random.nextInt(4)];
                    ghost.updateDirection(pacManVariables, newDirection);
                }
            }
        }
    }
    //check food collision
    private void checkFoodCollision(){
        Block foodEaten = null;
        for (Block food : pacManVariables.foods) {
            if (pacman.collision(pacman, food)) {
                foodEaten = food;
                pacManVariables.score += 10;
            }
        }
        pacManVariables.foods.remove(foodEaten);

        if (pacManVariables.foods.isEmpty()) {
            pacmanPaint.loadMap();
            resetPositions(pacman);
        }

    }

    private void resetPositions(Block pacman) {
        pacman.image = pacManVariables.pacmanRightImage;
        pacman.reset();
        pacman.velocityX = 0;
        pacman.velocityY = 0;
        for (Block ghost : pacManVariables.ghosts) {
            ghost.reset();
            char newDirection = pacManVariables.directions[pacManVariables.random.nextInt(4)];
            ghost.updateDirection(pacManVariables,newDirection);
        }
    }
}
