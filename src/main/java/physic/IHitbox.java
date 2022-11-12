package physic;

public interface IHitbox {
    void resize(int width, int height);
    void moveTo(int x, int y);
    void setLayer(int layer);
    int getX();
    int getY();
    int getWidth();
    int getHeight();
    int getLayer();
    boolean intersects(IHitbox hitBox);
}
