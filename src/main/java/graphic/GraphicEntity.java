package graphic;

import java.awt.image.BufferedImage;

public interface GraphicEntity {

    double getWidth();
    double getHeight();
    void start();
    void stop();
    void restart();
    void reset();
    void update();
    BufferedImage getSprite();
}
