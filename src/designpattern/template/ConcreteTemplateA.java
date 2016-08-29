package designpattern.template;

/**
 * 具体模板类 A
 * @author Frank Jiang
 */
public class ConcreteTemplateA extends AbstractTemplate {

	@Override
	public void open() {
		System.out.println("A：打开冰箱门...");
	}

	@Override
	public void put(String elephant) {
		System.out.println("A：放入 " + elephant);
	}

	@Override
	public void close() {
		System.out.println("A：关闭冰箱门...");
	}

}
