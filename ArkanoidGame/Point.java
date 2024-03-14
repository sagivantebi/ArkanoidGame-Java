import java.util.Random;

/**
 * @author SAGIV ANTEBI
 * A class of Point
 * The class support basic point operations - distance,equals,getX,getY.
 */
public class Point {
    // EPSILON - helps compare between doubles in java
    public static final double EPSILON = Math.pow(10, -15);
    // Fields - (x,y) represent the Location of the point
    private double x;
    private double y;
    /**.
     * constructor Point
     *
     * @param x - the x index of the point
     * @param y - the y index of the point
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    /**
     * distance -- return the distance of this point to the other point.
     *
     * @param other the other point.
     * @return the distance of this point to the other point.
     */
    public double distance(Point other) {
        //the equation to find the distance without the square root
        double equation = ((this.x - other.x) * (this.x - other.x) + ((this.y - other.y) * (this.y - other.y)));
        //checks if the equation is negative
        if (equation < 0) {
            return Math.sqrt(-1 * equation);
        }
        return Math.sqrt(equation);
    }
    /**.
     * equals -- return true is the points are equal, false otherwise
     *
     * @param other the other point.
     * @return 'true' if the point are equals, 'false' otherwise.
     */
    public boolean equals(Point other) {
        return (Math.abs(this.x - other.x) < EPSILON) && (Math.abs(this.y - other.y) < EPSILON);
    }
    /**.
     * getX -- Return the x value of this point
     *
     * @return x - the x value of this point
     */
    public double getX() {
        return this.x;
    }

    /**.
     * getY -- Return the y value of this point
     *
     * @return y - the y value of this point
     */
    public double getY() {
        return this.y;
    }

    /**.
     * setX -- set the new value in x
     *
     * @param x1 - set the y value of this point
     */
    public void setX(double x1) {
        this.x = x1;
    }
    /**.
     * setY -- set the new value in y
     *
     * @param y1 - set the y value of this point
     */
    public void setY(double y1) {
        this.y = y1;
    }

    /**.
     * toString -- prints the Point
     *
     * @return a string with the point info
     */
    public String toString() {
        return "Point{" + "x=" + this.getX() + ", y=" + this.getY() + '}';
    }

    /**.
     * generateRandomPoint -- creates new Point with random indexes for the ball
     *
     * x1 - integer in range xStart-xEnd
     * y2 - integer in range yStart-yEnd
     *
     * @param radius - the radius of the ball
     * @param xStart - the start index of the width frame
     * @param xEnd - the end index of the width frame
     * @param yStart - the start index of the height frame
     * @param yEnd - the end index of the height frame
     * @return the new Point
     */
    public static Point generateRandomPoint(int radius, int xStart, int xEnd, int yStart, int yEnd) {
        Random rand = new Random(); // create a random-number generator
        double x1, y1;
        //generate the random x index for the point
        x1 = xEnd - rand.nextInt(xEnd - xStart); // get integer in range xStart-xEnd
        //checks if the index + radius is bigger than the xEnd
        if (x1 + radius >= xEnd) {
            x1 -= radius;
        }
        //checks if the index - radius is smaller than the xStart
        if (x1 - radius <= xStart) {
            x1 += radius;
        }
        //generate the random y index for the point
        y1 = yEnd - rand.nextInt(yEnd - yStart); // get integer in range yStart-yEnd
        //checks if the index + radius is bigger than the yEnd
        if (y1 + radius >= yEnd) {
            y1 -= radius;
        }
        //checks if the index - radius is smaller than the yStart
        if (y1 - radius <= yStart) {
            y1 += radius;
        }
        return new Point(x1, y1);
    }
}
