package engine.kernel;

import engine.kernel.Entity;
import graphic.GraphicIdentity;
import org.junit.jupiter.api.Test;
import physic.PhysicIdentity;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class TestEntity {

    @Test
    void getGraphic() {
        Entity entity = new Entity("id");
        assertNull(entity.getSprite());
    }

    @Test
    void getPhysic() {
        Entity entity = new Entity("id");
        assertNull(entity.getChecker());
    }

    @Test
    void setGraphic() throws IOException {
        Entity entity = new Entity("id");
        GraphicIdentity identity = new GraphicIdentity("id","",0,0,10,10,0);
        entity.setSprite(identity);
        assertEquals(identity, entity.getSprite());
    }

    @Test
    void setPhysic() {
        Entity entity = new Entity("id");
        PhysicIdentity identity = new PhysicIdentity("id",0,0,10,10,0);
        entity.setChecker(identity);
        assertEquals(identity, entity.getChecker());
    }

    @Test
    void clear() throws IOException {
        Entity entity = new Entity("id");
        GraphicIdentity graphicIdentity = new GraphicIdentity("id","",0,0,10,10,0);
        entity.setSprite(graphicIdentity);
        PhysicIdentity physicIdentity = new PhysicIdentity("id",0,0,10,10,0);
        entity.setChecker(physicIdentity);
        entity.clear();
        assertNull(entity.getChecker());
        assertNull(entity.getSprite());
    }

    @Test
    void update() throws IOException {
        Entity entity = new Entity("id");
        GraphicIdentity graphicIdentity = new GraphicIdentity("id","",0,0,10,10,0);
        entity.setSprite(graphicIdentity);
        PhysicIdentity physicIdentity = new PhysicIdentity("id",10,20,10,10,0);
        entity.setChecker(physicIdentity);
        entity.update();
        assertEquals(entity.getSprite().getSprite().getX(), entity.getChecker().getHitbox().getX());
        assertEquals(entity.getSprite().getSprite().getY(), entity.getChecker().getHitbox().getY());
    }

    @Test
    void getId() {
        Entity entity = new Entity("id");
        assertEquals("id", entity.getId());
    }
}