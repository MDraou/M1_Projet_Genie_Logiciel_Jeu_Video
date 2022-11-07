package testphysicPackage;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.awt.geom.Point2D;

import physicpackage.PhysicalInformations;

public class TestPhysicalInformations {

    @Test
    void testGetSpeed() {
        PhysicalInformations physicalInformations = new PhysicalInformations(new Point2D.Double(), 5.0, 3.0);
        assertEquals(physicalInformations.getSpeed().elementAt(0), 5.0);
        assertEquals(physicalInformations.getSpeed().elementAt(1), 3.0);
    }

    @Test
    void testSetSpeed() {
        PhysicalInformations physicalInformations = new PhysicalInformations(new Point2D.Double(), 0.0, 8.0);
        physicalInformations.setSpeed(6, 4);
        assertEquals(physicalInformations.getSpeed().elementAt(0), 6.0);
        assertEquals(physicalInformations.getSpeed().elementAt(1), 4.0);
        physicalInformations.setSpeed(3, -5);
        assertEquals(physicalInformations.getSpeed().elementAt(0), 3.0);
        assertEquals(physicalInformations.getSpeed().elementAt(1), -5.0);
    }

    @Test
    void testGetPosition() {
        PhysicalInformations physicalInformations = new PhysicalInformations(new Point2D.Double(0, 6), 0, 0);
        assertEquals(physicalInformations.getPosition().getX(), 0);
        assertEquals(physicalInformations.getPosition().getY(), 6);
    }

    @Test
    void testSetPosition() {
        PhysicalInformations physicalInformations = new PhysicalInformations(new Point2D.Double(), 0, 0);
        physicalInformations.setPosition(new Point2D.Double(6, 10));
        assertEquals(physicalInformations.getPosition().getX(), 6);
        assertEquals(physicalInformations.getPosition().getY(), 10);
    }

    @Test
    void testUpdate() {
        PhysicalInformations physicalInformations = new PhysicalInformations(new Point2D.Double(), 10, 10);
        physicalInformations.setPosition(new Point2D.Double(12, -5));
        physicalInformations.update();
        assertEquals(physicalInformations.getPosition().getX(), 22);
        assertEquals(physicalInformations.getPosition().getY(), 5);
    }

}
