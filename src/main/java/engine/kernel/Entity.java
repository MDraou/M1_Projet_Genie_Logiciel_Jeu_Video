package engine.kernel;

import engine.graphic.ISprite;
import engine.physic.IMovementsChecker;

/**
 * The entity containing the identities needed.
 */
public class Entity {

    private final String id;
    private ISprite sprite = null;
    private IMovementsChecker checker = null;
    private final Point coords;
    private int layer;

    /**
     * The entity's constructor.
     * @param id the id of the entity
     */
    public Entity(String id, int x, int y, int layer) {
        this.id = id; coords = new Point(x, y); this.layer = layer;
    }

    /**
     * Return the sprite identity.
     * @return the sprite identity
     */
     protected ISprite getSprite() {
        return sprite;
    }

    /**
     * Return the controller identity.
     * @return the controller identity
     */
    protected IMovementsChecker getChecker() {
        return checker;
    }

    /**
     * Set a sprite identity to the entity.
     * @param sprite the new sprite identity
     */
    protected void setSprite(ISprite sprite) {
        this.sprite = sprite;
    }

    /**
     * Set a controller identity to the entity.
     * @param checker the new controller identity
     */
    protected void setChecker(IMovementsChecker checker) {
        this.checker = checker;
    }

    /**
     * Remove all the entity.
     */
    public void clear() {
        sprite = null;
        checker = null;
    }

    /**
     * Update the engines between them.
     */
    protected void update() {
        if (checker == null) return ;
        Point nextCoords = checker.getNextCoordinates();
        this.setCoordinates(nextCoords.getX(), nextCoords.getY());
    }


    /**
     * Return the id of this entity.
     * @return the id of this entity
     */
    public String getId() {
        return id;
    }

    /**
     * Return the coordinates of this entity.
     * @return the coordinates of this entity
     */
    public Point getCoordinates() {
        return this.coords;
    }

    /**
     * Change the coordinates of the entity.
     * @param x the new x coordinates
     * @param y the new y coordinates
     */
    public void setCoordinates(int x, int y) {
        this.coords.setLocation(x, y);
    }

    /**
     * Return the layer of the entity
     * @return the layer of the entity
     */
    public int getLayer() {
        return this.layer;
    }

    /**
     * Execute the strategy put in argument on the entity represented by the id.
     * @param strategy the strategy to execute
     */
    public void process(IStrategy strategy) {
        strategy.execute(this);
    }
}
