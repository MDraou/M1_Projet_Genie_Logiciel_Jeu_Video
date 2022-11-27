package kernel;

/**
 * Interface representing the strategies to execute request.
 */
public interface IStrategy {

    /**
     * Execute the strategy on an entity.
     * @param entity the entity which the strategy is executed on.
     */
    void execute(Entity entity);
}
