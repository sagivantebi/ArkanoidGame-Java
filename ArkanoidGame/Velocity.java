
/**
 * @author SAGIV ANTEBI
 * A class of Velocity
 * Velocity specifies the change in position on the `x` and the `y` axes.
 * The class support basic point operation - applyToPoint.
 */
public class Velocity {
    // dx - the velocity x index
    private double dx = 0;
    // dy - the velocity y index
    private double dy = 0;
    /**
     * .
     * constructor Velocity
     *
     * @param dx - the velocity x index
     * @param dy - the velocity y index
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * .
     * fromAngleAndSpeed - convert the angle and the speed into our velocity constructor
     * <p>
     * dx = cos(angle) * speed
     * dy = sin(angle) * speed
     *
     * @param angle - the ball velocity angle
     * @param speed - the ball speed
     * @return new Velocity
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double radianAngle = Math.toRadians(angle);
        double dx = Math.sin(radianAngle) * speed;
        double dy = Math.cos(radianAngle) * speed;
        return new Velocity(Math.round(dx), Math.round(-dy));
    }

    /**
     * .
     * applyToPoint -- add the velocity to the given point
     * <p>
     * Take a point with position (x,y) and return a new point
     * with position (x+dx, y+dy)
     *
     * @param p - the point to add the velocity.
     * @return new Point with the position of the original point plus velocity
     */
    public Point applyToPoint(Point p) {
        return new Point(p.getX() + this.dx, p.getY() + this.dy);
    }

    /**
     * .
     * getDx -- Return the dx value
     *
     * @return dx -the dx value
     */
    public double getDx() {
        return this.dx;
    }

    /**
     * .
     * getDy -- Return the dy value
     *
     * @return dy -the dy value
     */
    public double getDy() {
        return this.dy;
    }

    /**
     * .
     * toString -- prints the Point
     *
     * @return a string with the velocity info
     */
    public String toString() {
        return "Velocity{" + "x=" + this.getDx() + ", y=" + this.getDy() + '}';
    }
}
