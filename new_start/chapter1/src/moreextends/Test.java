package moreextends;


import mythread.MyThread;

public class Test {

    public static void main(String[] args) {
        MyThread thread = new MyThread();
        Thread t = new Thread(thread);
        t.start();

    }
}
