package academy.mindswap;

import academy.mindswap.field.Field;
import academy.mindswap.field.Position;
import academy.mindswap.field.Scoreboard;
import academy.mindswap.gameobjects.fruit.Fruit;
import academy.mindswap.gameobjects.snake.Direction;
import academy.mindswap.gameobjects.snake.Snake;
import com.googlecode.lanterna.input.Key;

public class Game {

    private Snake snake;
    private Fruit fruit;
    private Scoreboard scoreboard;

    private int delay;
/*
para parar é facil
é fazer um input para para o botao p
se o botao p for apertado define o delay para 10000
e quando for apertado de novo definir o deley para o normal
 */

    public Game(int cols, int rows, int delay) {
        Field.init(cols, rows);
        this.snake = new Snake(Direction.RIGHT);
        this.delay = delay;
        this.fruit = new Fruit();
        this.scoreboard = new Scoreboard();
    }

    public void start() throws InterruptedException {

       // while (true) {
        while (snake.isAlive()){
            Thread.sleep(delay);
            Field.clearTail(snake);
            moveSnake();
            checkCollisions();
            Field.drawSnake(snake);
            Field.drawScoreboard(scoreboard);
            Field.drawFruit(fruit);
        }
    }

    private static int pointCounter = 0;

    public static int getPointCounter() {
        return pointCounter;
    }

    public void generateFruit() {
        // preciso de uma nova instancia da fruta porque se não vai usar o da propria classe
        Fruit newFruitPosion = new Fruit();
        //fruti.setColor(color)
        fruit.intialPosition = new Position(newFruitPosion.getRandomGemX(), newFruitPosion.getRandomGemY());
        snake.increaseSize();
        pointCounter++;
        delay--;

    }

    private void moveSnake() {

        Key k = Field.readInput();

        if (k != null) {
            switch (k.getKind()) {
                case ArrowUp:
                    snake.move(Direction.UP);
                    return;

                case ArrowDown:
                    snake.move(Direction.DOWN);
                    return;

                case ArrowLeft:
                    snake.move(Direction.LEFT);
                    return;

                case ArrowRight:
                    snake.move(Direction.RIGHT);
                    return;
            }
        }
        snake.move();
    }

    private void checkCollisions() {

        for (int i = 1; i < snake.getSnakeSize(); i++) {
            if (i == snake.getSnakeSize()) {
                i = 1;
            }

            if (Snake.body.getFirst().getRow() == Snake.body.get(i).getRow() && Snake.body.getFirst().getCol() == Snake.body.get(i).getCol()) {
                snake.die();
            }
        }

        if (Snake.body.getFirst().getRow() == fruit.intialPosition.getRow() && Snake.body.getFirst().getCol() == fruit.intialPosition.getCol()) {
            generateFruit();

            fruit.appleWasEat = true;
        }

        if (Snake.body.getFirst().getCol() == 0 || Snake.body.getFirst().getCol() == Field.getWidth() - 1 || Snake.body.getFirst().getRow() == 0 || Snake.body.getFirst().getRow() == Field.getHeight() - 1) {
            snake.die();
        }

    }
}
