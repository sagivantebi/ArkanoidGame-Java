import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;

/**
 * @author SAGIV ANTEBI
 * A class of Block
 * The class support basic Block operations
 */
public class Paddle implements Sprite, Collidable {
    private int pWidth;
    private int pHeight;
    private static final int CHANGE_LEFT = -10;
    private static final int CHANGE_RIGHT = 10;
    private static final int PADDLE_LEFT_BORDER = 30;
    private int paddleRightBorder = 770 - pWidth;
    //the value to kick the ball out of the paddle
    private static final int KICK_BALL_OUT = 20;
    private biuoop.KeyboardSensor keyboard;
    private Block block;
    public static final double EPSILON = Math.pow(10, -10);
    private java.util.List<Ball> balls;
    private Point pStart;

    /**.
     * Paddle - constructor to paddle
     * @param keyboard - the keyboard
     * @param balls - the list of balls
     * @param pWidth - the paddle width
     * @param pHeight - the paddle height
     * @param pStart - the point the block will start
     */
    public Paddle(biuoop.KeyboardSensor keyboard, java.util.List<Ball> balls, int pWidth, int pHeight, Point pStart) {
        this.pHeight = pHeight;
        this.pWidth = pWidth;
        this.paddleRightBorder = 770 - pWidth;
        this.keyboard = keyboard;
        this.pStart = pStart;
        this.block = new Block(new Rectangle(pStart, pWidth, pHeight), Color.ORANGE);
        this.balls = balls;
    }

    /**
     * .
     * ballInPaddle - checks if the ball is in the paddle
     *
     * @param ball - the ball
     * @return true if the ball in the paddle
     */
    public boolean ballInPaddle(Ball ball) {
        //checks if the ball in the paddle from above
        double x = this.block.getCollisionRectangle().getUpperLeft().getX();
        double paddleY = this.block.getCollisionRectangle().getUpperLeft().getY();
        //checks if the ball in the height of the paddle and in the x indexes of him
        if ((ball.getY() > paddleY)
                && (ball.getX() > x) && (ball.getX() < x + this.pWidth)) {
            return true;
        }
        return false;
    }

    /**
     * .
     * moveLeft - moving the paddle left
     * checks if the puddle touches the side - if so does not move
     */
    public void moveLeft() {
        //if the paddle is in his left border limit
        if (this.block.getCollisionRectangle().getUpperLeft().getX() - (PADDLE_LEFT_BORDER + CHANGE_RIGHT) < 0) {
            return;
        }
        for (Ball b : this.balls) {
            if (ballInPaddle(b)) {
                b.setCenter(b.getX(), b.getY() - KICK_BALL_OUT);
            }
        }
        this.block.setNewUpperLeft(CHANGE_LEFT);
        Point upper = this.block.getCollisionRectangle().getUpperLeft();
        this.block = new Block(new Rectangle(upper, this.pWidth, this.pHeight), Color.ORANGE);
    }

    /**
     * .
     * moveRight - moving the paddle right
     * checks if the paddle touches the side - if so does not move
     */
    public void moveRight() {
        //if the paddle is in his right border limit
        if (this.paddleRightBorder - (this.block.getCollisionRectangle().getUpperLeft().getX() + CHANGE_RIGHT) < 0) {
            return;
        }
        for (Ball b : this.balls) {
            if (ballInPaddle(b)) {
                b.setCenter(b.getX(), b.getY() - KICK_BALL_OUT);
            }
        }
        this.block.setNewUpperLeft(CHANGE_RIGHT);
        Point upper = this.block.getCollisionRectangle().getUpperLeft();
        this.block = new Block(new Rectangle(upper, this.pWidth, this.pHeight), Color.ORANGE);
    }


    /**
     * .
     * timePassed - the operation of the moving paddle
     */
    public void timePassed() {
        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            moveLeft();
        }
        if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            moveRight();
        }
    }

    @Override
    public void drawOn(DrawSurface d) {
        this.block.drawOn(d);
    }

    @Override
    public Rectangle getCollisionRectangle() {
        return this.block.getCollisionRectangle();
    }

    @Override
    public Velocity hit(Ball ball, Point collisionPoint, Velocity currentVelocity) {
        Velocity newVelocity;
        // a fifth of the paddle
        double oneFifthOfX = this.pWidth / 5;
        //the start x point of the paddle
        double startPaddle = this.block.getCollisionRectangle().getUpperLeft().getX();
        double speedCalculate = Math.sqrt(currentVelocity.getDx() * currentVelocity.getDx()
                + currentVelocity.getDy() * currentVelocity.getDy());
        //checks 1/5 of the paddle
        if (collisionPoint.getX() <= oneFifthOfX + startPaddle) {
            newVelocity = Velocity.fromAngleAndSpeed(300, speedCalculate);
            //checks 2/5 of the paddle
        } else if (collisionPoint.getX() <= oneFifthOfX * 2 + startPaddle) {
            newVelocity = Velocity.fromAngleAndSpeed(330, speedCalculate);
            //checks 3/5 of the paddle
        } else if (collisionPoint.getX() <= oneFifthOfX * 3 + startPaddle) {
            newVelocity = Velocity.fromAngleAndSpeed(356, speedCalculate);
            //checks 4/5 of the paddle
        } else if (collisionPoint.getX() <= oneFifthOfX * 4 + startPaddle) {
            newVelocity = Velocity.fromAngleAndSpeed(30, speedCalculate);
            //checks 5/5 of the paddle
        } else if (collisionPoint.getX() <= oneFifthOfX * 5 + startPaddle) {
            newVelocity = Velocity.fromAngleAndSpeed(60, speedCalculate);
        } else {
            newVelocity = currentVelocity;
        }
        return newVelocity;
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
}
