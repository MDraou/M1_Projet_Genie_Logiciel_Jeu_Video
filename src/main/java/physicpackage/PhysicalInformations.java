package physicpackage;

import java.awt.geom.Point2D;
import java.util.Vector;

public class PhysicalInformations {
    private Point2D position;
    private Vector<Double> speed;

    public PhysicalInformations(Point2D position, double x, double y) {
        // initialisé à x=0 et y=0, réflechir à ou doit pop le player
        this.position = position;
        this.speed = new Vector<>();
        speed.add(x);
        speed.add(y);
    }

    public PhysicalInformations(Point2D position) {
        this.position = position;
        speed = new Vector<>();
        speed.add(0.0);
        speed.add(0.0);
    }

    public Point2D getPosition() {
        return position;
    }

    public void setPosition(Point2D point) {
        this.position = point;
    }

    public Vector<Double> getSpeed() {
        return this.speed;
    }

    public void setSpeed(double x, double y) {
        speed.set(0, x);
        speed.set(1, y);

    }

    // on doit créer un controller qui permet de définir que si l'on appuie sur une
    // touche alors un mouvement apparait
    public void update(/* Controller controller */) {
        /*
         * if (controller.isUp())
         * position.subtract(new Point2D(0, 1));
         * if (controller.isDown())
         * position.add(new Point2D(0, 1));
         * if (controller.isLeft())
         * position.subtract(new Point2D(1, 0));
         * if (controller.isRight())
         * position.add(new Point2D(1, 0));
         */
        position = new Point2D.Double(position.getX() + speed.elementAt(0), position.getY() + speed.elementAt(1));
    }

}
