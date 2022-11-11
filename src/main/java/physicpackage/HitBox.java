package physicpackage;

import java.awt.geom.Point2D;

public class HitBox {
    /*
     * La forme choisi pour l'instant est un rectangle, mais on réfléchira à plus
     * précis plus tard
     */
    private Point2D coordinates;
    private double width;
    private double height;

    public HitBox(Point2D coordinates, double width, double height) {
        this.coordinates = coordinates;
        this.width = width;
        this.height = height;
    }

    public boolean intersects(PhysicalEntity physicalEntity) {
        HitBox foreignHitBox = physicalEntity.getHitBox();

        return coordinates.getX() <= foreignHitBox.coordinates.getX() + foreignHitBox.width
                && coordinates.getX() + width >= foreignHitBox.coordinates.getX()
                && coordinates.getY() <= foreignHitBox.coordinates.getY() + foreignHitBox.height
                && coordinates.getY() + height >= foreignHitBox.coordinates.getY();
    }

    public void update(Point2D coordinates) {
        this.coordinates = coordinates;
    }

}
