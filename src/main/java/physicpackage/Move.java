package physicpackage;

import java.awt.geom.Point2D;
import java.util.List;

public class Move {
    public static void move(PhysicalEntity entity, List<PhysicalEntity> entities) {
        for (PhysicalEntity currentEntity : entities) {
            if (entity != currentEntity && entity.getHitBox().intersects(currentEntity)) {
                // System.out.println(entity.getHitBox().isInContact(currentEntity));
                double posX = entity.getPhysicalInformations().getPosition().getX()
                        - entity.getPhysicalInformations().getSpeed().elementAt(0);
                double posY = entity.getPhysicalInformations().getPosition().getY()
                        - entity.getPhysicalInformations().getSpeed().elementAt(1);
                entity.getPhysicalInformations().setPosition(new Point2D.Double(posX, posY));
                entity.getPhysicalInformations().setSpeed(0.0, 0.0);
                break;
            }
        }
        entity.update();
    }
}
