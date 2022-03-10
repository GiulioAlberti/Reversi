package Abstract;

import java.util.Random;

public class RandomNumberGenerator {
    public int getRandomInteger(int upperLimit) {
        return new Random().nextInt(upperLimit);
    }
}
