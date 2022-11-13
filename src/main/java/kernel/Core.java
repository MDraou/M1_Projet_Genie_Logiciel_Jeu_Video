package kernel;

/**
 * The engines' core. Manage the refreshment of the engines.
 */
public class Core implements Runnable {

    private final EngineManager engineManager;
    private final EntityManager entityManager;
    private volatile boolean isRunning = false;
    private volatile int fps = 30;

    /**
     * The core's constructor.
     * @param engineManager -> the manager of the engines
     * @param entityManager -> the manager of the entities
     */
    public Core(EngineManager engineManager, EntityManager entityManager) {
        this.entityManager = entityManager;
        this.engineManager = engineManager;
    }

    /**
     * Start the engines and the core.
     */
    public void launch() {
        engineManager.start();
        isRunning = true;
        new Thread(this).start();
    }

    /**
     * Execute the strategy put in argument on the entity represented by the id.
     * @param strategy -> the strategy to execute
     * @param id -> the entity's id
     */
    public void process(IStrategy strategy, String id) {
        strategy.execute(entityManager.get(id));
    }

    /**
     * Add an entity.
     * @param entity -> the entity to add
     */
    public void addEntity(Entity entity) {
        entityManager.add(entity);
        engineManager.addEntity(entity);
    }

    /**
     * Remove an entity.
     * @param id -> the entity's id to remove
     */
    public void removeEntity(String id) {
        entityManager.remove(id);
        engineManager.removeEntity(id);
    }

    /**
     * Clear the entity manager and the engine manager.
     */
    public void clear() {
        entityManager.clear();
        engineManager.clear();
    }

    /**
     * Set the number of frame per second.
     * @param fps -> the number of frame per second
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
     * Start the core.
     */
    public synchronized void start() {
        new Thread(this).start();
    }

    /**
     * Run the core and update the engines and the entities every 1000 / fps milliseconds.
     */
    @Override
    @SuppressWarnings("BusyWait")
    public void run() {
        while (isRunning) {
            engineManager.update();
            entityManager.update();
            try { Thread.sleep(1000 / fps); }
            catch (InterruptedException e) { throw new RuntimeException(e); }
        }
    }
}
