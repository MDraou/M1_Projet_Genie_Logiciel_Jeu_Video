package gameplay;

import engine.kernel.*;

import java.awt.*;
import java.awt.event.KeyListener;
import java.util.Random;

public class Pong implements Runnable{
    private final Core core = new Core();
    private final EntityBuilder builder = new EntityBuilder();

    private final int width = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2;
    private final int height = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2;

    private Ball ball = new Ball(width/2 - 10, height/2 - 10);
    private final Paddle leftPaddle = new Paddle("leftPaddle", 50, height / 2 - 50);
    private final Paddle rightPaddle = new Paddle("rightPaddle", width - 50, height / 2 - 50);
    private final Wall[] walls = new Wall[4];

    private final Score leftScore = new Score("leftScore", width/2-100, height/10 );


    private final Score rightScore = new Score("rightScore", width/2+50, height/10);


    public Pong() {
        CoreBuilder coreBuilder = new CoreBuilder(core);
        coreBuilder.buildGraphicEngine("Pong", width+width/34, height+height/14, 1, new InputEngine(new Player(this)));
        coreBuilder.buildPhysicEngine();
        createWalls();
        createPaddles();
        createScore();
        createBall();
    }

    private void createBall() {
        builder.setEntity(ball);
        builder.buildSprite("ball.png", 20, 20);
        builder.buildMovementChecker(20, 20, true);
        core.addEntity(ball);
    }

    private void createPaddles() {
        builder.setEntity(leftPaddle);
        builder.buildSprite("wall_v.png", 15, 100);
        builder.buildMovementChecker(15, 100, false);
        builder.setEntity(rightPaddle);
        builder.buildSprite("wall_v.png", 15, 100);
        builder.buildMovementChecker(15, 100, false);
        core.addEntity(leftPaddle);
        core.addEntity(rightPaddle);
    }

    private void createWalls() {
        walls[0] = new Wall("topWall", 0, 0);
        walls[1] = new Wall("bottomWall", 0, height - 5);
        walls[2] = new Wall("leftWall", 0, 0);
        walls[3] = new Wall("rightWall", width+width/137, 0);

        builder.setEntity(walls[0]);
        builder.buildMovementChecker(width+width/34, 5, false);
        builder.buildSprite("wall_h.png", width+width/34, 5);
        builder.setEntity(walls[1]);
        builder.buildMovementChecker(width+width/34, 5, false);
        builder.buildSprite("wall_h.png", width+width/34, 5);
        builder.setEntity(walls[2]);
        builder.buildMovementChecker(5, height, false);
        builder.buildSprite("wall_v.png", 5, height);
        builder.setEntity(walls[3]);
        builder.buildMovementChecker(5, height, false);
        builder.buildSprite("wall_v.png", 5, height);

        for (Wall wall : walls) core.addEntity(wall);
    }

    private void createScore() {
        Entity bar = new Entity("bar", width/2-12, height/10+20, 0);
        builder.setEntity(bar);
        builder.buildSprite("bar.png", 26, 13);

        builder.setEntity(leftScore);
        builder.buildSprite(leftScore.getImagePath(), 50, 50);
        builder.setEntity(rightScore);
        builder.buildSprite(rightScore.getImagePath(), 50, 50);

        core.addEntity(bar);
        core.addEntity(leftScore);
        core.addEntity(rightScore);
    }

    public void start() {
        core.launch();
        try { Thread.sleep(1000); } catch (InterruptedException e) { System.exit(1); }
        ball.process(new MoveStrategy(ball.getXSpeed(), ball.getYSpeed()));
        new Thread(this).start();
    }

    public void reset() {
        core.removeEntity("ball");
        ball = new Ball(width/2 - 10, height/2 - 10);
        createBall();
        try { Thread.sleep(1000); } catch (InterruptedException e) { System.exit(1); }
        ball.process(new MoveStrategy(ball.getXSpeed(), ball.getYSpeed()));
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
