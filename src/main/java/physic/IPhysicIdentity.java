package physic;

import kernel.Directions;
import kernel.Identity;

public interface IPhysicIdentity extends Identity {
    IHitbox getHitbox();
    Vector getSpeed();
    void setSpeed(int speed, Directions direction);
    void stop();
}
