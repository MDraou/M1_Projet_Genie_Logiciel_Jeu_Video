package kernel;

import graphic.IGraphicIdentity;
import physic.IMovementController;

/**
 * The entity containing the identities needed.
 */
public class Entity {

    private final String id;
    private IGraphicIdentity graphic = null;
    private IMovementController physic = null;
    private int x, y, layer;

    /**
     * The entity's constructor.
     * @param id -> the id of the entity
     */
    public Entity(String id, int x, int y, int layer) {
        this.id = id; this.x = x; this.y = y; this.layer = layer;
    }

    /**
     * Return the graphic identity.
     * @return the graphic identity
     */
    // IGraphicIdentity getGraphic() {
    //    return graphic;
    //}

    /**
     * Return the physic identity.
     * @return the physic identity
     */
    //public IMovementController getPhysic() {
    //    return physic;
    //}

    /**
     * Set a graphic identity to the entity.
     * @param graphic -> the new graphic identity
     */
    protected void setGraphic(IGraphicIdentity graphic) {
        this.graphic = graphic;
    }

    /**
     * Set a physic identity to the entity.
     * @param physic -> the new physic identity
     */
    protected void setPhysic(IMovementController physic) {
        this.physic = physic;
    }

    /**
     * Remove all the entity.
     */
    public void clear() {
        graphic = null;
        physic = null;
    }

    /**
     * Update the engines between them.
     */
    protected void update() {
        if (graphic != null) graphic.getSprite().moveTo(physic.getHitbox().getX(), physic.getHitbox().getY());
    }

    /**
     * Accept a visitor.
     * @param visitor -> the visitor to accept
     */
    protected void accept(IVisitor visitor) {
        visitor.visit(this);
    }

    /**
     * Return the id of this entity.
     * @return the id of this entity
     */
    public String getId() {
        return id;
    }

    public int getX() { return this.x; }

    public int getY() { return this.y; }

    public void setCoordinates(int x, int y) {
        this.x = x; this.y = y;
    }
}
