package physicpackage;

import physicpackage.PhysicalEntity;

import java.util.List;

public class Move {
    public static void move(PhysicalEntity entity, List<PhysicalEntity> entities) {
        for (PhysicalEntity currentEntity : entities) {
            if (entity != currentEntity && entity.getHitBox().isInContact(currentEntity)) {
                //System.out.println(entity.getHitBox().isInContact(currentEntity));
                entity.getTransition().setSpeed(0.0,0.0);
                break;
            }
        }
        entity.update();
    }
}
