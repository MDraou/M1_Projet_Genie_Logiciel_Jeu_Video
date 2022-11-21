package kernel;

import graphic.GraphicEngine;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import physic.PhysicEngine;

import java.text.MessageFormat;

/**
 * The engine manager's builder. Create the engines needed.
 */
public class EngineBuilder {

    private final EngineManager manager;

    /**
     * The engine builder constructor.
     * @param manager -> the engine manager to construct
     */
    public EngineBuilder(EngineManager manager) {
        this.manager = manager;
    }

    /**
     * Clear the engine manager.
     */
    public void reset() {
        manager.clear();
    }

    /**
     * Build a graphic engine and add it to the engine manager.
     * @param name -> the name of the window
     * @param width -> the window's width
     * @param height -> the window's height
     * @param nbLayer -> the window's number of layers
     */
    public void buildGraphicEngine(String name, int width, int height, int nbLayer) {
        manager.addEngine(new GraphicEngine(name, width, height, nbLayer));
    }

    /**
     * Build a physic engine and add it to the engine manager.
     */
    public void buildPhysicEngine() {
        manager.addEngine(new PhysicEngine());
    }
}
