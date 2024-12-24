package Games.SpaceInvaders;

import java.awt.Image;

public class Block {
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected Image img;

    Block() {}

    Block(int x, int y, int width, int height, Image img) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.img = img;
    }


    public int getX() { return x; }
    public void setX(int x) { this.x = x; }
    public int getY() { return y; }
    public void setY(int y) { this.y = y; }
    public int getWidth() { return width; }
    public void setWidth(int width) { this.width = width; }
    public int getHeight() { return height; }
    public void setHeight(int height) { this.height = height; }
    public Image getImg() { return img; }
    public void setImg(Image img) { this.img = img; }
}