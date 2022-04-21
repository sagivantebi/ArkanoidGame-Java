
import java.util.List;
// ID: 318159282

/**
 * @author SAGIV ANTEBI
 * A interface of LevelInformation
 * The interface will hold all the information a level needs
 */
public interface LevelInformation {
    /**
     * .
     * numberOfBalls - return the number of balls in the level
     *
     * @return - the number of balls
     */
    int numberOfBalls();

    /**
     * .
     * initialBallVelocities - The initial velocity of each ball
     *
     * @return The initial velocity of each ball
     */
    List<Velocity> initialBallVelocities();

    /**
     * .
     * paddleSpeed - the speed of the paddle
     *
     * @return the speed of the paddle
     */
    int paddleSpeed();

    /**
     * .
     * paddleWidth - the paddle width
     *
     * @return the paddle width
     */
    int paddleWidth();

    /**
     * .
     * levelName - the level name will be displayed at the top of the screen.
     *
     * @return - the level name
     */
    String levelName();

    /**
     * .
     * getBackground - Returns a sprite with the background of the level
     *
     * @return - a sprite with the background of the level
     */
    Sprite getBackground();

    // The Blocks that make up this level, each block contains
    // its size, color and location.

    /**
     * blocks -  The Blocks that make up this level, each block contains
     * its size, color and location.
     *
     * @return list of the blocks in the level
     */
    List<Block> blocks();

    /**
     * .
     * numberOfBlocksToRemove -Number of blocks that should be removed
     *
     * @return - Number of blocks that should be removed
     */
    int numberOfBlocksToRemove();

}
