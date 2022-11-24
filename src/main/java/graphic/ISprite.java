package graphic;

import java.awt.image.BufferedImage;
import java.io.IOException;

public interface ISprite {
    BufferedImage getImage();
    void changeImage(String imagePath) throws IOException;
    void resize(int width, int height);
    Integer getHeight();
    Integer getWidth();
    Integer getX();
    Integer getY();
    void setCoordinates(int x, int y);
}
