/**
 * @author SAGIV ANTEBI
 * A class of CollisionInfo
 * The class support basic CollisionInfo operations
 */
public class CollisionInfo {
    private Point p;
    private Collidable c;
    private int index;
    /**.
     * CollisionInfo - constructor
     * @param p1 - the point of the collide
     * @param c1 - the object that collide with the ball
     */
    public CollisionInfo(Point p1, Collidable c1) {
        this.p = p1;
        this.c = c1;
    }
    /**
     * collisionPoint - the point at which the collision occurs.
     * @return the point at which the collision occurs.
     */
    public Point collisionPoint() {
        return this.p;
    }
    /**
     * collisionObject - the collidable object involved in the collision.
     * @return the collidable object involved in the collision.
     */
    public Collidable collisionObject() {
        return this.c;

    }
}
