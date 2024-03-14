
/**
 * @author SAGIV ANTEBI
 * An interface of Collidable
 * The interface support basic Collidable operations - getCollisionRectangle,hit.
 */
public interface Collidable {
    /**
     * getCollisionRectangle - Return the "collision shape" of the object.
     *
     * @return - the "collision shape" of the object.
     */
    Rectangle getCollisionRectangle();


    /**
     * hit - Notify the object that we collided with it at collisionPoint with a given velocity.
     * The return is the new velocity expected after the hit (based on
     * the force the object inflicted on us).
     *
     * @param ball - the ball that collide with
     * @param collisionPoint  - the collision point
     * @param currentVelocity - the ball current velocity
     * @return - the new velocity of the ball after the collide
     */
    Velocity hit(Ball ball, Point collisionPoint, Velocity currentVelocity);
}
