package engine.kernel;

import engine.graphic.Sprite;
import engine.physic.MovementsChecker;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;


class TestResizeStrategy {

    @Test
    void execute() throws IOException {
        Entity entity = new Entity("id",0,0,0);
        Sprite sprite = new Sprite("",new Point(0,0),new Dimension(10,10));
        entity.setSprite(sprite);;
        MovementsChecker checker = new MovementsChecker("id",new Point(0,0),new Dimension(10,10),false);
        entity.setChecker(checker);
        IStrategy strategy = new ResizeStrategy(3, 5);
        strategy.execute(entity);
        assertEquals(3, entity.getChecker().getWidth());
        assertEquals(5, entity.getChecker().getHeight());
        assertEquals(3, entity.getSprite().getWidth());
        assertEquals(5, entity.getSprite().getHeight());
    }
}