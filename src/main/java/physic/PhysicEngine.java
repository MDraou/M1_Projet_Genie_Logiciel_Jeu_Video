package physic;

import kernel.Engine;
import kernel.Entity;

/**
 * The engine managing the physic.
 */
public class PhysicEngine implements Engine {

    private final PhysicCollection collection = new PhysicCollection();

    /**
     * Update the engine.
     */
    @Override
    public void update() {
        collection.update();
    }

    @Override
    public void start() {}

    @Override
    public void remove(String id) {
        collection.remove(id);
    }

    @Override
    public void addEntity(Entity entity) {
        collection.put(entity.getPhysic());
    }
}
