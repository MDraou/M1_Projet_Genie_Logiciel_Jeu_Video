package engine.kernel;

import engine.physic.MovementsChecker;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.*;

class TestMoveStrategy {

    @Test
    void execute() {
        Entity entity = new Entity("id",0,0,0);
        MovementsChecker checker = new MovementsChecker("id",new Point(0,0),new Dimension(10,10),false);
        entity.setChecker(checker);
        IStrategy strategy = new MoveStrategy(3,0);
        strategy.execute(entity);
        assertEquals(3, checker.getSpeed().getX());
    }
}