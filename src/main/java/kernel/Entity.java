package kernel;

import graphic.IGraphicIdentity;
import physic.IPhysicIdentity;

/**
 * The entity containing the identities needed.
 */
public class Entity implements IEntity {

    private final String id;
    private IGraphicIdentity graphic = null;
    private IPhysicIdentity physic = null;

    /**
     * The entity's constructor.
     * @param id -> the id of the entity
     */
    public Entity(String id) {
        this.id = id;
    }

    /**
     * Return the graphic identity.
     * @return the graphic identity
     */
    protected IGraphicIdentity getGraphic() {
        return graphic;
    }

    /**
     * Return the physic identity.
     * @return the physic identity
     */
    protected IPhysicIdentity getPhysic() {
        return physic;
    }

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
    protected void setPhysic(IPhysicIdentity physic) {
        this.physic = physic;
    }

    /**
     * Remove all the entity.
     */
    @Override
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
    @Override
    public String getId() {
        return id;
    }
}
