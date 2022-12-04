package gameplay;

import engine.kernel.Entity;
import engine.kernel.MoveStrategy;

import java.util.Random;

public class Ball extends Entity {

    Random random = new Random();
    private double vx = random.nextBoolean() ? 5.0 : -5.0, vy = random.nextBoolean() ? 4. : -4.;

    public Ball(int x, int y) {
        super("ball", x, y, 0);
    }

    @Override
    public int getX() {
        return entity.getCoordinates().getX();
    }

    @Override
    public int getY() {
        return entity.getCoordinates().getY();
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public Entity getEntity() {
        return entity;
    }

    public double getXSpeed() {
        return vx;
    }

    public double getYSpeed() {
        return vy;
    }

    @Override
    public void accept(ElementVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String getImagePath() {
        return imagePath;
    }
}
