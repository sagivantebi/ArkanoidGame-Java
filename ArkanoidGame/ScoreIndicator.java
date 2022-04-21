import biuoop.DrawSurface;

import java.awt.Color;
// ID: 318159282

/**
 * @author SAGIV ANTEBI
 * A class of ScoreIndicator
 * The class will show the score of the game
 */
public class ScoreIndicator implements Sprite {
    //The width and height of the frame
    private static final int WIDTH_FRAME = 800;
    private static final int HEIGHT_FRAME = 600;
    private GameFlow gameFlow;

    /**
     * .
     * Constructor of the ScoreIndicator
     *
     * @param gameFlow - the game to draw the score in
     */
    public ScoreIndicator(GameFlow gameFlow) {
        this.gameFlow = gameFlow;
    }

    @Override
    public void drawOn(DrawSurface d) {
        //draw the rectangle of the score
        d.setColor(Color.WHITE);
        d.fillRectangle(0, 0, WIDTH_FRAME, 20);
        d.setColor(Color.BLACK);
        d.drawRectangle(0, 0, WIDTH_FRAME, 20);
        //NEED TO WRITE THE SCORE IN
        d.drawText(350, 15, "Score: " + Integer.toString(this.gameFlow.getScore().getValue()), 15);

    }

    @Override
    public void timePassed() {
        return;
    }
}
