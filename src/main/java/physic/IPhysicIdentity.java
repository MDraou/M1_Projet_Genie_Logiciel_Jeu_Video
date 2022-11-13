package physic;

import kernel.Directions;
import kernel.IIdentity;

/**
 * The interface representing the physic identities.
 */
public interface IPhysicIdentity extends IIdentity {

    /**
     * Return its hitbox.
     * @return its hitbox
     */
    IHitbox getHitbox();

    /**
     * Return its speed represented by a vector.
     * @return its speed
     */
    Vector getSpeed();

    /**
     * Set the speed represented by a vector.
     * @param speed -> the vector's norm
     * @param direction -> the vector's direction
     */
    void setSpeed(int speed, Directions direction);

    /**
     * Stop the identity's movement.
     */
    void stop();
}
