package gameplay;

import engine.kernel.Entity;

public class Wall extends Entity {
    /**
     * The entity's constructor.
     *
     * @param id    the id of the entity
     * @param x
     * @param y
     */
    public Wall(String id, int x, int y) {
        super(id, x, y, 0);
    }
}
