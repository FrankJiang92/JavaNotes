package designpattern.factory.now.simplefactory;

public class LenovoComputer implements Computer {

	@Override
	public void makeComputer() {
		System.out.println("联想电脑...");
	}

}
