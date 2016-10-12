package thread.custom;

import java.util.LinkedList;
import java.util.List;

import thread.custom.TestThreadPool.RunnableTask;

/**
 * 自定义线程池类，实现线程管理<br>
 * Task:<br>
 * 	1. 创建线程<br>
 * 	2. 执行任务<br>
 *  3. 销毁线程<br>
 *  4. 获取线程状态<br>
 *  
 * @author Frank Jiang
 * 
 */
public class ThreadPool {

	// 默认线程个数
	private static int workerNum = 5;
	
	// 工作线程
	private WorkThread[] threads;
	
	// 未处理的任务
	private static volatile int finishedTask = 0;
	// 任务队列，作为一个缓冲，List线程不安全
	private List<Runnable> taskQueue = new LinkedList<Runnable>();
	
	private static ThreadPool threadPool;
	
	private ThreadPool() {
		this(5);
	}
	
	// 创建线程池，workerNum为工作线程个数
	private ThreadPool(int workerNum) {
		this.workerNum = workerNum;
		
		threads = new WorkThread[workerNum];
		
		for (int i = 0; i < workerNum; i++) {
			threads[i] = new WorkThread();
			threads[i].start();
		}
	}
	
	// 单例模式，获取ThreadPool实例
	public static ThreadPool getThreadPool() {
		return getThreadPool(ThreadPool.workerNum);
	}
	
	// 单例模式，获取ThreadPool实例
	public static ThreadPool getThreadPool(int workerNum) {
		if (workerNum <= 0) {
			workerNum = ThreadPool.workerNum;
		}
		if (threadPool == null) {
			threadPool = new ThreadPool(workerNum);
		}
		
		return threadPool;
	}
	
	// 执行任务，把任务加入任务队列，何时执行由线程池决定
	public void execute(Runnable task) {
		synchronized (taskQueue) {
			taskQueue.add(task);
			taskQueue.notify();
		}
	}
	
	// 批量执行任务
	public void execute(Runnable[] tasks) {
		synchronized (taskQueue) {
			for (Runnable runnable : tasks) {
				taskQueue.add(runnable);
			}
			taskQueue.notify();
		}
	}
	
	// 批量执行任务
	public void execute(List<Runnable> tasks) {
		synchronized (taskQueue) {
			for (Runnable runnable : tasks) {
				taskQueue.add(runnable);
			}
			taskQueue.notify();
		}
	}
	
	// 销毁线程
	public void destroy() {
		// 如果任务队列还有任务，则等待
		while(!taskQueue.isEmpty()) {
			System.out.println("---------------------------->" + this.toString());
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		// 停止工作线程
		for (int i = 0; i < workerNum; i++) {
			threads[i].stopThread();
			threads[i] = null;
		}
		
		threadPool = null;
		// 清空任务队列
		taskQueue.clear();
	}
	
	// 返回已完成任务的个数
	public int getWorkThreadNumber() {
		return finishedTask;
	}
	
	// 返回任务队列的长度，即未处理的任务个数
	public int getWaitTaskNumber() {
		return taskQueue.size();
	}
	
	@Override
	public String toString() {
		return "WorkThread Number:" + workerNum 
				+ "; Fished Number:" + finishedTask 
				+ "; Wait Number:" + getWaitTaskNumber();
	}
	
	// 工作线程
	private class WorkThread extends Thread {
		
		// 退出旗标
		private boolean isRunning = true;
			
		@Override
		public void run() {
			Runnable r = null;
			while(isRunning) {
				synchronized (taskQueue) {
					// 任务队列为空，则等待
					while(isRunning && taskQueue.isEmpty()) {
						try {
							taskQueue.wait(20);
						} catch (Exception e) {
							e.printStackTrace();
						}
						
					}
					// 任务队列不为空，取出一个队列
					if (!taskQueue.isEmpty()) {
						r = taskQueue.remove(0);
						System.out.println("取出Runnable---->Thread:" + this.getName() + "---->Runnable:" + ((RunnableTask)r).getName());
					}
				}
				
				if (r != null) {
					System.out.println("---->Start Thread:" + this.getName() + "---->Runnable:" + ((RunnableTask)r).getName());
					r.run();
					System.out.println("----------------->Start Thread:" + this.getName() + "---->Runnable:" + ((RunnableTask)r).getName());
				}
				
				finishedTask++;
				r = null;
			}
		}
		
		public void stopThread() {
			isRunning = false;
		}
	}
	
}
