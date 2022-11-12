package kernel;

public class MoveStrategy implements IStrategy {

    private final Directions direction;
    private final int speed;

    public MoveStrategy(Directions direction, int speed) {
        this.direction = direction;
        this.speed = speed;
    }

    @Override
    public void execute(Entity entity) {
        entity.getPhysic().setSpeed(speed, direction);
    }
}
