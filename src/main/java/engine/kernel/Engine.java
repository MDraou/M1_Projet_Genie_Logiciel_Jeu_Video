package engine.kernel;

/**
 * The interface representing the engines.
 */
public interface Engine<T> {

    /**
     * Update the engine.
     */
    void update();

    /**
     * Start the engine
     */
    void start();

    /**
     * Remove the element of the entity from the engine.
     * @param id the entity's id to remove
     */
    void remove(String id);

    /**
     * Add a element of a entity with a id and a layer
     * @param id the entity's id
     * @param element the entity's element
     * @param layer the entity's layer
     */
    void add(String id, T element, int layer);

    /**
     * Accept a visitor
     * @param visitor visitor that visit the engine
     */
    void accept(EngineVisitor visitor);
}
