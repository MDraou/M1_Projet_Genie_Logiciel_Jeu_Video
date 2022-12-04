package engine.kernel;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class TestPoint {

    @Test
    public void getX() {
        Point point = new Point(50,43);
        assertEquals(50, point.getX());
    }

    @Test
    public void getY() {
        Point point = new Point(34,56);
        assertEquals(56, point.getY());
    }

    @Test
    public void setLocation() {
        Point point = new Point(0,0);
        assertEquals(0, point.getX());
        assertEquals(0, point.getY());
        point.setLocation(14,23);
        assertEquals(14, point.getX());
        assertEquals(23, point.getY());
    }
}
