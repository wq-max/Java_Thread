package t4;

public class MyThread extends Thread{

    private int count = 5;

    @Override
    synchronized public void run() {
        super.run();
        count--;
        System.out.println("”… " + currentThread().getName() + "º∆À„£¨count=" + count);
    }
}
