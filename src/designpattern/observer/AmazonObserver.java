package designpattern.observer;

public class AmazonObserver extends Observer {

	
	
	public AmazonObserver(Subject subject) {
		this.subject = subject;
		this.subject.attachObserver(this);
	}

	@Override
	public void update() {
		System.out.println("亚马逊 价格变动：" + subject.getPrice());
	}

}
