package designpattern.factory.now.factorymethod;

public class Client {

	public static void main(String[] args) {
		
		/**
		 * 不同电脑在不同的工厂中创建
		 * 每个工厂继承抽象工厂接口，并实现getComputer方法
		 */
		ComputerFactory lenovoFactory = new LenovoComputerFactory();
		Computer lenovoComputer = lenovoFactory.makeComputer();
		lenovoComputer.getComputer();

		ComputerFactory acerFactory = new AcerComputerFactory();
		Computer acerComputer = acerFactory.makeComputer();
		acerComputer.getComputer();
		
	}

}
