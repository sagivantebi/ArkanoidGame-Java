
import biuoop.DrawSurface;

import java.awt.Color;

/**
 * @author SAGIV ANTEBI
 * A class of LevelOneBackground
 * The class that will represent level number Four Background
 */
public class LevelFourBackground implements Sprite {
    //The width and height of the frame
    private static final int WIDTH_FRAME = 800;
    private static final int HEIGHT_FRAME = 600;

    @Override
    public void drawOn(DrawSurface d) {
        Block b = new Block(new Rectangle(new Point(0, 0), WIDTH_FRAME, HEIGHT_FRAME + 50),
                new Color(51, 204, 255));
        b.drawOn(d);
        d.setColor(Color.WHITE);
        d.drawText(WIDTH_FRAME / 32 + 10, HEIGHT_FRAME / 3 + 50, "HAKUN-MATATA", 90);


    }

    @Override
    public void timePassed() {
        return;
    }
}
