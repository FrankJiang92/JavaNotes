package designpattern.factory.now.simplefactory;

public class ComputerFactory {

	public Computer getComputer(ComputerType type) {
		Computer computer = null;
		switch (type) {
		case LENOVO:
			computer = new LenovoComputer();
			break;
		case ACER:
			computer = new AcerComputer();
			break;
		default:
			break;
		}
		return computer;
	}
}
