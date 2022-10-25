package testphysicPackage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

import physicpackage.Point2D;

public class TestPoint2D {

    @Test
    void testGetX() {
        Point2D point2d = new Point2D(3, 0);
        assertEquals(3, point2d.getX());
        point2d = new Point2D(-4, 2);
        assertEquals(-4, point2d.getX());
        assertNotEquals(10, point2d.getX());
    }

    @Test
    void testGetY() {
        Point2D point2d = new Point2D(3, 8);
        assertEquals(8, point2d.getY());
        point2d = new Point2D(-4, 2);
        assertEquals(2, point2d.getY());
        assertNotEquals(10, point2d.getY());
    }

    @Test
    void testAdd() {
        Point2D point1 = new Point2D(3, -2);
        Point2D point2 = new Point2D(-3, 10);
        Point2D point3 = new Point2D(15, -26);
        point1.add(point2);
        assertEquals(point1.getX(), 0);
        assertEquals(point1.getY(), 8);
        point1.add(point3);
        assertEquals(point1.getX(), 15);
        assertEquals(point1.getY(), -18);
    }

    @Test
    void testSubtract() {
        Point2D point1 = new Point2D(3, -2);
        Point2D point2 = new Point2D(-3, 10);
        Point2D point3 = new Point2D(15, -26);
        point1.subtract(point2);
        assertEquals(point1.getX(), 6);
        assertEquals(point1.getY(), -12);
        point1.subtract(point3);
        assertEquals(point1.getX(), -9);
        assertEquals(point1.getY(), 14);
    }

    @Test
    void testMultiply() {
        Point2D point = new Point2D(5, -3);
        point.multiply(5);
        assertEquals(point.getX(), 25);
        assertEquals(point.getY(), -15);
        point.multiply(-2);
        assertEquals(point.getX(), -50);
        assertEquals(point.getY(), 30);
    }

}
