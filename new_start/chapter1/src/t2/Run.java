package t2;

public class Run {

    public static void main(String[] args) {
        Runnable runnable = new MyRunnable();
        Thread thread = new Thread(runnable);
        thread.start();
        System.out.println("ÔËĞĞ½áÊø£¡");
    }
}
