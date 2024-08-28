package hexlet.code;

import hexlet.games.CalcGame;
import hexlet.games.EvenGame;
import hexlet.games.GreetGame;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
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
            default:
                break;
        }
    }
}
