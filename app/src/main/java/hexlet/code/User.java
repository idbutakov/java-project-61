package hexlet.code;

import java.util.Scanner;

public class User {

    public static String getName() {
        System.out.println("May I have your name?");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static void greetByName(String name) {
        System.out.println("Hello, " + name + "!");
    }
}
