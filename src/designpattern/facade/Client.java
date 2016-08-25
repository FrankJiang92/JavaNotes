package designpattern.facade;

public class Client {

	public static void main(String[] args) {
		// 组装电脑
		MakeComputor maker = new MakeComputor();
		
		maker.make();
	}

}
