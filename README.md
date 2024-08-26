
# Arkanoid Game - Java Project

This project is a Java implementation of the classic Arkanoid game. The game involves controlling a paddle to bounce a ball and break blocks arranged in patterns. This project includes multiple levels, animations, and a scoring system.



https://user-images.githubusercontent.com/84729141/164450051-43c49ef4-7346-4d61-807a-256202cdf7d4.mp4


## Project Structure

- **Animation.java / AnimationRunner.java**: Handles the animation logic and the main game loop that runs the game animations.
- **Ass6Game.java**: The main class to start the game.
- **Ball.java**: Represents the ball in the game, including its movement and collision detection.
- **Block.java**: Represents the blocks that the ball needs to hit to score points.
- **Paddle.java**: Represents the paddle that the player controls to bounce the ball.
- **GameLevel.java**: Manages the different levels of the game, including setting up the level environment, initializing blocks, and handling level progression.
- **LevelOne.java, LevelTwo.java, LevelThree.java, LevelFour.java**: Defines the specific settings for each level, including block arrangements, backgrounds, and difficulty.
- **Sprite.java / SpriteCollection.java**: Manages the sprites (game objects) in the game, including drawing and updating them.
- **CollisionInfo.java / GameEnvironment.java**: Handles collision detection between the ball and other objects.
- **HitListener.java / HitNotifier.java**: Manages events related to when blocks or other objects are hit by the ball.
- **ScoreIndicator.java / ScoreTrackingListener.java**: Handles the game's scoring system, updating the score when blocks are hit.
- **PauseScreen.java / EndScreen.java / WinScreen.java**: Manages the different screens that appear during the game, such as pause, end game, and win screens.
- **biuoop-1.4.jar**: A JAR file that may be required for running the game, possibly providing additional utilities or libraries.

## Prerequisites

- **Java Development Kit (JDK)**: Make sure the JDK is installed on your machine.
- **biuoop-1.4.jar**: Ensure this JAR file is included in the classpath when compiling and running the game.

## How to Compile and Run

1. **Navigate to the project directory**:
   ```bash
   cd ArkanoidGame-Java-main/ArkanoidGame
   ```

2. **Compile the game**:
   ```bash
   javac -cp .:biuoop-1.4.jar *.java
   ```

   This command compiles all the Java files in the project, including the necessary JAR file in the classpath.

3. **Run the game**:
   ```bash
   java -cp .:biuoop-1.4.jar Ass6Game
   ```

   This command starts the game, and you can begin playing the Arkanoid game.

## Game Features

- **Multiple Levels**: The game includes several levels, each with its unique layout and difficulty.
- **Scoring System**: Players earn points by breaking blocks, and the score is tracked throughout the game.
- **Pause and End Screens**: The game includes functionality to pause the game, as well as end screens to show the player's final score.



