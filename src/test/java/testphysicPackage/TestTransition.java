package testphysicPackage;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.awt.geom.Point2D;

import physicpackage.Transition;

public class TestTransition {

    @Test
    void testGetSpeed() {
        Transition transition = new Transition(new Point2D.Double(), 5.0, 3.0);
        assertEquals(transition.getSpeed().elementAt(0), 5.0);
        assertEquals(transition.getSpeed().elementAt(1), 3.0);
    }

    @Test
    void testSetSpeed() {
        Transition transition = new Transition(new Point2D.Double(), 0.0, 8.0);
        transition.setSpeed(6, 4);
        assertEquals(transition.getSpeed().elementAt(0), 6.0);
        assertEquals(transition.getSpeed().elementAt(1), 4.0);
        transition.setSpeed(3, -5);
        assertEquals(transition.getSpeed().elementAt(0), 3.0);
        assertEquals(transition.getSpeed().elementAt(1), -5.0);
    }

    @Test
    void testGetPosition() {
        Transition transition = new Transition(new Point2D.Double(0, 6), 0, 0);
        assertEquals(transition.getPosition().getX(), 0);
        assertEquals(transition.getPosition().getY(), 6);
    }

    @Test
    void testSetPosition() {
        Transition transition = new Transition(new Point2D.Double(), 0, 0);
        transition.setPosition(new Point2D.Double(6, 10));
        assertEquals(transition.getPosition().getX(), 6);
        assertEquals(transition.getPosition().getY(), 10);
    }

    @Test
    void testUpdate() {
        Transition transition = new Transition(new Point2D.Double(), 10, 10);
        transition.setPosition(new Point2D.Double(12, -5));
        transition.update();
        assertEquals(transition.getPosition().getX(), 22);
        assertEquals(transition.getPosition().getY(), 5);
    }

}
