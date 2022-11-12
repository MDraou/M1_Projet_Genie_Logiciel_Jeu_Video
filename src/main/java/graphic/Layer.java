package graphic;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class Layer extends JPanel {

    private final HashMap<String, IGraphicIdentity> identities = new HashMap<>();

    public Layer() {
        this.setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics graphic) {
        super.paintComponent(graphic);
        for (IGraphicIdentity identity : identities.values()) {
            Sprite sprite = identity.getSprite();
            graphic.drawImage(sprite.getImage(), sprite.getX(), sprite.getY(), sprite.getWidth(), sprite.getHeight(), null);
        }
    }

    public void put(String id, IGraphicIdentity entity) {
        identities.put(id, entity);
    }

    public void remove(String id) {
        identities.remove(id);
    }

    public IGraphicIdentity get(String id) {
        return identities.get(id);
    }

    public boolean contain(String id) {
        return identities.containsKey(id);
    }
}
