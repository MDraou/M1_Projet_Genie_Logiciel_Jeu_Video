package kernel;

/**
 * The interface representing the engines.
 */
public interface Engine<T> {

    /**
     * Update the engine.
     */
    void update();
    void start();
    void remove(String id);
    void add(String id, T element, int layer);
}
