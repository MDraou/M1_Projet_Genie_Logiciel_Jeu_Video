package engine.kernel;

import engine.graphic.GraphicEngine;
import engine.physic.PhysicEngine;

public class AddEntityVisitor implements Visitor {

    private final Entity entity;

    public AddEntityVisitor(Entity entity) {
        this.entity = entity;
    }


    @Override
    public void visit(GraphicEngine engine) {
        engine.add(entity.getId(), entity.getGraphic(), entity.getLayer());
    }

    @Override
    public void visit(PhysicEngine engine) {
        engine.add(entity.getId(), entity.getPhysic(), entity.getLayer());
    }
}
