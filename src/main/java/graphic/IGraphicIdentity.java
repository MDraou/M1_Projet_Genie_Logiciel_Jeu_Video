package graphic;

import kernel.Identity;

public interface IGraphicIdentity extends Identity {
    Sprite getSprite();
    int getLayer();
}
