package kernel;


import graphic.IGraphicEngine;
import physic.IPhysicEngine;

/**
 * The engine's manager.
 */
public class EngineManager {

    private IGraphicEngine graphic = null;
    private IPhysicEngine physic = null;

    /**
     * Add an entity to the engines.
     * @param entity -> the entity to add
     */
    protected void addEntity(Entity entity) {
        if (entity.getGraphic() != null) graphic.getWindow().addIdentity(entity.getGraphic());
        if (entity.getPhysic() != null) physic.getCollection().put(entity.getPhysic());
    }

    /**
     * Remove from the engine the entity representing by the id.
     * @param id -> the id of the entity to remove
     */
    protected void removeEntity(String id) {
        graphic.getWindow().removeIdentity(id);
        physic.getCollection().remove(id);
    }

    /**
     * Set the graphic engine.
     * @param graphic -> the new graphic engine.
     */
    protected void setGraphic(IGraphicEngine graphic) {
        this.graphic = graphic;
    }

    /**
     * Set the physic engine.
     * @param physic -> the new physic engine.
     */
    protected void setPhysic(IPhysicEngine physic) {
        this.physic = physic;
    }

    /**
     * Remove the engines.
     */
    public void clear() {
        graphic = null;
        physic = null;
    }

    /**
     * Update the engines.
     */
    protected void update() {
        if (graphic != null) graphic.update();
        if (physic != null) physic.update();
    }

    /**
     * Start the engines.
     */
    protected void start() {
        if (graphic != null) graphic.getWindow().start();
    }
}
