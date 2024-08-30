package hexlet.games;

import hexlet.code.Engine;

import java.util.Random;

public class CalcGame {
    public static void calculate() {
        String userName = Engine.startGame();
        System.out.println("What is the result of the expression?");

        Random r = new Random();
        String[] questions = new String[Engine.ROUNDS_COUNT];
        String[] correctAnswers = new String[Engine.ROUNDS_COUNT];

        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {
            int randomCase = r.nextInt(Engine.ROUNDS_COUNT);
            int randomNumberOne = r.nextInt(100);
            int randomNumberTwo = r.nextInt(100);
            int correctAnswer = 0;
            String operation = "";

            switch (randomCase) {
                case 0:
                    operation = " + ";
                    correctAnswer = randomNumberOne + randomNumberTwo;
                    break;
                case 1:
                    operation = " - ";
                    correctAnswer = randomNumberOne - randomNumberTwo;
                    break;
                case 2:
                    operation = " * ";
                    correctAnswer = randomNumberOne * randomNumberTwo;
                    break;
                default:
                    break;
            }

            questions[i] = randomNumberOne + operation + randomNumberTwo;
            correctAnswers[i] = String.valueOf(correctAnswer);
        }

        Engine.runGame(userName, questions, correctAnswers);
    }
}
