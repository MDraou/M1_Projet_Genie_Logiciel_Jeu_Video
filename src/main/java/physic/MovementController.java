package physic;

import kernel.Direction;

import java.util.Objects;

/**
 * An entity's identity which represent the physic of this entity.
 */
public class MovementController implements IMovementController {

    private final String id;
    private final Vector speed = new Vector(0, 0);

    private volatile Integer x, y, width, height, layer;

    /**
     * The physic identity's constructor. Create a Hitbox object with the parameters.
     * @param id -> its entity's id
     */
    public MovementController(String id, int x, int y, int width, int height, int layer) {
        this.id = id; this.x = x; this.y = y; this.width = width; this.height = height; this.layer = layer;
    }

    /**
     * Return its speed represented by a vector.
     * @return its speed
     */
    @Override
    public Vector getSpeed() { return speed; }

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

    @Override
    public boolean intersects(IMovementController controller) {
        return Objects.equals(layer, controller.getLayer())
                && x < controller.getX() + controller.getWidth() && x + width > controller.getX()
                && y < controller.getY() + controller.getHeight() && y + height > controller.getY();
    }

    @Override
    public Integer getX() {
        return this.x;
    }

    @Override
    public Integer getY() {
        return this.y;
    }

    @Override
    public Integer getWidth() {
        return this.width;
    }

    @Override
    public Integer getHeight() {
        return this.height;
    }

    @Override
    public Integer getLayer() {
        return this.layer;
    }

    @Override
    public void setCoordinates(int x, int y) {
        this.x = x;
    }

    @Override
    public void resize(int width, int height) {
        this.width = width; this.height = height;
    }
}
