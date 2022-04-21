import biuoop.DrawSurface;

import java.awt.Color;
// ID: 318159282

/**
 * @author SAGIV ANTEBI
 * A class of LevelName
 * The class that will hold the level name
 */
public class LevelName implements Sprite {
    private LevelInformation levelInformation;

    /**.
     * LevelName - constructor
     * @param levelInformation - the information of the level name
     */
    public LevelName(LevelInformation levelInformation) {
        this.levelInformation = levelInformation;
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.BLACK);
        //NEED TO WRITE THE Level Name
        d.drawText(500, 15, this.levelInformation.levelName(), 15);
    }

    @Override
    public void timePassed() {
        return;
    }
}
