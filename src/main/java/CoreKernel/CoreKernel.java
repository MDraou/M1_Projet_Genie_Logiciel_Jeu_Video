package CoreKernel;

import graphic.GraphicEngine;
import graphic.Sprite;
import physicpackage.PhysicEngine;
import physicpackage.PhysicalEntity;
import physicpackage.PhysicalInformations;

import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class CoreKernel {
    private static int currentId = 0;
    private List<Integer> listId = new ArrayList<>();
    private PhysicEngine physicEngine;
    private GraphicEngine graphicEngine;

    public CoreKernel(int width, int height, String windowName) {
        this.physicEngine = new PhysicEngine();
        this.graphicEngine = new GraphicEngine(width, height, windowName);
    }

    public PhysicEngine getPhysicEngine() {
        return physicEngine;
    }

    public GraphicEngine getGraphicEngine() {
        return graphicEngine;
    }

    public void update() {
        physicEngine.update();
        for (int id = 0; id < currentId; id++) {
            Point2D point = physicEngine.getEntity(id).getPhysicalInformations().getPosition();
            graphicEngine.getEntity(id).setCoordinates((int) point.getX(), (int) point.getY());
        }
        graphicEngine.update();
    }


    public void start() {
        graphicEngine.launch();
    }

    public int createEntity(Point2D coordinate, String path, Dimension2D dimension2D) { // memoriser les IDs
                                                                                        // correspondant à certain objet
        physicEngine.addPhysicalEntity(new PhysicalEntity(new PhysicalInformations(coordinate), currentId, dimension2D));
        graphicEngine.createStaticEntity(currentId, coordinate, Sprite.loadSprite(path), dimension2D);
        listId.add(currentId);
        int id = currentId;
        currentId++;
        return id;
    }
}
