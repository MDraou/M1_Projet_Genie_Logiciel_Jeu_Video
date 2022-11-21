package kernel;

/**
 * The interface representing the engines.
 */
public interface Engine {

    /**
     * Update the engine.
     */
    void update();
    void start();
    void remove(String id);
    void addEntity(Entity entity);
}
