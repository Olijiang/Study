package threadDemo;

public class TestThread {
    public static void main(String[] args) {

        /*
        //Runnable 实现线程
        RunnableDemo t1 = new RunnableDemo("t1");
        RunnableDemo t2 = new RunnableDemo("t2");
        t1.start();
        t2.start();
        */

        //Thread实现线程

         ThreadDemo t1 = new ThreadDemo("t1");
         ThreadDemo t2 = new ThreadDemo("t2");
         t1.start();
         t2.start();

    }
}
