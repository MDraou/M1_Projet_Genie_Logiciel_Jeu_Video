package kernel;

import graphic.GraphicIdentity;
import org.junit.jupiter.api.Test;
import physic.PhysicIdentity;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class TestEntity {

    @Test
    void getGraphic() {
        Entity entity = new Entity("id");
        assertNull(entity.getGraphic());
    }

    @Test
    void getPhysic() {
        Entity entity = new Entity("id");
        assertNull(entity.getPhysic());
    }

    @Test
    void setGraphic() throws IOException {
        Entity entity = new Entity("id");
        GraphicIdentity identity = new GraphicIdentity("id","",0,0,10,10,0);
        entity.setSprite(identity);
        assertEquals(identity, entity.getGraphic());
    }

    @Test
    void setPhysic() {
        Entity entity = new Entity("id");
        PhysicIdentity identity = new PhysicIdentity("id",0,0,10,10,0);
        entity.setController(identity);
        assertEquals(identity, entity.getPhysic());
    }

    @Test
    void clear() throws IOException {
        Entity entity = new Entity("id");
        GraphicIdentity graphicIdentity = new GraphicIdentity("id","",0,0,10,10,0);
        entity.setSprite(graphicIdentity);
        PhysicIdentity physicIdentity = new PhysicIdentity("id",0,0,10,10,0);
        entity.setController(physicIdentity);
        entity.clear();
        assertNull(entity.getPhysic());
        assertNull(entity.getGraphic());
    }

    @Test
    void update() throws IOException {
        Entity entity = new Entity("id");
        GraphicIdentity graphicIdentity = new GraphicIdentity("id","",0,0,10,10,0);
        entity.setSprite(graphicIdentity);
        PhysicIdentity physicIdentity = new PhysicIdentity("id",10,20,10,10,0);
        entity.setController(physicIdentity);
        entity.update();
        assertEquals(entity.getGraphic().getSprite().getX(), entity.getPhysic().getHitbox().getX());
        assertEquals(entity.getGraphic().getSprite().getY(), entity.getPhysic().getHitbox().getY());
    }

    @Test
    void getId() {
        Entity entity = new Entity("id");
        assertEquals("id", entity.getId());
    }
}