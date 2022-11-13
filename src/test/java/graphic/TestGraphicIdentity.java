package graphic;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class TestGraphicIdentity {

    @Test
    void getLayer() throws IOException {
        GraphicIdentity identity = new GraphicIdentity("id", "image.png",0,0,10,10,0);
        assertEquals(0, identity.getLayer());
    }

    @Test
    void getSprite() throws IOException {
        GraphicIdentity identity = new GraphicIdentity("id", "image.png",0,0,10,10,0);
        Sprite sprite = new Sprite("image.png",0,0,10,10);
        assertEquals(sprite.getHeight(), identity.getSprite().getHeight());
        assertEquals(sprite.getWidth(), identity.getSprite().getWidth());
        assertEquals(sprite.getX(), identity.getSprite().getX());
        assertEquals(sprite.getY(), identity.getSprite().getY());
        assertEquals(sprite.getImage().getData().getNumDataElements(), identity.getSprite().getImage().getData().getNumDataElements());
        assertEquals(sprite.getImage().getData().getHeight(), identity.getSprite().getImage().getData().getHeight());
        assertEquals(sprite.getImage().getData().getWidth(), identity.getSprite().getImage().getData().getWidth());
    }

    @Test
    void getId() throws IOException {
        GraphicIdentity identity = new GraphicIdentity("id", "image.png",0,0,10,10,0);
        assertEquals("id", identity.getId());
    }
}