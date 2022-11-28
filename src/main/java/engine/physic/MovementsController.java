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
     * The movement controller's constructor.
     * @param id its entity's id
     * @param coords the coordinates of the entity in the physique
     * @param dimension the dimension of the hitbox
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

    /**
     * change the speed of the entity
     * @param vx the new speed on the x
     * @param vy the new speed on the y
     */
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

    /**
     * Return the speed on the x.
     * @return the speed on the x
     */
    @Override
    public int getX() {
        return this.coords.getX();
    }

    /**
     * Return the speed on the y.
     * @return the speed on the y
     */
    @Override
    public int getY() {
        return this.coords.getY();
    }

    /**
     * Return the width of the hitbox
     * @return the width of the hitox
     */
    @Override
    public int getWidth() {
        return this.dimension.width;
    }

    /**
     * Return the height of the hitbox
     * @return the height of the hitox
     */
    @Override
    public int getHeight() {
        return this.dimension.height;
    }

    /**
     * Change the size of the hitbox.
     * @param width the width of the hitbox
     * @param height the height of the hitbox
     */
    @Override
    public void resize(int width, int height) {
        this.dimension.setSize(width, height);
    }

    /**
     * test if the entity can move and return the next coordinates
     * @return the next coordinates
     */
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

    /**
     * Test if the entity intersect another entity on the x
     * @param fCtrl a movementcontroller of another entity
     * @return true if they intersect. else false.
     */
    @Override
    public boolean intersectInX(IMovementsController fCtrl) {
        int nextX = this.getX() + (int) this.speed.getX();
        return (this.getX() + this.getWidth() < fCtrl.getX() && nextX + this.getWidth() > fCtrl.getX()) ||
                (this.getX() > fCtrl.getX() + fCtrl.getWidth() && nextX < fCtrl.getX() + fCtrl.getWidth());
    }

    /**
     * Test if the entity intersect another entity on the y
     * @param fCtrl a movement controller of a foreign entity
     * @return true if they intersect. else false.
     */
    @Override
    public boolean intersectInY(IMovementsController fCtrl) {
        int nextY = this.getY() + (int) this.speed.getY();
        return (this.getY() + this.getHeight() < fCtrl.getY() && nextY + this.getHeight() > fCtrl.getY()) ||
               (this.getY() > fCtrl.getY()  + fCtrl.getHeight() && nextY < fCtrl.getY() + fCtrl.getHeight());
    }

    /**
     * Save a movement controller of a neighbor entity
     * @param fCtrl a movement controller of a neigbor entity
     */
    @Override
    public void setNeighbor(IMovementsController fCtrl) {
        this.fCtrl = fCtrl;
    }
}
