package graphic;

import java.io.IOException;

/**
 * An entity's graphic identity which represent the visual of this entity.
 */
public class GraphicIdentity implements IGraphicIdentity {

    private final String id;
    private final Sprite sprite;
    private int layer;

    /**
     * The graphic identity's constructor. Create a Sprite object with the parameters.
     * Throws an IOException if the image it's not found.
     * @param id -> its entity's id
     * @param spritePath -> its image's path
     * @param x -> the x coordinate
     * @param y -> the y coordinate
     * @param width -> its width
     * @param height -> its height
     * @param layer -> its layer's number
     * @throws IOException when its can't load image
     */
    public GraphicIdentity(String id, String spritePath, int x, int y, int width, int height, int layer) throws IOException {
        this.id = id; this.layer = layer; this.sprite = new Sprite(spritePath, x, y, width, height);
    }

    /**
     * Return its layer's number.
     * @return its layer's number
     */
    @Override
    public int getLayer() {
        return layer;
    }

    /**
     * Return its sprite.
     * @return its sprite
     */
    @Override
    public Sprite getSprite() {
        return sprite;
    }

    /**
     * Returns its entity's id.
     * @return its entity's id
     */
    @Override
    public String getId() {
        return id;
    }
}
