package kernel;

/**
 * An entities' visitor which update them.
 */
public class EntityVisitor implements IVisitor {
    /**
     * Update the entity.
     * @param entity -> the entity to update
     */
    @Override
    public void visit(Entity entity) {
        entity.update();
    }
}
