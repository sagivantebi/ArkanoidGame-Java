import java.util.ArrayList;
import java.util.List;
// ID: 318159282

/**
 * .
 *
 * @author SAGIV ANTEBI
 * A class of GameEnvironment
 * The class support basic GameEnvironment operations
 */
public class GameEnvironment {
    private List<Collidable> c = new ArrayList<Collidable>();

    /**
     * .
     * GameEnvironment - constructor (no parameters)
     */
    public GameEnvironment() {
    }

    /**
     * .
     * GameEnvironment - constructor
     *
     * @param c1 - the collidable list
     */
    public GameEnvironment(List<Collidable> c1) {
        this.c = c1;
    }

    /**
     * removeCollidable - remove the given collidable from the environment.
     *
     * @param c1 - the collideable to remove
     */
    public void removeCollidable(Collidable c1) {
        c.remove(c1);
    }

    /**
     * addCollidable -add the given collidable to the environment.
     *
     * @param c1 - the colidable object
     */
    public void addCollidable(Collidable c1) {
        this.c.add(c1);
    }

    /**
     * getClosestCollision -Assume an object moving from line.start() to line.end().
     * If this object will not collide with any of the collidables
     * in this collection, return null. Else, return the information
     * about the closest collision that is going to occur.
     *
     * @param trajectory - the line
     * @return the collision information and 1-index - not corner - 2 -is corner
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        Point pClosest = null, pTemp;
        Collidable cClosest = null;
        for (Collidable c1 : this.c) {
            pTemp = trajectory.closestIntersectionToStartOfLine(c1.getCollisionRectangle());
            if (pTemp != null) {
                if (pClosest == null) {
                    pClosest = pTemp;
                    cClosest = c1;
                } else if (pTemp.distance(trajectory.end()) < pClosest.distance(trajectory.end())) {
                    pClosest = pTemp;
                    cClosest = c1;
                }
            }
        }
        return new CollisionInfo(pClosest, cClosest);
    }
}