package designpattern.factory.now.factorymethod;

public class LenovoComputerFactory implements ComputerFactory {

	@Override
	public Computer makeComputer() {
		return new LenovoComputer();
	}
	
}
