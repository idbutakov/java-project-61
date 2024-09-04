package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.QuestionAnswerPair;

import java.util.Random;

public class PrimeGame {
    private static final int MAX_RANDOM_NUMBER = 100;
    private static final int MAX_PRIME = 3;

    public static void start() {
        String userName = Engine.startGame();
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");

        Random r = new Random();
        QuestionAnswerPair[] questionAnswerPairs = new QuestionAnswerPair[Engine.ROUNDS_COUNT];

        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {
            int randomNumber = r.nextInt(MAX_RANDOM_NUMBER) + 1;

            String question = generateQuestion(randomNumber);
            String correctAnswer = calculateCorrectAnswer(randomNumber);

            questionAnswerPairs[i] = new QuestionAnswerPair(question, correctAnswer);
        }

        Engine.runGame(userName, questionAnswerPairs);
    }

    private static String generateQuestion(int number) {
        return String.valueOf(number);
    }

    private static String calculateCorrectAnswer(int number) {
        return isPrime(number) ? "yes" : "no";
    }

    private static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        } else if (num == 2) {
            return true;
        } else if (num % 2 == 0) {
            return false;
        }
        for (int i = MAX_PRIME; i <= Math.sqrt(num); i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
