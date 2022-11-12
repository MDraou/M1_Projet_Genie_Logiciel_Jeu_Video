package kernel;


import graphic.IGraphicEngine;
import physic.IPhysicEngine;

public class EngineManager {

    private IGraphicEngine graphic = null;
    private IPhysicEngine physic = null;

    protected void addEntity(Entity entity) {
        if (entity.getGraphic() != null) graphic.getWindow().addIdentity(entity.getGraphic());
        if (entity.getPhysic() != null) physic.getCollection().put(entity.getId(), entity.getPhysic());
    }

    protected void removeEntity(String id) {
        graphic.getWindow().removeIdentity(id);
        physic.getCollection().remove(id);
    }

    protected void setGraphic(IGraphicEngine graphic) {
        this.graphic = graphic;
    }

    protected void setPhysic(IPhysicEngine physic) {
        this.physic = physic;
    }

    public void clear() {
        graphic = null;
        physic = null;
    }

    protected void update() {
        graphic.update();
        physic.update();
    }

    protected void start() {
        if (graphic != null) graphic.getWindow().start();
    }
}
