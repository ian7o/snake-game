//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package academy.mindswap.gameobjects.snake;

import academy.mindswap.field.Position;

import java.util.LinkedList;

public class Snake {
    public static LinkedList<Position> body;
    public static final int SNAKE_INITIAL_SIZE = 2;
    public Direction direction;
    public boolean alive = true;


    public void increaseSize() {
        body.addLast(body.getLast());
    }

    public Snake(Direction starting_direction) {
        body = new LinkedList<>();
        for (int i = 0; i < SNAKE_INITIAL_SIZE; ++i) {
            body.add(new Position(25 - i, 15));
        }

        this.direction = starting_direction;
    }

    public void move(Direction direction) {

        switch (direction) {

            case UP -> {

                // fazer uma nova posição e mover apenas o y
                if (this.direction == Direction.DOWN) {
                    move();
                    break;
                }
                body.removeLast();
                this.direction = direction;
                body.addFirst(new Position(body.getFirst().getCol(), body.getFirst().getRow() - 1));

            }

            case DOWN -> {

                if (this.direction == Direction.UP) {
                    move();
                    break;
                }
                body.removeLast();
                this.direction = direction;
                body.addFirst(new Position(body.getFirst().getCol(), body.getFirst().getRow() + 1));

            }

            case LEFT -> {
                if (this.direction == Direction.RIGHT) {
                    move();
                    break;
                }
                body.removeLast();
                this.direction = direction;
                body.addFirst(new Position(body.getFirst().getCol() - 1, body.getFirst().getRow()));

            }
            case RIGHT -> {
                if (this.direction == Direction.LEFT) {
                    move();
                    break;
                }
                body.removeLast();
                this.direction = direction;
                body.addFirst(new Position(body.getFirst().getCol() + 1, body.getFirst().getRow()));
            }
        }
    }

    public void move() {
        this.move(this.direction);

    }

    public void die() {
        this.alive = false;
//        for (int i = 0; i < getSnakeSize(); i++) {
//            body.removeFirst();
//        }
    }


    public boolean isAlive() {
        return this.alive;
    }

    public Position getHead() {
        return this.getFullSnake().getFirst();
    }

    public Position getTail() {
        return this.getFullSnake().getLast();
    }

    public LinkedList<Position> getFullSnake() {
        return body;
    }

    public int getSnakeSize() {
        return body.size();
    }
}
