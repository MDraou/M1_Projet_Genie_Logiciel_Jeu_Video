package physicpackage;

public class PhysicalEntity {
    private Vector2D vector2d;

    public PhysicalEntity(Vector2D vector2d) {
        this.vector2d = vector2d;
    }

    public Vector2D getVector2d() {
        return this.vector2d;
    }

    public void update() {
        vector2d.update();
    }

}
