package kernel;

import graphic.GraphicEngine;
import physic.PhysicEngine;

/**
 * The interface representing the visitors.
 */
public interface Visitor {

    /**
     * Visit an engine.
     * @param engine -> the engine to visit
     */
    void visit(GraphicEngine engine);
    /**
     * Visit an engine.
     * @param engine -> the engine to visit
     */
    void visit(PhysicEngine engine);
}
