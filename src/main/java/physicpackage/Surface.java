package physicpackage;

public class Surface {
    /*
     * La forme choisi pour l'instant est un rectangle, mais on réfléchira à plus
     * précis plus tard
     */
    private Point2D topLeftPoint;
    private Point2D bottomRightPoint;

    public Surface(Point2D topLeftPoint, Point2D bottomRightPoint) {
        this.topLeftPoint = topLeftPoint;
        this.bottomRightPoint = bottomRightPoint;
    }

    public boolean isInContact(Point2D contactPoint) {
        if (contactPoint.getX() <= bottomRightPoint.getX() || contactPoint.getX() >= topLeftPoint.getX()
                || contactPoint.getY() <= bottomRightPoint.getY() || contactPoint.getY() >= topLeftPoint.getY())
            return true;
        return false;
    }
}
