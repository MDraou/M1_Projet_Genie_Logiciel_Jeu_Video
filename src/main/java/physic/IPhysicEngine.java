package physic;

import kernel.Engine;

/**
 * The interface representing the physic engines.
 */
public interface IPhysicEngine extends Engine {

    /**
     * Return the physic identities' collection.
     * @return the physic identities' collection
     */
    PhysicCollection getCollection();
}
