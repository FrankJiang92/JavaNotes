package designpattern.factory.now.abstractfactory;

public class LenovoComputerFactory implements ComputerFactory {

	@Override
	public Computer makeLaptopComputer() {
		return new LenovoLaptopComputer();
	}

	@Override
	public Computer makeDesktopComputer() {
		return new LenovoDesktopComputer();
	}

	
}
