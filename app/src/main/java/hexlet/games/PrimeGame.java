package hexlet.games;

import hexlet.code.Engine;

import java.util.Random;

public class PrimeGame {
    public static void checkPrime() {
        String userName = Engine.startGame();
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");

        Random r = new Random();
        String[] questions = new String[Engine.ROUNDS_COUNT];
        String[] correctAnswers = new String[Engine.ROUNDS_COUNT];

        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {
            int randomNumber = r.nextInt(100) + 1;

            questions[i] = String.valueOf(randomNumber);
            correctAnswers[i] = isPrime(randomNumber) ? "yes" : "no";
        }

        Engine.runGame(userName, questions, correctAnswers);
    }

    private static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        } else if (num == 2) {
            return true;
        } else if (num % 2 == 0) {
            return false;
        }
        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
