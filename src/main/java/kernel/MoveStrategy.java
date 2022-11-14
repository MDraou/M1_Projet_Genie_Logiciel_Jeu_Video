package kernel;

/**
 * The strategy to move an entity to a direction.
 */
public class MoveStrategy implements IStrategy {

    private final Direction direction;
    private final int speed;

    /**
     * The strategy's constructor.
     * @param direction -> the movement's direction
     * @param speed -> the movement's speed
     */
    public MoveStrategy(Direction direction, int speed) {
        this.direction = direction;
        this.speed = speed;
    }

    /**
     * Execute the strategy.
     * @param entity -> the entity which the strategy is executed on.
     */
    @Override
    public void execute(Entity entity) {
        entity.getPhysic().setSpeed(speed, direction);
    }
}
