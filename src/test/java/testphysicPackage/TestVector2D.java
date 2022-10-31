package testphysicPackage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

import java.awt.geom.Point2D;
import physicpackage.Vector2D;

public class TestVector2D {

    @Test
    void testGetSpeed() {
        Vector2D vector2d = new Vector2D(5);
        assertEquals(vector2d.getSpeed(), 5);
        assertNotEquals(vector2d.getSpeed(), 6);
    }

    @Test
    void testSetSpeed() {
        Vector2D vector2d = new Vector2D(5);
        vector2d.setSpeed(8);
        assertEquals(vector2d.getSpeed(), 8);
        vector2d.setSpeed(-5);
        assertEquals(vector2d.getSpeed(), -5);
    }

    @Test
    void testGetPosition() {
        Vector2D vector2d = new Vector2D(5);
        assertEquals(vector2d.getPosition().getX(), 0);
        assertNotEquals(vector2d.getPosition().getY(), 6);
    }

    @Test
    void testSetPosition() {
        Vector2D vector2d = new Vector2D(3);
        vector2d.setPosition(new Point2D.Double(6, 10));
        assertEquals(vector2d.getPosition().getX(), 6);
        assertEquals(vector2d.getPosition().getY(), 10);
    }

    @Test
    void testUpdate() {
        Vector2D vector = new Vector2D(10);
        vector.setPosition(new Point2D.Double(12, -5));
        vector.update();
        assertEquals(vector.getPosition().getX(), 120);
        assertEquals(vector.getPosition().getY(), -50);
    }

}
