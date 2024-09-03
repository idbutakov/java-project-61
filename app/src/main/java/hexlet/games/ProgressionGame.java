package hexlet.games;

import hexlet.code.Engine;

import java.util.Random;

public class ProgressionGame {
    private final static int MAX_PROGRESSION_LENGTH = 6;
    private final static int MAX_PROGRESSION_LENGTH_ADDED = 5;
    private final static int MAX_START = 5;
    private final static int MAX_STEP = 5;

    public static void findMissingNumber() {
        String userName = Engine.startGame();
        System.out.println("What number is missing in the progression?");

        Random r = new Random();
        String[] questions = new String[Engine.ROUNDS_COUNT];
        String[] correctAnswers = new String[Engine.ROUNDS_COUNT];

        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {
            int progressionLength = r.nextInt(MAX_PROGRESSION_LENGTH) + MAX_PROGRESSION_LENGTH_ADDED;
            int start = r.nextInt(MAX_START);
            int step = r.nextInt(MAX_STEP) + 1;
            int hiddenIndex = r.nextInt(progressionLength);

            int[] progression = new int[progressionLength];
            StringBuilder progressionString = new StringBuilder();

            for (int j = 0; j < progressionLength; j++) {
                progression[j] = start + j * step;
                if (j == hiddenIndex) {
                    progressionString.append(".. ");
                } else {
                    progressionString.append(progression[j]).append(" ");
                }
            }

            questions[i] = progressionString.toString().trim();
            correctAnswers[i] = String.valueOf(progression[hiddenIndex]);
        }

        Engine.runGame(userName, questions, correctAnswers);
    }
}
