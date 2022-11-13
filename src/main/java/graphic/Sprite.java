package graphic;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

/**
 * A sprite which represent an image with coordinates and size.
 */
public class Sprite {
    private volatile BufferedImage image;
    private volatile int x, y, width, height;

    /**
     * The sprite's constructor. Throws an IOException if the image it's not found.
     * @param spritePath -> its image's path
     * @param x -> the x coordinate
     * @param y -> the y coordinate
     * @param width -> its width
     * @param height -> its height
     * @throws IOException when its can't load image
     */
    public Sprite(String spritePath, int x, int y, int width, int height) throws IOException {
        this.x = x; this.y = y; this.width = width; this.height = height;
        this.image = ImageIO.read(Objects.requireNonNull(GraphicIdentity.class.getResource(spritePath)));
    }

    /**
     * Resize the image.
     * @param width -> its new width
     * @param height -> its new height
     */
    public void resize(int width, int height) {
        this.width = width; this.height = height;
    }

    /**
     * Move the image to another location.
     * @param x -> the new x coordinate
     * @param y -> the new y coordinate
     */
    public void moveTo(int x, int y) {
        this.x = x; this.y = y;
    }

    /**
     * Change the sprite's image. Throws an IOException if the image it's not found.
     * @param spritePath -> the new image's path
     * @throws IOException when its can't load image
     */
    public void changeImage(String spritePath) throws IOException {
        this.image = ImageIO.read(Objects.requireNonNull(GraphicIdentity.class.getResource(spritePath)));
    }

    /**
     * Return the x coordinate.
     * @return the x coordinate
     */
    public int getX() {
        return x;
    }

    /**
     * Return the y coordinate.
     * @return the y coordinate
     */
    public int getY() {
        return y;
    }

    /**
     * Return the width
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * Return the height
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * Return a BufferedImage representing the image.
     * @return a BufferedImage representing the image
     */
    public BufferedImage getImage() {
        return image;
    }
}
