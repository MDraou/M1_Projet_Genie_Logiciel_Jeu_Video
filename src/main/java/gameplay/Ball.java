package gameplay;

import engine.kernel.Entity;

import java.util.Random;

public class Ball extends Entity {

    Random random = new Random();
    private double vx = random.nextBoolean() ? 5.0 : -5.0, vy = random.nextBoolean() ? 4. : -4.;

    public Ball(int x, int y) {
        super("ball", x, y, 0);
    }

    public double getXSpeed() {
        return vx;
    }

    public double getYSpeed() {
        return vy;
    }


}
