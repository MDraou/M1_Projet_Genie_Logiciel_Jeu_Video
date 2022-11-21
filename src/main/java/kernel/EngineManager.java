package kernel;


import java.util.ArrayList;

/**
 * The engine's manager.
 */
public class EngineManager {

    private final ArrayList<Engine> engines = new ArrayList<>();

    /**
     * Add an entity to the engines.
     * @param entity -> the entity to add
     */
    protected void addEntity(Entity entity) {
        for (Engine engine : engines) engine.addEntity(entity);
    }

    /**
     * Remove from the engine the entity representing by the id.
     * @param id -> the id of the entity to remove
     */
    protected void removeEntity(String id) {
        graphic.getWindow().removeIdentity(id);
        physic.getCollection().remove(id);
    }

    /**
     * Add an engine.
     * @param engine the new engine.
     */
    protected void addEngine(Engine engine) {
        this.engines.add(engine);
    }

    /**
     * Remove the engines.
     */
    public void clear() {
        engines.clear();
    }

    /**
     * Update the engines.
     */
    protected void update() {
        for (Engine engine: engines) engine.update();
    }

    /**
     * Start the engines.
     */
    protected void start() {
        for (Engine engine: engines) engine.start();
    }
}
