package physic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestHitbox {

    @Test
    void resize() {
        IHitbox hitbox = new RectangularHitbox(10,20,10,10,0);
        assertEquals(10, hitbox.getWidth());
        assertEquals(10, hitbox.getHeight());
        hitbox.resize(5,3);
        assertEquals(5, hitbox.getWidth());
        assertEquals(3, hitbox.getHeight());
    }

    @Test
    void moveTo() {
        IHitbox hitbox = new RectangularHitbox(10,20,10,10,0);
        assertEquals(10, hitbox.getX());
        assertEquals(20, hitbox.getY());
        hitbox.moveTo(50,60);
        assertEquals(50, hitbox.getX());
        assertEquals(60, hitbox.getY());
    }

    @Test
    void setLayer() {
        IHitbox hitbox = new RectangularHitbox(10,20,10,10,0);
        assertEquals(0, hitbox.getLayer());
        hitbox.setLayer(1);
        assertEquals(1,hitbox.getLayer());
    }

    @Test
    void getX() {
        IHitbox hitbox = new RectangularHitbox(10,20,10,10,0);
        assertEquals(10, hitbox.getX());
    }

    @Test
    void getY() {
        IHitbox hitbox = new RectangularHitbox(10,20,10,10,0);
        assertEquals(20, hitbox.getY());
    }

    @Test
    void getWidth() {
        IHitbox hitbox = new RectangularHitbox(10,20,10,10,0);
        assertEquals(10, hitbox.getWidth());
    }

    @Test
    void getHeight() {
        IHitbox hitbox = new RectangularHitbox(10,20,10,100,0);
        assertEquals(100, hitbox.getHeight());
    }

    @Test
    void getLayer() {
        IHitbox hitbox = new RectangularHitbox(10,20,10,10,0);
        assertEquals(0, hitbox.getLayer());
    }

    @Test
    void intersects() {
        IHitbox hitbox = new RectangularHitbox(10,20,10,10,0);
        IHitbox intersectedHitbox = new RectangularHitbox(11,21,10,10,0);
        IHitbox noIntersectedHitbox = new RectangularHitbox(100,200,10,10,0);
        assertTrue(hitbox.intersects(intersectedHitbox));
        assertFalse(hitbox.intersects(noIntersectedHitbox));
    }
}