package graphic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestWindow {
    Window window = new Window(500, 500, "Window");

    @Test
    public void addTest() {
        assertEquals(window.getContentPane().getComponents().length, 0);
        window.add(new GraphicPanel(0, 0));
        assertEquals(window.getContentPane().getComponents().length, 1);
    }

    @Test
    public void startTest() {
        window.start();
        assertTrue(window.isVisible());
    }
}
