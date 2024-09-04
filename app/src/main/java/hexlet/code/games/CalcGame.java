package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.QuestionAnswerPair;

import java.util.Random;

public class CalcGame {
    private static final int MAX_RANDOM_CASE = 3;
    private static final int MAX_RANDOM_NUMBER = 100;

    public static void start() {
        String userName = Engine.startGame();
        System.out.println("What is the result of the expression?");

        Random r = new Random();
        QuestionAnswerPair[] questionAnswerPairs = new QuestionAnswerPair[Engine.ROUNDS_COUNT];

        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {
            int randomCase = r.nextInt(MAX_RANDOM_CASE);
            int randomNumberOne = r.nextInt(MAX_RANDOM_NUMBER);
            int randomNumberTwo = r.nextInt(MAX_RANDOM_NUMBER);

            String question = generateQuestion(randomNumberOne, randomNumberTwo, randomCase);
            String correctAnswer = calculateCorrectAnswer(randomNumberOne, randomNumberTwo, randomCase);

            questionAnswerPairs[i] = new QuestionAnswerPair(question, correctAnswer);
        }

        Engine.runGame(userName, questionAnswerPairs);
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

    private static String calculateCorrectAnswer(int numberOne, int numberTwo, int operationType) {
        int correctAnswer;
        if (operationType == 0) {
            correctAnswer = numberOne + numberTwo;
        } else if (operationType == 1) {
            correctAnswer = numberOne - numberTwo;
        } else if (operationType == 2) {
            correctAnswer = numberOne * numberTwo;
        } else {
            throw new IllegalArgumentException("Invalid operation type: " + operationType);
        }
        return String.valueOf(correctAnswer);
    }
}
