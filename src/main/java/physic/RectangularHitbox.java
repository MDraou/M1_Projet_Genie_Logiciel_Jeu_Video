package physic;

public class RectangularHitbox implements IHitbox {

    private volatile int x, y, width, height, layer;

    public RectangularHitbox(int x, int y, int width, int height, int layer) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.layer = layer;
    }

    @Override
    public void resize(int width, int height) {
        this.width = width; this.height = height;
    }

    @Override
    public void moveTo(int x, int y) {
        this.x = x; this.y = y;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public void setLayer(int layer) {
        this.layer = layer;
    }

    @Override
    public int getLayer() {
        return layer;
    }

    @Override
    public boolean intersects(IHitbox hitBox) {
        return layer == hitBox.getLayer()
            && x < hitBox.getX() + hitBox.getWidth() && x + width > hitBox.getX()
            && y < hitBox.getY() + hitBox.getHeight() && y + height > hitBox.getY();
    }
}
