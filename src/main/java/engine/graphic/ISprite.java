package engine.graphic;

import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Sprites' interface
 */
public interface ISprite {

    /**
     * Return a BufferedImage representing the image.
     * @return a BufferedImage representing the image
     */
    BufferedImage getImage();

    /**
     * Change the sprite's image. Throws an IOException if the image it's not found.
     * @param imagePath the new image's path
     */
    void changeImage(String imagePath);

    /**
     * Resize the image.
     * @param width its new width
     * @param height its new height
     */
    void resize(int width, int height);

    /**
     * Return the height
     * @return the height
     */
    int getHeight();

    /**
     * Return the width
     * @return the width
     */
    int getWidth();

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
     * Move the image to another location.
     * @param x the new x coordinate
     * @param y the new y coordinate
     */
    void setCoordinates(int x, int y);
}
