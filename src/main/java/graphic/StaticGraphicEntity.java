package graphic;

import java.awt.image.BufferedImage;

public class StaticGraphicEntity implements GraphicEntity {

    private final Frame frame;

    public StaticGraphicEntity(BufferedImage frame) {
        this.frame = new Frame(frame);
    }

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
