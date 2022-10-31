package testphysicPackage;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import java.awt.geom.Point2D;
import physicpackage.Surface;

public class TestSurface {

    @Test
    void testIsInContact() {
        Surface surface = new Surface(new Point2D.Double(0, 0), new Point2D.Double(10, 10));
        assertTrue(surface.isInContact(new Point2D.Double(6, 0)));
        assertTrue(surface.isInContact(new Point2D.Double(10, 8)));
        assertFalse(surface.isInContact(new Point2D.Double(13, 0)));
    }

}
