package hexlet.code;

import hexlet.games.*;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("4 - GCD");
        System.out.println("5 - Progression");
        System.out.println("6 - Prime");
        System.out.println("0 - Exit");

        Scanner scanner = new Scanner(System.in);
        int gameNumber = scanner.nextInt();
        System.out.println("Your choice: " + gameNumber);

        switch (gameNumber) {
            case 0:
                break;
            case 1:
                GreetGame.greetByName();
                break;
            case 2:
                EvenGame.isEven();
                break;
            case 3:
                CalcGame.calculate();
                break;
            case 4:
                GCDGame.findGCD();
                break;
            case 5:
                ProgressionGame.findMissingNumber();
                break;
            case 6:
                PrimeGame.checkPrime();
                break;
            default:
                break;
        }
    }
}
