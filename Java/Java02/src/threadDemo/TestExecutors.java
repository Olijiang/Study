package threadDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestExecutors {
    public static void main(String[] args) {
        //线程池
        ExecutorService service = Executors.newFixedThreadPool(5);
        RunnableDemo t = new RunnableDemo("t");
        service.submit(t);
        System.out.println("-------------");
        service.submit(t);
        service.shutdown();
    }
}