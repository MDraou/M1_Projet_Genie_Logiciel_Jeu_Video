package engine.physic;


import engine.Point;

import java.awt.*;

/**
 * An entity's identity which represent the physic of this entity.
 */
public class MovementsController implements IMovementsController {

    private final String id;
    private final Vector speed = new Vector(0, 0);
    private final Point coords;
    private final Dimension dimension;

    private volatile IMovementsController fCtrl = null;

    /**
     * The physic identity's constructor. Create a Hitbox object with the parameters.
     * @param id -> its entity's id
     */
    public MovementsController(String id, Point coords, Dimension dimension) {
        this.id = id;
        this.coords = coords;
        this.dimension = dimension;
    }

    /**
     * Return its speed represented by a vector.
     * @return its speed
     */
    @Override
    public Vector getSpeed() { return speed; }

    /**
     * Returns its entity's id.
     * @return its entity's id
     */
    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setSpeed(double vx, double vy) {
        this.speed.set(vx, vy);
    }

    /**
     * Stop the identity's movement.
     */
    public void stop() {
        this.speed.set(0, 0);
    }

    @Override
    public int getX() {
        return this.coords.getX();
    }

    @Override
    public int getY() {
        return this.coords.getY();
    }

    @Override
    public int getWidth() {
        return this.dimension.width;
    }

    @Override
    public int getHeight() {
        return this.dimension.height;
    }

    @Override
    public void resize(int width, int height) {
        this.dimension.setSize(width, height);
    }

    @Override
    public Point getNextCoordinates() {
        Point newCoords = new Point((int) (this.getX() + speed.getX()), (int) (this.getY() + speed.getY()));
        if (fCtrl == null) return newCoords;
        if (speed.getX() == 0) {
            if (this.getX() + this.getWidth() < fCtrl.getX()) newCoords.setLocation(fCtrl.getX() - this.getWidth(), this.getY());
            if (this.getX() > fCtrl.getX() + fCtrl.getWidth()) newCoords.setLocation(fCtrl.getX() + fCtrl.getWidth(), this.getY());
        }
        if (speed.getY() == 0) {
            if (this.getY() + this.getHeight() < fCtrl.getY()) newCoords.setLocation(this.getX(), fCtrl.getY() - this.getHeight());
            if (this.getY() > fCtrl.getY() + fCtrl.getHeight()) newCoords.setLocation(this.getX(), fCtrl.getY() + fCtrl.getHeight());
        }
        fCtrl = null;
        return newCoords;
    }

    @Override
    public boolean intersectInX(IMovementsController fCtrl) {
        int nextX = this.getX() + (int) this.speed.getX();
        return (this.getX() + this.getWidth() < fCtrl.getX() && nextX + this.getWidth() >= fCtrl.getX()) ||
                (this.getX() > fCtrl.getX() + fCtrl.getWidth() && nextX <= fCtrl.getX() + fCtrl.getWidth());
    }

    @Override
    public boolean intersectInY(IMovementsController fCtrl) {
        int nextY = this.getY() + (int) this.speed.getY();
        return (this.getY() + this.getHeight() < fCtrl.getY() && nextY + this.getHeight() >= fCtrl.getY()) ||
               (this.getY() > fCtrl.getY()  + fCtrl.getHeight() && nextY <= fCtrl.getY() + fCtrl.getHeight());
    }

    @Override
    public void setNeighbor(IMovementsController fCtrl) {
        this.fCtrl = fCtrl;
    }
}
