package moreextends;

public class BServer extends AServer implements Runnable{

    public void b_save_method() {
        System.out.println("b�б������ݵķ�����ִ�У�");
    }

    @Override
    public void run() {
        b_save_method();
    }
}
