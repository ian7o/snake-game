//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package academy.mindswap;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        Game game = new Game(100, 25, 100);

        try {
            game.start();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }

    }
}
