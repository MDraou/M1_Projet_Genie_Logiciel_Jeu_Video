package kernel;

public class EntityVisitor implements IVisitor {
    @Override
    public void visit(Entity entity) {
        if (entity.getGraphic() == null) return;
        entity.update();
    }
}
