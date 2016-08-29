package designpattern.template;

/**
 * 测试方法
 * @author Frank Jiang
 */
public class Main {

	public static void main(String[] args) {
		
		//A 执行把大象放冰箱
		AbstractTemplate a = new ConcreteTemplateA();
		a.putInElephant("大象");
		
		//B 执行把大象放冰箱
		AbstractTemplate b = new ConcreteTemplateB();
		b.putInElephant("小象");
	}

}
