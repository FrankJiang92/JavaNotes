package designpattern.factory.now.factorymethod;

public class AcerComputerFactory implements ComputerFactory {

	@Override
	public Computer getComputer() {
		return new AcerComputer();
	}

}
