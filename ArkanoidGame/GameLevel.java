import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
// ID: 318159282

/**
 * @author SAGIV ANTEBI
 * A class of GameLevel
 * The class implemenets Animation - and basiclly runs the game
 */
public class GameLevel implements Animation {
    //The width and height of the blocks
    private static final int WIDTH = 45;
    private static final int HEIGHT = 30;
    //The width and height of the frame
    private static final int WIDTH_FRAME = 800;
    private static final int HEIGHT_FRAME = 600;
    //start ball velocity
    private static final int SPEED = 5;
    private static final int ZERO = 0;
    private SpriteCollection sprites;
    private GameEnvironment environment;
    //list of the balls in the game
    private java.util.List<Ball> balls;
    //the block remover and the counter of the remaining blocks in the game
    private BlockRemover blockRemover;
    private Counter numBlocks;
    //the ball remover and the counter of the balls in the game
    private BallRemover ballRemover;
    private Counter numBalls;
    //the score counter of the game and the ScoreTrackingListener
    private ScoreTrackingListener scoreTracking;
    private Counter score;
    //ScoreIndicator  - the score display
    private ScoreIndicator scoreIndicator;
    //the animation runner and the stop function (running)
    private AnimationRunner runner;
    private boolean running;
    private biuoop.KeyboardSensor keyboard;
    private LevelInformation levelInformation;
    //the pause or exit key pressed
    private KeyPressStoppableAnimation keyPressStoppableAnimation;

    /**
     * .
     * Game - constructor
     *
     * @param levelInformation - the level information
     * @param ks               - the keyboard sensor
     * @param ar               - the animation runner
     * @param se               - the score indicator
     */
    public GameLevel(LevelInformation levelInformation, KeyboardSensor ks, AnimationRunner ar, ScoreIndicator se) {
        this.sprites = new SpriteCollection();
        this.environment = new GameEnvironment();
        this.balls = new ArrayList<Ball>();
        this.numBlocks = new Counter();
        this.blockRemover = new BlockRemover(this, this.numBlocks);
        this.numBalls = new Counter();
        this.ballRemover = new BallRemover(this, this.numBalls);
        this.score = new Counter();
        this.scoreTracking = new ScoreTrackingListener(this.score);
        this.scoreIndicator = se;
        this.runner = ar;
        this.running = true;
        this.keyboard = ks;
        this.levelInformation = levelInformation;

    }

