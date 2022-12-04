package engine.graphic;

import engine.kernel.Point;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;


class TestWindow {

    @Test
    void addSpriteAndGetSprite() throws IOException {
        Window window = new Window("test",100,100,5);
        Sprite sprite = new Sprite( "",new Point(0,0),new Dimension(10,10));
        window.addSprite("id",sprite,0);
        assertEquals(sprite,window.getSprite("id"));
    }

    @Test
    void removeIdentity() throws IOException {
        Window window = new Window("test",100,100,5);
        Sprite sprite = new Sprite( "",new Point(0,0),new Dimension(10,10));
        window.addSprite("id",sprite,0);
        assertEquals(sprite,window.getSprite("id"));
        window.removeSprite("id");
        assertNotEquals(sprite,window.getSprite("id"));
    }

}