package graphic;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class AnimatedGraphicEntity implements GraphicEntity {
    private int frameCount;                 // Counts ticks for change
    private int frameDelay;                 // frame delay 1-12 (You will have to play around with this)
    private int currentFrame;               // animations current frame
    private int animationDirection;         // animation direction (i.e. counting forward or backward)
    private final int totalFrames;                // total amount of frames for your animation

    private boolean stopped;                // has animations stopped

    private final List<Frame> frames = new ArrayList<>();    // Arraylist of frames

    public AnimatedGraphicEntity(BufferedImage[] frames, int frameDelay) {
        this.stopped = true;
        for (BufferedImage frame : frames) addFrame(frame, frameDelay);
        this.frameCount = 0;
        this.frameDelay = frameDelay;
        this.currentFrame = 0;
        this.animationDirection = 1;
        this.totalFrames = this.frames.size();

    }

    @Override
    public double getWidth() {
        return 0;
    }

    @Override
    public double getHeight() {
        return 0;
    }

    public void start() {
        if (!stopped || frames.size() == 0) return;
        stopped = false;
    }

    public void stop() {
        if (frames.size() == 0) return;
        stopped = true;
    }

    public void restart() {
        if (frames.size() == 0) return;
        stopped = false;
        currentFrame = 0;
    }

    public void reset() {
        this.stopped = true;
        this.frameCount = 0;
        this.currentFrame = 0;
    }

    public void addFrame(BufferedImage frame, int duration) {
        if (duration <= 0) {
            System.err.println("Invalid duration: " + duration);
            throw new RuntimeException("Invalid duration: " + duration);
        }
        frames.add(new Frame(frame, duration));
        currentFrame = 0;
    }

    public BufferedImage getSprite() {
        return frames.get(currentFrame).getFrame();
    }

    public void update() {
        if (!stopped) {
            if (++frameCount > frameDelay) {
                frameCount = 0;
                currentFrame += (currentFrame + animationDirection) % totalFrames;
            }
        }
    }
}
