package graphic;

import org.junit.jupiter.api.Test;
import sample.Window;

import java.awt.geom.Point2D;

public class TestGraphicEntity {

    @Test
    public void rotateTest() throws InterruptedException {
        GraphicEntity entity = new GraphicEntity("image.png", new Point2D.Double(25, 25));
        sample.Window window = new Window("Penguin", 500, 500);
        window.add(entity);
        window.start();
        for (int i = 0 ; i < 1_000_000_000 ; i++) {
            Thread.sleep(10);
            entity.rotate(1);
            window.repaint();
        }
    }
}
