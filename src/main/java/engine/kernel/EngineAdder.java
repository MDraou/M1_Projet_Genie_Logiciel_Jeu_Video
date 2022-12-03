package engine.kernel;

import engine.graphic.GraphicEngine;
import engine.physic.PhysicEngine;

public class EngineAdder implements EngineVisitor {

    private final Entity entity;

    /**
     * Memorize the entity to add.
     * @param entity the entity to add
     */
    public EngineAdder(Entity entity) {
        this.entity = entity;
    }

    /**
     * Visit a graphic engine.
     * @param engine the engine to visit
     */
    @Override
    public void visit(GraphicEngine engine) {
        if (entity.getSprite() != null) engine.add(entity.getId(), entity.getSprite(), entity.getLayer());
    }

    /**
     * Visit a physic engine.
     * @param engine the engine to visit
     */
    @Override
    public void visit(PhysicEngine engine) {
        if (entity.getChecker() != null) engine.add(entity.getId(), entity.getChecker(), entity.getLayer());
    }
}
