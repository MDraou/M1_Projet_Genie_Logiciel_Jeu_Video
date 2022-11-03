package graphic;

import java.awt.image.BufferedImage;

public class Frame {

    private final BufferedImage frame;
    private int duration;

    public Frame(BufferedImage frame, int duration) {
        this.frame = frame;
        this.duration = duration;
    }

    public Frame(BufferedImage frame) {
        this.frame = frame;
    }

    public BufferedImage getFrame() {
        return frame;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
