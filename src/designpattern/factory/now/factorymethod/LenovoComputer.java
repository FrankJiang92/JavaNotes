package designpattern.factory.now.factorymethod;

public class LenovoComputer implements Computer {

	@Override
	public void makeComputer() {
		System.out.println("联想电脑...");
	}

}
