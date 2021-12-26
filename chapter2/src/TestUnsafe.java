import sun.misc.Unsafe;

public class TestUnsafe {

    //获取Unsafe的实例
    static final Unsafe unsafe = Unsafe.getUnsafe();

    //记录变量state在类TestUnsafe中的偏移值
    static long stateOffset = 0;

    private volatile long state = 0;

    static {
        try {
            //获取state变量在类TestUnsafe中的偏移值
            stateOffset = unsafe.objectFieldOffset(TestUnsafe.class.
                    getDeclaredField("state"));
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            throw new Error(e);
        }
    }

    public static void main(String[] args) {
        //创建实例并设置state值为1
        TestUnsafe test = new TestUnsafe();
        Boolean sucess = unsafe.compareAndSwapInt(test,stateOffset,0,1);
        System.out.println(sucess);
    }
}
