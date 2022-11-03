package graphic;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.awt.geom.Point2D;

public class GraphicEngine {
    private final HashMap<Integer, GraphicPanel> graphicEntities = new HashMap<>();
    private final Window window;

    public GraphicEngine(int width, int height, String name) {
        window = new Window(width, height, name);
    }

    public void createAnimatedEntity(int id, Point2D coordinates, int duration, BufferedImage... sprites) {
        GraphicPanel panel = new GraphicPanel(coordinates);
        panel.setGraphicEntity(new AnimatedGraphicEntity(sprites, duration));
        graphicEntities.put(id, panel);
        window.validate();
    }

    public void createAnimatedEntity(int id, int coordX, int coordY, int duration, BufferedImage... sprites) {
        GraphicPanel panel = new GraphicPanel(coordX, coordY);
        panel.setGraphicEntity(new AnimatedGraphicEntity(sprites, duration));
        graphicEntities.put(id, panel);
        window.validate();
    }

    public void createStaticEntity(int id, Point2D coordinates, BufferedImage sprite) {
        GraphicPanel panel = new GraphicPanel(coordinates);
        panel.setGraphicEntity(new StaticGraphicEntity(sprite));
        graphicEntities.put(id, panel);
        window.validate();
    }

    public void createStaticEntity(int id, int coordX, int coordY, BufferedImage sprite) {
        GraphicPanel panel = new GraphicPanel(coordX, coordY);
        panel.setGraphicEntity(new StaticGraphicEntity(sprite));
        graphicEntities.put(id, panel);
        window.validate();
    }

    public GraphicPanel getEntity(int id) {
        return graphicEntities.get(id);
    }

}
