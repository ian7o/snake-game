//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package academy.mindswap.field;

import academy.mindswap.Game;
import academy.mindswap.gameobjects.fruit.Fruit;
import academy.mindswap.gameobjects.snake.Snake;
import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.ScreenCharacterStyle;
import com.googlecode.lanterna.screen.ScreenWriter;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.TerminalPosition;
import com.googlecode.lanterna.terminal.Terminal.Color;
import java.util.Iterator;

public final class Field {
    private static final String BORDER_STRING = "▒";
    private static final String SNAKE_BODY_STRING = "#";
    private static final String SNAKE_HEAD_STRING = "0";
    private static final String FRUIT_STRING = "@";
    private static int width;
    private static int height;
    private static Screen screen;
    private static ScreenWriter screenWriter;

    public Field() {
    }

    public static void init(int width, int height) {
        screen = TerminalFacade.createScreen();
        Field.width = width;
        Field.height = height;
        screen.getTerminal().getTerminalSize().setColumns(width);
        screen.getTerminal().getTerminalSize().setRows(height);
        screenWriter = new ScreenWriter(screen);
        screen.setCursorPosition((TerminalPosition)null);
        screen.startScreen();
        drawWalls();
        screen.refresh();
    }

    public static void drawSnake(Snake snake) {
        Terminal.Color snakeColor = Color.GREEN;
        if (!snake.isAlive()) {
            snakeColor = Color.RED;
        }

        Position head = snake.getHead();
        Iterator var3 = snake.getFullSnake().iterator();

        while(var3.hasNext()) {
            Position p = (Position)var3.next();
            if (!p.equals(head)) {
                screen.putString(p.getCol(), p.getRow(), "#", snakeColor, (Terminal.Color)null, new ScreenCharacterStyle[0]);
            } else {
                screen.putString(p.getCol(), p.getRow(), "0", snakeColor, (Terminal.Color)null, new ScreenCharacterStyle[0]);
            }
        }

        screen.refresh();
    }

    public static void clearTail(Snake snake) {
        Position tail = snake.getTail();
        screen.putString(tail.getCol(), tail.getRow(), " ", (Terminal.Color)null, (Terminal.Color)null, new ScreenCharacterStyle[0]);
    }

    private static void drawWalls() {
        int j;
        for(j = 0; j < width; ++j) {
            screenWriter.drawString(j, 0, "▒", new ScreenCharacterStyle[0]);
            screenWriter.drawString(j, height - 1, "▒", new ScreenCharacterStyle[0]);
        }

        for(j = 0; j < height; ++j) {
            screenWriter.drawString(0, j, "▒", new ScreenCharacterStyle[0]);
            screenWriter.drawString(width - 1, j, "▒", new ScreenCharacterStyle[0]);
        }

    }

    public static Key readInput() {
        return screen.readInput();
    }

    public static void drawFruit(Fruit fruit) {
        screen.putString(fruit.getPosition().getCol(), fruit.getPosition().getRow(), "@", fruit.getRandomColor(), (Terminal.Color)null, new ScreenCharacterStyle[0]);
    }

    public static void drawScoreboard(Scoreboard scoreboard) {
        screen.putString(scoreboard.getScoreboardPosition().getCol(), scoreboard.getScoreboardPosition().getRow(), Scoreboard.getPlacarSign() + Game.getPointCounter(), Color.GREEN, (Terminal.Color)null, new ScreenCharacterStyle[0]);
    }

    public static int getWidth() {
        return width;
    }

    public static int getHeight() {
        return height;
    }
}
