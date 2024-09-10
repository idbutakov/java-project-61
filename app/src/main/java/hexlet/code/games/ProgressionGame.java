package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.Random;

public class ProgressionGame {
    private static final int MAX_PROGRESSION_LENGTH = 6;
    private static final int MAX_PROGRESSION_LENGTH_ADDED = 5;
    private static final int MAX_RANDOM = 5;

    public static void start() {
        String userName = Engine.startGame();
        System.out.println("What number is missing in the progression?");

        Random r = new Random();
        String[][] questionsAndAnswers = new String[Engine.ROUNDS_COUNT][2];

        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {
            int progressionLength = r.nextInt(MAX_PROGRESSION_LENGTH) + MAX_PROGRESSION_LENGTH_ADDED;
            int start = Utils.getRandomInt(0, MAX_RANDOM);
            int step = Utils.getRandomInt(0, MAX_RANDOM) + 1;
            int hiddenIndex = r.nextInt(progressionLength);

            int[] progression = generateProgression(progressionLength, start, step);

            String question = hideProgressionElement(progression, hiddenIndex);

            String correctAnswer = calculateMissingNumber(start, step, hiddenIndex);

            questionsAndAnswers[i][0] = question;
            questionsAndAnswers[i][1] = correctAnswer;
        }

        Engine.runGame(userName, questionsAndAnswers);
    }

    private static int[] generateProgression(int length, int start, int step) {
        int[] progression = new int[length];
        for (int i = 0; i < length; i++) {
            progression[i] = start + i * step;
        }
        return progression;
    }

    private static String hideProgressionElement(int[] progression, int hiddenIndex) {
        StringBuilder progressionString = new StringBuilder();
        for (int i = 0; i < progression.length; i++) {
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
