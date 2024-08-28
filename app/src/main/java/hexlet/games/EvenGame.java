package hexlet.games;

import hexlet.code.Engine;

import java.util.Random;

public class EvenGame {
    public static void isEven() {
        String userName = Engine.startGame();

        Random r = new Random();
        String[] questions = new String[Engine.ROUNDS_COUNT];
        String[] correctAnswers = new String[Engine.ROUNDS_COUNT];

        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {
            int randomNumber = r.nextInt(100);
            boolean isEven = randomNumber % 2 == 0;
            questions[i] = String.valueOf(randomNumber);
            correctAnswers[i] = isEven ? "yes" : "no";
        }

        Engine.runGame(userName, questions, correctAnswers);
    }
}
