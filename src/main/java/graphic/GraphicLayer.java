package graphic;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

/**
 * A JPanel object representing a layer of a window.
 */
public class GraphicLayer extends JPanel {

    /**
     * A HashMap of the graphic sprites.
     */
    private final HashMap<String, ISprite> sprites = new HashMap<>();

    /**
     * The layer's constructor. Make the layer background opaque
     */
    public GraphicLayer() {
        this.setOpaque(false);
    }

    /**
     * Paint the sprites on the layer.
     * @param graphic the <code>Graphics</code> object to protect
     */
    @Override
    protected void paintComponent(Graphics graphic) {
        super.paintComponent(graphic);
        for (ISprite sprite : sprites.values()) {
            graphic.drawImage(sprite.getImage(), sprite.getX(), sprite.getY(), sprite.getWidth(), sprite.getHeight(), null);
        }
    }

    /**
     * Put a sprite in the layer.
     * @param id the
     * @param sprite the sprite to put
     */
    public void put(String id, ISprite sprite) {
        sprites.put(id, sprite);
    }

    /**
     * Remove a sprite representing by the id from the layer.
     * @param id the graphic identity's id
     */
    public void remove(String id) {
        sprites.remove(id);
    }

    /**
     * Return a sprite representing by the id from the layer.
     * @param id the graphic identity's id
     * @return the graphic identity wanted
     */
    public ISprite get(String id) {
        return sprites.get(id);
    }

    /**
     * Return true if the sprite representing by the id is in the layer. Return false otherwise.
     * @param id the graphic identity's id
     * @return the graphic identity wanted
     */
    public boolean contain(String id) {
        return sprites.containsKey(id);
    }
}
