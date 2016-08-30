package designpattern.factory.now.abstractfactory;

public class AcerComputerFactory implements ComputerFactory {

	@Override
	public Computer makeLaptopComputer() {
		return new AcerLaptopComputer();
	}

	@Override
	public Computer makeDesktopComputer() {
		return new AcerDesktopComputer();
	}

}
