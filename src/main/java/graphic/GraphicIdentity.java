package graphic;

import java.io.IOException;

public class GraphicIdentity implements IGraphicIdentity {

    private final String id;
    private final Sprite sprite;
    private int layer;

    public GraphicIdentity(String id, String spritePath, int x, int y, int width, int height, int layer) throws IOException {
        this.id = id; this.layer = layer; this.sprite = new Sprite(spritePath, x, y, width, height);
    }

    @Override
    public int getLayer() {
        return layer;
    }

    @Override
    public Sprite getSprite() {
        return sprite;
    }

    @Override
    public String getId() {
        return id;
    }
}
