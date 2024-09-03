package hexlet.games;

import hexlet.code.Engine;

import java.util.Random;

public class GCDGame {
    private static final int MAX_RANDOM_NUMBER = 100;

    public static void findGCD() {
        String userName = Engine.startGame();
        System.out.println("Find the greatest common divisor of given numbers.");

        Random r = new Random();
        String[] questions = new String[Engine.ROUNDS_COUNT];
        String[] correctAnswers = new String[Engine.ROUNDS_COUNT];

        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {
            int randomNumberOne = r.nextInt(MAX_RANDOM_NUMBER) + 1;
            int randomNumberTwo = r.nextInt(MAX_RANDOM_NUMBER) + 1;

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
