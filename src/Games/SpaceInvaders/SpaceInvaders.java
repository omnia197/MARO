package Games.SpaceInvaders;

import gameOver.GameOverLogic;
import core.Games;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import javafx.application.Platform;
import javafx.stage.Stage;

public class SpaceInvaders extends SpaceInvadersGameFrame implements ActionListener {
    private final BoardPanel bp;
    private Timer gameLoop;
    private final Stage primaryStage;

    public SpaceInvaders(Stage primaryStage) {
        super(Games.SPACEINVADERS, primaryStage);
        this.primaryStage = primaryStage;
        this.bp = BoardPanel.getBp();

        setPreferredSize(new Dimension(bp.getB().getBoardWidth(), bp.getB().getBoardHeight()));
        setBackground(Color.black);
        setFocusable(true);
        addKeyListener(new SpaceKeyHandle());

        gameLoop = new Timer(1000 / 60, this);
        bp.setGameLoop(gameLoop);
        startGame();
    }

    @Override
    public void startGame() {
        Board board = Board.getB();
        board.setRows(25);
        board.setColumns(25);
        board.setTileSize(30);

        loadImages();
        setupInitialState();

        bp.setGameOver(false);
        bp.setScore(0);
        gameLoop.start();
    }

    private void loadImages() {

        bp.setShipImg(new ImageIcon(getClass().getResource("/media/SpaceInvaders/ship.png")).getImage());

        Image alienImg = new ImageIcon(getClass().getResource("/media/SpaceInvaders/alien.png")).getImage();
        Image alienCyanImg = new ImageIcon(getClass().getResource("/media/SpaceInvaders/alien-cyan.png")).getImage();
        Image alienMagentaImg = new ImageIcon(getClass().getResource("/media/SpaceInvaders/alien-magenta.png"))
                .getImage();
        Image alienYellowImg = new ImageIcon(getClass().getResource("/media/SpaceInvaders/alien-yellow.png"))
                .getImage();

        bp.getAlienImgArray().clear();
        bp.getAlienImgArray().add(alienImg);
        bp.getAlienImgArray().add(alienCyanImg);
        bp.getAlienImgArray().add(alienMagentaImg);
        bp.getAlienImgArray().add(alienYellowImg);

    }

    private void setupInitialState() {

        bp.getShip().setHeight(bp.getB().getTileSize());
        bp.getShip().setWidth(2 * bp.getB().getTileSize());
        bp.getShip().setX(bp.getB().getTileSize() * bp.getB().getColumns() / 2 - bp.getB().getTileSize());
        bp.getShip().setY(bp.getB().getTileSize() * bp.getB().getRows() - bp.getB().getTileSize() * 2);
        bp.getShip().setImg(bp.getShipImg());
        bp.getShip().setShipVelocityx(bp.getB().getTileSize());

        createAliens(5, 5);
    }

    private void createAliens(int rows, int cols) {
        bp.getAlienArray().clear();
        int alienWidth = bp.getB().getTileSize() * 2;
        int alienHeight = bp.getB().getTileSize();
        int alienX = bp.getB().getTileSize();
        int alienY = bp.getB().getTileSize();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                int randomImgIndex = (int) (Math.random() * bp.getAlienImgArray().size());
                Aliens alien = new Aliens(
                        alienX + c * alienWidth,
                        alienY + r * alienHeight,
                        alienWidth,
                        alienHeight,
                        bp.getAlienImgArray().get(randomImgIndex),
                        true,
                        1);
                bp.getAlienArray().add(alien);
            }
        }
        bp.setAlienCount(bp.getAlienArray().size());
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    @Override
    public void draw(Graphics g) {

        g.drawImage(bp.getShip().getImg(), bp.getShip().getX(), bp.getShip().getY(),
                bp.getShip().getWidth(), bp.getShip().getHeight(), null);

        for (Aliens alien : bp.getAlienArray()) {
            if (alien.isAlive()) {
                g.drawImage(alien.getImg(), alien.getX(), alien.getY(), alien.getWidth(), alien.getHeight(), null);
            }
        }

        g.setColor(Color.WHITE);
        for (Bullets bullet : bp.getBulletArray()) {
            if (!bullet.isUsed()) {
                g.drawRect(bullet.getX(), bullet.getY(), bullet.getWidth(), bullet.getHeight());
            }
        }

        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.PLAIN, 32));
        if (bp.isGameOver()) {
            gameLoop.stop();
            Platform.runLater(() -> GameOverLogic.showGameOverScreen(bp.getScore(), primaryStage));

        } else {
            g.drawString(String.valueOf(bp.getScore()), 10, 35);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        moveGame();
        repaint();
        if (bp.isGameOver()) {
            gameLoop.stop();
        }
    }

    private void moveGame() {

        for (Aliens alien : bp.getAlienArray()) {
            if (alien.isAlive()) {
                alien.setX(alien.getX() + alien.getAlienVelocityX());

                if (alien.getX() + alien.getWidth() >= bp.getB().getBoardWidth() || alien.getX() <= 0) {
                    alien.setY(alien.getY() + alien.getHeight());
                    alien.setAlienVelocityX(alien.getAlienVelocityX() * -1);
                }

                if (alien.getY() >= bp.getShip().getY() &&
                        (alien.getX() + 2 * bp.getB().getTileSize()) >= bp.getShip().getX()) {
                    bp.setGameOver(true);
                }
            }
        }

        for (int i = bp.getBulletArray().size() - 1; i >= 0; i--) {
            Bullets bullet = bp.getBulletArray().get(i);
            bullet.setY(bullet.getY() - 10);

            for (Aliens alien : bp.getAlienArray()) {
                if (!bullet.isUsed() && alien.isAlive() && detectCollision(bullet, alien)) {
                    bullet.setUsed(true);
                    alien.setAlive(false);
                    bp.setAlienCount(bp.getAlienCount() - 1);
                    bp.setScore(bp.getScore() + 100);
                }
            }

            if (bullet.isUsed() || bullet.getY() < 0) {
                bp.getBulletArray().remove(i);
            }
        }

        if (bp.getAlienCount() == 0) {
            int nextRows = Math.min(6, 5 + 1);
            int nextCols = Math.min(6, 5 + 1);
            bp.setScore(bp.getScore() + nextRows * nextCols * 100);
            createAliens(nextRows, nextCols);
        }
    }

    private boolean detectCollision(Block a, Block b) {
        return a.getX() < b.getX() + b.getWidth() &&
                a.getX() + a.getWidth() > b.getX() &&
                a.getY() < b.getY() + b.getHeight() &&
                a.getY() + a.getHeight() > b.getY();
    }
}