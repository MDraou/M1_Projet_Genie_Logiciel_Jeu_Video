package engine.kernel;
/**
 * The strategy to resize an entity.
 */
public class ResizeStrategy implements IStrategy {

    private final int width, height;

    /**
     * The strategy's constructor.
     * @param width the new width
     * @param height the new height
     */
    public ResizeStrategy(int width, int height) {
        this.width = width; this.height = height;
    }

    /**
     * Execute the strategy.
     * @param entity the entity which the strategy is executed on.
     */
    @Override
    public void execute(Entity entity) {
        entity.getGraphic().resize(width, height);
        entity.getPhysic().resize(width, height);
    }
}
