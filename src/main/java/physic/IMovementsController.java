package physic;

import kernel.Direction;

import java.awt.geom.Point2D;

/**
 * The interface representing the physic identities.
 */
public interface IMovementsController {

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

    void setSpeed(int vx, int vy);

    /**
     * Stop the identity's movement.
     */
    void stop();

    String getId();

    boolean intersects(int x, int y, int width, int height);

    Integer getX();
    Integer getY();
    Integer getWidth();
    Integer getHeight();
    Integer getLayer();
    void setCoordinates(int x, int y);
    void resize(int width, int height);
    Point2D.Double getNextCoordinates();
    boolean isBouncing();
}
