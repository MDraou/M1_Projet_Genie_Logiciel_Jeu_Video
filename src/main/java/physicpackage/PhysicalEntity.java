package physicpackage;

import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;

public class PhysicalEntity {
    private int id;
    private Transition transition;
    private HitBox hitBox;

    public PhysicalEntity(Transition transition, int id, Dimension2D dimension) {
        this.transition = transition;
        Point2D bottomRightPoint = new Point2D.Double();
        bottomRightPoint.setLocation(transition.getPosition().getX() + dimension.getWidth(), transition.getPosition().getY() + dimension.getHeight());
        this.hitBox = new HitBox(transition.getPosition(), bottomRightPoint);
        this.id = id;
    }

    public int getID() {
        return this.id;
    }

    public Transition getTransition() {
        return this.transition;
    }

    public void update() {
        transition.update();
    }

}
