package engine.kernel;

import engine.graphic.GraphicEngine;
import engine.physic.PhysicEngine;

public class EngineVisitor implements Visitor {

    private final Entity entity;

    /**
     * Memorize the entity to add.
     * @param entity the entity to add
     */
    public EngineVisitor(Entity entity) {
        this.entity = entity;
    }

    /**
     * Visit a graphic engine.
     * @param engine the engine to visit
     */
    @Override
    public void visit(GraphicEngine engine) {
        engine.add(entity.getId(), entity.getSprite(), entity.getLayer());
    }

    /**
     * Visit a physic engine.
     * @param engine the engine to visit
     */
    @Override
    public void visit(PhysicEngine engine) {
        engine.add(entity.getId(), entity.getMovementController(), entity.getLayer());
    }
}
