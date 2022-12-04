package engine.physic;

import engine.kernel.Engine;
import engine.kernel.EngineVisitor;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A collection of physic controllers.
 */
public class PhysicEngine implements Engine<IMovementsChecker> {

    private final ArrayList<HashMap<String, IMovementsChecker>> layers = new ArrayList<>();

    /**
     * Add a movement controller to the window.
     * @param id the id associate
     * @param controller a Movements controller
     * @param layer the layer associate
     */
    @Override
    public void add(String id, IMovementsChecker controller, int layer) {
        while (layers.size() <= layer) layers.add(new HashMap<>());
        layers.get(layer).put(id, controller);
    }

    /**
     * remove a movement controller from the layer.
     * @param id the movement controller's id to remove from the layer
     */
    @Override
    public void remove(String id) {
        for (HashMap<String, IMovementsChecker> layer : layers)
            if (layer.containsKey(id)) { layer.remove(id); return ; }
    }

    /**
     * Return a graphic identity from the window if it's contain or null if not.
     * @param id the graphic identity's id
     * @return the movement controller represented by the id
     */
    public IMovementsChecker getController(String id) {
        for (HashMap<String, IMovementsChecker> layer : layers)
            if (layer.containsKey(id)) return layer.get(id);
        return null;
    }

    /**
     *
     */
    @Override
    public void start() {

    }

    /**
     * Check if the hitboxes intersect another hitbox and update their speed vector.
     */
    @Override
    public void update() {
        for (HashMap<String, IMovementsChecker> layer : layers)
            for (IMovementsChecker checker : layer.values()) {
                if (checker.getSpeed().isNull()) continue;
                for (IMovementsChecker fChecker : layer.values()) {
                    if (checker == fChecker) continue ;
                    if (checker.intersectInX(fChecker)) {
                        checker.setSpeed(0, checker.getSpeed().getY());
                        checker.setNeighbor(fChecker);
                    }
                    if (checker.intersectInY(fChecker)) {
                        checker.setSpeed(checker.getSpeed().getX(), 0);
                        checker.setNeighbor(fChecker);
                    }
                }
            }
    }

    /**
     * Accept a visitor
     * @param visitor visitor that visit the engine
     */
    @Override
    public void accept(EngineVisitor visitor) {
        visitor.visit(this);
    }
}
