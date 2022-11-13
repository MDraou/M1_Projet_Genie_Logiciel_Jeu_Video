package physic;

/**
 * A 2D vector.
 */
public class Vector {
    private volatile int x, y;

    /**
     * The vector's constructor.
     * @param x -> the x coordinate
     * @param y -> the y coordinate
     */
    public Vector(int x, int y) {
        this.x = x; this.y = y;
    }

    /**
     * Return the x coordinate.
     * @return the x coordinate
     */
    public int getX() {
        return x;
    }

    /**
     * Return the y coordinate.
     * @return the y coordinate
     */
    public int getY() {
        return y;
    }

    /**
     * Set the coordinates.
     * @param x -> the new x coordinate
     * @param y -> the new y coordinate
     */
    public void set(int x, int y) {
        this.x = x; this.y = y;
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
