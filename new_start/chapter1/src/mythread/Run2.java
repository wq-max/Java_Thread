package mythread;

import java.util.concurrent.TimeUnit;

public class Run2 {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.start();
        // Thread.sleep(200);
        System.out.println("begin: " + System.currentTimeMillis());
        TimeUnit.SECONDS.sleep(5);
        System.out.println("end: " + System.currentTimeMillis());
        System.out.println("运行结束！");
    }
}
