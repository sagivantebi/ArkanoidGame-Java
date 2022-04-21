import biuoop.DrawSurface;

import java.util.Random;
import java.awt.Color;
// ID: 318159282

/**
 * @author SAGIV ANTEBI
 * A class of Ball
 * The class of the ball.
 */
public class Ball implements Sprite {
    //max speed of the balls
    public static final int MAX_SPEED = 8;
    //max size of the ball - for the speed
    public static final int MAX_SIZE = 50;
    // center - the center point of the ball.
    private Point center;
    // r - the radius of the ball.
    private int r;
    // color - the color of the ball.
    private java.awt.Color color;
    // v - the ball velocity - initials with - dx = 0, dy = 0.
    private Velocity v = new Velocity(0, 0);
    //the frame size the ball can move in
    private Point pStart, pEnd;
    //the game environment of the ball
    private GameEnvironment ge;
    public static final double EPSILON = Math.pow(10, -10);

    /**
     * constructor Ball.
     *
     * @param center - the center of the ball.
     * @param r      - the radius of the ball.
     * @param color  - the color of the ball.
     */
    public Ball(Point center, int r, java.awt.Color color) {
        this.center = center;
        this.r = r;
        this.color = color;
    }

    /**
     * constructor Ball.
     *
     * @param x     - the x index of the ball.
     * @param y     - the y index of the ball.
     * @param r     - the radius of the ball.
     * @param color - the color of the ball.
     */
    public Ball(int x, int y, int r, java.awt.Color color) {
        this.center = new Point(x, y);
        this.r = r;
        this.color = color;
    }

    /**
     * full constructor Ball.
     *
     * @param center - the center of the ball.
     * @param r      - the radius of the ball.
     * @param color  - the color of the ball.
     * @param pStart - the start point of the frame.
     * @param pEnd   - the end point of the frame.
     * @param ge     - the game environment.
     */
    public Ball(Point center, int r, java.awt.Color color, Point pStart, Point pEnd, GameEnvironment ge) {
        //checks if the X&Y index of the center is right to the frame size
        if (center.getX() < pStart.getX() || center.getX() > pEnd.getX() || center.getY() < pStart.getY()
                || center.getY() > pEnd.getY()) {
            this.center = new Point((int) pStart.getX() + r, (int) pStart.getY() + r);
        } else {
            this.center = center;
        }
        this.r = r;
        this.color = color;
        this.pStart = pStart;
        this.pEnd = pEnd;
        this.ge = ge;
    }

    /**
     * .
     * Ball - constructor of a ball
     *
     * @param point - the point
     * @param i     - the radius size
     */
    public Ball(Point point, int i) {
        this.center = point;
        this.r = i;
    }

    /**
     * .
     * getX -- Return the x value of the center of the ball
     *
     * @return x - the x value of the center of the ball
     */
    public int getX() {
        return (int) this.center.getX();
    }

    /**
     * .
     * getY -- Return the y value of the center of the ball
     *
     * @return y - the y value of the center of the ball
     */
    public int getY() {
        return (int) this.center.getY();
    }

    /**
     * .
     * getSize -- Return the size of the ball
     *
     * @return area - pie multiply the radius powered by 2.
     */
    public int getSize() {
        return this.r;
    }

    /**
     * .
     * getColor -- Return the color of the ball
     *
     * @return color - the color of the ball.
     */
    public java.awt.Color getColor() {
        return this.color;
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(color);
        d.fillCircle((int) this.center.getX(), (int) this.center.getY(), this.r);
        d.setColor(Color.black);
        d.drawCircle((int) this.center.getX(), (int) this.center.getY(), this.r);
    }

    /**
     * .
     * setVelocity -- set the velocity
     *
     * @param v1 - the velocity to set.
     */
    public void setVelocity(Velocity v1) {
        this.v = v1;
    }

    /**
     * .
     * setVelocity -- set the velocity
     *
     * @param dx - the change in the x index
     * @param dy - the change in the y index
     */
    public void setVelocity(int dx, int dy) {

        this.v = new Velocity(dx, dy);
    }

    /**
     * .
     * getVelocity -- Return the Velocity
     *
     * @return v - the value of the Velocity of the ball
     */
    public Velocity getVelocity() {

        return this.v;
    }

    /**
     * .
     * createRandomColor -- create random color for the ball
     * <p>
     * has to be static because we want to generate the color
     * before we have the object.
     *
     * @return color - random color
     */
    public static Color createRandomColor() {
        Random rand = new Random();
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();
        return new Color(r, g, b);
    }

    /**
     * .
     * moveOneStep -- move the ball one step
     * checks if the ball is touching the border and change his velocity
     */
    public void moveOneStep() {
        //if the velocity in Dx and Dy is equal to 0
        if (this.v.getDx() == 0 && this.v.getDy() == 0) {
            return;
        }
        //calculate the course of the ball
        Line l1 = trajectoryOfBall();
        CollisionInfo colInfo = ge.getClosestCollision(l1);
        //if there is no hits with any object
        if (colInfo.collisionPoint() == null) {
            this.center = this.getVelocity().applyToPoint(this.center);
            return;
        }
        this.center = new Point(colInfo.collisionPoint().getX() - this.v.getDx(),
                colInfo.collisionPoint().getY() - this.v.getDy());
        //if there is a hit , it will change his course
        this.v = colInfo.collisionObject().hit(this, colInfo.collisionPoint(), this.v);
        //the new center of the ball (his new position)

    }

