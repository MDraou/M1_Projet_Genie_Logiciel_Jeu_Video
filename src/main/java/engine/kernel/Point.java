package engine.kernel;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Define a 2D point with two AtomicInteger for the coordinates.
 */
public class Point {
    private final AtomicInteger x, y;

    /**
     * Constructor of a point.
     * @param x the coordinate x of the point
     * @param y the coordinate y of the point
     */
    public Point(int x, int y) {
        this.x = new AtomicInteger(x); this.y = new AtomicInteger(y);
    }

    /**
     * Return the coordinate x.
     * @return the coordinate x
     */
    public int getX() {
        return x.get();
    }

    /**
     * Return the coordinate y.
     * @return the coordinate y
     */
    public int getY() {
        return y.get();
    }

    /**
     * Change the coordinates od the point.
     * @param x the coordinate x
     * @param y the coordinate y
     */
    public void setLocation(int x, int y) {
        this.x.set(x); this.y.set(y);
    }
}
