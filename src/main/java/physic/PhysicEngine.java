package physic;

public class PhysicEngine implements IPhysicEngine {

    private final PhysicCollection collection = new PhysicCollection();

    @Override
    public PhysicCollection getCollection() {
        return collection;
    }

    @Override
    public void update() {
        collection.update();
    }
}
