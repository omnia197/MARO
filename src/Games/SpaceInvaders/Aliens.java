package Games.SpaceInvaders;

import java.awt.Image;

public class Aliens extends Block {
    private boolean alive = true;
    private int alienVelocityX;

    Aliens() {}

    Aliens(int x, int y, int width, int height, Image img, boolean alive, int alienVelocityX) {
        super(x, y, width, height, img);
        this.alive = alive;
        this.alienVelocityX = alienVelocityX;
    }

    public boolean isAlive() { return alive; }
    public void setAlive(boolean alive) { this.alive = alive; }
    public int getAlienVelocityX() { return alienVelocityX; }
    public void setAlienVelocityX(int alienVelocityX) { this.alienVelocityX = alienVelocityX; }
}