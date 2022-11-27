package kernel;

import graphic.Sprite;
import physic.MovementsController;

import java.awt.*;
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
     * @param entity the entity to build
     */
    public void setEntity(Entity entity) {
        this.entity = entity;
    }

    /**
     * Create a sprite and add it to the entity.
     * @param spritePath the image's path
     * @param width the image's width
     * @param height the image's height
     */
    public void buildSprite(String spritePath, int width, int height) {
        if (entity == null) return ;
        try { entity.setSprite(new Sprite(spritePath, entity.getCoordinates(), new Dimension(width, height))); }
        catch (IOException ignored) {}
    }

    /**
     * Create a movement controller and add it to the entity.
     * @param width the hitbox's width
     * @param height the hitbox's height
     */
    public void buildMovementController(int width, int height) {
        if (entity == null) return ;
        entity.setController(new MovementsController(entity.getId(), entity.getCoordinates(), new Dimension(width, height)));
    }
}
