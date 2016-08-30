package designpattern.factory.now.simplefactory;

public class Client {

	public static void main(String[] args) {
		/**
		 * 所有的Computer都在一个Factory中创建
		 */
		ComputerFactory factory = new ComputerFactory();
		
		Computer lenovoComputer = factory.getComputer(ComputerType.LENOVO);
		lenovoComputer.makeComputer();
		
		Computer acerComputer = factory.getComputer(ComputerType.ACER);
		acerComputer.makeComputer();
		
	}

}
