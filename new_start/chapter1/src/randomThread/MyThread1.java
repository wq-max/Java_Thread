package randomThread;

public class MyThread1 extends Thread{
    private Integer id;

    public MyThread1(Integer id) {
        super();
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println(id);
    }
}
