package engine.kernel;

import engine.graphic.GraphicEngine;
import engine.physic.PhysicEngine;

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