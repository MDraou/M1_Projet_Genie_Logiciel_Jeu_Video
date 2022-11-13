package physic;

/**
 * Interface representing a hitbox.
 */
public interface IHitbox {

    /**
     * Resize the hitbox.
     * @param width -> the new width
     * @param height -> the new height
     */
    void resize(int width, int height);

    /**
     * Move the hitbox to the desired location.
     * @param x -> the new x coordinate
     * @param y -> the new y coordinate
     */
    void moveTo(int x, int y);

    /**
     * Change the hitbox's layer.
     * @param layer -> the new layer
     */
    void setLayer(int layer);

    /**
     * Return the x coordinate.
     * @return the x coordinate
     */
    int getX();

    /**
     * Return the y coordinate.
     * @return the y coordinate
     */
    int getY();

    /**
     * Return the hitbox's width.
     * @return the width
     */
    int getWidth();

    /**
     * Return the hitbox's height.
     * @return the height
     */
    int getHeight();

    /**
     * Return the hitbox's layer.
     * @return the layer
     */
    int getLayer();

    /**
     * Check if the hitbox intersect the a foreign hitbox in argument.
     * @param hitBox -> the foreign hitbox to check with
     * @return true if the hitbox intersect the foreign hitbox in argument. Return false otherwise
     */
    boolean intersects(IHitbox hitBox);
}
