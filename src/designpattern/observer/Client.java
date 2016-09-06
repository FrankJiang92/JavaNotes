package designpattern.observer;

public class Client {

	public static void main(String[] args) {
		Subject subject = new Subject();
		subject.setPrice(100);
		
		Observer tianmao = new TianmaoObserver(subject);
		Observer jingdong = new JingdongObserver(subject);
		Observer amazon = new AmazonObserver(subject);
		System.out.println(">>>>>>>>>>>提价");
		subject.setPrice(120);
		System.out.println(">>>>>>>>>>>降价");
		subject.setPrice(80);
	}

}
