package physic;

/**
 * A rectangular hitbox.
 */
public class RectangularHitbox implements IHitbox {

    private volatile int x, y, width, height, layer;

    /**
     * The hitbox's constructor.
     * @param x -> the x coordinate
     * @param y -> the y coordinate
     * @param width -> its width
     * @param height -> its height
     * @param layer -> its layer
     */
    public RectangularHitbox(int x, int y, int width, int height, int layer) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.layer = layer;
    }

    /**
     * Resize the hitbox.
     * @param width -> the new width
     * @param height -> the new height
     */
    @Override
    public void resize(int width, int height) {
        this.width = width; this.height = height;
    }

    /**
     * Move the hitbox to the desired location.
     * @param x -> the new x coordinate
     * @param y -> the new y coordinate
     */
    @Override
    public void moveTo(int x, int y) {
        this.x = x; this.y = y;
    }

    /**
     * Return the x coordinate.
     * @return the x coordinate
     */
    @Override
    public int getX() {
        return x;
    }

    /**
     * Return the y coordinate.
     * @return the y coordinate
     */
    @Override
    public int getY() {
        return y;
    }

    /**
     * Return the hitbox's width.
     * @return the width
     */
    @Override
    public int getWidth() {
        return width;
    }

    /**
     * Return the hitbox's height.
     * @return the height
     */
    @Override
    public int getHeight() {
        return height;
    }

    /**
     * Change the hitbox's layer.
     * @param layer -> the new layer
     */
    @Override
    public void setLayer(int layer) {
        this.layer = layer;
    }

    /**
     * Return the hitbox's layer.
     * @return the layer
     */
    @Override
    public int getLayer() {
        return layer;
    }

    /**
     * Detect if the hitbox  intersect the hitbox in argument.
     * @return true if the hitbox intersect the hitbox in argument. Return false otherwise
     */
    @Override
    public boolean intersects(IHitbox hitBox) {
        return layer == hitBox.getLayer()
            && x < hitBox.getX() + hitBox.getWidth() && x + width > hitBox.getX()
            && y < hitBox.getY() + hitBox.getHeight() && y + height > hitBox.getY();
    }
}
