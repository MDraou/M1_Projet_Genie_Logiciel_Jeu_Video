package kernel;

import graphic.ISprite;
import physic.IMovementsController;

import java.awt.geom.Point2D;

/**
 * The entity containing the identities needed.
 */
public class Entity {

    private final String id;
    private ISprite sprite = null;
    private IMovementsController controller = null;
    private int x, y, layer;

    /**
     * The entity's constructor.
     * @param id -> the id of the entity
     */
    public Entity(String id, int x, int y, int layer) {
        this.id = id; this.x = x; this.y = y; this.layer = layer;
    }

    /**
     * Return the sprite identity.
     * @return the sprite identity
     */
    // IGraphicIdentity getGraphic() {
    //    return sprite;
    //}

    /**
     * Return the controller identity.
     * @return the controller identity
     */
    //public IMovementController getPhysic() {
    //    return controller;
    //}

    /**
     * Set a sprite identity to the entity.
     * @param sprite -> the new sprite identity
     */
    protected void setSprite(ISprite sprite) {
        this.sprite = sprite;
    }

    /**
     * Set a controller identity to the entity.
     * @param controller -> the new controller identity
     */
    protected void setController(IMovementsController controller) {
        this.controller = controller;
    }

    /**
     * Remove all the entity.
     */
    public void clear() {
        sprite = null;
        controller = null;
    }

    /**
     * Update the engines between them.
     */
    protected void update() {}

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
