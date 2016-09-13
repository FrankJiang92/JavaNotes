package designpattern.chainofresponsibility;

/**
 * 抽象处理者
 * @author FrankJiang
 */
public abstract class Handler {

	// 后继处理对象
	protected Handler successor;
	
	public abstract void handleRequest();
	
	public Handler getSuccessor() {
		return successor;
	}
	
	public void setSuccessor(Handler successor) {
		this.successor = successor;
	}
	
}
