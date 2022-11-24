package graphic;

import javax.swing.*;
import java.util.ArrayList;

/**
 * A JFrame object representing a graphic window
 */
public class Window extends JFrame {

    /**
     * The ArrayList of the Layer.
     */
    private final ArrayList<Layer> layers = new ArrayList<>();

    /**
     * The Window constructor. Initialize the window with a name, width, height and a number of layers.
     * @param name -> the window's name
     * @param width -> the window's width
     * @param height -> the window's height
     * @param nbLayer -> the window's number of layers
     */
    public Window(String name, int width, int height, int nbLayer) {
        setTitle(name);
        setSize(width, height);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        for (int i = 0; i < nbLayer; i++) {
            Layer layer = new Layer();
            layers.add(layer);
            super.add(layer);
        }
    }

    /**
     * Make the window visible.
     */
    public void start() {
        setVisible(true);
    }

    /**
     * Add a graphic identity to the window.
     * @param sprite a sprite to show on the window
     */
    public void addIdentity(String id, Sprite sprite, int layer) {
        layers.get(layer).put(id, sprite);
    }

    /**
     * remove a graphic identity from the window.
     * @param id -> the graphic identity's id to remove from the window
     */
    public void removeIdentity(String id) {
        for (Layer layer : layers) if (layer.contain(id)) { layer.remove(id); return ; }
    }

    /**
     * Return a graphic identity from the window if it's contain or null if not.
     * @param id -> the graphic identity's id
     * @return the graphic identity represented by the id
     */
    public ISprite getIdentity(String id) {
        ISprite sprite = null;
        for (Layer layer : layers) if (layer.contain(id)) { sprite = layer.get(id); break;}
        return sprite;
    }

    /**
     * Update the window.
     */
    public void update() {
        for (Layer layer : layers) layer.repaint();
        validate();
    }
}
