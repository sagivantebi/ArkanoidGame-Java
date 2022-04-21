import java.util.List;
// ID: 318159282

/**
 * @author SAGIV ANTEBI
 * A class of Line
 * The class support basic Line operations - lenght,middle,isIntersecting,intersectionWith,equals
 */
public class Line {
    // EPSILON - helps compare between doubles in java
    public static final double EPSILON = Math.pow(10, -10);
    public static final double INF = Double.POSITIVE_INFINITY;
    // Fields - Point start,end - are the two points of the line
    //          (x1,y1) represents the Location of the start point
    //          (x2,y2) represents the Location of the end point
    private Point start;
    private Point end;
    private double m; //the line slope
    private double c; //the line constant
    // constructors

    /**
     * constructor line.
     *
     * @param start - the start point.
     * @param end   - the end point.
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
        slopeConstCal();
    }

    /**
     * constructor line.
     * <p>
     * checks which of the point is the start point and which is the end point
     *
     * @param x1 - start x index.
     * @param y1 - start y index.
     * @param x2 - end x index.
     * @param y2 - end y index.
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
        slopeConstCal();

    }

    /**
     * .
     * Help method to constructor
     * <p>
     * this function will create and insert the slope and constant of the line
     */
    public void slopeConstCal() {
        if (isDoubleEqual(this.start.getX(), this.end.getX())) {
            this.m = INF;
            this.c = 0;
        } else if (isDoubleEqual(this.start.getY(), this.end.getY())) {
            this.m = 0;
            this.c = this.start.getY();
            //the slope of the first line
        } else {

            this.m = ((this.end.getY() - this.start.getY()) / (this.end.getX() - this.start.getX()));
            //the constant of the first line
            this.c = this.start.getY() - (this.m * this.start.getX());
        }
    }

    /**
     * .
     * length -- Return the length of the line
     *
     * @return the length of the line
     */
    public double length() {
        return this.start.distance(this.end);
    }

    /**
     * middle -- Returns the middle point of the line
     * <p>
     * using a simple math trick.
     * (x1+x2)/2 = mid x
     * (y1+y2)/2 = mid y
     * (mid x , mid y) = mid point
     *
     * @return the middle point of the line
     */
    public Point middle() {
        double midX = (this.start.getX() + this.end.getX()) / 2;
        double midY = (this.start.getY() + this.end.getY()) / 2;
        return new Point(midX, midY);
    }

    /**
     * .
     * start -- Return the start point
     *
     * @return start - the start point
     */
    public Point start() {
        return this.start;
    }

    /**
     * .
     * end -- Return the end point
     *
     * @return end - the end point
     */
    public Point end() {
        return this.end;
    }

    /**
     * .
     * isIntersecting -- checks if the two lines intersect
     *
     * @param other the other Line.
     * @return 'true' if the two lines intersect, 'false' otherwise.
     */
    public boolean isIntersecting(Line other) {
        //check if one line is included in the other line
        if (isOneLineOnOther(this, other) && this.m == other.m && this.c == other.c) {
            return true;
        }
        return (!(this.intersectionWith(other) == null));
    }

    /**
     * intersectionWith -- checks if the two lines intersect and return the intersect point.
     * <p>
     * The line equations will be in form of : y = (m * x) + c
     * valueX - the x index of the intersect
     * valueY - the y index of the intersect
     * <p>
     * If the lines are the same it will return null
     * also if one line included the other it will return null
     *
     * @param other the other Line.
     * @return the intersection point if the lines intersect,and null otherwise.
     */
    public Point intersectionWith(Line other) {
        double valueX, valueY;
        //ALL THE EDGE CASES:
        //checks if both lines are points
        if (this.start.equals(this.end) && other.start.equals(other.end)) {
            if (this.start.equals(other.start)) {
                return this.start;
            }
        }
        //checks if the lines are the same
        if (this.equals(other)) {
            return null;
        }
        //checks if this line is a point
        if (this.start.equals(this.end)) {
            return checksPointInLine(this.start, other);
        }
        //checks if the other line is a point
        if (other.start.equals(other.end)) {
            return checksPointInLine(other.start, this);
        }

        //check if both of the lines are vertical
        if (this.m == INF && other.m == INF) {
            if (checksPointInLine(this.start, other) != null) {
                return checksPointInLine(this.end, other);
            }
            if (checksPointInLine(this.start, other) != null) {
                return checksPointInLine(this.end, other);
            }
            return null;
        }

        //checks if this line line is vertical
        if (this.m == INF) {
            return oneLineVertical(this, other);
        }
        //checks if the other line is vertical
        if (other.m == INF) {
            return oneLineVertical(other, this);
        }
        //checks if  their slopes are equal
        if (isDoubleEqual(this.m, other.m) && isDoubleEqual(this.c, other.c)) {
            return sameLineDifferentPoints(this, other);
        }
        //END OF EDGE CASES
        //checks for an intersection point
        valueX = (other.c - this.c) / (this.m - other.m);
        valueY = this.m * valueX + this.c;
        Point p1 = new Point(valueX, valueY);
        //Eight If's statements to check if the intersection point appears in the lines
        //checks if the valueX is larger than the maximum point of this
        if (!this.checkPointHitLine(new Point(valueX, valueY))) {
            return null;
        }
        if (!other.checkPointHitLine(new Point(valueX, valueY))) {
            return null;
        }
        return p1;
    }

