package engine.graphic;

import engine.kernel.Point;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

/**
 * A sprite which represent an image with coordinates and size.
 */
public class Sprite implements ISprite {
    private volatile BufferedImage image;
    private final Point coords;
    private final Dimension dimension;

    /**
     * The sprite's constructor. Throws an IOException if the image it's not found.
     * @param spritePath its image's path
     * @param coords the coordinate of the sprite
     * @param dimension the size of the sprite
     * @throws IOException when its can't load image
     */
    public Sprite(String spritePath, Point coords, Dimension dimension) throws IOException {
        this.coords = coords; this.dimension = dimension;
        this.image = ImageIO.read(Objects.requireNonNull(Sprite.class.getResource(spritePath)));
    }

    /**
     * Resize the image.
     * @param width its new width
     * @param height its new height
     */
    @Override
    public void resize(int width, int height) {
        this.dimension.setSize(width, height);
    }

    /**
     * Move the image to another location.
     * @param x the new x coordinate
     * @param y the new y coordinate
     */
    @Override
    public void setCoordinates(int x, int y) {
        this.coords.setLocation(x, y);
    }

    /**
     * Change the sprite's image. Throws an IOException if the image it's not found.
     * @param spritePath the new image's path
     */
    @Override
    public void changeImage(String spritePath) {
        try { this.image = ImageIO.read(Objects.requireNonNull(Sprite.class.getResource(spritePath))); }
        catch (IOException e) { throw new RuntimeException(e); }
    }

    /**
     * Return the x coordinate.
     * @return the x coordinate
     */
    @Override
    public int getX() {
        return this.coords.getX();
    }

    /**
     * Return the y coordinate.
     * @return the y coordinate
     */
    @Override
    public int getY() {
        return this.coords.getY();
    }

    /**
     * Return the width
     * @return the width
     */
    @Override
    public int getWidth() {
        return this.dimension.width;
    }

    /**
     * Return the height
     * @return the height
     */
    @Override
    public int getHeight() {
        return this.dimension.height;
    }

    /**
     * Return a BufferedImage representing the image.
     * @return a BufferedImage representing the image
     */
    @Override
    public BufferedImage getImage() {
        return image;
    }
}
