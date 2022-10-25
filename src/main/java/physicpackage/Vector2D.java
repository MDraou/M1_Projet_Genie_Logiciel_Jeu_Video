package physicpackage;

public class Vector2D {
    private Point2D position;
    private double speed;

    public Vector2D(double speed) {
        // initialisé à x=0 et y=0, réflechir à ou doit pop le player
        this.position = new Point2D(0, 0);
        this.speed = speed;
    }

    public Point2D getPosition() {
        return position;
    }

    public void setPosition(Point2D point) {
        this.position = point;
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
        position.multiply(speed);
    }

}
