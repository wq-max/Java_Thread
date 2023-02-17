package stream;

import java.util.stream.Stream;

public class StreamParallelDemo {

    public static void main(String[] args) {
        Stream.of(1,2,3,4,5,6,7,8,9)
                .parallel()
                .reduce((a, b) -> {
                    System.out.printf("%s: %d + %d = %d%n",
                            Thread.currentThread().getName(), a, b, a + b);
                    return a + b;
                })
                .ifPresent(System.out::println);
    }
}
