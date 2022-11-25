package graphic;

import kernel.Engine;

/**
 * An engine which update the window.
 */
public class GraphicEngine implements Engine<ISprite> {

    private final Window window;

    /**
     * The graphic engine constructor. Initialize the window with a name, width, height and a number of layers.
     * @param name -> the window's name
     * @param width -> the window's width
     * @param height -> the window's height
     * @param nbLayer -> the window's number of layers
     */
    public GraphicEngine(String name, int width, int height, int nbLayer) {
        window = new Window(name, width, height, nbLayer);
    }

    @Override
    public void add(String id, ISprite sprite, int layer) {
        window.addSprite(id, sprite, layer);
    }

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

    @Override
    public void start() {
        window.start();
    }
}
