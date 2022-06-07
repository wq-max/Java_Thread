package random;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomTest {

    public static void main(String[] args) {
        //Random random = new Random();
        ThreadLocalRandom random = ThreadLocalRandom.current();
        for (int i = 0; i < 10; i++) {
            System.out.println(random.nextInt(5));
        }
    }
}
