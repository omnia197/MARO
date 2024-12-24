package Games.SpaceInvaders;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BoardPanel {
    private Board b = Board.getB();
    private ArrayList<Image> alienImgArray = new ArrayList<>();
    private ArrayList<Aliens> alienArray = new ArrayList<>();
    private Image shipImg;
    private Timer gameLoop;
    private int alienCount;
    private Ship ship = new Ship();
    private int score = 0;
    private boolean gameOver = false;
    private ArrayList<Bullets> bulletArray = new ArrayList<>();

    private static BoardPanel bp = new BoardPanel();

    private BoardPanel() {}

    public static BoardPanel getBp() {
        return bp;
    }


    public Board getB() { return b; }
    public void setB(Board b) { this.b = b; }
    public ArrayList<Image> getAlienImgArray() { return alienImgArray; }
    public void setAlienImgArray(ArrayList<Image> alienImgArray) { this.alienImgArray = alienImgArray; }
    public ArrayList<Aliens> getAlienArray() { return alienArray; }
    public void setAlienArray(ArrayList<Aliens> alienArray) { this.alienArray = alienArray; }
    public Image getShipImg() { return shipImg; }
    public void setShipImg(Image shipImg) { this.shipImg = shipImg; }
    public Timer getGameLoop() { return gameLoop; }
    public void setGameLoop(Timer gameLoop) { this.gameLoop = gameLoop; }
    public int getAlienCount() { return alienCount; }
    public void setAlienCount(int alienCount) { this.alienCount = alienCount; }
    public Ship getShip() { return ship; }
    public void setShip(Ship ship) { this.ship = ship; }
    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }
    public boolean isGameOver() { return gameOver; }
    public void setGameOver(boolean gameOver) { this.gameOver = gameOver; }
    public ArrayList<Bullets> getBulletArray() { return bulletArray; }
    public void setBulletArray(ArrayList<Bullets> bulletArray) { this.bulletArray = bulletArray; }
}