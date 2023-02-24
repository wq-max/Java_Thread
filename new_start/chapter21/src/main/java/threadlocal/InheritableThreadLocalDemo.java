package threadlocal;

public class InheritableThreadLocalDemo {

    public static void main(String[] args) {
        Thread a = new Thread(() -> {
            ThreadLocal<String> itl = new ThreadLocal<>();
            //InheritableThreadLocal<String> itl = new InheritableThreadLocal<>();
            itl.set("InheritableThreadLocal");

            Thread b = new Thread(() -> {
                String str = itl.get();
                System.out.println(str);
            });
            b.start();

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            itl.remove();
        });

        a.start();
    }
}
