package physic;


public class Vector {
    private volatile int x, y;

    public Vector(int x, int y) {
        this.x = x; this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void set(int x, int y) {
        this.x = x; this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
