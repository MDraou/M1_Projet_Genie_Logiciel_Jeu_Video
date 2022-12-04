package engine.kernel;

import engine.graphic.Sprite;
import engine.physic.MovementsChecker;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class TestEntity {

    @Test
    void getSprite() {
        Entity entity = new Entity("id",0,0,0);
        assertNull(entity.getSprite());
    }

    @Test
    void getChecker() {
        Entity entity = new Entity("id",0,0,0);
        assertNull(entity.getChecker());
    }

    @Test
    void setSprite() throws IOException {
        Entity entity = new Entity("id",0,0,0);
        Sprite sprite = new Sprite("",new Point(0,0),new Dimension(10,10));
        entity.setSprite(sprite);
        assertEquals(sprite, entity.getSprite());
    }

    @Test
    void setChecker() {
        Entity entity = new Entity("id",0,0,0);
        MovementsChecker checker = new MovementsChecker("id",new Point(0,0),new Dimension(10,10),false);
        entity.setChecker(checker);
        assertEquals(checker, entity.getChecker());
    }

    @Test
    void clear() throws IOException {
        Entity entity = new Entity("id",0,0,0);
        Sprite sprite = new Sprite("",new Point(0,0),new Dimension(10,10));
        entity.setSprite(sprite);
        MovementsChecker checker = new MovementsChecker("id",new Point(0,0),new Dimension(10,10),false);
        entity.setChecker(checker);
        entity.clear();
        assertNull(entity.getChecker());
        assertNull(entity.getSprite());
    }

    @Test
    void update() throws IOException {
        Entity entity = new Entity("id",0,0,0);
        Sprite sprite = new Sprite("",new Point(0,0),new Dimension(10,10));
        entity.setSprite(sprite);;
        MovementsChecker checker = new MovementsChecker("id",new Point(0,0),new Dimension(10,10),false);
        entity.setChecker(checker);
        entity.update();
        assertEquals(entity.getSprite().getX(), entity.getChecker().getX());
        assertEquals(entity.getSprite().getY(), entity.getChecker().getY());
    }

    @Test
    void getId() {
        Entity entity = new Entity("id",0,0,0);
        assertEquals("id", entity.getId());
    }
}