package threadPriority;

import java.util.stream.IntStream;

public class PriorityTest {
    public static class T1 extends Thread {
        @Override
        public void run() {
            super.run();
            System.out.printf("当前执行的线程是：%s, 优先级：%d%n",
                    Thread.currentThread().getName(),
                    Thread.currentThread().getPriority());
        }
    }

    public static void main(String[] args) {
        IntStream.range(1, 10).forEach(i -> {
            Thread thread = new Thread(new T1());
            thread.setPriority(i);
            thread.start();
        });
    }
}
