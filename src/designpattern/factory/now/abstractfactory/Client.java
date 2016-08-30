package designpattern.factory.now.abstractfactory;

public class Client {

	public static void main(String[] args) {
		// lenovo laptop computer
		ComputerFactory lenovoFactory = new LenovoComputerFactory();
		Computer lenovoLaptop = lenovoFactory.makeLaptopComputer();
		lenovoLaptop.getComputer();
		
		// acer desktop computer
		ComputerFactory acerFactory = new AcerComputerFactory();
		Computer acerDesktop = acerFactory.makeDesktopComputer();
		acerDesktop.getComputer();
	}

}
