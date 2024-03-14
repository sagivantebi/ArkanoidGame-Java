
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;


/**
 * @author SAGIV ANTEBI
 * A class of LevelFour
 * The class that will represent level number Four
 */
public class LevelFour implements LevelInformation {
    private static final int WIDTH = 49;
    private static final int HEIGHT = 30;
    //The width and height of the frame
    private static final int WIDTH_FRAME = 800;
    private static final int HEIGHT_FRAME = 600;

    @Override
    public int numberOfBalls() {
        return 1;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> v = new ArrayList<Velocity>();
        v.add(new Velocity(0, 7));
        return v;
    }

    @Override
    public int paddleSpeed() {
        return 10;
    }

    @Override
    public int paddleWidth() {
        return 100;
    }

    @Override
    public String levelName() {
        return "Level 4 : Final Round!";
    }

    @Override
    public Sprite getBackground() {
        return new LevelFourBackground();
    }

    @Override
    public List<Block> blocks() {
        List<Block> listBlocks = new ArrayList<Block>();
        Color[] colors = new Color[7];
        colors[0] = Color.GRAY;
        colors[1] = Color.RED;
        colors[2] = Color.YELLOW;
        colors[3] = Color.BLUE;
        colors[4] = Color.PINK;
        colors[5] = Color.GREEN;
        colors[6] = Color.WHITE;
        for (int j = 0; j < 7; j++) {
            for (int i = 0; i < 15; i++) {
                Block block = new Block((new Rectangle(new Point((WIDTH * i) + 32,
                        (HEIGHT_FRAME / 3) - 120 + j * HEIGHT), WIDTH, HEIGHT)),
                        colors[j]);
                listBlocks.add(block);
            }
        }

        return listBlocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 105;
    }
}
