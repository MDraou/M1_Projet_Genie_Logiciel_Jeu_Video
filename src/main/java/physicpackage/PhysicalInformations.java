package physicpackage;

import java.awt.geom.Point2D;

public class PhysicalInformations {
    private Point2D position;
    private Vector speed;

    public PhysicalInformations(Point2D position, double x, double y) {
        // initialisé à x=0 et y=0, réflechir à ou doit pop le player
        this.position = position;
        this.speed = new Vector(x, y);
    }

    public PhysicalInformations(Point2D position) {
        this.position = position;
        speed = new Vector(0, 0);
    }

    public Point2D getPosition() {
        return position;
    }

    public void setPosition(Point2D point) {
        this.position = point;
    }

    public Vector getSpeed() {
        return this.speed;
    }

    public void setSpeed(double x, double y) {
        speed.set(0, x);
        speed.set(1, y);

    }

    public void update() {
        position = new Point2D.Double(position.getX() + speed.getX(), position.getY() + speed.getY());
    }

}
