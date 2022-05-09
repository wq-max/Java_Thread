package createThread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadTest {

    //继承Thread类并重写run方法
    public static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("I am a child thread");
        }
    }

    //实现Runnable接口
    public static class RunnableTask implements Runnable {
        @Override
        public void run() {
            System.out.println("I am a child thread_Runnable " + Math.random());
        }
    }

    //创建任务类，类似Runnable---FutureTask
    public static class CallerTask implements Callable<String> {

        @Override
        public String call() throws Exception {
            return "Hello";
        }
    }

    public static void main(String[] args) {
        //创建线程
        MyThread thread = new MyThread();

        //启动线程
        thread.start();

        RunnableTask task = new RunnableTask();
        new Thread(task).start();
        new Thread(task).start();

        //创建异步任务
        FutureTask<String> futureTask = new FutureTask<>(new CallerTask());
        //启动线程
        new Thread(futureTask).start();
        try {
            //等待任务执行完毕，并返回结果
            String result = futureTask.get();
            System.out.println(result);
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
