package threadDemo;
//通过继承Thread类实现线程
public class ThreadDemo extends Thread {
    private String threadname;

    public ThreadDemo(String threadname) {
        this.threadname = threadname;
    }

    @Override
    public void run() {
        for (int i=1; i<10; i++){
            System.out.println(threadname + ":"+i);
        }
    }

}
