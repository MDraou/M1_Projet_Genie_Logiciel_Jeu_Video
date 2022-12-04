package engine.physic;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import engine.physic.Vector;

public class TestVector {

    @Test
    public void getTest() {
        Vector vector = new Vector(10,20);
        assertEquals(10,vector.getX());
        assertEquals(20,vector.getY());
    }

    @Test
    public void setTest() {
        Vector vector = new Vector(0,0);
        vector.set(1,1);
        assertEquals(1,vector.getX());
        assertEquals(1,vector.getY());
    }

    @Test
    public void testIsNull() {
        Vector test = new Vector(0, 0);
        Vector test1 = new Vector(1, 2);
        assertTrue(test.isNull());
        assertFalse(test1.isNull());
    }

    @Test
    public void testToString() {
        Vector test = new Vector(0, 0);
        assertEquals(test.toString(), "(" + test.getX() + ", " + test.getY() + ")");
    }
}
