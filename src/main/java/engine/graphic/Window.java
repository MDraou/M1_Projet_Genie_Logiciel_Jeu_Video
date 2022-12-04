package engine.graphic;

import javax.swing.*;
import java.util.ArrayList;

/**
 * A JFrame object representing a graphic window
 */
public class Window extends JFrame {

    /**
     * The ArrayList of the Layer.
     */
    private final ArrayList<GraphicLayer> layers = new ArrayList<>();

    /**
     * The Window constructor. Initialize the window with a name, width, height and a number of layers.
     * @param name the window's name
     * @param width the window's width
     * @param height the window's height
     * @param nbLayer the window's number of layers
     */
    public Window(String name, int width, int height, int nbLayer) {
        setTitle(name);
        setSize(width, height);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        for (int i = 0; i < nbLayer; i++) {
            GraphicLayer layer = new GraphicLayer();
            layers.add(layer);
            super.add(layer);
        }
    }

    /**
     * Make the window visible.
     */
    public void start() {
        setResizable(false);
        setVisible(true);
    }

    /**
     * Add a sprite to a layer.
     * @param id the id of the entity associate with the sprite
     * @param sprite a sprite to show on the window
     * @param layer the layer of the sprite
     */
    public void addSprite(String id, ISprite sprite, int layer) {
        layers.get(layer).put(id, sprite);
    }

    /**
     * remove a graphic identity from the window.
     * @param id the sprite's id to remove from the window
     */
    public void removeSprite(String id) {
        for (GraphicLayer layer : layers) if (layer.contain(id)) { layer.remove(id); return ; }
    }

    /**
     * Return a sprite from a layer if it's contain or null if not.
     * @param id the graphic identity's id
     * @return the sprite represented by the id
     */
    public ISprite getSprite(String id) {
        ISprite sprite = null;
        for (GraphicLayer layer : layers) if (layer.contain(id)) { sprite = layer.get(id); break;}
        return sprite;
    }

    /**
     * Update the window.
     */
    public void update() {
        for (GraphicLayer layer : layers) layer.repaint();
        validate();
    }
}
