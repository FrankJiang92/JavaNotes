package thread.custom;

import java.util.Scanner;

public class TestThreadPool {

	public static void main(String[] args) {
		
		ThreadPool pool = ThreadPool.getThreadPool();
		int no = 0;
		Scanner scan = new Scanner(System.in);
		while(scan.hasNextLine()) {
			int num = Integer.parseInt(scan.nextLine());
			for (int i = 0; i < num; i++) {
				pool.execute(new RunnableTask("---" + ++no + "---"));
			}
			System.out.println("================" + pool.toString() + "================");
		}
		
//		pool.destroy();
		
	}
	 
	 
	public static class RunnableTask implements Runnable {
		
		private String name;
		
		public String getName() {
			return name;
		} 
		
		public RunnableTask(String name) {
			this.name = name;
		}
		
		@Override
		public void run() {
			System.out.println("----->Runable：" + this.name + "开始执行");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("----->Runable：" + this.name + "结束执行");
		}
		
	}
	 
}
