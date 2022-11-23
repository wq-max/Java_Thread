package threadState;

import org.junit.Test;

public class StateTest {

    private void testStateNew() {
        Thread thread = new Thread(() -> {});
        System.out.println(thread.getState());
    }

    @Test
    public void testStartMethod() {
        Thread thread = new Thread(() -> {});
        thread.start();
        thread.start();
    }

    @Test
    public void blockedTest() throws InterruptedException {
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                testMethod();
            }
        }, "a");

        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                testMethod();
            }
        }, "b");

        a.start();
        a.join(1000L);
        b.start();

        System.out.println(a.getName() + ": " + a.getState());
        System.out.println(b.getName() + ": " + b.getState());
    }

    // 同步方法争夺锁
    private synchronized void testMethod() {
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {});
        System.out.println(thread.getState());
    }
}
