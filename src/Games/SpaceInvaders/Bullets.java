package Games.SpaceInvaders;

import java.awt.Image;

public class Bullets extends Block {
    private int bulletVelocityY;
    private boolean used = false;

    Bullets() {}

    Bullets(int x, int y, int width, int height, Image img, boolean used, int bulletVelocityY) {
        super(x, y, width, height, img);
        this.used = used;
        this.bulletVelocityY = bulletVelocityY;
    }

    public int getBulletVelocityY() { return bulletVelocityY; }
    public void setBulletVelocityY(int bulletVelocityY) { this.bulletVelocityY = bulletVelocityY; }
    public boolean isUsed() { return used; }
    public void setUsed(boolean used) { this.used = used; }
}