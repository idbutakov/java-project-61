package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class CalcGame {
    public static void start() {
        String userName = Engine.startGame();
        System.out.println("What is the result of the expression?");

        String[][] questionsAndAnswers = new String[Engine.ROUNDS_COUNT][2];

        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {
            int randomCase = Utils.getRandomInt(0, 2);
            int randomNumberOne = Utils.getRandomInt(0, 100);
            int randomNumberTwo = Utils.getRandomInt(0, 100);

            String question = generateQuestion(randomNumberOne, randomNumberTwo, randomCase);
            int correctAnswer = calculateCorrectAnswer(randomNumberOne, randomNumberTwo, randomCase);

            questionsAndAnswers[i][0] = question;
            questionsAndAnswers[i][1] = String.valueOf(correctAnswer);
        }

        Engine.runGame(userName, questionsAndAnswers);
    }

    private static String generateQuestion(int numberOne, int numberTwo, int operationType) {
        String operation;
        if (operationType == 0) {
            operation = " + ";
        } else if (operationType == 1) {
            operation = " - ";
        } else if (operationType == 2) {
            operation = " * ";
        } else {
            throw new IllegalArgumentException("Invalid operation type: " + operationType);
        }
        return numberOne + operation + numberTwo;
    }

    private static int calculateCorrectAnswer(int numberOne, int numberTwo, int operationType) {
        if (operationType == 0) {
            return numberOne + numberTwo;
        } else if (operationType == 1) {
            return numberOne - numberTwo;
        } else if (operationType == 2) {
            return numberOne * numberTwo;
        } else {
            throw new IllegalArgumentException("Invalid operation type: " + operationType);
        }
    }
}
