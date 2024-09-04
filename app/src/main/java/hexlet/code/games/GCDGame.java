package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.QuestionAnswerPair;

import java.util.Random;

public class GCDGame {
    private static final int MAX_RANDOM_NUMBER = 100;

    public static void start() {
        String userName = Engine.startGame();
        System.out.println("Find the greatest common divisor of given numbers.");

        Random r = new Random();
        QuestionAnswerPair[] questionAnswerPairs = new QuestionAnswerPair[Engine.ROUNDS_COUNT];

        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {
            int randomNumberOne = r.nextInt(MAX_RANDOM_NUMBER) + 1;
            int randomNumberTwo = r.nextInt(MAX_RANDOM_NUMBER) + 1;

            String question = generateQuestion(randomNumberOne, randomNumberTwo);
            String correctAnswer = calculateGCD(randomNumberOne, randomNumberTwo);

            questionAnswerPairs[i] = new QuestionAnswerPair(question, correctAnswer);
        }

        Engine.runGame(userName, questionAnswerPairs);
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
