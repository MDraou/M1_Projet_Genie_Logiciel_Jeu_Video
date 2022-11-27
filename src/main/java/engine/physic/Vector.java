package engine.physic;

import java.util.concurrent.atomic.AtomicReference;

/**
 * A 2D vector.
 */
public class Vector {
    private final AtomicReference<Double> x, y;

    /**
     * The vector's constructor.
     * @param x the x value
     * @param y the y value
     */
    public Vector(double x, double y) {
        this.x = new AtomicReference<>(x); this.y = new AtomicReference<>(y);
    }

    /**
     * Return the x value.
     * @return the x value
     */
    public double getX() {
        return x.get();
    }

    /**
     * Return the y value.
     * @return the y value
     */
    public double getY() {
        return y.get();
    }

    /**
     * Set the value.
     * @param x the new x value
     * @param y the new y value
     */
    public void set(double x, double y) {
        this.x.set(x); this.y.set(y);
    }

    /**
     * test if the values of x and y is 0.
     * @return true if the value of x and y is 0
     */
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
