package kernel;

import graphic.GraphicEngine;
import graphic.GraphicIdentity;
import org.junit.jupiter.api.Test;
import physic.PhysicEngine;
import physic.PhysicIdentity;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class TestCore {

    @Test
    void process() {
        Entity entity = new Entity("id");
        PhysicIdentity physicIdentity = new PhysicIdentity("id", 0, 0, 10,10, 0);
        entity.setController(physicIdentity);
        EngineManager engineManager = new EngineManager();
        EntityManager entityManager = new EntityManager();
        PhysicEngine physicEngine = new PhysicEngine();
        engineManager.setPhysic(physicEngine);
        entityManager.add(entity);
        engineManager.addEntity(entity);
        Core core = new Core(engineManager,entityManager);
        core.process(new MoveStrategy(Direction.DOWN,3),"id");
        assertEquals(3, entity.getPhysic().getSpeed().getY());
    }

    @Test
    void addEntity() throws IOException {
        Entity entity = new Entity("id");
        PhysicIdentity physicIdentity = new PhysicIdentity("id", 0, 0, 10,10, 0);
        entity.setController(physicIdentity);
        GraphicIdentity graphicIdentity = new GraphicIdentity("id","",0,0,10,10,0);
        entity.setSprite(graphicIdentity);
        EngineManager engineManager = new EngineManager();
        EntityManager entityManager = new EntityManager();
        PhysicEngine physicEngine = new PhysicEngine();
        engineManager.setPhysic(physicEngine);
        GraphicEngine graphicEngine = new GraphicEngine("nom", 100, 100, 5);
        engineManager.setGraphic(graphicEngine);
        Core core = new Core(engineManager,entityManager);
        core.addEntity(entity);
        assertEquals(entity, entityManager.get("id"));
        assertEquals(entity.getPhysic(), physicEngine.getCollection().get("id"));
        assertEquals(entity.getGraphic(), graphicEngine.getWindow().getIdentity("id"));
    }

    @Test
    void removeEntity() throws IOException {
        Entity entity = new Entity("id");
        PhysicIdentity physicIdentity = new PhysicIdentity("id", 0, 0, 10,10, 0);
        entity.setController(physicIdentity);
        GraphicIdentity graphicIdentity = new GraphicIdentity("id","",0,0,10,10,0);
        entity.setSprite(graphicIdentity);
        EngineManager engineManager = new EngineManager();
        EntityManager entityManager = new EntityManager();
        PhysicEngine physicEngine = new PhysicEngine();
        engineManager.setPhysic(physicEngine);
        GraphicEngine graphicEngine = new GraphicEngine("nom", 100, 100, 5);
        engineManager.setGraphic(graphicEngine);
        Core core = new Core(engineManager,entityManager);
        core.addEntity(entity);
        assertEquals(entity, entityManager.get("id"));
        assertEquals(entity.getPhysic(), physicEngine.getCollection().get("id"));
        assertEquals(entity.getGraphic(), graphicEngine.getWindow().getIdentity("id"));
        core.removeEntity("id");
        assertNull(entityManager.get("id"));
        assertNull(physicEngine.getCollection().get("id"));
        assertNull(graphicEngine.getWindow().getIdentity("id"));
    }
}