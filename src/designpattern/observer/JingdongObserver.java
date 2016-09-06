package designpattern.observer;

public class JingdongObserver extends Observer {

	public JingdongObserver(Subject subject) {
		this.subject = subject;
		this.subject.attachObserver(this);
	}
	
	@Override
	public void update() {
		System.out.println("京东 价格变动：" + subject.getPrice());
		
	}

}
