package graphic;

import java.util.HashMap;
import java.awt.geom.Point2D;

public class GraphicEngine {
    private final HashMap<Integer, GraphicEntity> graphicEntities = new HashMap<>();
    private final Window window;

    public GraphicEngine(int width, int height, String name) {
        window = new Window(width, height, name);
    }

    public void createEntity(int id, Point2D coordinates, String path) {
        graphicEntities.put(id, new GraphicEntity(path, coordinates));
    }

    public void createEntity(int id, int coordX, int coordY, String path) {
        graphicEntities.put(id, new GraphicEntity(path, new Point2D.Double(coordX, coordY)));
    }

    public GraphicEntity getEntity(int id) {
        return graphicEntities.get(id);
    }

    public void showAll() {

    }

    public void show(int id) {

    }

    public void hide() {

    }
}
