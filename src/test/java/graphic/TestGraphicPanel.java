package graphic;

import org.junit.jupiter.api.Test;
import java.awt.geom.Point2D;
import static org.junit.jupiter.api.Assertions.*;

public class TestGraphicPanel {

    @Test
    public void Test() throws InterruptedException {
        Window window = new Window(500, 500, "Penguin");
        GraphicEntity entity = new StaticGraphicEntity(Sprite.loadSprite("image.png"), null);

        GraphicPanel panel_1 = new GraphicPanel(0, 0);
        panel_1.setGraphicEntity(entity);
        window.add(panel_1, 0);
        window.start();
        assertEquals(panel_1.getGraphicEntity(), entity);
        Thread.sleep(1000);

        GraphicPanel panel_2 = new GraphicPanel(new Point2D.Double(100, 100));
        panel_2.setGraphicEntity(entity);
        window.add(panel_2, 0);
        assertEquals(panel_2.getGraphicEntity(), entity);
        Thread.sleep(1000);

        panel_2.setCoordinates(200, 200);
        assertEquals(panel_2.getCoordinates(), new Point2D.Double(200, 200));
        Thread.sleep(1000);

        panel_1.setCoordinates(new Point2D.Double(0, 200));
        assertEquals(panel_1.getCoordinates(), new Point2D.Double(0, 200));
        Thread.sleep(1000);
    }
}
