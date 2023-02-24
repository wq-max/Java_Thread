package threadlocal;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.TtlRunnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TransmittableThreadLocalDemo {

    static ExecutorService executorService = Executors.newFixedThreadPool(1);

    static ThreadLocal<String> context = new TransmittableThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        context.set("first");

        Runnable firstRunnable = () -> {
            String firstValue = context.get();
            System.out.println(firstValue);
        };

        TtlRunnable firstTtlRunnable = TtlRunnable.get(firstRunnable);

        executorService.execute(firstTtlRunnable);

        Thread.sleep(10);

        context.set("second");

        Runnable secondRunnable = () -> {
            String secondValue = context.get();
            System.out.println(secondValue);
        };

        TtlRunnable secondTtlRunnable = TtlRunnable.get(secondRunnable);

        executorService.execute(secondTtlRunnable);

        Thread.sleep(10);
        context.remove();
    }
}
