package p1;

public class Demo {
    public static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("MyThread");
        }
    }

    public static class MyThread1 implements Runnable {
        @Override
        public void run() {
            System.out.println("MyThread1");
        }
    }

    public static void main(String[] args) {
        Thread myThread = new MyThread();
        myThread.start();

        new Thread(new MyThread1()).start();

        new Thread(() -> System.out.println("Java 8 匿名内部类")).start();
    }
}
