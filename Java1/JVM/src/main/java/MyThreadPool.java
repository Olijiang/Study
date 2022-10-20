import org.springframework.scheduling.concurrent.CustomizableThreadFactory;

import java.util.Date;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author ZGB
 * @version 1.0
 * @description: TODO
 * @date 2022/10/19 15:58
 */
public class MyThreadPool extends ThreadPoolExecutor {

	private int maxThreadCount = 20;
	private final int minimumQueueCount;
	private final int coreThreadCount;
	private final String threadName;
	private Long st;


	public MyThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, int BlockingQueueCapacity, String threadName) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit.SECONDS, new MyLinkedBlockingQueue<>(BlockingQueueCapacity), new CustomizableThreadFactory(threadName));
		this.minimumQueueCount = BlockingQueueCapacity;
		this.coreThreadCount = corePoolSize;
		this.threadName = threadName;
		this.st = new Date().getTime();
	}

	public int getMaxThreadCount() {
		return maxThreadCount;
	}

	public void setMaxThreadCount(int maxThreadCount) {
		this.maxThreadCount = maxThreadCount;
	}

	@Override
	public void execute(Runnable command) {
		// 提交之前检查线程池队列容量是否需要增加
		dynamicIncrease(this);
		super.execute(command);
	}

	@Override
	protected void afterExecute(Runnable r, Throwable t) {
		threadPoolStatus(this,"");
		dynamicDecrease(this);
	}

	@Override
	public void shutdown() {
		super.shutdown();
		try {
			this.awaitTermination(10, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		threadPoolStatus(this,"关闭线程池-->>");
		System.out.println("experience time ---->" + (new Date().getTime() - st)+"ms");
	}

	private void dynamicIncrease(ThreadPoolExecutor executor) {
		// 动态修改线程池参数, 核心线程和最大线程数量一致
		// 队列初始化大小为核心线程的2倍
		MyLinkedBlockingQueue<Runnable> queue = (MyLinkedBlockingQueue<Runnable>) executor.getQueue();
		double d = (double)queue.size() / (double)queue.getQueueSize();    // 队列使用率
		// 队列使用率达到百分之90开始扩容
		if(d>0.9){
			synchronized ("increase"){
				queue = (MyLinkedBlockingQueue<Runnable>) executor.getQueue();
				d = (double)queue.size() / (double)queue.getQueueSize();    // 队列使用率
				if(d>0.9){
					threadPoolStatus(executor, "扩容前状态");
					if (executor.getCorePoolSize()<maxThreadCount){
						// 核心线程数最大限制
						executor.setCorePoolSize(executor.getCorePoolSize() << 1);
						executor.setMaximumPoolSize(executor.getMaximumPoolSize() << 1);
					}
					queue.setQueueSize(queue.getQueueSize() << 1);
					threadPoolStatus(executor, "扩容后状态");
				}
			}
		}
	}

	private void dynamicDecrease(ThreadPoolExecutor executor) {

		MyLinkedBlockingQueue<Runnable> queue = (MyLinkedBlockingQueue<Runnable>) executor.getQueue();
		double d = (double)queue.size() / (double) queue.getQueueSize();    // 队列使用率
		// 队列使用率小于0.45 开始减容 ,
		if(d<0.4 && queue.getQueueSize() > minimumQueueCount){
			synchronized ("decrease"){
				queue = (MyLinkedBlockingQueue<Runnable>) executor.getQueue();
				d = (double)queue.size() / (double) queue.getQueueSize();    // 队列使用率
				if(d<0.4){
					threadPoolStatus(executor,"减容前状态");
					if (queue.getQueueSize() > minimumQueueCount){
						queue.setQueueSize(queue.getQueueSize() >> 1);
					}
					if (executor.getCorePoolSize()>queue.getQueueSize()>>1 ){
						// 核心线程 > 队列的一半开始减线程
						executor.setCorePoolSize(executor.getCorePoolSize() >> 1);
						executor.setMaximumPoolSize(executor.getMaximumPoolSize() >> 1 );
					}
					threadPoolStatus(executor,"减容后状态");
				}

			}
		}
	}

	private void threadPoolStatus(ThreadPoolExecutor executor, String msg) {
		MyLinkedBlockingQueue<Runnable> queue = (MyLinkedBlockingQueue<Runnable>) executor.getQueue();
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

	private String divide(int x, int y) {
		return String.format("%.2f%%",
				(double) x / (double) y * 100
		);
	}
}
