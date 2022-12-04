package gameplay;

import engine.kernel.Entity;

public class Score implements Element {

    private static final String[] numberPaths = {"zero", "one", "two", "three", "four", "five", "six", "seven"};

    private Entity entity;
    private int width, height, score = 0;

    /**
     * The entity's constructor.
     *
     * @param id the id of the entity
     * @param x the x coordinate
     * @param y the y coordinate
     */
    public Score(String id, int x, int y, int width, int height) {
        this.width = width; this.height = height;
        entity = new Entity(id, x, y, 0);
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

    @Override
    public Entity getEntity() {
        return entity;
    }

    @Override
    public void accept(IElementVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public int getX() {
        return entity.getCoordinates().getX();
    }

    @Override
    public int getY() {
        return entity.getCoordinates().getY();
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }
}
