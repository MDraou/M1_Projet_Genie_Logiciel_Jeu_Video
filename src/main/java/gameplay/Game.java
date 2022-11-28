package gameplay;

import engine.kernel.Core;
import engine.kernel.CoreBuilder;
import engine.kernel.EntityBuilder;

public class Game {
    private static Core core;

    public static void main(String[] args) {
        core = new Core();
        CoreBuilder cBuilder = new CoreBuilder(core);
        cBuilder.buildGraphicEngine("P.O.N.G.", 500, 500, 2);
        EntityBuilder builder = new EntityBuilder();
        initializeBall(builder);
        initializePaddleG(builder);
        initializePaddleD(builder);
        core.launch();
    }


    private static void initializeBall(EntityBuilder builder) {
        Ball ball = new Ball("ball", 250, 250, 1);
        builder.setEntity(ball);
        builder.buildSprite("image.png", 25, 25);
        core.addEntity(ball);
    }
    private static void initializePaddleG(EntityBuilder builder) {
        Paddle paddle = new Paddle("paddleG", 30, 125, 1);
        builder.setEntity(paddle);
        builder.buildSprite("image.png", 25, 200);
        core.addEntity(paddle);
    }

    private static void initializePaddleD(EntityBuilder builder) {
        Paddle paddle = new Paddle("paddleD", 445, 125, 1);
        builder.setEntity(paddle);
        builder.buildSprite("image.png", 25, 200);
        core.addEntity(paddle);
    }


}
