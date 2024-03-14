import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;

/**
 * @author SAGIV ANTEBI
 * A class of EndScreen
 * The class will show the end screen
 */
public class EndScreen implements Animation {
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
    public EndScreen(KeyboardSensor k, Counter score) {
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
        if (this.finalScore.getValue() == 0) {
            d.fillRectangle(150, d.getHeight() / 2 - 25, 395, 32);
        } else {
            d.fillRectangle(150, d.getHeight() / 2 - 25, 430, 32);
        }
        d.setColor(Color.blue);
        d.drawText(150, d.getHeight() / 2,
                "Game Over. Your score is " + Integer.toString(this.finalScore.getValue()), 32);
        this.kpa.doOneFrame(d);
        this.stop = this.kpa.shouldStop();
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}
