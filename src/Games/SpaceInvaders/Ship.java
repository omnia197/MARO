package Games.SpaceInvaders;

import java.awt.Image;

public class Ship extends Block {
    private double shipVelocityx;

    Ship() {}

    Ship(int x, int y, int width, int height, Image img, double shipVelocityx) {
        super(x, y, width, height, img);
        this.shipVelocityx = shipVelocityx;
    }

    public double getShipVelocityx() { return shipVelocityx; }
    public void setShipVelocityx(double shipVelocityx) { this.shipVelocityx = shipVelocityx; }
}