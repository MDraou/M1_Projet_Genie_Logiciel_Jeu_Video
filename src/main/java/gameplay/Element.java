package gameplay;

import engine.kernel.Entity;

public interface Element {
    Entity getEntity();
    void accept(IElementVisitor visitor);

    int getX();
    int getY();
    int getWidth();
    int getHeight();

    String getImagePath();
}
