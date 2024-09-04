package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.QuestionAnswerPair;

import java.util.Random;

public class ProgressionGame {
    private static final int MAX_PROGRESSION_LENGTH = 6;
    private static final int MAX_PROGRESSION_LENGTH_ADDED = 5;
    private static final int MAX_START = 5;
    private static final int MAX_STEP = 5;

    public static void start() {
        String userName = Engine.startGame();
        System.out.println("What number is missing in the progression?");

        Random r = new Random();
        QuestionAnswerPair[] questionAnswerPairs = new QuestionAnswerPair[Engine.ROUNDS_COUNT];

        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {
            int progressionLength = r.nextInt(MAX_PROGRESSION_LENGTH) + MAX_PROGRESSION_LENGTH_ADDED;
            int start = r.nextInt(MAX_START);
            int step = r.nextInt(MAX_STEP) + 1;
            int hiddenIndex = r.nextInt(progressionLength);

            String question = generateProgressionQuestion(progressionLength, start, step, hiddenIndex);
            String correctAnswer = calculateMissingNumber(start, step, hiddenIndex);

            questionAnswerPairs[i] = new QuestionAnswerPair(question, correctAnswer);
        }

        Engine.runGame(userName, questionAnswerPairs);
    }

    private static String generateProgressionQuestion(int length, int start, int step, int hiddenIndex) {
        int[] progression = new int[length];
        StringBuilder progressionString = new StringBuilder();

        for (int i = 0; i < length; i++) {
            progression[i] = start + i * step;
            if (i == hiddenIndex) {
                progressionString.append(".. ");
            } else {
                progressionString.append(progression[i]).append(" ");
            }
        }

        return progressionString.toString().trim();
    }

    private static String calculateMissingNumber(int start, int step, int hiddenIndex) {
        return String.valueOf(start + hiddenIndex * step);
    }
}
