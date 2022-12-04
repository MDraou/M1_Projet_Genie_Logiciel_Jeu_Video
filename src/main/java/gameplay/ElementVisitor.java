package gameplay;

import engine.kernel.EntityBuilder;

public class ElementVisitor implements IElementVisitor {

    private final EntityBuilder builder;

    public ElementVisitor(EntityBuilder builder) {
        this.builder = builder;
    }

    @Override
    public void visit(Wall wall) {
        builder.setEntity(wall.getEntity());
        builder.buildSprite(wall.getImagePath(), wall.getWidth(), wall.getHeight());
        builder.buildMovementChecker(wall.getWidth(), wall.getHeight(), false);
    }

    @Override
    public void visit(Ball ball) {
        builder.setEntity(ball.getEntity());
        builder.buildSprite(ball.getImagePath(), ball.getWidth(), ball.getHeight());
        builder.buildMovementChecker(ball.getWidth(), ball.getHeight(), true);
    }

    @Override
    public void visit(Paddle paddle) {
        builder.setEntity(paddle.getEntity());
        builder.buildSprite(paddle.getImagePath(), paddle.getWidth(), paddle.getHeight());
        builder.buildMovementChecker(paddle.getWidth(), paddle.getHeight(), false);
    }

    @Override
    public void visit(Score score) {
        builder.setEntity(score.getEntity());
        builder.buildSprite(score.getImagePath(), score.getWidth(), score.getHeight());
    }
}
