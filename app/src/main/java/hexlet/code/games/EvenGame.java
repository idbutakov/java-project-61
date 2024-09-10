package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class EvenGame {
    private static final int MAX_RANDOM = 100;

    public static void start() {
        String userName = Engine.startGame();
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        String[][] questionsAndAnswers = new String[Engine.ROUNDS_COUNT][2];

        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {
            int randomNumber = Utils.getRandomInt(0, MAX_RANDOM);
            String question = String.valueOf(randomNumber);
            String correctAnswer = getCorrectAnswer(randomNumber);

            questionsAndAnswers[i][0] = question;
            questionsAndAnswers[i][1] = correctAnswer;
        }

        Engine.runGame(userName, questionsAndAnswers);
    }

    private static String getCorrectAnswer(int number) {
        return isEven(number) ? "yes" : "no";
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }
}
