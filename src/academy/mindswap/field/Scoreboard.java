//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package academy.mindswap.field;

public class Scoreboard {
    private static final String placarSign = "points: ";
    private Position scoreboardPosition = new Position(1, 0);

    public Scoreboard() {
    }

    public static String getPlacarSign() {
        return "points: ";
    }

    public Position getScoreboardPosition() {
        return this.scoreboardPosition;
    }
}
