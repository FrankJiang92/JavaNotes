package designpattern.observer_java;

import java.util.Observer;

public class Client {

	public static void main(String[] args) {
		Subject subject = new Subject("《Java设计模式》");
		Observer tianmao = new TianmaoObserver();
		Observer jingdong = new JingdongObserver();
		Observer amazon = new AmazonObserver();
		
		subject.addObserver(tianmao);
		subject.addObserver(jingdong);
		System.out.println(">>>>>>>>升价");
		subject.setPrice(120);
		
		System.out.println("----------->加入亚马逊");
		subject.addObserver(amazon);
		
		System.out.println(">>>>>>>>降价");
		subject.setPrice(100);
		
	}

}
