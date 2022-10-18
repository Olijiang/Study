import org.springframework.scheduling.concurrent.CustomizableThreadFactory;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;



/**
 * @author ZGB
 * @version 1.0
 * @description: TODO
 * @date 2022/10/18 11:44
 */
public class ThreadChangeDemo {

	private static final int threadCount = 500;
	private static final int minimumQueueCount = 30;



	public static void main(String[] args) throws InterruptedException {
		ThreadPoolExecutor executor = buildThreadPool();
		// 倒计时器
//		final CountDownLatch countDownLatch = new CountDownLatch(threadCount);
		Runnable task = new Runnable() {
			@Override
			public void run() {
//				threadPoolStatus(executor, "创建线程");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}finally {
					// 线程回调操作
					dynamicDecrease(executor);
//					countDownLatch.countDown();
				}
			}
		};
		for (int i=0; i<threadCount; i++){
			dynamicIncrease(executor);
			Thread.sleep(1);
			executor.execute(task);
		}
		executor.shutdown();
//		countDownLatch.await();
//		threadPoolStatus(executor, "结束");

	}


	/**
	 * @description: 自定义线程池
	 * @param:
	 * @return:
	 * @date: 2022/10/18 11:45
	 */
	private static ThreadPoolExecutor buildThreadPool(){
		// maximumPoolSize 当队列满后会激活这部分的线程, 并且只要队列不空这部分会一直存在, 队列空后等待超时时间后销毁
		return  new ThreadPoolExecutor(10,20, 60, TimeUnit.SECONDS,
				new MyLinkedBlockingQueue<>(minimumQueueCount),
				new CustomizableThreadFactory("SpringThread-"));
	}

	private static void dynamicIncrease(ThreadPoolExecutor executor) {
		// 动态修改线程池参数, 核心线程 维持为 最大线程的一半
		// 当线程池活跃度大于80% 时,队列也已经满了,将 队列容量, 核心线程数量, 最大线程数量翻倍
		// 由于在最大线程部分中的线程激活后在队列空之前不会销毁, 使用活跃度判断并不准确,
		double c = (double)executor.getActiveCount() / (double) executor.getMaximumPoolSize();
		MyLinkedBlockingQueue queue = (MyLinkedBlockingQueue) executor.getQueue();
		int d = queue.size() / queue.getQueueSize();    // 队列使用率

		// 根据队列使用率和活跃度一起判断
		if(d==1 && c>0.85){
//			threadPoolStatus(executor, "活跃度:" + c + " 队列使用率:" + d + "------------开始扩容");
			synchronized ("increase"){
				c = (double)executor.getActiveCount() / (double) executor.getMaximumPoolSize();
				queue = (MyLinkedBlockingQueue) executor.getQueue();
				d = queue.size() / queue.getQueueSize();    // 队列使用率
				if(d>0.8 && c==1) {
					threadPoolStatus(executor, "扩容前状态");
					executor.setCorePoolSize(executor.getCorePoolSize() << 1);
					executor.setMaximumPoolSize(executor.getMaximumPoolSize() << 1);
					queue.setQueueSize(queue.getQueueSize() << 1);
					threadPoolStatus(executor, "扩容后状态");
				}
			}
		}
	}

	private static void dynamicDecrease(ThreadPoolExecutor executor) {

		MyLinkedBlockingQueue queue = (MyLinkedBlockingQueue) executor.getQueue();
		double d = (double)queue.size() / (double) queue.getQueueSize();    // 队列使用率
		// 根据队列使用率和活跃度一起判断
		if(d<0.45 && queue.getQueueSize() > minimumQueueCount){
			synchronized ("decrease"){
				queue = (MyLinkedBlockingQueue) executor.getQueue();
				d = (double)queue.size() / (double) queue.getQueueSize();    // 队列使用率
				if(d<0.45 && queue.getQueueSize() > minimumQueueCount){
					threadPoolStatus(executor,"减容前状态");
					executor.setCorePoolSize(executor.getCorePoolSize() >> 1);
					executor.setMaximumPoolSize(executor.getMaximumPoolSize() >> 1 );
					queue.setQueueSize(queue.getQueueSize() >> 1);
					threadPoolStatus(executor,"减容后状态");
				}
			}
		}
	}

	private static void threadPoolStatus(ThreadPoolExecutor executor, String msg) {
		MyLinkedBlockingQueue queue = (MyLinkedBlockingQueue) executor.getQueue();
		System.out.println(Thread.currentThread().getName() + "-" + msg +
				" 核心线程数:" + executor.getCorePoolSize() +
				" 活动线程数:" + executor.getActiveCount() +
				" 最大线程数:" + executor.getMaximumPoolSize() +
				" 线程池活跃度:" + divide(executor.getActiveCount() , executor.getMaximumPoolSize()) +
				" 任务完成数:" + executor.getCompletedTaskCount() +
				" 队列大小:" + (queue.size() + queue.remainingCapacity()) +
				" 队列剩余大小:" + queue.remainingCapacity() +
				" 当前排队数量:" + queue.size() +
				" 队列使用度:" + divide(queue.size() , (queue.size() + queue.remainingCapacity()))
		);
	}

	private static String divide(int x, int y) {
		return String.format("%.2f%%",
				(double) x / (double) y * 100
		);
	}


}
