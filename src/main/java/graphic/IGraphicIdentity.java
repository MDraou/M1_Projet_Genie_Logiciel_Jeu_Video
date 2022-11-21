package graphic;

import kernel.IIdentity;

/**
 * The interface representing the graphic identities.
 */
public interface IGraphicIdentity {

    /**
     * Return its sprite.
     * @return its sprite
     */
    Sprite getSprite();
    /**
     * Return its layer's number.
     * @return its layer's number
     */
    int getLayer();

    String getId();
}
