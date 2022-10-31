package physicpackage;

public class PhysicalEntity {
    private int id;
    private Transition transition;

    public PhysicalEntity(Transition transition, int id) {
        this.transition = transition;
        this.id = id;
    }

    public int getID() {
        return this.id;
    }

    public Transition getTransition() {
        return this.transition;
    }

    public void update() {
        transition.update();
    }

}
