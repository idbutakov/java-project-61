package hexlet.code;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("0 - Exit");

        Scanner scanner = new Scanner(System.in);
        int gameNumber = scanner.nextInt();
        System.out.println("Your choice: " + gameNumber);

        switch (gameNumber) {
            case 0:
                break;
            case 1:
                System.out.println("Welcome to the Brain Games!");
                String name = User.getName();
                User.greetByName(name);
                break;
            case 2:
                IsEvenCalculation.isEven();
                break;
            default:
                break;
        }
    }
}
