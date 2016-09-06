package designpattern.observer_java;

import java.util.Observable;

public class Subject extends Observable {

	
	private String name;
	private int price;
	
	public Subject(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
		this.setChanged();
		this.notifyObservers(price);
	}
	
}
