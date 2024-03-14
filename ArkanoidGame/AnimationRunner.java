import biuoop.DrawSurface;
import biuoop.GUI;

/**
 * @author SAGIV ANTEBI
 * A class of AnimationRunner
 * The class will show and run the game animation
 */
public class AnimationRunner {
    //The width and height of the frame
    private static final int WIDTH_FRAME = 800;
    private static final int HEIGHT_FRAME = 600;
    private GUI gui;
    private int framesPerSecond;
    private biuoop.Sleeper sleeper;
    private biuoop.KeyboardSensor keyboard;

    /**
     * .
     * AnimationRunner - constructor
     */
    public AnimationRunner() {
        this.gui = new GUI("Arkanoid", WIDTH_FRAME, HEIGHT_FRAME);
        this.sleeper = new biuoop.Sleeper();
        this.framesPerSecond = 60;
        this.keyboard = this.gui.getKeyboardSensor();
    }

    /**
     * .
     * run - the run method
     *
     * @param animation - the game to show
     */
    public void run(Animation animation) {
        int millisecondsPerFrame = 1000 / framesPerSecond;
        while (!animation.shouldStop()) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = this.gui.getDrawSurface();

            animation.doOneFrame(d);

            this.gui.show(d);
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                this.sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }

    /**
     * .
     * getKeyboard - return the keyboard
     *
     * @return the keyboard
     */
    public biuoop.KeyboardSensor getKeyboard() {
        return this.keyboard;
    }

    /**
     * .
     * closeGui - close the gui
     */
    public void closeGui() {
        this.gui.close();
    }
}