    /**
     * .
     * sameLineDifferentPoints -- checks if they are both have the same line equation
     * <p>
     * if one line includes the other it will return null
     *
     * @param l1 the first Line.
     * @param l2 the second line
     * @return the intersection point if the lines intersect,and null otherwise.
     */
    private Point sameLineDifferentPoints(Line l1, Line l2) {
        //checks if they meet only in the edge points
        if (Math.abs(l1.start.getX() - l2.end.getX()) < EPSILON) {
            return l1.start;
        }
        if (Math.abs(l1.end.getX() - l2.start.getX()) < EPSILON) {
            return l1.end;
        }
        //checks if they start together
        if (Math.abs(l1.start.getX() - l2.start.getX()) < EPSILON) {
            return null;
        }
        //checks if they are end together
        if (Math.abs(l1.end.getX() - l2.end.getX()) < EPSILON) {
            return null;
        }
        //check if one line is included in the other line
        if (isOneLineOnOther(l1, l2)) {
            return null;
        }
        return l1.start;
    }

    /**
     * .
     * isOneLineOnOther - checks if the one line is over the other one
     *
     * @param l1 - the first Line
     * @param l2 - the second Line
     * @return true - if one line is on another | false - otherwise
     */
    public boolean isOneLineOnOther(Line l1, Line l2) {
        //check if this second is included in the first line
        if (l1.start.getX() < l2.start.getX() && l1.end.getX() > l2.start.getX()) {
            return true;
        }
        if (l1.start.getX() < l2.end.getX() && l1.end.getX() > l2.end.getX()) {
            return true;
        }
        //checks if the first line is included in second line
        if (l2.start.getX() < l1.start.getX() && l2.end.getX() > l1.start.getX()) {
            return true;
        }
        if (l2.start.getX() < l1.end.getX() && l2.end.getX() > l1.end.getX()) {
            return true;
        }
        return false;
    }

    /**
     * .
     * oneLineVertical -- checks the edge case if only one line is vertical
     *
     * @param verticalLine the vertical Line.
     * @param regLine      the regular Line.
     * @return the intersection point if the lines intersect,and null otherwise.
     */
    private Point oneLineVertical(Line verticalLine, Line regLine) {
        double valueX, valueY;
        valueX = verticalLine.start.getX();
        valueY = valueX * regLine.m + regLine.c;
        //checks if the point is larger than the highest value of the vertical line
        if (valueY > Math.max(verticalLine.start.getY(), verticalLine.end.getY())) {
            return null;
        }
        //checks if the point is smaller than the lowest value of the vertical line
        if (valueY < Math.min(verticalLine.start.getY(), verticalLine.end.getY())) {
            return null;
        }
        Point p = new Point(valueX, valueY);
        return checksPointInLine(p, regLine);
    }

    /**
     * checksPointInLine -- checks if the Point and the line intersect and return the intersect point.
     *
     * @param p1 the Point
     * @param l  the Line.
     * @return the intersection point if the lines intersect,and null otherwise.
     */
    public static Point checksPointInLine(Point p1, Line l) {
        double valueX, valueY;
        if (!l.checkPointHitLine(p1)) {
            return null;
        }
        valueX = p1.getX();
        valueY = valueX * l.m + l.c;
        Point p2 = new Point(valueX, valueY);
        if (p1.equals(p2)) {
            return p1;
        }
        return null;
    }

    /**
     * .
     * checkPointHitLine - checks if the point hit the line
     *
     * @param p - the point
     * @return true if the point hit the line | false otherwise
     */
    public Boolean checkPointHitLine(Point p) {
        double disLine = start.distance(end);
        double disLine1 = p.distance(end);
        double disLine2 = start.distance(p);
        if (Math.abs(disLine1 + disLine2 - disLine) < EPSILON) {
            return true;
        }
        return false;

    }

    /**
     * .
     * IsDoubleEqual - checks for two doubles number if they are equal
     *
     * @param d1 - first num
     * @param d2 - second num
     * @return - true - if they are equal | false otherwise
     */
    public static boolean isDoubleEqual(double d1, double d2) {
        return Math.abs(d1 - d2) < EPSILON;
    }

    /**
     * .
     * equals -- return true is the points are equal, false otherwise
     *
     * @param other the other Line.
     * @return 'true' if the Line are equals, 'false' otherwise.
     */
    public boolean equals(Line other) {
        return (this.start().equals(other.start) && this.end.equals(other.end));
    }

    /**
     * closestIntersectionToStartOfLine - return the closest intersection point to the start of the line.
     *
     * @param rect - the rectangle
     * @return the closest intersection point to the start of the line, otherwise null
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        //the list of the intersections points of the rectangle with the line
        List<Point> listOfPoints = rect.intersectionPoints(this);
        //checks if the list is empty
        if (listOfPoints.isEmpty()) {
            return null;
        }
        //checks if there is only one line
        if (listOfPoints.size() == 1) {
            return listOfPoints.get(0);
        }
        //checks if there is two line , than check who is bigger
        if (Math.abs(listOfPoints.get(0).distance(this.start) - listOfPoints.get(1).distance(this.start)) > EPSILON) {
            return listOfPoints.get(1);
        }
        return listOfPoints.get(0);
    }

    /**
     * .
     * toString -- prints the Line
     *
     * @return a string with the point info
     */
    public String toString() {
        return this.start.toString() + this.end.toString();
    }
}