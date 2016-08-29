package designpattern.template;

/**
 * 抽象模板类
 * @author Frank Jiang
 */
public abstract class AbstractTemplate {
	
	// 抽象方法：打开冰箱门
	public abstract void open();
	// 抽象方法：把大象放入
	public abstract void put(String elephant);
	// 抽象方法：关闭冰箱门
	public abstract void close();

	// 模板方法： 把大象装冰箱的过程
	public void putInElephant(String elephant) {
		open();
		put(elephant);
		close();
	}
}
