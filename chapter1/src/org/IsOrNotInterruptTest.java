package org;

public class IsOrNotInterruptTest {
    public static void main(String[] args) throws InterruptedException{
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!Thread.interrupted());
                System.out.println("threadOne isInterrupted:" + Thread.currentThread().isInterrupted());
            }
        });

        threadOne.start();

        threadOne.interrupt();

        //threadOne.join();

        System.out.println("isInterrupted:" + threadOne.isInterrupted());

        System.out.println("isInterrupted:" + Thread.interrupted());

        System.out.println("isInterrupted:" + Thread.interrupted());

        System.out.println("isInterrupted:" + threadOne.isInterrupted());

        threadOne.join();

        System.out.println("main thread is over");
    }
}
