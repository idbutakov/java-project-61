package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.QuestionAnswerPair;

import java.util.Random;

public class EvenGame {
    private static final int MAX_RANDOM_NUMBER = 100;

    public static void start() {
        String userName = Engine.startGame();
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        Random r = new Random();
        QuestionAnswerPair[] questionAnswerPairs = new QuestionAnswerPair[Engine.ROUNDS_COUNT];

        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {
            int randomNumber = r.nextInt(MAX_RANDOM_NUMBER);
            String question = String.valueOf(randomNumber);
            String correctAnswer = getCorrectAnswer(randomNumber);

            questionAnswerPairs[i] = new QuestionAnswerPair(question, correctAnswer);
        }

        Engine.runGame(userName, questionAnswerPairs);
    }

    private static String getCorrectAnswer(int number) {
        return isEven(number) ? "yes" : "no";
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }
}
