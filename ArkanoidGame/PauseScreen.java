import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;
// ID: 318159282

/**
 * @author SAGIV ANTEBI
 * A class of PauseScreen
 * The class will show the pause screen
 */
public class PauseScreen implements Animation {
    //The width and height of the frame
    private static final int WIDTH_FRAME = 800;
    private static final int HEIGHT_FRAME = 600;
    private KeyboardSensor keyboard;
    private boolean stop;
    private KeyPressStoppableAnimation kpa;

    /**
     * .
     * constructor
     *
     * @param k - the KeyboardSensor
     */
    public PauseScreen(KeyboardSensor k) {
        this.keyboard = k;
        this.stop = false;
        this.kpa = new KeyPressStoppableAnimation(keyboard, KeyboardSensor.SPACE_KEY, this);
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        d.setColor(new Color(247, 209, 255));
        d.fillCircle(WIDTH_FRAME / 2, HEIGHT_FRAME / 2, 500);
        d.setColor(new Color(209, 159, 243));
        d.fillRectangle(170, d.getHeight() / 2 - 25, 475, 32);
        d.setColor(Color.blue);
        d.drawText(170, d.getHeight() / 2, "paused -- press space to continue", 32);
        this.kpa.doOneFrame(d);
        this.stop = this.kpa.shouldStop();
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}
