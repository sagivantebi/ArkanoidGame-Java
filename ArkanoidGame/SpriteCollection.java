import biuoop.DrawSurface;

import java.util.ArrayList;
// ID: 318159282

/**
 * @author SAGIV ANTEBI
 * A class of SpriteCollection
 * The class has all the objects in the game
 */
public class SpriteCollection {
    private java.util.List<Sprite> listOfSprite;

    /**
     * .
     * SpriteCollection - constructor for the class
     */
    public SpriteCollection() {
        this.listOfSprite = new ArrayList<Sprite>();
    }

    /**
     * .
     * removeSprite - remove the sprite from the list of sprites
     *
     * @param s1 - the sprite to remove
     */
    public void removeSprite(Sprite s1) {
        this.listOfSprite.remove(s1);
    }

    /**
     * .
     * addSprite - add sprite to the list
     *
     * @param s - the sprite to add
     */
    public void addSprite(Sprite s) {
        this.listOfSprite.add(s);
    }

    /**
     * .
     * notifyAllTimePassed - all the time of sprites passed
     * call timePassed() on all sprites.
     */
    public void notifyAllTimePassed() {
        for (int i = 0; i < this.listOfSprite.size(); i++) {
            this.listOfSprite.get(i).timePassed();
        }
    }

    /**
     * .
     * drawAllOn - draw all the sprites
     * call drawOn(d) on all sprites.
     *
     * @param d - the surface to draw on
     */
    public void drawAllOn(DrawSurface d) {
        for (Sprite s : this.listOfSprite) {
            s.drawOn(d);
        }
    }
}