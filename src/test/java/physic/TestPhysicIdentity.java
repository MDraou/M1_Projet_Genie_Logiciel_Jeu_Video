package physic;

import org.junit.jupiter.api.Test;

class TestPhysicIdentity {

    @Test
    void getSpeed() {
        PhysicIdentity identity = new PhysicIdentity("id",0,0,10,10,0);
        assertEquals(0, identity.getSpeed().getX());
        assertEquals(0, identity.getSpeed().getY());
    }

    @Test
    void getId() {
        PhysicIdentity identity = new PhysicIdentity("id",0,0,10,10,0);
        assertEquals("id", identity.getId());
    }

    @Test
    void setSpeed() {
        PhysicIdentity identity = new PhysicIdentity("id",0,0,10,10,0);
        assertEquals(0, identity.getSpeed().getX());
        assertEquals(0, identity.getSpeed().getY());
        identity.setSpeed(1, Direction.RIGHT);
        assertEquals(1, identity.getSpeed().getX());
        assertEquals(0, identity.getSpeed().getY());
        identity.setSpeed(1, Direction.UP);
        assertEquals(1, identity.getSpeed().getX());
        assertEquals(-1, identity.getSpeed().getY());
    }

    @Test
    void getHitbox() {
        PhysicIdentity identity = new PhysicIdentity("id",0,0,10,10,0);
        IHitbox hitbox = identity.getHitbox();
        IHitbox testHitbox = new RectangularHitbox(0, 0, 10, 10, 0);
        assertEquals(hitbox.getX(), testHitbox.getX());
        assertEquals(hitbox.getY(), testHitbox.getY());
        assertEquals(hitbox.getWidth(), testHitbox.getWidth());
        assertEquals(hitbox.getHeight(), testHitbox.getHeight());
        assertEquals(hitbox.getLayer(), testHitbox.getLayer());
    }
}