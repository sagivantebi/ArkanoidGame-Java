import biuoop.DrawSurface;

import java.awt.Color;
// ID: 318159282
/**
 * @author SAGIV ANTEBI
 * A class of CountdownAnimation
 * The CountdownAnimation will display the given gameScreen,for numOfSeconds seconds, and on top of them it will show
 * a countdown from countFrom back to 1, where each number will appear on the screen for (numOfSeconds / countFrom)
 * seconds, before it is replaced with the next one.
 */
public class CountdownAnimation implements Animation {
    //The width and height of the frame
    private static final int WIDTH_FRAME = 800;
    private static final int HEIGHT_FRAME = 600;
    private double numOfSeconds;
    private int originalCount;
    private int countFrom;
    private SpriteCollection gameScreen;
    private Boolean stop;
    private biuoop.Sleeper sleeper;

    /**.
     * CountdownAnimation - constructor
     * @param numOfSeconds - the number of seconds to delay
     * @param countFrom - numbers to count from
     * @param gameScreen - the sprites in the game to show
     */
    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen) {
        this.numOfSeconds = numOfSeconds;
        this.originalCount = countFrom;
        this.countFrom = countFrom;
        this.gameScreen = gameScreen;
        this.stop = false;
        this.sleeper = new biuoop.Sleeper();
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        this.gameScreen.drawAllOn(d);
        d.setColor(Color.white);
        d.drawText(WIDTH_FRAME / 2 - 10, HEIGHT_FRAME / 2 + 150, Integer.toString(this.countFrom), 50);
        //erase the white screen at the beginning
        if (this.countFrom == this.originalCount) {
            sleeper.sleepFor((long) this.numOfSeconds / 100);
        }
        //checks if it is not the first round
        if (this.countFrom != this.originalCount) {
            sleeper.sleepFor(300 * (long) this.numOfSeconds);
        }
        if (this.countFrom == 0) {
            sleeper.sleepFor(300 * (long) this.numOfSeconds);
            this.stop = true;
            return;
        }
        this.decreaseCount();
    }

    /**.
     * decreaseCount - decrease the Count by 1
     */
    private void decreaseCount() {
        this.countFrom--;
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}
