package sample;

import engine.Point;
import engine.kernel.*;



public class Prototype {
    public static void main(String[] args) {
        Core core = new Core();
        CoreBuilder coreBuilder = new CoreBuilder(core);
        coreBuilder.buildGraphicEngine("Penguin", 500, 500, 1);
        coreBuilder.buildPhysicEngine();

        EntityBuilder entityBuilder = new EntityBuilder();

        Entity penguin = new Entity("penguin", 100, 100, 0);

        entityBuilder.setEntity(penguin);
        entityBuilder.buildGraphicIdentity("image.png", 50, 50);
        entityBuilder.buildPhysicIdentity(50, 50);

        Entity rightWall = new Entity("rightWall", 480,0, 0);

        entityBuilder.setEntity(rightWall);
        entityBuilder.buildGraphicIdentity("wall_v.png",10,500);
        entityBuilder.buildPhysicIdentity(10, 500);

        Entity leftWall = new Entity("leftWall", 0,0, 0);

        entityBuilder.setEntity(leftWall);
        entityBuilder.buildGraphicIdentity("wall_v.png",10,500);
        entityBuilder.buildPhysicIdentity(10, 500);

        Entity topWall = new Entity("topWall", 0,0, 0);

        entityBuilder.setEntity(topWall);
        entityBuilder.buildGraphicIdentity("wall_h.png",500, 10);
        entityBuilder.buildPhysicIdentity(500, 10);

        Entity bottomWall = new Entity("bottomWall", 0,480, 0);

        entityBuilder.setEntity(bottomWall);
        entityBuilder.buildGraphicIdentity("wall_h.png",500, 10);
        entityBuilder.buildPhysicIdentity(500, 10);

        core.addEntity(rightWall);
        core.addEntity(leftWall);
        core.addEntity(topWall);
        core.addEntity(bottomWall);
        core.addEntity(penguin);
        core.launch();

        try { Thread.sleep(1000); } catch (InterruptedException e) { throw new RuntimeException(e); }
        double speedX = 5.0; double speedY = 2.0;
        penguin.process(new MoveStrategy(speedX, speedY));
        while (true) {
            Point pCoords = penguin.getCoordinates();
            if (pCoords.getX() + 50 == rightWall.getCoordinates().getX()) {
                speedX = -speedX;
                penguin.process(new MoveStrategy(speedX, speedY));
                continue;
            }
            if (pCoords.getX() == leftWall.getCoordinates().getX() + 10) {
                speedX = -speedX;
                penguin.process(new MoveStrategy(speedX, speedY));
                continue;
            }
            if (pCoords.getY() == topWall.getCoordinates().getY() + 10) {
                speedY = -speedY;
                penguin.process(new MoveStrategy(speedX, speedY));
                continue;
            }
            if (pCoords.getY() + 50 == bottomWall.getCoordinates().getY()) {
                speedY = -speedY;
                penguin.process(new MoveStrategy(speedX, speedY));
            }
        }

    }
}
