package gameplay;

import engine.kernel.Core;
import engine.kernel.CoreBuilder;
import engine.kernel.EntityBuilder;
import engine.kernel.MoveStrategy;

import java.awt.*;
import java.awt.event.KeyListener;
import java.util.Random;

public class Pong implements Runnable{
    private final Core core = new Core();
    private final EntityBuilder builder = new EntityBuilder();

    private final int width = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2;
    private final int height = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2;

    private Ball ball = new Ball(width/2 - 10, height/2 - 10);
    private final Paddle leftPaddle = new Paddle("leftPaddle", 20, height / 2 - 50);
    private final Paddle rightPaddle = new Paddle("rightPaddle", width - 20, height / 2 - 50);
    private final Wall[] walls = new Wall[4];



    public Pong() {
        CoreBuilder coreBuilder = new CoreBuilder(core);
        coreBuilder.buildGraphicEngine("Pong", width+width/34, height+height/14, 2, new InputEngine(new Player(this)));
        coreBuilder.buildPhysicEngine();
        createWalls();
        createPaddles();
        createBall();
    }

    private void createBall() {
        builder.setEntity(ball);
        builder.buildSprite("ball.png", 20, 20);
        builder.buildMovementChecker(20, 20);
        core.addEntity(ball);
    }

    private void createPaddles() {
        builder.setEntity(leftPaddle);
        builder.buildSprite("wall_v.png", 15, 100);
        builder.buildMovementChecker(15, 76);
        builder.setEntity(rightPaddle);
        builder.buildSprite("wall_v.png", 15, 100);
        builder.buildMovementChecker(15, 100);
        core.addEntity(leftPaddle);
        core.addEntity(rightPaddle);
    }

    private void createWalls() {
        walls[0] = new Wall("topWall", 0, 0);
        walls[1] = new Wall("bottomWall", 0, height - 5);
        walls[2] = new Wall("leftWall", 0, 0);
        walls[3] = new Wall("rightWall", width+width/137, 0);

        builder.setEntity(walls[0]);
        builder.buildMovementChecker(width+width/34, 5);
        builder.buildSprite("wall_v.png", width+width/34, 5);
        builder.setEntity(walls[1]);
        builder.buildMovementChecker(width+width/34, 5);
        builder.buildSprite("wall_v.png", width+width/34, 5);
        builder.setEntity(walls[2]);
        builder.buildMovementChecker(5, height);
        builder.buildSprite("wall_h.png", 5, height);
        builder.setEntity(walls[3]);
        builder.buildMovementChecker(5, height);
        builder.buildSprite("wall_h.png", 5, height);

        for (Wall wall : walls) core.addEntity(wall);
    }

    public void start() {
        core.launch();
        try { Thread.sleep(1000); } catch (InterruptedException e) { System.exit(1); }
        new Thread(this).start();
    }

    public void reset() {
        ball = new Ball(width/2 - 10, height/2 - 10);
        createBall();
    }

    public Paddle getLeftPaddle() {
        return leftPaddle;
    }

    public Paddle getRightPaddle() {
        return rightPaddle;
    }

    public Ball getBall() {
        return ball;
    }

    @Override
    public void run() {
        ball.process(new MoveStrategy(ball.getXSpeed(), ball.getYSpeed()));
    }
}
