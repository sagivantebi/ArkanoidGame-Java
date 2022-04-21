// ID: 318159282

/**
 * @author SAGIV ANTEBI
 * An interface of HitListener
 * The interface of the hit listener
 */
public interface HitListener {
    /**
     * hitEvent - This method is called whenever the ball is being Hit.
     * The hitter parameter is the Ball that's doing the hitting.
     * @param beingHit - the object that being hit
     * @param hitter - the hitter ball
     */
    void hitEvent(Block beingHit, Ball hitter);
}

