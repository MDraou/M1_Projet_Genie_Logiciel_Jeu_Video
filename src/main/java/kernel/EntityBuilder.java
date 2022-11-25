package kernel;

import graphic.GraphicIdentity;
import physic.PhysicIdentity;

import java.io.IOException;

/**
 * The entities' builder. Create the identities needed.
 */
public class EntityBuilder {

    private Entity entity;

    /**
     * Remove all the entity's identities.
     */
    public void reset() {
        entity.clear();
    }

    /**
     * Set the entity to build.
     * @param entity -> the entity to build
     */
    public void setEntity(Entity entity) {
        this.entity = entity;
    }

    /**
     * Create a graphic identity and add it to the entity.
     * @param spritePath -> the image's path
     * @param x -> the x coordinate
     * @param y -> the x coordinate
     * @param width -> the image's width
     * @param height -> the image's height
     * @param layer -> the identity layer
     */
    public void buildGraphicIdentity(String spritePath, int x, int y, int width, int height, int layer) {
        if (entity == null) return ;
        try { entity.setSprite(new GraphicIdentity(entity.getId(), spritePath, x, y, width, height, layer)); }
        catch (IOException ignored) {}
    }

    /**
     * Create a physic identity and add it to the entity.
     * @param x -> the x coordinate
     * @param y -> the x coordinate
     * @param width -> the hitbox's width
     * @param height -> the hitbox's height
     * @param layer -> the identity layer
     */
    public void buildPhysicIdentity(int x, int y, int width, int height, int layer) {
        if (entity == null) return ;
        entity.setController(new PhysicIdentity(entity.getId(), x, y, width, height, layer));
    }
}
