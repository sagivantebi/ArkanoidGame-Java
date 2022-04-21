// ID: 318159282

/**
 * @author SAGIV ANTEBI
 * A class of BallRemover
 * a BlockRemover is in charge of removing Ball from the game, as well as keeping count
 * of the number of Ball that remain.
 */
public class BallRemover implements HitListener {
    private GameLevel gameLevel;
    private Counter remainingBalls;

    /**
     * .
     * BallRemover - Constructor
     *
     * @param gameLevel     - the game to remove from
     * @param numBalls - the removed balls counter
     */
    public BallRemover(GameLevel gameLevel, Counter numBalls) {
        this.gameLevel = gameLevel;
        this.remainingBalls = numBalls;
    }

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.removeFromGame(this.gameLevel);
        this.remainingBalls.decrease(1);

    }
}