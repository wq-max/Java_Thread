package createThread;

public class TestThreadLocal {

    public static ThreadLocal<String> threadLocal = new ThreadLocal<>();
    //public static ThreadLocal<String> threadLocal = new InheritableThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        threadLocal.set("hello world");
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread() + threadLocal.get());
            }
        });

        thread.start();
        thread.join();

        System.out.println(Thread.currentThread() + threadLocal.get());
    }
}
