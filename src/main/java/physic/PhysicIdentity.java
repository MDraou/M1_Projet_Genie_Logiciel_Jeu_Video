package physic;

import kernel.Directions;

public class PhysicIdentity implements IPhysicIdentity {

    private final String id;
    private final IHitbox hitbox;
    private final Vector speed = new Vector(0, 0);

    public PhysicIdentity(String id, int x, int y, int width, int height, int layer) {
        this.id = id; this.hitbox = new RectangularHitbox(x, y, width, height, layer);
    }

    @Override
    public Vector getSpeed() { return speed; }

    @Override
    public IHitbox getHitbox() {
        return hitbox;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setSpeed(int speed, Directions direction) {
        switch (direction) {
            case UP -> this.speed.set(this.speed.getX(), -speed);
            case DOWN -> this.speed.set(this.speed.getX(), speed);
            case LEFT -> this.speed.set(-speed, this.speed.getY());
            case RIGHT -> this.speed.set(speed, this.speed.getY());
            case STAY -> stop();
        }
    }

    public void stop() {
        this.speed.set(0, 0);
    }
}
