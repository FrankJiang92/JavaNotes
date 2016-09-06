package designpattern.observer_java;

import java.util.Observable;
import java.util.Observer;

public class JingdongObserver implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("京东 价格变动："  + ((Subject) o).getName() +  arg);
	}

}
