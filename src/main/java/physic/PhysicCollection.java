package physic;

import java.util.HashMap;

/**
 * A collection of physic controllers.
 */
public class PhysicCollection {

    private final HashMap<String, IMovementController> controllers = new HashMap<>();

    /**
     * Put an entity in the collection.
     * @param entity -> the entity to put
     */
    public void put(IMovementController entity) {
        controllers.put(entity.getId(), entity);
    }

    /**
     * Remove the entity represented by the id from the collection.
     * @param id -> the entity's id to remove
     */
    public void remove(String id) {
        controllers.remove(id);
    }

    /**
     * Return the entity represented by the id from the collection.
     * @param id -> the entity's id to return
     * @return the entity wanted
     */
    public IMovementController get(String id) {
        return controllers.get(id);
    }

    /**
     * Check if the entity represented by the id is contains in the collection.
     * @param id -> the entity's id to check
     * @return true if the entity is contains in the collection. Return false if not
     */
    public boolean contain(String id) {
        return controllers.containsKey(id);
    }

    /**
     * Check if the hitboxes intersect another hitbox and update their speed vector.
     */
    public void update() {
        for (IMovementController controller : controllers.values()) {
            Vector speed = controller.getSpeed();
            if (speed.getX() == 0 && speed.getY() == 0) continue;
            for (IMovementController foreignController : controllers.values()) {
                if (controller != foreignController && controller.intersects(foreignController)) {
                   controller.moveTo(hitbox.getX() - speed.getX(), hitbox.getY() - speed.getY());
                    controller.stop();
                    break;
                }
                hitbox.moveTo(hitbox.getX() + speed.getX(), hitbox.getY() + speed.getY());
            }
        }
    }
}
