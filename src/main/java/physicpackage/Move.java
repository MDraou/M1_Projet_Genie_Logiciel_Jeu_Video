package physicpackage;

import physicpackage.PhysicalEntity;

import java.awt.geom.Point2D;
import java.util.List;

public class Move {
    public static void move(PhysicalEntity entity, List<PhysicalEntity> entities) {
        for (PhysicalEntity currentEntity : entities) {
            if (entity != currentEntity && entity.getHitBox().isInContact(currentEntity)) {
                //System.out.println(entity.getHitBox().isInContact(currentEntity));
                double posX = entity.getTransition().getPosition().getX() - entity.getTransition().getSpeed().elementAt(0);
                double posY = entity.getTransition().getPosition().getY() - entity.getTransition().getSpeed().elementAt(1);
                entity.getTransition().setPosition(new Point2D.Double(posX, posY));
                entity.getTransition().setSpeed(0.0,0.0);
                break;
            }
        }
        entity.update();
    }
}
