package createThread;

public class InterruptTest2 {

    public static void main(String[] args) throws InterruptedException {
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!Thread.interrupted()) {

                }

                System.out.println("threadOne isInterrupted:" + Thread.currentThread().isInterrupted());
            }
        });

        threadOne.start();
        threadOne.interrupt();
        threadOne.join();
        System.out.println("main thread is over");
    }

    /*public static void main(String[] args) throws InterruptedException {
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                for(;;);
            }
        });

        threadOne.start();

        threadOne.interrupt();

        System.out.println("isInterrupted:" + threadOne.isInterrupted());

        System.out.println("isInterrupted:" + threadOne.interrupted());

        System.out.println("isInterrupted:" + Thread.interrupted());

        System.out.println("isInterrupted:" + threadOne.isInterrupted());

        threadOne.join();

        System.out.println("main thread is over");
    }*/

    /*public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                //如果当前线程被中断则退出循环
                while (!Thread.currentThread().isInterrupted())
                    System.out.println(Thread.currentThread() + " hello");
            }
        });

        //启动子线程
        thread.start();

        //主线程休眠1s，以便中断前让子线程输出
        Thread.sleep(1000);

        //中断子线程
        System.out.println("main thread interrupt thread");
        thread.interrupt();

        //等待子线程执行完毕
        thread.join();
        System.out.println("main is over");
    }*/

    /*public static void main(String[] args) throws InterruptedException {
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("threadOne begin sleep for 2000 seconds");
                    Thread.sleep(2000000);
                    System.out.println("threadOne awaking");
                } catch (InterruptedException e) {
                    System.out.println("threadOne is interrupted while sleeping");
                }

                System.out.println("threadOne-leaving normally");
            }
        });

        //启动线程
        threadOne.start();

        Thread.sleep(1000);

        threadOne.interrupt();

        threadOne.join();

        System.out.println("main thread is over");
    }*/
}
