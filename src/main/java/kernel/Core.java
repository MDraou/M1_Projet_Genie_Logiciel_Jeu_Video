package kernel;

public class Core implements Runnable {

    private final EngineManager engineManager;
    private final EntityManager entityManager;
    private volatile boolean isRunning = false;
    private volatile int fps = 30;

    public Core(EngineManager engineManager, EntityManager entityManager) {
        this.entityManager = entityManager;
        this.engineManager = engineManager;
    }

    public void launch() {
        engineManager.start();
        isRunning = true;
        new Thread(this).start();
    }

    public void process(IStrategy strategy, String id) {
        strategy.execute(entityManager.get(id));
    }

    public void addEntity(Entity entity) {
        entityManager.add(entity);
        engineManager.addEntity(entity);
    }

    public void removeEntity(String id) {
        entityManager.remove(id);
        engineManager.removeEntity(id);
    }

    public void clear() {
        entityManager.clear();
        engineManager.clear();
    }

    public void setFps(int fps) {
        this.fps = fps;
    }

    public synchronized void stop() {
        isRunning = false;
    }

    public synchronized void start() {
        new Thread(this).start();
    }

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
