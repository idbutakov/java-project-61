package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class IsEvenCalculation {
    public static void isEven() {
        String name = User.getName();
        User.greetByName(name);

        for (int i = 0; i < 3; i++) {
            System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
            Random r = new Random();
            int randomNumber = r.nextInt(100);
            System.out.println("Question: " + randomNumber);

            Scanner scanner = new Scanner(System.in);
            String answer = scanner.nextLine();

            if ((answer.equals("yes") && randomNumber % 2 == 0) || (answer.equals("no") && randomNumber % 2 != 0)) {
                System.out.println("Correct!");
            } else if (!answer.equals("no") && randomNumber % 2 != 0) {
                System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was 'no'.");
            } else if (!answer.equals("yes") && randomNumber % 2 == 0) {
                System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was 'yes'.");
            }
        }

        System.out.println("Congratulations, " + name + "!");
    }
}
