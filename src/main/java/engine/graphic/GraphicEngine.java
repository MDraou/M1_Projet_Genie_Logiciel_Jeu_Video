package engine.graphic;

import engine.kernel.EngineVisitor;
import engine.kernel.Engine;

import java.awt.event.KeyListener;

/**
 * An engine which update the window.
 */
public class GraphicEngine implements Engine<ISprite> {

    private final Window window;

    /**
     * The graphic engine constructor. Initialize the window with a name, width, height and a number of layers.
     * @param name the window's name
     * @param width the window's width
     * @param height the window's height
     * @param nbLayer the window's number of layers
     * @param listener the window's listener
     */
    public GraphicEngine(String name, int width, int height, int nbLayer, KeyListener listener) {
        window = new Window(name, width, height, nbLayer);
        window.addKeyListener(listener);
    }

    /**
     * The graphic engine constructor. Initialize the window with a name, width, height and a number of layers.
     * @param name the window's name
     * @param width the window's width
     * @param height the window's height
     * @param nbLayer the window's number of layers
     */
    public GraphicEngine(String name, int width, int height, int nbLayer) {
        window = new Window(name, width, height, nbLayer);
    }

    /**
     * Add a sprite of a entity in the window with a id and a layer
     * @param id the id of the entity a posses the sprite
     * @param sprite the sprite of a entity
     * @param layer the layer of a entity
     */
    @Override
    public void add(String id, ISprite sprite, int layer) {
        window.addSprite(id, sprite, layer);
    }

    /**
     * Remove the spite of entity from the window
     * @param id the id of the entity
     */
    @Override
    public void remove(String id) {
        window.removeSprite(id);
    }

    /**
     * Update the window.
     */
    @Override
    public void update() {
        window.update();
    }

    /**
     * Start the window.
     */
    @Override
    public void start() {
        window.start();
    }

    /**
     * Accept a visitor
     * @param visitor the visitor to visit
     */
    @Override
    public void accept(EngineVisitor visitor) {
        visitor.visit(this);
    }


}
