
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * @author SAGIV ANTEBI
 * A class of LevelTwo
 * The class that will represent level number Two
 */
public class LevelTwo implements LevelInformation {
    private static final int WIDTH = 49;
    private static final int HEIGHT = 30;
    //The width and height of the frame
    private static final int WIDTH_FRAME = 800;
    private static final int HEIGHT_FRAME = 600;
    private static final int HEARTS_POSITION = 360;

    @Override
    public int numberOfBalls() {
        return 20;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> v = new ArrayList<Velocity>();
        for (int i = 0; i < 10; i++) {
            v.add(new Velocity(-i, 10 - i));
            v.add(new Velocity(i, 10 - i));

        }
        return v;
    }

    @Override
    public int paddleSpeed() {
        return 10;
    }

    @Override
    public int paddleWidth() {
        return 500;
    }

    @Override
    public String levelName() {
        return "Level 2 : Just For Fun!";
    }

    @Override
    public Sprite getBackground() {
        return new LevelTwoBackground();
    }

    @Override
    public List<Block> blocks() {
        List<Block> listBlocks = new ArrayList<Block>();

        for (int i = 0; i < 15; i++) {
            Block block = new Block((new Rectangle(new Point((WIDTH * i) + 32,
                    (HEIGHT_FRAME / 2) - 20), WIDTH, HEIGHT)),
                    Color.white);
            listBlocks.add(block);

        }

        return listBlocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 15;
    }

}
