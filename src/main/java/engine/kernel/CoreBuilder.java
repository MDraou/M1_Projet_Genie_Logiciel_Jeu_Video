package engine.kernel;

import engine.graphic.GraphicEngine;
import engine.physic.PhysicEngine;

/**
 * The engine manager's builder. Create the engines needed.
 */
public class CoreBuilder {

    private final Core core;

    /**
     * The engine builder constructor.
     * @param core the core to construct
     */
    public CoreBuilder(Core core) {
        this.core = core;
    }

    /**
     * Clear the engine manager.
     */
    public void reset() {
        core.clear();
    }

    /**
     * Build a graphic engine and add it to the engine manager.
     * @param name -> the name of the window
     * @param width -> the window's width
     * @param height -> the window's height
     * @param nbLayer -> the window's number of layers
     */
    public void buildGraphicEngine(String name, int width, int height, int nbLayer) {
        core.addEngine(new GraphicEngine(name, width, height, nbLayer));
    }

    /**
     * Build a physic engine and add it to the engine manager.
     */
    public void buildPhysicEngine() {
        core.addEngine(new PhysicEngine());
    }
}
