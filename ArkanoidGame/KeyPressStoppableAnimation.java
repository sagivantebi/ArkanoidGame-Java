import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
// ID: 318159282

/**
 * @author SAGIV ANTEBI
 * A class of KeyPressStoppableAnimation
 * The class that indicates of the key pressed
 */
public class KeyPressStoppableAnimation implements Animation {
    private KeyboardSensor sensor;
    private String key;
    private Animation animation;
    private boolean stopRun;
    private boolean isAlreadyPressed;

    /**.
     * constructor
     *
     * @param sensor    - keyboard sensor
     * @param key       - the key that indicates to stop
     * @param animation - the animation to run
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.sensor = sensor;
        this.key = key;
        this.animation = animation;
        this.stopRun = false;
        this.isAlreadyPressed = true;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        if (this.sensor.isPressed(key) && (isAlreadyPressed)) {
            return;
        }
        if (this.sensor.isPressed(key)) {
            this.stopRun = true;
        }
        if (!this.sensor.isPressed(key)) {
            this.isAlreadyPressed = false;
        }
    }

    @Override
    public boolean shouldStop() {
        return this.stopRun;
    }

}
