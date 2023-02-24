package threadlocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalOOMDemo {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        executorService.execute(() -> {
            ThreadLocal<String> threadLocal = new ThreadLocal<>();
            String s = new String();
            threadLocal.set(s);
            //threadLocal = null;
        });
    }
}
