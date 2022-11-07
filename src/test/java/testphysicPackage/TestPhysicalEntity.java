package testphysicPackage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.awt.geom.Point2D;

import physicpackage.PhysicalEntity;
import physicpackage.PhysicalInformations;

public class TestPhysicalEntity {

    @Test
    void testGetPhysicalInformations() {
        PhysicalEntity physicalEntity = new PhysicalEntity(new PhysicalInformations(new Point2D.Double(), 6, 0), 0,
                null);
        PhysicalInformations physicalInformations = physicalEntity.getPhysicalInformations();
        assertEquals(physicalInformations.getSpeed().getX(), 6);
        assertEquals(physicalInformations.getPosition().getX(), 0);
        assertEquals(physicalInformations.getPosition().getY(), 0);
    }

    @Test
    void testUpdate() {
        PhysicalInformations PhysicalInformations = new PhysicalInformations(new Point2D.Double(), 36, -27);
        PhysicalEntity physicalEntity = new PhysicalEntity(PhysicalInformations, 0, null);
        physicalEntity.getPhysicalInformations().setPosition(new Point2D.Double(4, -3));
        physicalEntity.update();
        assertEquals(physicalEntity.getPhysicalInformations().getPosition().getX(), 40);
        assertEquals(physicalEntity.getPhysicalInformations().getPosition().getY(), -30);
    }

}
