package kernel;

/**
 * The interface representing the visitors.
 */
public interface IVisitor {

    /**
     * Visit an entity.
     * @param entity -> the entity to visit
     */
    void visit(Entity entity);
}
