package academy.mindswap.field;

public class Scoreboard {
    private static final String placarSign = "points: ";

    public static String getPlacarSign() {
        return placarSign;
    }

    private Position scoreboardPosition =  new Position(1,0);

    public Position getScoreboardPosition() {
        return scoreboardPosition;
    }

}