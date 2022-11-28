package gameplay;

import engine.kernel.Entity;

public class Ball extends Entity {
    /**
     * The entity's constructor.
     *
     * @param id    the id of the entity
     * @param x
     * @param y
     * @param layer
     */
    public Ball(String id, int x, int y, int layer) {
        super(id, x, y, layer);
    }

}
