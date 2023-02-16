package fork_join;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

public class FibonacciTest {

    class Fibonacci extends RecursiveTask<Integer> {
        int n;

        public Fibonacci(int n) {
            this.n = n;
        }

        @Override
        protected Integer compute() {
            if (n <= 1) {
                return n;
            } else {
                Fibonacci f1 = new Fibonacci(n - 1);
                f1.fork();
                Fibonacci f2 = new Fibonacci(n - 2);
                f2.fork();
                return f1.join() + f2.join();
            }
        }
    }

    public int plainRecursion(int n) {
        if(n == 1 || n == 2) {
            return 1;
        }
        else {
            return plainRecursion(n - 1) + plainRecursion(n - 2);
        }
    }

    public int computeFibonacci(int n) {
        if (n == 1 || n == 2) {
            return n;
        } else {
            int first = 1;
            int second = 1;
            int third = 0;
            for (int i = 3; i <= n; i++) {
                third = first + second;
                first = second;
                second = third;
            }
            return third;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FibonacciTest fibonacciTest = new FibonacciTest();
        fibonacciTest.forkTest(70);
        fibonacciTest.plainTest(70);
        fibonacciTest.computeTest(70);
    }

    public void forkTest(int n) throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        System.out.println("CPU核数：" + Runtime.getRuntime().availableProcessors());
        long start = System.currentTimeMillis();
        Fibonacci fibonacci = new Fibonacci(n);
        Future<Integer> future = forkJoinPool.submit(fibonacci);
        System.out.println(future.get());
        long end = System.currentTimeMillis();
        System.out.printf("耗时：%d millis%n", end - start);
    }

    public void plainTest(int n) {
        long start = System.currentTimeMillis();
        int result = plainRecursion(n);
        System.out.println("计算结果：" + result);
        long end = System.currentTimeMillis();
        System.out.printf("耗时：%d millis%n", end - start);
    }

    public void computeTest(int n) {
        long start = System.currentTimeMillis();
        int result = computeFibonacci(n);
        System.out.println("计算结果：" + result);
        long end = System.currentTimeMillis();
        System.out.printf("耗时：%d millis%n", end - start);
    }
}
