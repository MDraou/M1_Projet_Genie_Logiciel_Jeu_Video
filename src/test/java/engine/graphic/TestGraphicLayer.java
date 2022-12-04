package engine.graphic;

import engine.kernel.Point;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class TestGraphicLayer {

    @Test
    void putAndGet() throws IOException {
        GraphicLayer layer = new GraphicLayer();
        Sprite sprite = new Sprite( "",new Point(0,0),new Dimension(10,10));
        layer.put("id", sprite);
        assertEquals(sprite, layer.get("id"));
    }

    @Test
    void remove() throws IOException {
        GraphicLayer layer = new GraphicLayer();
        Sprite sprite = new Sprite( "",new Point(0,0),new Dimension(10,10));
        layer.put("id", sprite);
        assertEquals(sprite, layer.get("id"));
        layer.remove("id");
        assertNotEquals(sprite, layer.get("id"));
    }

    @Test
    void contain() throws IOException {
        GraphicLayer layer = new GraphicLayer();
        Sprite sprite = new Sprite( "",new Point(0,0),new Dimension(10,10));
        layer.put("id", sprite);
        assertTrue(layer.contain("id"));
    }
}