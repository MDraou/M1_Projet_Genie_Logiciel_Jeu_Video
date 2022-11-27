package physic;

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

    void setSpeed(double vx, double vy);

    /**
     * Stop the identity's movement.
     */
    void stop();

    String getId();

    int getX();
    int getY();
    int getWidth();
    int getHeight();
    void resize(int width, int height);
    Point2D.Double getNextCoordinates();

    boolean intersectInX(IMovementsController controller);
    boolean intersectInY(IMovementsController controller);
    void setNeighbor(IMovementsController fCtrl);
}
