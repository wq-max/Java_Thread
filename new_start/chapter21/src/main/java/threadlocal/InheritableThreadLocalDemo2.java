package threadlocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class InheritableThreadLocalDemo2 {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        InheritableThreadLocal<String> itl = new InheritableThreadLocal<>();
        itl.set("first");
        executorService.execute(() -> {
            String firstValue = itl.get();
            System.out.println(firstValue);
        });

        Thread.sleep(10);
        itl.remove();

        itl.set("second");
        executorService.execute(() -> {
            String secondValue = itl.get();
            System.out.println(secondValue);
        });

        Thread.sleep(10);
        itl.remove();
    }
}
