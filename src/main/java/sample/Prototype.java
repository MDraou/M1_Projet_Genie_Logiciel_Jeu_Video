package sample;

import kernel.*;


public class Prototype {
    public static void main(String[] args) {
        EngineManager engineManager = new EngineManager();
        EntityManager entityManager = new EntityManager();

        EngineBuilder engineBuilder = new EngineBuilder(engineManager);


        engineBuilder.buildGraphicEngine("Penguin", 500, 500, 1);
        engineBuilder.buildPhysicEngine();

        Entity penguin = new Entity("penguin");

        EntityBuilder entityBuilder = new EntityBuilder();
        entityBuilder.setEntity(penguin);
        entityBuilder.buildGraphicIdentity("image.png", 0, 0, 50, 50, 0);
        entityBuilder.buildPhysicIdentity(0, 0,50, 50, 0);

        Entity rightWall = new Entity("rightWall");

        entityBuilder.setEntity(rightWall);
        entityBuilder.buildGraphicIdentity("wall_v.png",480,0,10,500, 0);
        entityBuilder.buildPhysicIdentity(480, 0,10, 500, 0);

        Core core = new Core(engineManager, entityManager);
        core.addEntity(penguin);
        core.addEntity(rightWall);
        core.launch();

        try { Thread.sleep(1000); } catch (InterruptedException e) { throw new RuntimeException(e); }

        core.process(new MoveStrategy(Direction.RIGHT, 2), "penguin");

    }
}
