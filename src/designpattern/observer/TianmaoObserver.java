package designpattern.observer;

public class TianmaoObserver extends Observer {

	public TianmaoObserver(Subject subject) {
		this.subject = subject;
		this.subject.attachObserver(this);
	}
	
	@Override
	public void update() {
		System.out.println("天猫 价格变动：" + subject.getPrice());
	}

}
