package engine.kernel;

import engine.graphic.GraphicEngine;
import engine.physic.PhysicEngine;

public class AddEntityVisitor implements Visitor {

    private final Entity entity;

    /**
     * Memorize the entity to add.
     * @param entity the entity to add
     */
    public AddEntityVisitor(Entity entity) {
        this.entity = entity;
    }

    /**
     * Visit a graphic engine.
     * @param engine the engine to visit
     */
    @Override
    public void visit(GraphicEngine engine) {
        engine.add(entity.getId(), entity.getGraphic(), entity.getLayer());
    }

    /**
     * Visit a physic engine.
     * @param engine the engine to visit
     */
    @Override
    public void visit(PhysicEngine engine) {
        engine.add(entity.getId(), entity.getPhysic(), entity.getLayer());
    }
}
