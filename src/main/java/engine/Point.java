package engine;

import java.util.concurrent.atomic.AtomicInteger;

public class Point {
    private final AtomicInteger x, y;

    public Point(int x, int y) {
        this.x = new AtomicInteger(x); this.y = new AtomicInteger(y);
    }

    public int getX() {
        return x.get();
    }

    public int getY() {
        return y.get();
    }

    public void setLocation(int x, int y) {
        this.x.set(x); this.y.set(y);
    }
}
