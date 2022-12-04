package engine.kernel;

public class AccelerateStrategy implements IStrategy {
    private final double dx, dy;

    public AccelerateStrategy(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    @Override
    public void execute(Entity entity) {
        double vx = entity.getChecker().getSpeed().getX();
        double vy = entity.getChecker().getSpeed().getY();
        entity.getChecker().getSpeed().set(vx + ((vx > 0) ? dx : -dx), vy + ((vy > 0) ? dy : -dy));
    }
}
