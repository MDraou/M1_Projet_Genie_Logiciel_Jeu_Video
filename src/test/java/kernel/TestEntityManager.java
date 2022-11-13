package kernel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestEntityManager {

    @Test
    void addAndGet() {
        EntityManager entityManager = new EntityManager();
        Entity entity = new Entity("id");
        entityManager.add(entity);
        assertEquals(entity, entityManager.get("id"));
    }

    @Test
    void remove() {
        EntityManager entityManager = new EntityManager();
        Entity entity = new Entity("id");
        entityManager.add(entity);
        assertEquals(entity, entityManager.get("id"));
        entityManager.remove("id");
        assertNotEquals(entity, entityManager.get("id"));
    }

    @Test
    void clear() {
        EntityManager entityManager = new EntityManager();
        Entity entity = new Entity("id");
        entityManager.add(entity);
        assertEquals(entity, entityManager.get("id"));
        entityManager.clear();
        assertNotEquals(entity, entityManager.get("id"));
    }
}