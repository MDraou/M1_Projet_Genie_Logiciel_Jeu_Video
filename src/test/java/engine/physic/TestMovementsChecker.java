package engine.physic;

import engine.kernel.Point;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class TestMovementsChecker {

    @Test
    public void testGetSpeed() {
        MovementsChecker test = new MovementsChecker("0", new Point(3, 6), new Dimension(3, 8),false);
        assertEquals(test.getSpeed().getX(), 0);
        assertEquals(test.getSpeed().getY(), 0);
    }

    @Test
    public void testGetId() {
        MovementsChecker test = new MovementsChecker("0", new Point(3, 6), new Dimension(3, 8), false);
        assertEquals(test.getId(), "0");
    }

    @Test
    public void testSetSpeed() {
        MovementsChecker test = new MovementsChecker("0", new Point(3, 6), new Dimension(3, 8), false);
        test.setSpeed(3, 1);
        assertEquals(test.getSpeed().getX(), 3);
        assertEquals(test.getSpeed().getY(), 1);
    }

    @Test
    public void testStop() {
        MovementsChecker test = new MovementsChecker("0", new Point(3, 6), new Dimension(3, 8), false);
        test.stop();
        assertEquals(test.getSpeed().getX(), 0);
        assertEquals(test.getSpeed().getY(), 0);
    }

    @Test
    public void testGetXAndY() {
        MovementsChecker test = new MovementsChecker("0", new Point(3, 6), new Dimension(3, 8), false);
        assertEquals(test.getX(), 3);
        assertEquals(test.getY(), 6);
    }

    @Test
    public void testGetWidthAndHeight() {
        MovementsChecker test = new MovementsChecker("0", new Point(3, 6), new Dimension(3, 8), false);
        assertEquals(test.getWidth(), 3);
        assertEquals(test.getHeight(), 8);
    }

    @Test
    public void testResize() {
        MovementsChecker test = new MovementsChecker("0", new Point(3, 6), new Dimension(3, 8), false);
        test.resize(2, 13);
        assertEquals(test.getWidth(), 2);
        assertEquals(test.getHeight(), 13);
    }

    @Test
    public void testGetFChecker() {
        MovementsChecker test = new MovementsChecker("0", new Point(3, 6), new Dimension(3, 8), false);
        assertEquals(test.getFChecker(), null);
    }

    @Test
    public void testSetNeighbor() {
        MovementsChecker test = new MovementsChecker("0", new Point(3, 6), new Dimension(3, 8), false);
        IMovementsChecker test1 = new MovementsChecker("0", new Point(3, 6), new Dimension(3, 8), false);
        test.setNeighbor(test1);
        assertEquals(test1, test.getFChecker());

    }

    @Test
    public void testGetNextCoordinates() {
        MovementsChecker test = new MovementsChecker("0", new Point(7, 6), new Dimension(1, 1), false);
        MovementsChecker test1 = new MovementsChecker("0", new Point(1, 1), new Dimension(3, 3), false);
        MovementsChecker test2 = new MovementsChecker("0", new Point(12, 12), new Dimension(3, 3), false);
        MovementsChecker test3 = new MovementsChecker("0", new Point(1, 1), new Dimension(3, 3), false);
        MovementsChecker test4 = new MovementsChecker("0", new Point(12, 12), new Dimension(3, 3), false);

        test1.setNeighbor(test);
        test2.setNeighbor(test);
        test3.setNeighbor(test);
        test4.setNeighbor(test);

        //Initial test
        Point nextCoordinates = test.getNextCoordinates();
        assertEquals(nextCoordinates.getX(), test.getX() + test.getSpeed().getX());
        assertEquals(nextCoordinates.getY(), test.getY() + test.getSpeed().getY());
        //test 1
        test1.setSpeed(0, 1);
        Point nextCoordinates1 = test1.getNextCoordinates();
        assertEquals(nextCoordinates1.getX(), test.getX() - test1.getWidth());
        assertEquals(nextCoordinates1.getY(), test1.getY());
        //test 2
        test2.setSpeed(0, 1);
        Point nextCoordinates2 = test2.getNextCoordinates();
        assertEquals(nextCoordinates2.getX(), test.getX() + test.getWidth());
        assertEquals(nextCoordinates2.getY(), test2.getY());
        //test 3
        test3.setSpeed(1, 0);
        Point nextCoordinates3 = test3.getNextCoordinates();
        assertEquals(nextCoordinates3.getX(), test3.getX());
        assertEquals(nextCoordinates3.getY(), test.getY() - test3.getHeight());
        //test 4
        test4.setSpeed(1, 0);
        Point nextCoordinates4 = test4.getNextCoordinates();
        assertEquals(nextCoordinates4.getX(), test4.getX());
        assertEquals(nextCoordinates4.getY(), test.getY() + test.getHeight());
    }

    @Test
    public void testIsBouncing() {
        MovementsChecker test = new MovementsChecker("0", new Point(7, 6), new Dimension(1, 1), false);
        assertFalse(test.isBouncing());
    }

    @Test
    public void testIntersectInYAndX() {
        MovementsChecker test = new MovementsChecker("0", new Point(7, 6), new Dimension(1, 1), false);
        MovementsChecker test1 = new MovementsChecker("0", new Point(8, 6), new Dimension(1, 1), false);
        MovementsChecker test2 = new MovementsChecker("0", new Point(7, 7), new Dimension(1, 1), false);

        assertTrue(test.intersectInX(test1));
        assertFalse(test.intersectInY(test1));

        assertFalse(test.intersectInX(test2));
        assertTrue(test.intersectInY(test2));
    }




}