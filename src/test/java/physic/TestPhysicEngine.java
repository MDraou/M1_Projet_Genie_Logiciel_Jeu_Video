package physic;

import org.junit.jupiter.api.Test;

class TestPhysicCollection {

    @Test
    void putAndGetTest() {
        PhysicIdentity identity = new PhysicIdentity("id",0,0,0,0,0);
        PhysicCollection physicCollection = new PhysicCollection();
        physicCollection.put(identity);
        assertEquals(identity, physicCollection.get("id"));
    }

    @Test
    void remove() {
        PhysicIdentity identity = new PhysicIdentity("id",0,0,0,0,0);
        PhysicCollection physicCollection = new PhysicCollection();
        physicCollection.put(identity);
        assertEquals(identity, physicCollection.get("id"));
        physicCollection.remove("id");
        assertNotEquals(identity, physicCollection.get("id"));
    }

    @Test
    void contain() {
        PhysicIdentity identity = new PhysicIdentity("id",0,0,0,0,0);
        PhysicCollection physicCollection = new PhysicCollection();
        physicCollection.put(identity);
        assertTrue(physicCollection.contain("id"));
    }

    @Test
    void update() {
        PhysicIdentity identity = new PhysicIdentity("id",0,0,0,0,0);
        PhysicCollection physicCollection = new PhysicCollection();
        identity.setSpeed(1, Direction.RIGHT);
        physicCollection.put(identity);
        physicCollection.update();
        assertEquals(1, identity.getHitbox().getX());
    }
}