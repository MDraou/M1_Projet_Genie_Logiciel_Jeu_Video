package kernel;

import java.util.HashMap;

/**
 * The entities' manager.
 */
public class EntityManager {

    private final HashMap<String, Entity> entities = new HashMap<>();

    /**
     * Add an entity to the manager.
     * @param entity -> the entity to add
     */
    public void add(Entity entity) {
        entities.put(entity.getId(), entity);
    }

    /**
     * Remove the entity representing by the id.
     * @param id -> the id of the entity to remove
     */
    public void remove(String id) {
        entities.remove(id);
    }

    /**
     * Update the entities with a visitor.
     */
    public void update() {
        IVisitor visitor = new EntityVisitor();
        for (Entity entity: entities.values()) entity.accept(visitor);
    }

    /**
     * Return the identity represented by the id.
     * @param id -> the id of the entity wanted
     * @return an entity
     */
    public Entity get(String id) {
        return entities.get(id);
    }

    /**
     * Remove all the entity.
     */
    public void clear() {
        entities.clear();
    }
}
