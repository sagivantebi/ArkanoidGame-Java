
import biuoop.DrawSurface;

import java.awt.Color;

/**
 * @author SAGIV ANTEBI
 * A class of LevelTwoBackground
 * The class that will represent level number Two Background
 */
public class LevelTwoBackground implements Sprite {
    //The width and height of the frame
    private static final int WIDTH_FRAME = 800;
    private static final int HEIGHT_FRAME = 600;

    @Override
    public void drawOn(DrawSurface d) {
        Block b = new Block(new Rectangle(new Point(0, 0), WIDTH_FRAME, HEIGHT_FRAME + 50), Color.pink);
        b.drawOn(d);
        d.setColor(new Color(255, 255, 157));
        d.fillCircle(WIDTH_FRAME / 3, HEIGHT_FRAME / 2 - 150, 75);
        for (int i = -250; i < 500; i += 5) {
            d.drawLine(WIDTH_FRAME / 3, HEIGHT_FRAME / 2 - 150, (WIDTH_FRAME / 3) + i, (HEIGHT_FRAME / 2) - 20);
        }
        d.setColor(new Color(241, 241, 98));
        d.fillCircle(WIDTH_FRAME / 3, HEIGHT_FRAME / 2 - 150, 65);
        //set color to yellow
        d.setColor(new Color(255, 255, 0));
        //the circle
        d.fillCircle(WIDTH_FRAME / 3, HEIGHT_FRAME / 2 - 150, 55);
        d.setColor(new Color(255, 255, 157));
    }

    @Override
    public void timePassed() {
        return;
    }
}
