package graphic;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Sprite {

    private volatile BufferedImage image;
    private volatile int x, y, width, height;

    public Sprite(String spritePath, int x, int y, int width, int height) throws IOException {
        this.x = x; this.y = y; this.width = width; this.height = height;
        this.image = ImageIO.read(Objects.requireNonNull(GraphicIdentity.class.getResource(spritePath)));
    }

    public void resize(int width, int height) {
        this.width = width; this.height = height;
    }

    public void moveTo(int x, int y) {
        this.x = x; this.y = y;
    }

    public void changeImage(String spritePath) throws IOException {
        this.image = ImageIO.read(Objects.requireNonNull(GraphicIdentity.class.getResource(spritePath)));
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public BufferedImage getImage() {
        return image;
    }
}
