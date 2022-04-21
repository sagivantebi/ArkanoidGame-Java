// ID: 318159282

import biuoop.DrawSurface;

import java.awt.Color;

/**
 * @author SAGIV ANTEBI
 * A class of LevelOneBackground
 * The class that will represent level number Three Background
 */
public class LevelThreeBackground implements Sprite {
    //The width and height of the frame
    private static final int WIDTH_FRAME = 800;
    private static final int HEIGHT_FRAME = 600;

    @Override
    public void drawOn(DrawSurface d) {
        Block b = new Block(new Rectangle(new Point(0, 0), WIDTH_FRAME, HEIGHT_FRAME + 50),
                new Color(57, 248, 166));
        b.drawOn(d);
        //first cloud
        //the rain
        d.setColor(new Color(215, 209, 209));
        for (int i = 5; i < 50; i += 5) {
            d.drawLine((WIDTH_FRAME / 3 - 120) + i, HEIGHT_FRAME - 205, (WIDTH_FRAME / 3 - 150) + i, HEIGHT_FRAME);

        }
        //the clouds
        d.setColor(new Color(215, 209, 209));
        d.fillCircle(WIDTH_FRAME / 3 - 150, HEIGHT_FRAME - 190, 25);
        d.setColor(new Color(191, 189, 189));
        d.fillCircle(WIDTH_FRAME / 3 - 120, HEIGHT_FRAME - 205, 35);
        d.setColor(new Color(187, 185, 185));
        d.fillCircle(WIDTH_FRAME / 3 - 100, HEIGHT_FRAME - 180, 25);
        d.setColor(new Color(193, 185, 185));
        d.fillCircle(WIDTH_FRAME / 3 - 90, HEIGHT_FRAME - 210, 30);
        d.setColor(new Color(191, 189, 189));
        d.fillCircle(WIDTH_FRAME / 3 - 80, HEIGHT_FRAME - 190, 20);
        d.setColor(new Color(173, 171, 171));
        d.fillCircle(WIDTH_FRAME / 3 - 70, HEIGHT_FRAME - 215, 35);

        //second cloud
        d.setColor(new Color(215, 209, 209));
        //the rain
        for (int i = 5; i < 50; i += 5) {
            d.drawLine((WIDTH_FRAME / 3 + 400) + i, HEIGHT_FRAME - 155, (WIDTH_FRAME / 3 + 370) + i, HEIGHT_FRAME);

        }
        //the clouds
        d.setColor(new Color(215, 209, 209));
        d.fillCircle(WIDTH_FRAME / 3 + 450, HEIGHT_FRAME - 190 + 50, 25);
        d.setColor(new Color(191, 189, 189));
        d.fillCircle(WIDTH_FRAME / 3 + 420, HEIGHT_FRAME - 205 + 50, 35);
        d.setColor(new Color(187, 185, 185));
        d.fillCircle(WIDTH_FRAME / 3 + 400, HEIGHT_FRAME - 180 + 50, 25);
        d.setColor(new Color(193, 185, 185));
        d.fillCircle(WIDTH_FRAME / 3 + 390, HEIGHT_FRAME - 210 + 50, 30);
        d.setColor(new Color(191, 189, 189));
        d.fillCircle(WIDTH_FRAME / 3 + 380, HEIGHT_FRAME - 190 + 50, 20);
        d.setColor(new Color(173, 171, 171));
        d.fillCircle(WIDTH_FRAME / 3 + 370, HEIGHT_FRAME - 215 + 50, 35);


    }

    @Override
    public void timePassed() {
        return;
    }
}
