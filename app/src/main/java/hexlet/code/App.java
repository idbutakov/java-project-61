package hexlet.code;

import hexlet.games.CalcGame;
import hexlet.games.EvenGame;
import hexlet.games.GCDGame;
import hexlet.games.GreetGame;
import hexlet.games.ProgressionGame;
import hexlet.games.PrimeGame;

import java.util.Scanner;

public class App {
    private static final int CHOICE_ZERO = 0;
    private static final int CHOICE_ONE = 1;
    private static final int CHOICE_TWO = 2;
    private static final int CHOICE_THREE = 3;
    private static final int CHOICE_FOUR = 4;
    private static final int CHOICE_FIVE = 5;
    private static final int CHOICE_SIX = 6;

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
            case CHOICE_ZERO:
                break;
            case CHOICE_ONE:
                GreetGame.greetByName();
                break;
            case CHOICE_TWO:
                EvenGame.isEven();
                break;
            case CHOICE_THREE:
                CalcGame.calculate();
                break;
            case CHOICE_FOUR:
                GCDGame.findGCD();
                break;
            case CHOICE_FIVE:
                ProgressionGame.findMissingNumber();
                break;
            case CHOICE_SIX:
                PrimeGame.checkPrime();
                break;
            default:
                break;
        }
    }
}
