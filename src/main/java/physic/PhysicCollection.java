package physic;

import java.util.HashMap;

public class PhysicCollection {

    private final HashMap<String, IPhysicIdentity> identities = new HashMap<>();

    public void put(String id, IPhysicIdentity entity) {
        identities.put(id, entity);
    }

    public void remove(String id) {
        identities.remove(id);
    }

    public IPhysicIdentity get(String id) {
        return identities.get(id);
    }

    public boolean contain(String id) {
        return identities.containsKey(id);
    }

    public void update() {
        for (IPhysicIdentity currentEntity : identities.values()) {
            Vector speed = currentEntity.getSpeed();
            if (speed.getX() == 0 && speed.getY() == 0) continue;
            IHitbox hitbox = currentEntity.getHitbox();
            for (IPhysicIdentity checkedEntity : identities.values()) {
                if (currentEntity != checkedEntity && hitbox.intersects(checkedEntity.getHitbox())) {
                   hitbox.moveTo(hitbox.getX() - speed.getX(), hitbox.getY() - speed.getY());
                    currentEntity.stop();
                    break;
                }
                hitbox.moveTo(hitbox.getX() + speed.getX(), hitbox.getY() + speed.getY());
            }
        }
    }


}
