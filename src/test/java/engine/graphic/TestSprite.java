package engine.graphic;

import engine.kernel.Point;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class TestSprite {

    @Test
    void resize() throws IOException {
        Sprite sprite = new Sprite("",new Point(0,0),new Dimension(10,10));
        assertEquals(10, sprite.getWidth());
        assertEquals(10, sprite.getHeight());
        sprite.resize(100,3);
        assertEquals(100, sprite.getWidth());
        assertEquals(3, sprite.getHeight());
    }

    @Test
    void changeImage() throws IOException {
        Sprite sprite = new Sprite("",new Point(0,0),new Dimension(10,10));
        sprite.changeImage("image.png");
        BufferedImage bufferedImage = ImageIO.read(Objects.requireNonNull(Sprite.class.getResource("image.png")));
        assertEquals(bufferedImage.getData().getWidth(),sprite.getImage().getData().getWidth());
        assertEquals(bufferedImage.getData().getHeight(),sprite.getImage().getData().getHeight());
        assertEquals(bufferedImage.getData().getNumDataElements(),sprite.getImage().getData().getNumDataElements());
    }

    @Test
    void getX() throws IOException {
        Sprite sprite = new Sprite("",new Point(0,0),new Dimension(10,10));
        assertEquals(0, sprite.getX());
    }

    @Test
    void getY() throws IOException {
        Sprite sprite = new Sprite("",new Point(0,30),new Dimension(10,10));
        assertEquals(30, sprite.getY());
    }

    @Test
    void getWidth() throws IOException {
        Sprite sprite = new Sprite("",new Point(0,0),new Dimension(10,10));
        assertEquals(10, sprite.getWidth());
    }

    @Test
    void getHeight() throws IOException {
        Sprite sprite = new Sprite("",new Point(0,0),new Dimension(10,10));
        assertEquals(10, sprite.getHeight());
    }

    @Test
    void getImage() throws IOException {
        Sprite sprite = new Sprite("image.png",new Point(0,0),new Dimension(10,10));
        BufferedImage bufferedImage = ImageIO.read(Objects.requireNonNull(Sprite.class.getResource("image.png")));
        assertEquals(bufferedImage.getData().getWidth(),sprite.getImage().getData().getWidth());
        assertEquals(bufferedImage.getData().getHeight(),sprite.getImage().getData().getHeight());
        assertEquals(bufferedImage.getData().getNumDataElements(),sprite.getImage().getData().getNumDataElements());
    }
}