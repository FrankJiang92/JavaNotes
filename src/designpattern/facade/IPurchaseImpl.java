package designpattern.facade;

public class IPurchaseImpl implements IPurchase {

	@Override
	public void purchase() {
		System.out.println("Make Computor : Purchase");
	}

}
