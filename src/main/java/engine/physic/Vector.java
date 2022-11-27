package engine.physic;

import java.util.concurrent.atomic.AtomicReference;

/**
 * A 2D vector.
 */
public class Vector {
    private final AtomicReference<Double> x, y;

    /**
     * The vector's constructor.
     * @param x -> the x coordinate
     * @param y -> the y coordinate
     */
    public Vector(double x, double y) {
        this.x = new AtomicReference<>(x); this.y = new AtomicReference<>(y);
    }

    /**
     * Return the x coordinate.
     * @return the x coordinate
     */
    public double getX() {
        return x.get();
    }

    /**
     * Return the y coordinate.
     * @return the y coordinate
     */
    public double getY() {
        return y.get();
    }

    /**
     * Set the coordinates.
     * @param x -> the new x coordinate
     * @param y -> the new y coordinate
     */
    public void set(double x, double y) {
        this.x.set(x); this.y.set(y);
    }

    public boolean isNull() {
        return this.x.get() == 0.0 && this.y.get() == 0.0;
    }

    /**
     * Return a String representation of the vector.
     * @return a String representation of the vector
     */
    @Override
    public String toString() {
        return "(" + x.get() + ", " + y.get() + ")";
    }
}
