package physicpackage;

import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;

public class PhysicalEntity {
    private int id;
    private PhysicalInformations physicalInformations;
    private HitBox hitBox;

    public PhysicalEntity(PhysicalInformations physicalInformations, int id, Dimension2D dimension) {
        this.physicalInformations = physicalInformations;
        Point2D bottomRightPoint = new Point2D.Double();
        bottomRightPoint.setLocation(physicalInformations.getPosition().getX() + dimension.getWidth(),
                physicalInformations.getPosition().getY() + dimension.getHeight());
        this.hitBox = new HitBox(physicalInformations.getPosition(), dimension.getWidth(), dimension.getHeight());
        this.id = id;
    }

    public HitBox getHitBox() {
        return hitBox;
    }

    public int getID() {
        return this.id;
    }

    public PhysicalInformations getPhysicalInformations() {
        return this.physicalInformations;
    }

    public void update() {
        physicalInformations.update();
        hitBox.update(physicalInformations.getPosition());
    }

}
