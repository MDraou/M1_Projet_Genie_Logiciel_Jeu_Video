package engine.kernel;

/**
 * The strategy to move an entity to a direction.
 */
public class MoveStrategy implements IStrategy {

    private final double vx, vy;

    /**
     * Constructor of a move strategy.
     * @param vx the speed on the x
     * @param vy the speed on the y
     */
    public MoveStrategy(double vx, double vy) {
        this.vx = vx; this.vy = vy;
    }

    /**
     * Execute the strategy.
     * @param entity the entity which the strategy is executed on.
     */
    @Override
    public void execute(Entity entity) {
        entity.getChecker().setSpeed(vx, vy);
    }
}
