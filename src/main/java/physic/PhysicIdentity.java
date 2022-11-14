package physic;

import kernel.Direction;

/**
 * An entity's identity which represent the physic of this entity.
 */
public class PhysicIdentity implements IPhysicIdentity {

    private final String id;
    private final IHitbox hitbox;
    private final Vector speed = new Vector(0, 0);

    /**
     * The physic identity's constructor. Create a Hitbox object with the parameters.
     * @param id -> its entity's id
     * @param x -> the x coordinate
     * @param y -> the y coordinate
     * @param width -> its width
     * @param height -> its height
     * @param layer -> its layer's number
     */
    public PhysicIdentity(String id, int x, int y, int width, int height, int layer) {
        this.id = id; this.hitbox = new RectangularHitbox(x, y, width, height, layer);
    }

    /**
     * Return its speed represented by a vector.
     * @return its speed
     */
    @Override
    public Vector getSpeed() { return speed; }

    /**
     * Return its hitbox.
     * @return its hitbox
     */
    @Override
    public IHitbox getHitbox() {
        return hitbox;
    }

    /**
     * Returns its entity's id.
     * @return its entity's id
     */
    @Override
    public String getId() {
        return id;
    }

    /**
     * Set the speed represented by a vector.
     * @param speed -> the vector's norm
     * @param direction -> the vector's direction
     */
    @Override
    public void setSpeed(int speed, Direction direction) {
        switch (direction) {
            case UP -> this.speed.set(this.speed.getX(), -speed);
            case DOWN -> this.speed.set(this.speed.getX(), speed);
            case LEFT -> this.speed.set(-speed, this.speed.getY());
            case RIGHT -> this.speed.set(speed, this.speed.getY());
            case STAY -> stop();
        }
    }

    /**
     * Stop the identity's movement.
     */
    public void stop() {
        this.speed.set(0, 0);
    }
}
