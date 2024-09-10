package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class PrimeGame {
    private static final int MAX_RANDOM = 100;
    private static final int MAX_PRIME = 3;

    public static void start() {
        String userName = Engine.startGame();
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");

        String[][] questionsAndAnswers = new String[Engine.ROUNDS_COUNT][2];

        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {
            int randomNumber = Utils.getRandomInt(0, MAX_RANDOM);

            String[] questionAndAnswer = generateQuestionAndAnswer(randomNumber);

            questionsAndAnswers[i][0] = questionAndAnswer[0];
            questionsAndAnswers[i][1] = questionAndAnswer[1];
        }

        Engine.runGame(userName, questionsAndAnswers);
    }

    private static String[] generateQuestionAndAnswer(int number) {
        String question = String.valueOf(number);
        String correctAnswer = isPrime(number) ? "yes" : "no";
        return new String[]{question, correctAnswer};
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
