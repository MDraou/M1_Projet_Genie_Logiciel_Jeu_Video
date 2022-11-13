package kernel;

import graphic.GraphicEngine;
import org.junit.jupiter.api.Test;
import physic.PhysicEngine;

import static org.junit.jupiter.api.Assertions.*;

class TestEngineManager {

    @Test
    void addEntity() {
        EngineManager engineManager = new EngineManager();
        PhysicEngine physicEngine = new PhysicEngine();
        GraphicEngine graphicEngine = new GraphicEngine("nom", 100,100,5);
        engineManager.setGraphic(graphicEngine);
        engineManager.setPhysic(physicEngine);
        Entity entity = new Entity("id");
        engineManager.addEntity(entity);
        assertEquals(entity.getPhysic(), physicEngine.getCollection().get("id"));
        assertEquals(entity.getGraphic(), graphicEngine.getWindow().getIdentity("id"));
    }

    @Test
    void removeEntity() {
        EngineManager engineManager = new EngineManager();
        PhysicEngine physicEngine = new PhysicEngine();
        GraphicEngine graphicEngine = new GraphicEngine("nom", 100,100,5);
        engineManager.setGraphic(graphicEngine);
        engineManager.setPhysic(physicEngine);
        Entity entity = new Entity("id");
        engineManager.addEntity(entity);
        assertEquals(entity.getPhysic(), physicEngine.getCollection().get("id"));
        assertEquals(entity.getGraphic(), graphicEngine.getWindow().getIdentity("id"));
        engineManager.removeEntity("id");
        assertNull(physicEngine.getCollection().get("id"));
        assertNull(graphicEngine.getWindow().getIdentity("id"));
    }

}