package kernel;

/**
 * The interface representing the entities.
 */
public interface IEntity {

    /**
     * Return the id of this entity.
     * @return the id of this entity
     */
    String getId();

    /**
     * CLear the entity.
     */
    void clear();
}
