package physic;

import kernel.Direction;

/**
 * The interface representing the physic identities.
 */
public interface IMovementController {

    /**
     * Return its speed represented by a vector.
     * @return its speed
     */
    Vector getSpeed();

    /**
     * Set the speed represented by a vector.
     * @param speed -> the vector's norm
     * @param direction -> the vector's direction
     */
    void setSpeed(int speed, Direction direction);

    /**
     * Stop the identity's movement.
     */
    void stop();

    String getId();

    boolean intersects(IMovementController controller);

    Integer getX();
    Integer getY();
    Integer getWidth();
    Integer getHeight();
    Integer getLayer();
    void setCoordinates(int x, int y);
    void resize(int width, int height);
}
