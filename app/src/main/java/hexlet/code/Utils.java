package hexlet.code;

import java.util.Random;

public class Utils {
    private static final Random RANDOM = new Random();

    public static int getRandomInt(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("Min value cannot be greater than max value.");
        }
        return RANDOM.nextInt((max - min) + 1) + min;
    }
}
