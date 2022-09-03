package test;

import mythread.MyThread;

public class Test {

    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.setName("myThread");
        thread.start();

        for (int i = 0; i < 10000; i++) {
            System.out.println("main=" + Thread.currentThread().getName());
        }
    }
}
