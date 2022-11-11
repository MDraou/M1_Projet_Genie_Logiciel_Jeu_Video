package physicpackage;

import CoreKernel.Entity;

import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;
import java.util.List;

public class PhysicalEntity {
    private int id;
    private PhysicalInformations physicalInformations;
    private HitBox hitBox;

    public PhysicalEntity(PhysicalInformations physicalInformations, int id, Dimension2D dimension) {
        this.physicalInformations = physicalInformations;
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

    public void update(List<PhysicalEntity> physicalEntities) {
        move(physicalEntities);
        physicalInformations.update();
        hitBox.update(physicalInformations.getPosition());
    }

    public void move(List<PhysicalEntity> entities) {
        for (PhysicalEntity currentEntity : entities) {
            if (this != currentEntity && getHitBox().intersects(currentEntity)) {
                double posX = getPhysicalInformations().getPosition().getX()
                        - getPhysicalInformations().getSpeed().getX();
                double posY = getPhysicalInformations().getPosition().getY()
                        - getPhysicalInformations().getSpeed().getY();
                getPhysicalInformations().setPosition(new Point2D.Double(posX, posY));
                getPhysicalInformations().setSpeed(0.0, 0.0);
                break;
            }
        }

    }

    public void setCoordinates(int x, int y) {
        physicalInformations.setPosition(new Point2D.Double(x, y));
    }
}
