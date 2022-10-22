import java.util.concurrent.ThreadPoolExecutor;



/**
 * @author ZGB
 * @version 1.0
 * @description: TODO
 * @date 2022/10/18 11:44
 */
public class ThreadChangeDemo {

	private static final int corePoolSize = 5;
	private static final int minimumQueueCount = 10;
	
	public static void main(String[] args) throws InterruptedException {
		ThreadPoolExecutor executor = new MyThreadPool(corePoolSize,corePoolSize,60,minimumQueueCount,"spring");
		for (int i=0; i<100; i++){
			executor.execute(()->{
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			});
			Thread.sleep(1);
		}
		executor.shutdown();
	}
}
