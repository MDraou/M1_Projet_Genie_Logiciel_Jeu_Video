package physicpackage;

public class Point2D {
    private double x;
    private double y;

    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public void add(Point2D point2D) {
        this.x += point2D.x;
        this.y += point2D.y;
    }

    public void subtract(Point2D point2D) {
        this.x -= point2D.x;
        this.y -= point2D.y;
    }

    public void multiply(double factor) {
        this.x *= factor;
        this.y *= factor;
    }

}
