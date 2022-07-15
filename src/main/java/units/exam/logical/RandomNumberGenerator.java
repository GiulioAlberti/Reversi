package units.exam.logical;

import java.util.Random;

public class RandomNumberGenerator {
    private final Random random = new Random();

    protected int getRandomInteger(int upperLimit) {
        return random.nextInt(upperLimit);
    }
}
