package designpattern.strategy;

/**
 * 操作策略类的上下文环境
 * @author FrankJiang
 */
public class SortContext {
	
	private SortStrategy strategy;
	
	public SortContext() {
		strategy = new DefaultSortStrategy();
	} 
	
	public void sort(int[] input) {
		strategy.sort(input);
	}
	
	/**
	 * 设置策略类
	 * @param strategy
	 */
	public void setStrategy(SortStrategy strategy) {
		this.strategy = strategy;
	}
	
}
