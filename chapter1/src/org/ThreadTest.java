package org;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadTest {

    public static class MyThread extends Thread{
        @Override
        public void run(){
            System.out.println("T I am a child thread");
        }
    }

    public static class RunableTask implements Runnable{
        @Override
        public void run(){
            System.out.println("R I am a child thread");
        }
    }

    public static class CallerTask implements Callable<String>{
        @Override
        public String call() throws Exception{
            return "hello";
        }
    }

    public static void main(String[] args) throws InterruptedException{
        MyThread thread = new MyThread();
        thread.start();

        RunableTask task = new RunableTask();
        new Thread(task).start();
        new Thread(task).start();

        FutureTask<String> futureTask = new FutureTask<>(new CallerTask());
        new Thread(futureTask).start();
        try {
            String result = futureTask.get();
            System.out.println(result);
        } catch (ExecutionException e){
            e.printStackTrace();
        }
    }
}
