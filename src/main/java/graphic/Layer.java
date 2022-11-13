package graphic;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

/**
 * A JPanel object representing a layer of a window.
 */
public class Layer extends JPanel {

    /**
     * A HashMap of the graphic identities.
     */
    private final HashMap<String, IGraphicIdentity> identities = new HashMap<>();

    /**
     * The layer's constructor. Make the layer background opaque
     */
    public Layer() {
        this.setOpaque(false);
    }

    /**
     * Paint the sprites on the layer.
     * @param graphic the <code>Graphics</code> object to protect
     */
    @Override
    protected void paintComponent(Graphics graphic) {
        super.paintComponent(graphic);
        for (IGraphicIdentity identity : identities.values()) {
            Sprite sprite = identity.getSprite();
            graphic.drawImage(sprite.getImage(), sprite.getX(), sprite.getY(), sprite.getWidth(), sprite.getHeight(), null);
        }
    }

    /**
     * Put a graphic identity in the layer.
     * @param identity -> the graphic identity to put
     */
    public void put(IGraphicIdentity identity) {
        identities.put(identity.getId(), identity);
    }

    /**
     * Remove a graphic identity representing by the id from the layer.
     * @param id -> the graphic identity's id
     */
    public void remove(String id) {
        identities.remove(id);
    }

    /**
     * Return a graphic identity representing by the id from the layer.
     * @param id -> the graphic identity's id
     * @return the graphic identity wanted
     */
    public IGraphicIdentity get(String id) {
        return identities.get(id);
    }

    /**
     * Return true if the graphic identity representing by the id is in the layer. Return false otherwise.
     * @param id -> the graphic identity's id
     * @return the graphic identity wanted
     */
    public boolean contain(String id) {
        return identities.containsKey(id);
    }
}
