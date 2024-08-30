package hexlet.games;

import hexlet.code.Engine;

import java.util.Random;

public class GCDGame {
    public static void findGCD() {
        String userName = Engine.startGame();

        Random r = new Random();
        String[] questions = new String[Engine.ROUNDS_COUNT];
        String[] correctAnswers = new String[Engine.ROUNDS_COUNT];

        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {
            int randomNumberOne = r.nextInt(100) + 1;
            int randomNumberTwo = r.nextInt(100) + 1;

            questions[i] = randomNumberOne + " " + randomNumberTwo;
            correctAnswers[i] = String.valueOf(gcd(randomNumberOne, randomNumberTwo));
        }

        Engine.runGame(userName, questions, correctAnswers);
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
