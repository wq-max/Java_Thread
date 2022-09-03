package komi;

public class ITest {

    private volatile static int k = 0;

    synchronized static public void addK() {
        k++;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                addK();
                System.out.println(k);

            }).start();
        }
        System.out.println("end " + k);
    }
}
