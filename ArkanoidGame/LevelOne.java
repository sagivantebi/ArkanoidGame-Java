
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
// ID: 318159282

/**
 * @author SAGIV ANTEBI
 * A class of LevelOne
 * The class that will represent level number One
 */
public class LevelOne implements LevelInformation {
    private static final int WIDTH = 50;
    private static final int HEIGHT = 50;
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
        v.add(new Velocity(0, 5));
        return v;
    }

    @Override
    public int paddleSpeed() {
        return 10;
    }

    @Override
    public int paddleWidth() {
        return 200;
    }

    @Override
    public String levelName() {
        return "Level 1 : Easy Pizzy!";
    }

    @Override
    public Sprite getBackground() {
        return new LevelOneBackground();
    }

    @Override
    public List<Block> blocks() {
        List<Block> listBlocks = new ArrayList<Block>();
        Block block = new Block((new Rectangle(new Point(WIDTH_FRAME / 2 - 25, 200), WIDTH, HEIGHT)),
                Color.RED);
        listBlocks.add(block);
        return listBlocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 1;
    }

}
