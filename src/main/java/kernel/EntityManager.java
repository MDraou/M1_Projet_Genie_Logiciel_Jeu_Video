package kernel;

import java.util.HashMap;

public class EntityManager {

    private final HashMap<String, Entity> entities = new HashMap<>();

    public void add(Entity entity) {
        entities.put(entity.getId(), entity);
    }

    public void remove(String id) {
        entities.remove(id);
    }

    public void update() {
        IVisitor visitor = new EntityVisitor();
        for (Entity entity: entities.values()) entity.accept(visitor);
    }

    public Entity get(String id) {
        return entities.get(id);
    }

    public void clear() {
        entities.clear();
    }
}
