package engine.kernel;

/**
 * The strategy to change the image of a entity
 */
public class ChangeImageStrategy implements IStrategy{

    private String path;

    /**
     * The strategy's constructor
     * @param path the path of the new image
     */
    public ChangeImageStrategy(String path) {
        this.path = path;
    }

    /**
     * Change the image of the entity
     * @param entity the entity which the strategy is executed on.
     */
    @Override
    public void execute(Entity entity) {
        entity.getSprite().changeImage(path);
    }
}
