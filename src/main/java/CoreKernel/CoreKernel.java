package CoreKernel;

import graphic.GraphicEngine;
import physicpackage.PhysicEngine;
import physicpackage.PhysicalEntity;

import java.util.ArrayList;
import java.util.List;

public class CoreKernel {
    private static int currentId = 0;
    private List<Integer> listId = new ArrayList<>();
    private PhysicEngine physicEngine;
    private GraphicEngine graphicEngine;


    public CoreKernel(PhysicEngine physicEngine) {
        this.physicEngine = physicEngine;
        //this.graphicEngine = graphicEngine;
    }

    public void update() {

    }

    public void start() {

    }

    public void createEntity() { //memoriser les IDs correspondant à certain objet
        createPhysicEntity();
        createGraphicEntity();
        listId.add(currentId++);
    }

    private void createGraphicEntity() { //Image image

    }

    private void createPhysicEntity() {
        physicEngine.addPhysicalEntity(new PhysicalEntity(null, currentId));
    }
}
