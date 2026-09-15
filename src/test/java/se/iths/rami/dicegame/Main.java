package se.iths.rami.dicegame;

public class Main {
    static void main() {
        Game game = new Game();
        do {
            game.play();
        } while (!game.isFinished());
    }
}
