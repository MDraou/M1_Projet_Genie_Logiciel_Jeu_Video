package gameplay;

import engine.kernel.Entity;

public class Paddle extends Entity {
    /**
     * The entity's constructor.
     *
     * @param id the id of the entity
     * @param x the x coordinates
     * @param y the y coordinates
     */
    public Paddle(String id, int x, int y) {
        super(id, x, y, 0);
    }
}
