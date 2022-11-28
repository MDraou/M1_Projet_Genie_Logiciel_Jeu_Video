package gameplay;

import engine.kernel.Entity;

public class Paddle extends Entity {
    /**
     * The entity's constructor.
     *
     * @param id    the id of the entity
     * @param x
     * @param y
     * @param layer
     */
    public Paddle(String id, int x, int y, int layer) {
        super(id, x, y, layer);
    }
}
