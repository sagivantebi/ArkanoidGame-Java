
/**
 * @author SAGIV ANTEBI
 * A class of ScoreTrackingListener
 * a ScoreTrackingListener is in charge of keeping score of the Game (increasing the score while ball touch block)
 */
public class ScoreTrackingListener implements HitListener {
    //the current score in the game
    private Counter currentScore;

    /**
     * .
     * BallRemover - Constructor
     *
     * @param scoreCounter - the score of the game
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        this.currentScore.increase(5);
    }
}
