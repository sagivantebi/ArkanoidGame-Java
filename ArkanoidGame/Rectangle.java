import java.util.ArrayList;
import java.util.List;
/**
 * @author SAGIV ANTEBI
 * A class of Rectangle
 * The class support basic Rectangle operations - intersectionPoints,getWidth,getHeight.
 */
public class Rectangle {
    private Point upperLeft;
    private int width;
    private int height;
    // 0 - leftBorder | 1 - rightBorder | 2 - upperBorder | 3 - bottomBorder
    private Line[] recBorders;

    /**
     * .
     * Rectangle - Create a new rectangle with location and width/height.
     *
     * @param upperLeft - the upper left point of the rectangle.
     * @param width     - the width of the rectangle.
     * @param height    - the height of the rectangle.
     */
    public Rectangle(Point upperLeft, int width, int height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
        this.recBorders = splitRectangle(upperLeft, width, height);
    }

    /**
     * intersectionPoints - Return a (possibly empty) List of intersection points
     * with the specified line.
     *
     * @param line - the line to check the intersection with
     * @return a list of the intersection points
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        //the list of the intersections points of the rectangle with the line
        List<Point> listOfPoints = new ArrayList<Point>();
        //for loop for every border(line) of the rectangle - to check intersection
        for (Line l : recBorders) {
            //the intersection point
            Point intersectPoint = line.intersectionWith(l);
            //checks if the intersection point is not null - if so it will add to the list
            if (intersectPoint != null) {
                listOfPoints.add(intersectPoint);
            }
        }
        return listOfPoints;
    }

    /**.
     * splitRectangle - the function splits the rectangle borders
     * into 4 different lines
     * @param upperLeft - the upper left point
     * @param width     - the rectangle width
     * @param height    - the rectangle height
     * @return an array of 4 lines of the rectangle
     */
    public static Line[] splitRectangle(Point upperLeft, double width, double height) {
        Line[] lines = new Line[4];
        //the leftBorder line
        Point pStart;
        Point pEnd = new Point(upperLeft.getX(), upperLeft.getY() + height);
        lines[0] = new Line(upperLeft, pEnd);
        //the rightBorder line
        pStart = new Point(upperLeft.getX() + width, upperLeft.getY());
        pEnd = new Point(upperLeft.getX() + width, upperLeft.getY() + height);
        lines[1] = new Line(pStart, pEnd);
        //the upperBorder line
        pStart = new Point(upperLeft.getX(), upperLeft.getY());
        pEnd = new Point(upperLeft.getX() + width, upperLeft.getY());
        lines[2] = new Line(pStart, pEnd);
        //the bottomBorder line
        pStart = new Point(upperLeft.getX(), upperLeft.getY() + height);
        pEnd = new Point(upperLeft.getX() + width, upperLeft.getY() + height);
        lines[3] = new Line(pStart, pEnd);
        return lines;
    }

    /**
     * .
     * getWidth
     *
     * @return the width of the rectangle
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * .
     * getHeight
     *
     * @return the height of the rectangle
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * .
     * getUpperLeft
     *
     * @return the upper-left point of the rectangle.
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }

    /**
     * .
     * getRecArrayLines - return the array of the rectangle borders
     *
     * @return - an array of the lines of the rectangle
     */
    public Line[] getRecArrayLines() {
        return this.recBorders;
    }

    /**.
     * setNewUpperLeft - set new upper left location
     * @param change - the velocity change of the ball.
     */
    public void setNewUpperLeft(int change) {
        this.upperLeft = new Point(this.getUpperLeft().getX() + change, this.getUpperLeft().getY());
    }
}
