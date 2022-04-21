// ID: 318159282

import java.util.ArrayList;
import java.util.List;

/**
 * @author SAGIV ANTEBI
 * A class of Ass5Game
 * The class is the main class of ass5
 */
public class Ass6Game {
    private static final String NUN_LEVELS = "[1-4]";

    /**
     * .
     * main
     *
     * @param args - no args required
     */
    public static void main(String[] args) {
        runGame(args);
    }

    /**.
     * getLevelInfo - return the level information according to index
     * @param num - num of level
     * @return the LevelInformation according to the index
     */
    public static LevelInformation getLevelInfo(int num) {
        if (num == 0) {
            return new LevelOne();
        } else if (num == 1) {
            return new LevelTwo();
        } else if (num == 2) {
            return new LevelThree();
        } else if (num == 3) {
            return new LevelFour();
        }
        return null;
    }

    /**.
     * runGame - runs the function in the main
     * @param args - args from main (the order of levels)
     */
    private static void runGame(String[] args) {
        List<Integer> listLevelsNumbers = new ArrayList<Integer>();
        //loop to go check every argument passed by the user
        for (String num : args) {
            //checks if the input matches the levels
            if (num.matches(NUN_LEVELS)) {
                listLevelsNumbers.add(Integer.parseInt(num) - 1);
            }
        }
        List<LevelInformation> levelInformations = new ArrayList<LevelInformation>();
        // checks if the list is empty
        if (listLevelsNumbers.size() == 0) {
            levelInformations.add(new LevelOne());
            levelInformations.add(new LevelTwo());
            levelInformations.add(new LevelThree());
            levelInformations.add(new LevelFour());
        } else {
            for (Integer num : listLevelsNumbers) {
                levelInformations.add(getLevelInfo(num));
            }
        }

        // runs the animation
        AnimationRunner animationRunner = new AnimationRunner();
        biuoop.KeyboardSensor keyboard = animationRunner.getKeyboard();
        GameFlow gameFlow = new GameFlow(animationRunner, keyboard);
        gameFlow.runLevels(levelInformations);
        return;

    }
}
