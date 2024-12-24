package Games.pacMan;

import java.awt.*;

public class Block {
    int x;
    int y;
    int width;
    int height;
    Image image;

    int startX;
    int startY;
    char direction = 'U'; // U D L R
    int velocityX = 0;
    int velocityY = 0;

    Block(Image image, int x, int y, int width, int height) {
        this.image = image;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.startX = x;
        this.startY = y;
    }

    void updateDirection(PacManVariables pacManVariables,char direction) {
        char prevDirection = this.direction;
        this.direction = direction;
        updateVelocity(pacManVariables);
        this.x += this.velocityX;
        this.y += this.velocityY;
        for (Block wall : pacManVariables.walls) {
            if (collision(this, wall)) {
                this.x -= this.velocityX;
                this.y -= this.velocityY;
                this.direction = prevDirection;
                updateVelocity(pacManVariables);
            }
        }
    }
    public boolean collision(Block a, Block b) {
        return  a.x < b.x + b.width &&
                a.x + a.width > b.x &&
                a.y < b.y + b.height &&
                a.y + a.height > b.y;
    }
    void updateVelocity(PacManVariables pacManVariables) {
        if (this.direction == 'U') {
            this.velocityX = 0;
            this.velocityY = -pacManVariables.tileSize/4;
        }
        else if (this.direction == 'D') {
            this.velocityX = 0;
            this.velocityY = pacManVariables.tileSize/4;
        }
        else if (this.direction == 'L') {
            this.velocityX = -pacManVariables.tileSize/4;
            this.velocityY = 0;
        }
        else if (this.direction == 'R') {
            this.velocityX = pacManVariables.tileSize/4;
            this.velocityY = 0;
        }
    }

    void reset() {
        this.x = this.startX;
        this.y = this.startY;
    }
}
