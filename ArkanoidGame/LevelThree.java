
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * @author SAGIV ANTEBI
 * A class of LevelThree
 * The class that will represent level number Three
 */
public class LevelThree implements LevelInformation {
    private static final int WIDTH = 49;
    private static final int HEIGHT = 30;
    //The width and height of the frame
    private static final int WIDTH_FRAME = 800;
    private static final int HEIGHT_FRAME = 600;
    //the numbers of columns and rows of the building (the blocks)
    private static final int COLS = 12;
    private static final int ROWS = 6;

    @Override
    public int numberOfBalls() {
        return 2;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> v = new ArrayList<Velocity>();
        v.add(new Velocity(-1, 6));
        v.add(new Velocity(1, 6));
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
        return "Level 3 : Death Zone";
    }

    @Override
    public Sprite getBackground() {
        return new LevelThreeBackground();
    }

    @Override
    public List<Block> blocks() {
        List<Block> listBlocks = new ArrayList<Block>();
        double valX = WIDTH_FRAME - 30;
        //the blocks colors
        Color[] colors = new Color[6];
        colors[0] = Color.GRAY;
        colors[1] = Color.RED;
        colors[2] = Color.YELLOW;
        colors[3] = Color.BLUE;
        colors[4] = Color.PINK;
        colors[5] = Color.GREEN;
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS - i; j++) {
                Block newBlock = new Block(new Rectangle(new Point(valX - WIDTH * (j + 1), 100 + i * HEIGHT),
                        WIDTH, HEIGHT), colors[i]);
                listBlocks.add(newBlock);

            }
        }
        return listBlocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 57;
    }
}
