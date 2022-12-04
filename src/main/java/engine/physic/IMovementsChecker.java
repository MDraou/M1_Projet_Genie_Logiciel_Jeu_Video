package engine.physic;

import engine.kernel.Point;

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


    /**
     * check if the entity can move and return the next coordinates
     * @return the next coordinates
     */
    Point getNextCoordinates();

    /**
     * Test if the entity intersect another entity on the x
     * @param controller a movement controller of another entity
     * @return true if they intersect and false otherwise.
     */
    boolean intersectInX(IMovementsChecker controller);

    /**
     * Test if the entity intersect another entity on the y
     * @param controller a movement controller of a foreign entity
     * @return true if they intersect and false otherwise.
     */
    boolean intersectInY(IMovementsChecker controller);

    /**
     * Save a movement controller of a neighbor entity
     * @param fCtrl a movement controller of a neighbor entity
     */
    void setNeighbor(IMovementsChecker fCtrl);

    /**
     * Verify if the entity need to bounce when it intersects
     * @return true if the entity need to bounce
     */
    boolean isBouncing();
}
