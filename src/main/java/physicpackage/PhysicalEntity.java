package physicpackage;

public class PhysicalEntity {
    private Transition transition;

    public PhysicalEntity(Transition transition) {
        this.transition = transition;
    }

    public Transition getTransition() {
        return this.transition;
    }

    public void update() {
        transition.update();
    }

}
