package testphysicPackage;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.awt.geom.Point2D;
import physicpackage.PhysicalEntity;
import physicpackage.Vector2D;

public class TestPhysicalEntity {

    @Test
    void testGetVector2d() {
        PhysicalEntity physicalEntity = new PhysicalEntity(new Vector2D(6));
        Vector2D vector2d = physicalEntity.getVector2d();
        assertEquals(vector2d.getSpeed(), 6);
        assertEquals(vector2d.getPosition().getX(), 0);
        assertEquals(vector2d.getPosition().getY(), 0);
    }

    @Test
    void testUpdate() {
        Vector2D vector = new Vector2D(10);
        PhysicalEntity physicalEntity = new PhysicalEntity(vector);
        physicalEntity.getVector2d().setPosition(new Point2D.Double(4, -3));
        physicalEntity.update();
        assertEquals(physicalEntity.getVector2d().getPosition().getX(), 40);
        assertEquals(physicalEntity.getVector2d().getPosition().getY(), -30);

    }
}
