package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StreamParallelTestDemo {

    public static void main(String[] args) {
        System.out.printf("本计算机的核数：%d\n", Runtime.getRuntime().availableProcessors());

        Random random = new Random();
        List<Integer> list = new ArrayList<>(1000_0000);

        for (int i = 0; i < 1000_0000; i++) {
            list.add(random.nextInt(100));
        }

        long prevTime = System.currentTimeMillis();
        list.stream().reduce(Integer::sum).ifPresent(System.out::println);
        System.out.printf("单线程耗时：%d\n", System.currentTimeMillis() - prevTime);

        prevTime = System.currentTimeMillis();
        list.stream().parallel().reduce(Integer::sum).ifPresent(System.out::println);
        System.out.printf("多线程耗时：%d\n", System.currentTimeMillis() - prevTime);
    }
}
