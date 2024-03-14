
import biuoop.DrawSurface;

import java.awt.Color;

/**
 * @author SAGIV ANTEBI
 * A class of LevelOneBackground
 * The class that will represent level number One Background
 */
public class LevelOneBackground implements Sprite {
    //The width and height of the frame
    private static final int WIDTH_FRAME = 800;
    private static final int HEIGHT_FRAME = 600;

    @Override
    public void drawOn(DrawSurface d) {
        Block b = new Block(new Rectangle(new Point(0, 0), WIDTH_FRAME, HEIGHT_FRAME + 50), Color.black);
        b.drawOn(d);
        d.setColor(Color.blue);
        d.drawCircle(WIDTH_FRAME / 2, HEIGHT_FRAME / 2 - 80, 125);
        d.drawCircle(WIDTH_FRAME / 2, HEIGHT_FRAME / 2 - 80, 100);
        d.drawCircle(WIDTH_FRAME / 2, HEIGHT_FRAME / 2 - 80, 75);
        //left line
        d.drawLine((WIDTH_FRAME / 2) - 150, HEIGHT_FRAME / 2 - 80, (WIDTH_FRAME / 2) - 50, HEIGHT_FRAME / 2 - 80);
        //right line
        d.drawLine((WIDTH_FRAME / 2) + 50, HEIGHT_FRAME / 2 - 80, (WIDTH_FRAME / 2) + 150, HEIGHT_FRAME / 2 - 80);
        //upper line
        d.drawLine((WIDTH_FRAME / 2), HEIGHT_FRAME / 2 - 220, (WIDTH_FRAME / 2), HEIGHT_FRAME / 2 - 120);
        //bottom line
        d.drawLine((WIDTH_FRAME / 2), HEIGHT_FRAME / 2 - 30, (WIDTH_FRAME / 2), HEIGHT_FRAME / 2 + 70);
    }

    @Override
    public void timePassed() {
        return;
    }
}
