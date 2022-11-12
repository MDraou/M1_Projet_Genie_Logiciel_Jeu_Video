package kernel;

import graphic.IGraphicIdentity;

public class ResizeStrategy implements IStrategy {

    private final int width, height;

    public ResizeStrategy(int width, int height) {
        this.width = width; this.height = height;
    }

    @Override
    public void execute(Entity entity) {
        IGraphicIdentity graphic = entity.getGraphic();
        graphic.getSprite().resize(width, height);
    }
}
