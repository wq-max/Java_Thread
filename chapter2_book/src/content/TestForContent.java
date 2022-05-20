package content;

public class TestForContent {
    static final int LINE_NUM = 1024;
    static final int COLUMN_NUM = 1024;


    @jdk.internal.vm.annotation.Contended
    public final static class FilledLong {
        public volatile long value = 0L;
    }

   /* public synchronized void helloA() {
        System.out.println("hello A");
    }

    public synchronized void helloB() {
        System.out.println("hello B");
        helloA();
    }*/

    public static void main(String[] args) {
        long[][] array = new long[LINE_NUM][COLUMN_NUM];

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < LINE_NUM; i++) {
            for (int j = 0; j < COLUMN_NUM; j++)
                array[i][j] = i * 2 + j;
        }

        long endTime = System.currentTimeMillis();
        long cacheTime = endTime - startTime;
        System.out.println("cache time :" + cacheTime);
       /* TestForContent testForContent = new TestForContent();
        testForContent.helloB();*/
    }
}
