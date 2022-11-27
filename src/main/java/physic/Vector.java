package physic;

/**
 * A 2D vector.
 */
public class Vector {
    private volatile double x, y;

    /**
     * The vector's constructor.
     * @param x -> the x coordinate
     * @param y -> the y coordinate
     */
    public Vector(double x, double y) {
        this.x = x; this.y = y;
    }

    /**
     * Return the x coordinate.
     * @return the x coordinate
     */
    public double getX() {
        return x;
    }

    /**
     * Return the y coordinate.
     * @return the y coordinate
     */
    public double getY() {
        return y;
    }

    /**
     * Set the coordinates.
     * @param x -> the new x coordinate
     * @param y -> the new y coordinate
     */
    public void set(double x, double y) {
        this.x = x; this.y = y;
    }

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
