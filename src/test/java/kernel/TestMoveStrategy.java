package kernel;

import org.junit.jupiter.api.Test;
import physic.PhysicIdentity;

class TestMoveStrategy {

    @Test
    void execute() {
        Entity entity = new Entity("id");
        PhysicIdentity physicIdentity = new PhysicIdentity("id", 0, 0, 10,10, 0);
        entity.setController(physicIdentity);
        IStrategy strategy = new MoveStrategy(Direction.RIGHT,3);
        strategy.execute(entity);
        assertEquals(3, physicIdentity.getSpeed().getX());
    }
}