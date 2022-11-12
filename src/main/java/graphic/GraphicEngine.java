package graphic;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GraphicEngine implements IGraphicEngine {

    private final Window window;
    private static final Logger logger = LogManager.getLogger(GraphicEngine.class);

    public GraphicEngine(String name, int width, int height, int nbLayer) {
        window = new Window(name, width, height, nbLayer);
    }

    @Override
    public Window getWindow() {
        return window;
    }

    public void update() {
        window.update();
    }
}
