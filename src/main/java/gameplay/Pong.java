package gameplay;

import engine.kernel.*;

import java.awt.*;
import java.util.HashMap;

public class Pong implements Runnable {
    private final Core core = new Core();
    private final EntityBuilder builder = new EntityBuilder();

    private final int width = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2;
    private final int height = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2;

    private final HashMap<String, Element> elements = new HashMap<>();

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
    }

    public void initialize() {
        elements.put("topWall", new Wall("topWall", 0, 0, width+width/34, 5));
        elements.put("bottomWall", new Wall("bottomWall", 0, height - 5, width+width/34, 5));
        elements.put("leftWall", new Wall("leftWall", 0, 0, 5, height));
        elements.put("rightWall", new Wall("rightWall", width+width/137, 0, 5, height));
        elements.put("leftPaddle", new Paddle("leftPaddle", 50, height / 2 - 50, 15, 100));
        elements.put("rightPaddle", new Paddle("rightPaddle", width - 50, height / 2 - 50,  15, 100));
        elements.put("leftScore", new Score("leftScore", width/2-100, height/10 , 50, 50));
        elements.put("rightScore",  new Score("rightScore", width/2+50, height/10, 50, 50));
        elements.put("ball", new Ball(width/2 - 10, height/2 - 10, 20, 20));

        Entity bar = new Entity("bar", width/2-12, height/10+20, 0);
        builder.setEntity(bar);
        builder.buildSprite("bar.png", 26, 13);

        ElementVisitor visitor = new Visitor(builder);
        for (Element element : elements.values()) {
            element.accept(visitor);
            core.addEntity(element.getEntity());
        }
        core.addEntity(bar);
    }

    private void createBall() {
        builder.setEntity(ball);
        builder.buildSprite("ball.png", 20, 20);
        builder.buildMovementChecker(20, 20, true);
        core.addEntity(ball);
    }


    public void start() {
        core.launch();
        try { Thread.sleep(1000); } catch (InterruptedException e) { System.exit(1); }
        ball.process(new MoveStrategy(ball.getXSpeed(), ball.getYSpeed()));
        new Thread(this).start();
    }

    public void resetRightGoal() {
        core.removeEntity("ball");
        ball = new Ball(width/2 - 10, height/2 - 10);
        createBall();
        try { Thread.sleep(1000); } catch (InterruptedException e) { System.exit(1); }
        ball.process(new MoveStrategy(-5, ball.getYSpeed()));
    }

    public void resetLeftGoal() {
        core.removeEntity("ball");
        ball = new Ball(width/2 - 10, height/2 - 10);
        createBall();
        try { Thread.sleep(1000); } catch (InterruptedException e) { System.exit(1); }
        ball.process(new MoveStrategy(5, ball.getYSpeed()));
    }

    private void end() {
        try { Thread.sleep(100); } catch (InterruptedException e) { System.exit(1); }
        Entity go = new Entity("gameOver", width/2-100, 2*height/4, 0);
        builder.setEntity(go);
        builder.buildSprite("game_over.png", 200, height/4);
        core.addEntity(go);
    }

    public Paddle getLeftPaddle() {
        return (Paddle) elements.get("leftPaddle");
    }

    public Paddle getRightPaddle() {
        return (Paddle) elements.get("rightPaddle");
    }


    @Override
    public void run() {
        while(true) {
            if (elements.get("ball").getEntity().getCoordinates().getX() <= elements.get("leftWall").getEntity().getCoordinates().getX()+10) {
                ((Score) elements.get("rightScore")).increment();
                elements.get("rightScore").getEntity().process(new ChangeImageStrategy(elements.get("rightScore").getImagePath()));
                if (((Score) elements.get("rightScore")).getScore() < 7) resetLeftGoal();
                else { core.removeEntity("ball"); break; }
            }
            if (elements.get("ball").getEntity().getCoordinates().getX()+20 >= elements.get("rightWall").getEntity().getCoordinates().getX()-5) {
                ((Score) elements.get("leftScore")).increment();
                elements.get("leftScore").getEntity().process(new ChangeImageStrategy(elements.get("leftScore").getImagePath()));
                if (((Score) elements.get("leftScore")).getScore() < 7) resetRightGoal();
                else { core.removeEntity("ball"); break; }
            }
        }
        end();
    }
}
