// ID: 318159282

import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * @author SAGIV ANTEBI
 * A class of Block
 * The class support basic Block operations (made of rectangle)
 */
public class Block implements Collidable, Sprite, HitNotifier {
    private List<HitListener> hitListeners;
    private Rectangle r;
    private java.awt.Color color;

    public Block(Rectangle rectangle, java.awt.Color color) {
        this.r = rectangle;
        this.color = color;
        this.hitListeners = new ArrayList<HitListener>();
    }

    @Override
    public Rectangle getCollisionRectangle() {
        return this.r;
    }

    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        Velocity newVelocity = currentVelocity;
        if (this.getCollisionRectangle().getRecArrayLines()[0].checkPointHitLine(collisionPoint)) {
            newVelocity = new Velocity(-1 * (int) currentVelocity.getDx(), (int) currentVelocity.getDy());
        }
        if (this.getCollisionRectangle().getRecArrayLines()[1].checkPointHitLine(collisionPoint)) {
            newVelocity = new Velocity(-1 * (int) currentVelocity.getDx(), (int) currentVelocity.getDy());
        }
        if (this.getCollisionRectangle().getRecArrayLines()[2].checkPointHitLine(collisionPoint)) {
            newVelocity = new Velocity((int) currentVelocity.getDx(), -1 * (int) currentVelocity.getDy());
        }
        if (this.getCollisionRectangle().getRecArrayLines()[3].checkPointHitLine(collisionPoint)) {
            newVelocity = new Velocity((int) currentVelocity.getDx(), -1 * (int) currentVelocity.getDy());
        }
        // notify the hit
        this.notifyHit(hitter);
        return newVelocity;
    }

    /**
     * .
     * notifyHit - notify if there is a hit with any of the ball
     *
     * @param hitter - the hitter ball to check
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }

    /**
     * .
     * getColor - send the color
     *
     * @return the color of the block
     */
    public Color getColor() {
        return this.color;
    }

    @Override
    public void drawOn(DrawSurface d) {
        int xLeft, yLeft;
        xLeft = (int) this.r.getUpperLeft().getX();
        yLeft = (int) this.r.getUpperLeft().getY();
        d.setColor(this.color);
        d.fillRectangle(xLeft, yLeft, (int) this.r.getWidth(), (int) this.r.getHeight());
        d.setColor(Color.BLACK);
        d.drawRectangle(xLeft, yLeft, (int) this.r.getWidth(), (int) this.r.getHeight());
    }

    @Override
    public void timePassed() {
        return;
    }

    /**
     * .
     * addToGame - add the object to the game
     *
     * @param g - the game
     */
    public void addToGame(GameLevel g) {
        g.addCollidable(this);
        g.addSprite(this);
    }

    /**
     * .
     * removeFromGame - remove the block from the game
     *
     * @param gameLevel - the game to remove the block from
     */
    public void removeFromGame(GameLevel gameLevel) {
        gameLevel.removeSprite(this);
        gameLevel.removeCollidable(this);
    }

    /**
     * .
     * setNewUpperLeft - set new upper left location
     *
     * @param change - the velocity change of the ball.
     */
    public void setNewUpperLeft(int change) {
        this.r.setNewUpperLeft(change);
    }

    @Override
    public void addHitListener(HitListener hl) {
        hitListeners.add(hl);

    }

    @Override
    public void removeHitListener(HitListener hl) {
        hitListeners.remove(hl);
    }
}
