package CoreKernel;

import graphic.GraphicEngine;
import graphic.Sprite;
import physicpackage.PhysicEngine;
import physicpackage.PhysicalEntity;
import physicpackage.Transition;

import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class CoreKernel {
    private static int currentId = 0;
    private List<Integer> listId = new ArrayList<>();
    private PhysicEngine physicEngine;
    private GraphicEngine graphicEngine;


    public CoreKernel(PhysicEngine physicEngine, GraphicEngine graphicEngine) {
        this.physicEngine = physicEngine;
        this.graphicEngine = graphicEngine;
    }

    public PhysicEngine getPhysicEngine() { return physicEngine; }
    public GraphicEngine getGraphicEngine() { return graphicEngine; }

    public void update() {
        physicEngine.update();
        graphicEngine.update();
    }

    public void start() {
        graphicEngine.launch();
    }

    public void createEntity(Point2D coordinate, String path, Dimension2D dimension2D) { //memoriser les IDs correspondant à certain objet
        createPhysicEntity(coordinate, dimension2D);
        createGraphicEntity(coordinate, path, dimension2D);
        listId.add(currentId);
        currentId++;
    }

    private void createGraphicEntity(Point2D coordinate, String path, Dimension2D dimension2D) { //Image image
        graphicEngine.createStaticEntity(currentId, coordinate, Sprite.loadSprite(path), dimension2D);
    }

    private void createPhysicEntity(Point2D coordinate, Dimension2D dimension2D) {
        physicEngine.addPhysicalEntity(new PhysicalEntity(new Transition(coordinate), currentId, dimension2D));
    }
}
