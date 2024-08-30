package hexlet.games;

import hexlet.code.Engine;

import java.util.Random;

public class ProgressionGame {
    public static void findMissingNumber() {
        String userName = Engine.startGame();

        Random r = new Random();
        String[] questions = new String[Engine.ROUNDS_COUNT];
        String[] correctAnswers = new String[Engine.ROUNDS_COUNT];

        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {
            int progressionLength = r.nextInt(6) + 5;
            int start = r.nextInt(50);
            int step = r.nextInt(10) + 1;
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
