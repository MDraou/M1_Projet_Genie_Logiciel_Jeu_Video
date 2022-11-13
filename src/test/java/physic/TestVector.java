package physic;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import physic.Vector;

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
}
