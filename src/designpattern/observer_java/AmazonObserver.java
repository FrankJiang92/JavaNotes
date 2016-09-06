package designpattern.observer_java;

import java.util.Observable;
import java.util.Observer;

public class AmazonObserver implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("亚马逊 价格变动：" + ((Subject) o).getName() +  arg);
	}

}
