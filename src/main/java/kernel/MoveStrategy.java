package kernel;

/**
 * The strategy to move an entity to a direction.
 */
public class MoveStrategy implements IStrategy {

    private final double vx, vy;

    public MoveStrategy(double vx, double vy) {
        this.vx = vx; this.vy = vy;
    }

    /**
     * Execute the strategy.
     * @param entity -> the entity which the strategy is executed on.
     */
    @Override
    public void execute(Entity entity) {
        entity.getPhysic().setSpeed(vx, vy);
    }
}
