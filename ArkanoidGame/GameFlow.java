import biuoop.KeyboardSensor;

import java.util.List;
// ID: 318159282

/**
 * @author SAGIV ANTEBI
 * A class of GameFlow
 * The class will run all the stages
 */
public class GameFlow {
    private KeyboardSensor keyboardSensor;
    private AnimationRunner animationRunner;
    private Counter score;

    /**
     * .
     * GameFlow - constructor
     *
     * @param ar - the animation rummer
     * @param ks - the keyboard sensor
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks) {
        this.animationRunner = ar;
        this.keyboardSensor = ks;
        this.score = new Counter();
    }

    /**
     * .
     * runLevels - the function that run the levels in the list
     *
     * @param levels - list of the levels to run
     */
    public void runLevels(List<LevelInformation> levels) {
        int countWin = 0;
        ScoreIndicator scoreIndicator = null;
        int lastScore = 0;
        for (LevelInformation levelInfo : levels) {
            countWin++;
            scoreIndicator = new ScoreIndicator(this);
            GameLevel level = new GameLevel(levelInfo, this.keyboardSensor, this.animationRunner, scoreIndicator);
            level.getScore().increase(lastScore);
            this.score = level.getScore();
            level.addSprite(scoreIndicator);
            level.initialize();
            while (level.getNumBalls() != 0 && level.getNumBlocks() != 0) {
                level.run();
                lastScore = this.score.getValue();
            }
            //when all the balls are out of the screen the player lost
            if (level.getNumBalls() == 0) {
                break;
            }

        }
        //need to implement if the user won
        if (countWin == levels.size()) {
            GameLevel level = new GameLevel(levels.get(0), this.keyboardSensor, this.animationRunner, scoreIndicator);
            level.showWinScreen(this.score);
        }
        this.animationRunner.closeGui();
    }

    /**.
     * getScore - return the score
     * @return the score
     */
    public Counter getScore() {
        return score;
    }
}

