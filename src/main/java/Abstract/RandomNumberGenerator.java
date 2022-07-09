package Abstract;

import java.util.Random;

public class RandomNumberGenerator {
    private final Random random = new Random();
    public int getRandomInteger(int upperLimit) {
        return random.nextInt(upperLimit);
    }
}
