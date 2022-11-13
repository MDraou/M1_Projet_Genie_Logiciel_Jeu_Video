package graphic;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * An engine which update the window.
 */
public class GraphicEngine implements IGraphicEngine {

    private final Window window;
    private static final Logger logger = LogManager.getLogger(GraphicEngine.class);

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

    /**
     * Return the graphic engine window.
     * @return the window
     */
    @Override
    public Window getWindow() {
        return window;
    }

    /**
     * Update the window.
     */
    @Override
    public void update() {
        window.update();
    }
}
