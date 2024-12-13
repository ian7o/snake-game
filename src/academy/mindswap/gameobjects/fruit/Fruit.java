package academy.mindswap.gameobjects.fruit;

import academy.mindswap.field.Field;
import academy.mindswap.field.Position;
import com.googlecode.lanterna.terminal.Terminal;

public class Fruit {
    public Position intialPosition;

    private int fildX = Field.getHeight() - 2;

    private int fildY = Field.getWidth() - 3;

    private int randomGemX = (int) (Math.random() * fildY) + 1;

    public int getRandomGemX() {
        return randomGemX;
    }

    private int randomGemY = (int) (Math.random() * fildX) + 1;

    public int getRandomGemY() {
        return randomGemY;
    }

    public Fruit() {
        this.intialPosition = new Position(randomGemX, randomGemY);
    }

    public Position getPosition() {
        return intialPosition;
    }



   public Terminal.Color[] colors = Terminal.Color.values();
    public int randomIndex = (int) (Math.random() * colors.length);
    public boolean appleWasEat;

    public Terminal.Color getRandomColor() {
        return colors[randomIndex];
    }

//    public Terminal.Color getRandomColor() {
//
//        if (!appleWasEat){
//            return null;
//        }
//
//        return colors[randomIndex];
//    }

    //criar variavel cor varias variaveis uma com cada cor diferente
    // gerar random baseado no numero

}
