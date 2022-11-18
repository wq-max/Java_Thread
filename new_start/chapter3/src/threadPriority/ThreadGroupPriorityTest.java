package threadPriority;

public class ThreadGroupPriorityTest {
    public static void main(String[] args) {
        ThreadGroup threadGroup = new ThreadGroup("t1");
        threadGroup.setMaxPriority(6);
        Thread thread = new Thread(threadGroup, "thread");
        thread.setPriority(9);
        System.out.println("我是线程组的优先级：" + threadGroup.getMaxPriority());
        System.out.println("我是线程的优先级：" + thread.getPriority());
        System.out.println(threadGroup.getName());
        System.out.println(thread.getThreadGroup().getName());
        System.out.println(Thread.currentThread().getThreadGroup().getName());
        System.out.println(Thread.currentThread().getName());
    }
}