    /**
     * .
     * <p>
     * addCollidable - add object
     *
     * @param c - Collidable
     */
    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }

    /**
     * .
     * addSprite - add sprite
     *
     * @param s - sprite
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }

    /**
     * .
     * SpriteCollection - return the sprite collection of the game
     *
     * @return -the sprite collection of the game
     */
    public SpriteCollection getSprites() {
        return this.sprites;
    }

    /**
     * .
     * GameEnvironment - return the game environment of the game
     *
     * @return the game environment of the game
     */
    public GameEnvironment getEnvironment() {
        return this.environment;
    }

    /**
     * initialize - create the Blocks and Ball (and Paddle)
     * and add them to the game.
     * The actual game environment
     */
    public void initialize() {
        this.sprites.addSprite(levelInformation.getBackground());
        //the frames
        Block left = new Block(new Rectangle(new Point(0, 0), 30, HEIGHT_FRAME), Color.GRAY);
        Block up = new Block(new Rectangle(new Point(0, 0), 800, HEIGHT), Color.GRAY);
        Block right = new Block(new Rectangle(new Point(WIDTH_FRAME - 30, 0), 30, HEIGHT_FRAME), Color.GRAY);

        //the deathRegion is the bottom rectangle that will remove the balls that are fall out the screen
        Block deathRegion = new Block(new Rectangle(new Point(0, HEIGHT_FRAME + 10),
                WIDTH_FRAME, HEIGHT_FRAME + 10), Color.GRAY);
        deathRegion.addHitListener(this.ballRemover);

        //add the borders to the game and the deathRegion
        left.addToGame(this);
        up.addToGame(this);
        deathRegion.addToGame(this);
        right.addToGame(this);
        for (Block b : levelInformation.blocks()) {
            b.addHitListener(this.blockRemover);
            b.addHitListener(this.scoreTracking);
            this.numBlocks.increase(1);
            b.addToGame(this);
        }
        //the balls
        for (int i = 0; i < this.levelInformation.numberOfBalls(); i++) {
            Ball newBall = new Ball(new Point(WIDTH_FRAME / 2, HEIGHT_FRAME / 2 + 50), 6, Color.white,
                    new Point(30, 30),
                    new Point(WIDTH_FRAME - 30, HEIGHT_FRAME - 30), this.environment);
            newBall.setVelocity(this.levelInformation.initialBallVelocities().get(i));
            newBall.addToGame(this);
            this.balls.add(newBall);

        }
        this.numBalls.increase(this.levelInformation.numberOfBalls());
        //add the ScoreIndicator
        this.sprites.addSprite(scoreIndicator);
        //adding the name of the level
        this.sprites.addSprite(new LevelName(this.levelInformation));
    }

    /**
     * run - Run the game -- start the animation loop.
     */
    public void run() {
        double xValue = (WIDTH_FRAME / 2) - (this.levelInformation.paddleWidth() / 2);
        Point pStartPaddle = new Point(xValue, HEIGHT_FRAME - 10);
        //the paddle
        Paddle paddle = new Paddle(this.keyboard, balls, this.levelInformation.paddleWidth(), 30, pStartPaddle);
        paddle.addToGame(this);
        this.runner.run(new CountdownAnimation(2, 3, this.sprites));
        //reset the running indication to be true
        this.running = true;
        // the runner to show the animation
        this.runner.run(this);
    }

    /**
     * .
     * removeCollidable - remove collidable
     *
     * @param c - the collidable to remove
     */
    public void removeCollidable(Collidable c) {
        this.environment.removeCollidable(c);
    }

    /**
     * .
     * removeSprite - remove a sprite
     *
     * @param s - the sprite to remove
     */
    public void removeSprite(Sprite s) {
        this.sprites.removeSprite(s);

    }

    /**
     * .
     * getScore - return the score
     *
     * @return the score of the game
     */
    public Counter getScore() {
        return score;
    }

    /**
     * .
     * getBalls - return the list of balls
     *
     * @return the list of balls
     */
    public List<Ball> getBalls() {
        return this.balls;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        //checks if there is no more ball or all the blocks removed
        if (this.numBlocks.getValue() == ZERO) {
            //increase the score by 100
            this.score.increase(100);
            //returning an indication that the game is done
            this.running = false;
        }
        if (this.keyboard.isPressed("p")) {
            this.runner.run(new PauseScreen(this.keyboard));
        }
        //checks if the game is finished
        if (numBalls.getValue() == ZERO) {
            this.runner.run(new EndScreen(this.keyboard, this.getScore()));
            closeGame();
        }
        this.sprites.drawAllOn(d);
        this.sprites.notifyAllTimePassed();
    }

    @Override
    public boolean shouldStop() {
        return !this.running;
    }

    /**
     * .
     * closeGame - close the gui game
     */
    public void closeGame() {
        this.runner.closeGui();
    }

    /**
     * .
     * getNumBalls  - return the number of balls
     *
     * @return the number of balls
     */
    public int getNumBalls() {
        return numBalls.getValue();
    }

    /**
     * .
     * getNumBlocks  - return the number of Blocks
     *
     * @return the number of Blocks
     */
    public int getNumBlocks() {
        return numBlocks.getValue();
    }

    /**
     * .
     * showWinScreen - shoes the win screen
     *
     * @param finalScore - the final score of the game
     */
    public void showWinScreen(Counter finalScore) {
        this.runner.run(new WinScreen(this.keyboard, finalScore));
    }
}