package engine.physic;

import engine.Point;

/**
 * The interface representing the physic identities.
 */
public interface IMovementsChecker {

    /**
     * Return its speed represented by a vector.
     * @return its speed
     */
    Vector getSpeed();

    /**
     * change the speed of the entity
     * @param vx the new speed on the x
     * @param vy the new speed on the y
     */
    void setSpeed(double vx, double vy);

    /**
     * Stop the identity's movement.
     */
    void stop();

    /**
     * Return the id of the entity that posses the movement controller
     * @return the id
     */
    String getId();

    /**
     * Return the speed on the x.
     * @return the speed on the x
     */
    int getX();

    /**
     * Return the speed on the y.
     * @return the speed on the y
     */
    int getY();

    /**
     * Return the width of the hitbox
     * @return the width of the hitox
     */
    int getWidth();

    /**
     * Return the height of the hitbox
     * @return the height of the hitox
     */
    int getHeight();

    /**
     * Change the size of the hitbox.
     * @param width the width of the hitbox
     * @param height the height of the hitbox
     */
    void resize(int width, int height);


    Point getNextCoordinates();

    boolean intersectInX(IMovementsChecker controller);
    boolean intersectInY(IMovementsChecker controller);
    void setNeighbor(IMovementsChecker fCtrl);
}
