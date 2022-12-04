package gameplay;

import engine.kernel.Entity;

public class Paddle implements Element {
    private Entity entity;
    private int width, height;
    private final String imagePath = "red_square.png";

    /**
     * The entity's constructor.
     *
     * @param id the id of the entity
     * @param x the x coordinates
     * @param y the y coordinates
     */
    public Paddle(String id, int x, int y, int width, int height) {
        this.width = width; this.height = height;
        this.entity = new Entity(id, x, y, 0);
    }

    public Entity getEntity() {
        return entity;
    }

    @Override
    public void accept(ElementVisitor visitor) {
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

    @Override
    public String getImagePath() {
        return imagePath;
    }
}
