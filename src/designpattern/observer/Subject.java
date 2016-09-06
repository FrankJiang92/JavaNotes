package designpattern.observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {

	private List<Observer> observers = new ArrayList<Observer>();
	
	private int price;

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
		this.notifyAllObserver();
	}
	
	
	public void attachObserver(Observer observer) {
		observers.add(observer);
	}
	
	private void notifyAllObserver() {
		for (Observer observer : observers) {
			observer.update();
		}
	}
	
}
