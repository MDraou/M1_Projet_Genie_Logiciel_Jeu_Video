package graphic;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class TestGraphicLayer {

    @Test
    void putAndGet() throws IOException {
        GraphicLayer layer = new GraphicLayer();
        GraphicIdentity identity = new GraphicIdentity("id", "",0,0,10,10,0);
        layer.put(identity);
        assertEquals(identity, layer.get("id"));
    }

    @Test
    void remove() throws IOException {
        GraphicLayer layer = new GraphicLayer();
        GraphicIdentity identity = new GraphicIdentity("id", "",0,0,10,10,0);
        layer.put(identity);
        assertEquals(identity, layer.get("id"));
        layer.remove("id");
        assertNotEquals(identity, layer.get("id"));
    }

    @Test
    void contain() throws IOException {
        GraphicLayer layer = new GraphicLayer();
        GraphicIdentity identity = new GraphicIdentity("id", "",0,0,10,10,0);
        layer.put(identity);
        assertTrue(layer.contain("id"));
    }
}