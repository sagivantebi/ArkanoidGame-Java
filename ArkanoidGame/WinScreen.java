import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;

/**
 * @author SAGIV ANTEBI
 * A class of WinScreen
 * The class will show the win screen
 */
public class WinScreen implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;
    private Counter finalScore;
    private KeyPressStoppableAnimation kpa;

    /**
     * .
     * constructor
     *
     * @param k     - the KeyboardSensor
     * @param score - the final score getting from the game
     */
    public WinScreen(KeyboardSensor k, Counter score) {
        this.keyboard = k;
        this.stop = false;
        this.finalScore = score;
        this.kpa = new KeyPressStoppableAnimation(keyboard, KeyboardSensor.SPACE_KEY, this);
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        d.setColor(new Color(138, 255, 255));
        d.fillCircle(d.getWidth() / 2, d.getHeight() / 2, 500);
        d.setColor(new Color(209, 159, 243));
        d.fillRectangle(150, d.getHeight() / 2 - 25, 390, 32);
        d.setColor(Color.blue);
        d.drawText(150, d.getHeight() / 2,
                "You Win! Your score is " + Integer.toString(this.finalScore.getValue()), 31);
        this.kpa.doOneFrame(d);
        this.stop = this.kpa.shouldStop();
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}
