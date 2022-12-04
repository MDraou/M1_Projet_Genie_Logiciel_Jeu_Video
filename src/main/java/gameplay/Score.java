package gameplay;

import engine.kernel.Entity;

public class Score extends Entity {

    private static final String[] numberPaths = {"zero", "one", "two", "three", "four", "five", "six", "seven"};

    private int score = 0;

    /**
     * The entity's constructor.
     *
     * @param id the id of the entity
     * @param x
     * @param y
     */
    public Score(String id, int x, int y) {
        super(id, x, y, 0);
    }

    public void increment() {
        score += 1;
    }

    public int getScore() {
        return score;
    }


    public String getImagePath() {
        return numberPaths[score]   + ".png";
    }
}
