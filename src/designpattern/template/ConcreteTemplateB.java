package designpattern.template;

/**
 * 具体模板类 B
 * @author Frank Jiang
 */
public class ConcreteTemplateB extends AbstractTemplate {

	@Override
	public void open() {
		System.out.println("B：打开冰箱门...");
	}

	@Override
	public void put(String elephant) {
		System.out.println("B：放入 " + elephant);
	}

	@Override
	public void close() {
		System.out.println("B：关闭冰箱门...");
	}

}
