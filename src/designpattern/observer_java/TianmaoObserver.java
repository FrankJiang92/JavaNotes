package designpattern.observer_java;

import java.util.Observable;
import java.util.Observer;

public class TianmaoObserver implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("天猫 价格更新："  + ((Subject) o).getName() +  arg);
	}

}
