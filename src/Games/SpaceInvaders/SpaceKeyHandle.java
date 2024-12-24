package Games.SpaceInvaders;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SpaceKeyHandle implements KeyListener {
    private BoardPanel bp = BoardPanel.getBp();

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT && bp.getShip().getX() - bp.getShip().getShipVelocityx() >= 0) {
            bp.getShip().setX(bp.getShip().getX() - (int)bp.getShip().getShipVelocityx());
        }
        else if (e.getKeyCode() == KeyEvent.VK_RIGHT && bp.getShip().getX() + bp.getShip().getShipVelocityx() + bp.getShip().getWidth() <= bp.getB().getBoardWidth()) {
            bp.getShip().setX(bp.getShip().getX() + (int)bp.getShip().getShipVelocityx());
        }
        else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            fireBullet();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    private void fireBullet() {
        int bulletWidth = bp.getB().getTileSize()/8;
        int bulletHeight = bp.getB().getTileSize()/2;
        Bullets bullet = new Bullets(
                bp.getShip().getX() + bp.getShip().getWidth()*15/32,
                bp.getShip().getY(),
                bulletWidth,
                bulletHeight,
                null,
                false,
                -10
        );
        bp.getBulletArray().add(bullet);
    }
}