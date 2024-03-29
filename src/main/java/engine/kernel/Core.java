package engine.kernel;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * The engines' core. Manage the refreshment of the engines.
 */
@SuppressWarnings("rawtypes")
public class Core implements Runnable {

    private final ArrayList<Engine> engines = new ArrayList<>();
    private final HashMap<String, Entity> entities = new HashMap<>();
    private volatile boolean isRunning = false;
    private volatile int fps = 30;

    /**
     * Start the engines and the core.
     */
    public void launch() {
        for (Engine engine : engines) engine.start();
        isRunning = true;
        new Thread(this).start();
    }

    /**
     * Add an entity.
     * @param entity the entity to add
     */
    public void addEntity(Entity entity) {
        EngineVisitor visitor = new EngineAdder(entity);
        for (Engine engine : engines) engine.accept(visitor);
        entities.put(entity.getId(), entity);;
    }

    /**
     * Remove an entity.
     * @param id the entity's id to remove
     */
    public void removeEntity(String id) {
        for (Engine engine : engines) engine.remove(id);
        entities.remove(id);
    }

    /**
     * Add a engine
     * @param engine the engine to add
     */
    public void addEngine(Engine engine) {
        engines.add(engine);
    }

    /**
     * Clear the entities and the engines.
     */
    public void clear() {
        entities.clear();
        engines.clear();
    }

    /**
     * Set the number of frame per second.
     * @param fps the number of frame per second
     */
    public void setFps(int fps) {
        this.fps = fps;
    }

    /**
     * Stop the core.
     */
    public synchronized void stop() {
        isRunning = false;
    }

    /**
     * Run the core and update the engines and the entities every 1000 / fps milliseconds.
     */
    @Override
    @SuppressWarnings("BusyWait")
    public void run() {
        while (isRunning) {
            long start = System.nanoTime();
            for (Engine engine : engines) engine.update();
            for (Entity entity: entities.values()) entity.update();
            long time = (1000 / fps) - (System.nanoTime() - start) / 1_000_000;
            try { Thread.sleep(time > 0 ? time : 0); }
            catch (InterruptedException e) { System.exit(1); }
        }
    }
}
