package physic;

import java.util.HashMap;

/**
 * A collection of physic identities.
 */
public class PhysicCollection {

    private final HashMap<String, IPhysicIdentity> identities = new HashMap<>();

    /**
     * Put an entity in the collection.
     * @param entity -> the entity to put
     */
    public void put(IPhysicIdentity entity) {
        identities.put(entity.getId(), entity);
    }

    /**
     * Remove the entity represented by the id from the collection.
     * @param id -> the entity's id to remove
     */
    public void remove(String id) {
        identities.remove(id);
    }

    /**
     * Return the entity represented by the id from the collection.
     * @param id -> the entity's id to return
     * @return the entity wanted
     */
    public IPhysicIdentity get(String id) {
        return identities.get(id);
    }

    /**
     * Check if the entity represented by the id is contains in the collection.
     * @param id -> the entity's id to check
     * @return true if the entity is contains in the collection. Return false if not
     */
    public boolean contain(String id) {
        return identities.containsKey(id);
    }

    /**
     * Check if the hitboxes intersect another hitbox and update their speed vector.
     */
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
