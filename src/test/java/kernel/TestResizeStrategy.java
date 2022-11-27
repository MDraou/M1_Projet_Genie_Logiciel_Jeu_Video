package kernel;

import graphic.GraphicIdentity;
import org.junit.jupiter.api.Test;
import physic.PhysicIdentity;

import java.io.IOException;

class TestResizeStrategy {

    @Test
    void execute() throws IOException {
        Entity entity = new Entity("id");
        PhysicIdentity physicIdentity = new PhysicIdentity("id", 0, 0, 10,10, 0);
        GraphicIdentity graphicIdentity = new GraphicIdentity("id","",0,0,10,10,0);
        entity.setController(physicIdentity);
        entity.setSprite(graphicIdentity);
        IStrategy strategy = new ResizeStrategy(3, 5);
        strategy.execute(entity);
        assertEquals(3, entity.getPhysic().getHitbox().getWidth());
        assertEquals(5, entity.getPhysic().getHitbox().getHeight());
        assertEquals(3, entity.getGraphic().getSprite().getWidth());
        assertEquals(5, entity.getGraphic().getSprite().getHeight());
    }
}