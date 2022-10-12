package threadDemo;
// 通过Runnable接口实现线程
public class RunnableDemo implements Runnable{
    private final String threadname;
    private int i = 0;

    public RunnableDemo(String threadname) {
        this.threadname = threadname;
    }

    @Override
    public void run() {
        for (; i<100; i++){
            System.out.println(threadname+ "：" + i);
        }
    }

    public void start(){
        Thread t = new Thread(this, threadname);
        t.start();
    }
}
