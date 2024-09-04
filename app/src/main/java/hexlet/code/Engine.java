package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static final int ROUNDS_COUNT = 3;

    public static String startGame() {
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");

        Scanner scanner = new Scanner(System.in);
        String userName = scanner.nextLine();

        System.out.println("Hello, " + userName + "!");
        return userName;
    }

    public static void runGame(String userName, QuestionAnswerPair[] questionAnswerPairs) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < ROUNDS_COUNT; i++) {
            System.out.println("Question: " + questionAnswerPairs[i].getQuestion());
            String userAnswer = scanner.nextLine();
            System.out.println("Your answer: " + userAnswer);

            if (userAnswer.equals(questionAnswerPairs[i].getAnswer())) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + userAnswer + "' is the wrong answer ;(. Correct answer was '"
                        + questionAnswerPairs[i].getAnswer() + "'.");
                System.out.println("Let's try again, " + userName + "!");
                return;
            }
        }
        System.out.println("Congratulations, " + userName + "!");
    }
}
