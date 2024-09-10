package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class GCDGame {
    private static final int MAX_RANDOM = 100;

    public static void start() {
        String userName = Engine.startGame();
        System.out.println("Find the greatest common divisor of given numbers.");

        String[][] questionsAndAnswers = new String[Engine.ROUNDS_COUNT][2];

        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {
            int randomNumberOne = Utils.getRandomInt(0, MAX_RANDOM);
            int randomNumberTwo = Utils.getRandomInt(0, MAX_RANDOM);

            String question = generateQuestion(randomNumberOne, randomNumberTwo);
            String correctAnswer = calculateGCD(randomNumberOne, randomNumberTwo);

            questionsAndAnswers[i][0] = question;
            questionsAndAnswers[i][1] = correctAnswer;
        }

        Engine.runGame(userName, questionsAndAnswers);
    }

    private static String generateQuestion(int numberOne, int numberTwo) {
        return numberOne + " " + numberTwo;
    }

    private static String calculateGCD(int numberOne, int numberTwo) {
        return String.valueOf(gcd(numberOne, numberTwo));
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
