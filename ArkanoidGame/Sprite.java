import biuoop.DrawSurface;
// ID: 318159282
/**
 * @author SAGIV ANTEBI
 * An interface of Sprite
 * The interface support basic Sprite operations - drawOn,timePassed
 */
public interface Sprite {
    /**.
     * drawOn - draw the sprite to the screen
     * @param d - the draw surface
     */
    void drawOn(DrawSurface d);

    /**
     * .
     * timePassed -notify the sprite that time has passed
     */
    void timePassed();
}