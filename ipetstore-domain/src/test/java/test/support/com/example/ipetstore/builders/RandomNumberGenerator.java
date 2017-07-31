package test.support.com.example.ipetstore.builders;

import static java.lang.String.valueOf;

import java.util.Random;

public class RandomNumberGenerator {

    private final int maxValue;
    private final Random random;

    public RandomNumberGenerator(int maxValue) {
        this.maxValue = maxValue;
        random = new Random();
    }

    public String generateNumber() {
        return valueOf(random.nextInt(maxValue));
    }
}
