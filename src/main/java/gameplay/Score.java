package gameplay;

import engine.kernel.Entity;

public class Score extends Entity {

    private int score = 0;

    /**
     * The entity's constructor.
     *
     * @param id the id of the entity
     * @param x
     * @param y
     * @param layer
     */
    public Score(String id, int x, int y, int layer) {
        super(id, x, y, layer);
    }

    public void increment() {
        score += 1;
    }
}
