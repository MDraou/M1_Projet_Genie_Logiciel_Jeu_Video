package physic;

/**
 * A 2D vector.
 */
public class Vector {
    private volatile double x, y;

    /**
     * The vector's constructor.
     * @param x the x value
     * @param y the y value
     */
    public Vector(double x, double y) {
        this.x = x; this.y = y;
    }

    /**
     * Return the x value.
     * @return the x value
     */
    public double getX() {
        return x;
    }

    /**
     * Return the y value.
     * @return the y value
     */
    public double getY() {
        return y;
    }

    /**
     * Set the value.
     * @param x the new x value
     * @param y the new y value
     */
    public void set(double x, double y) {
        this.x = x; this.y = y;
    }

    /**
     * test if the values of x and y is 0.
     * @return true if the value of x and y is 0
     */
    public boolean isNull() {
        return this.x == 0.0 && this.y == 0.0;
    }

    /**
     * Return a String representation of the vector.
     * @return a String representation of the vector
     */
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
