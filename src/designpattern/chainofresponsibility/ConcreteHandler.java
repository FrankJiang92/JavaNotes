package designpattern.chainofresponsibility;

public class ConcreteHandler extends Handler {

	@Override
	public void handleRequest() {
		if (getSuccessor() != null) {
			System.out.println("---->跳到下一个处理");
			getSuccessor().handleRequest();
		} else {
			System.out.println("---->直接处理请求");
		}
	}

}
