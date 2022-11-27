package physic;

import kernel.Engine;
import kernel.Visitor;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A collection of physic controllers.
 */
public class PhysicEngine implements Engine<IMovementsController> {

    private final ArrayList<HashMap<String, IMovementsController>> layers = new ArrayList<>();

    /**
     * Add a graphic identity to the window.
     * @param controller a Movements controller
     */
    @Override
    public void add(String id, IMovementsController controller, int layer) {
        while (layers.size() <= layer) layers.add(new HashMap<>());
        layers.get(layer).put(id, controller);
    }

    /**
     * remove a graphic identity from the window.
     * @param id -> the graphic identity's id to remove from the window
     */
    @Override
    public void remove(String id) {
        for (HashMap<String, IMovementsController> layer : layers)
            if (layer.containsKey(id)) { layer.remove(id); return ; }
    }

    /**
     * Return a graphic identity from the window if it's contain or null if not.
     * @param id -> the graphic identity's id
     * @return the graphic identity represented by the id
     */
    public IMovementsController getController(String id) {
        for (HashMap<String, IMovementsController> layer : layers)
            if (layer.containsKey(id)) return layer.get(id);
        return null;
    }

    @Override
    public void start() {

    }

    /**
     * Check if the hitboxes intersect another hitbox and update their speed vector.
     */
    @Override
    public void update() {
        for (HashMap<String, IMovementsController> layer : layers)
            for (IMovementsController ctrl : layer.values()) {
                if (ctrl.getSpeed().isNull()) continue;
                for (IMovementsController fCtrl : layer.values()) {
                    if (ctrl == fCtrl) continue ;
                    if (ctrl.intersectInX(fCtrl)) {
                        ctrl.setSpeed(0, ctrl.getSpeed().getY());
                        ctrl.setNeighbor(fCtrl);
                    }
                    if (ctrl.intersectInY(fCtrl)) {
                        ctrl.setSpeed(ctrl.getSpeed().getX(), 0);
                        ctrl.setNeighbor(fCtrl);
                    }
                }
            }
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
