package kernel;

import graphic.IGraphicIdentity;
import physic.IPhysicIdentity;

public class Entity implements IEntity {

    private final String id;
    private IGraphicIdentity graphic = null;
    private IPhysicIdentity physic = null;

    public Entity(String id) {
        this.id = id;
    }

    protected IGraphicIdentity getGraphic() {
        return graphic;
    }

    protected IPhysicIdentity getPhysic() {
        return physic;
    }

    protected void setGraphic(IGraphicIdentity graphic) {
        this.graphic = graphic;
    }

    protected void setPhysic(IPhysicIdentity physic) {
        this.physic = physic;
    }

    @Override
    public void clear() {
        graphic = null;
        physic = null;
    }

    protected void update() {
        graphic.getSprite().moveTo(physic.getHitbox().getX(), physic.getHitbox().getY());
    }

    protected void accept(IVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String getId() {
        return id;
    }
}
