package physicpackage;

public class PhysicalEntity {
    public final double ACCELERATION = 3; // 3m/s^2
    public double speed = 0;
    public Vector vector;

    public PhysicalEntity(Vector Vector) {
        this.vector = Vector;
    }

    public void move() {
        // TODO
    }

    // Calcule la surface de contact de l'objet entity
    public boolean calculateSurface() {
        // TODO
        return false;
    }
}
