package physic;

/**
 * The engine managing the physic.
 */
public class PhysicEngine implements IPhysicEngine {

    private final PhysicCollection collection = new PhysicCollection();

    /**
     * Return the physic identities' collection.
     * @return the physic identities' collection
     */
    @Override
    public PhysicCollection getCollection() {
        return collection;
    }

    /**
     * Update the engine.
     */
    @Override
    public void update() {
        collection.update();
    }
}
