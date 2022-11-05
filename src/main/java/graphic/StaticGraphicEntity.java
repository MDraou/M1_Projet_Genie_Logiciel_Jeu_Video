package graphic;

import java.awt.*;
import java.awt.geom.Dimension2D;
import java.awt.image.BufferedImage;

public class StaticGraphicEntity implements GraphicEntity {

    private final Frame frame;
    private double width, height;

    public StaticGraphicEntity(BufferedImage frame, Dimension2D dimension2D) {
        this.frame = new Frame(frame);
        this.width = dimension2D.getWidth();
        this.height = dimension2D.getHeight();
    }

    public double getWidth() { return width; }
    public double getHeight() { return height; }
    @Override
    public void start() {}

    @Override
    public void stop() {}

    @Override
    public void restart() {}

    @Override
    public void reset() {}

    @Override
    public void update() {}

    @Override
    public BufferedImage getSprite() {
        return frame.getFrame();
    }

}