    /**
     * .
     * trajectoryOfBall - calculate the path of the ball
     *
     * @return - the line of the ball
     */
    private Line trajectoryOfBall() {
        //the new temp after adding the velocity
        Point tempP = new Point(this.center.getX() + this.v.getDx(), this.center.getY() + this.v.getDy());
        return new Line(this.center, tempP);
    }

    /**
     * .
     * speedToSize -- create a speed to the ball according to his size
     *
     * @param r1 - the radius of the ball
     * @return velocity - the speed according to the ball size
     */
    public int speedToSize(String r1) {
        int radius = Integer.parseInt(r1);
        if (radius >= MAX_SIZE) {
            return 1;
        }
        return MAX_SPEED - (int) Math.sqrt(radius);
    }

    /**
     * .
     * generateRandomBall -- generate new ball
     *
     * @param sizeBall - the size of the ball to generate
     * @param xStart   - the start index of the width frame
     * @param xEnd     - the end index of the width frame
     * @param yStart   - the start index of the height frame
     * @param yEnd     - the end index of the height frame
     * @return newBall - the new ball
     */
    public static Ball generateRandomBall(String sizeBall, int xStart, int xEnd, int yStart, int yEnd) {
        //checks if the ball is larger than the size of the frame
        int radiusBall = checksFrameToSize(sizeBall, xStart, xEnd, yStart, yEnd);
        //creating new Point for the center of the ball
        Point p;
        if (radiusBall == (xEnd - xStart) / 2 || radiusBall == (yEnd - yStart) / 2) {
            p = new Point((xEnd + xStart) / 2, (yEnd + yStart) / 2);
        } else {
            p = Point.generateRandomPoint(radiusBall, xStart, xEnd, yStart, yEnd);
        }
        //creating new ball
        Point p1 = new Point(xStart, yStart);
        Point p2 = new Point(xEnd, yEnd);
        Ball newBall = new Ball(p, radiusBall, Color.getColor("", Ball.createRandomColor()), p1, p2, null);
        //setting his velocity
        newBall.setVelocity(newBall.speedToSize(sizeBall), newBall.speedToSize(sizeBall));
        return newBall;
    }

    /**
     * .
     * checksFrameToSize -- checks if the radius is valid to the frame size
     * and also create the radius accordingly
     * <p>
     * return the radius of the ball according to the limits of the frame
     *
     * @param sizeBall - the size of the ball to generate
     * @param xStart   - the start index of the width frame
     * @param xEnd     - the end index of the width frame
     * @param yStart   - the start index of the height frame
     * @param yEnd     - the end index of the height frame
     * @return radius - the new radius
     */
    public static int checksFrameToSize(String sizeBall, int xStart, int xEnd, int yStart, int yEnd) {
        int radius = Integer.parseInt(sizeBall);
        if (radius * 2 > xEnd - xStart && radius * 2 > yEnd - yStart) {
            return Math.min((xEnd - xStart) / 2, (yEnd - yStart) / 2);
        }
        if (radius * 2 > xEnd - xStart) {
            return (xEnd - xStart) / 2;
        }
        if (radius * 2 > yEnd - yStart) {
            return (yEnd - yStart) / 2;
        }
        return radius;

    }

    /**
     * .
     * generateRandomBalls -- generate array of balls
     * <p>
     * create array of new balls in the sizes from numBalls and the
     * center in the frame
     *
     * @param numBalls - the sizes of the ball to generate
     * @param xStart   - the start index of the width frame
     * @param xEnd     - the end index of the width frame
     * @param yStart   - the start index of the height frame
     * @param yEnd     - the end index of the height frame
     * @return arrBalls - array of the new balls
     */
    public static Ball[] generateRandomBalls(String[] numBalls, int xStart, int xEnd, int yStart, int yEnd) {
        //an array of balls
        Ball[] arrBall = new Ball[numBalls.length];
        //loop for every argument that contain ball information - for the first frame
        for (int i = 0; i < numBalls.length; i++) {
            arrBall[i] = generateRandomBall(numBalls[i], xStart, xEnd, yStart, yEnd);
        }
        return arrBall;
    }

    /**
     * .
     * toString -- prints the Point
     *
     * @return a string with the ball info
     */
    public String toString() {
        return "Point{" + "x=" + this.getX() + ", y=" + this.getY() + "} " + this.v;
    }

    /**
     * .
     * getCenter - get the center of the ball
     *
     * @return - the center of the ball
     */
    public Point getCenter() {
        return this.center;
    }

    /**
     * .
     * setGameEnvironment - set the game environment of the ball
     *
     * @param ge1 - the game environment of the ball
     */
    public void setGameEnvironment(GameEnvironment ge1) {
        this.ge = ge1;
    }

    @Override
    public void timePassed() {
        this.moveOneStep();
    }

    /**
     * .
     * addToGame - add the object to the game
     *
     * @param g - the game
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    /**
     * .
     * setCenter - set new center to the ball
     *
     * @param x - the x index
     * @param y -the y index
     */
    public void setCenter(double x, double y) {
        this.center = new Point(x, y);
    }
    /**
     * .
     * removeFromGame - remove the block from the game
     *
     * @param gameLevel - the game to remove the block from
     */
    public void removeFromGame(GameLevel gameLevel) {
        gameLevel.removeSprite(this);
    }
}