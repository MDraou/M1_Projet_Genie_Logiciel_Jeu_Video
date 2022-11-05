package testphysicPackage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.awt.geom.Point2D;

import physicpackage.PhysicalEntity;
import physicpackage.Transition;

public class TestPhysicalEntity {

    @Test
    void testGetTransition() {
        PhysicalEntity physicalEntity = new PhysicalEntity(new Transition(new Point2D.Double(), 6, 0), 0, null);
        Transition transition = physicalEntity.getTransition();
        assertEquals(transition.getSpeed().elementAt(0), 6);
        assertEquals(transition.getPosition().getX(), 0);
        assertEquals(transition.getPosition().getY(), 0);
    }

    @Test
    void testUpdate() {
        Transition transition = new Transition(new Point2D.Double(), 36, -27);
        PhysicalEntity physicalEntity = new PhysicalEntity(transition, 0, null);
        physicalEntity.getTransition().setPosition(new Point2D.Double(4, -3));
        physicalEntity.update();
        assertEquals(physicalEntity.getTransition().getPosition().getX(), 40);
        assertEquals(physicalEntity.getTransition().getPosition().getY(), -30);
    }

}
