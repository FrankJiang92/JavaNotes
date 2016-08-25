package designpattern.facade;

public class MakeComputor {

	public void make() {
		IPurchase purchaser = new IPurchaseImpl();
		IInstall installer = new IInstallImpl();
		ITest tester = new ITestImpl();
		System.out.println(">>>Make Computor : Start<<<");
		purchaser.purchase();
		installer.install();
		tester.test();
		System.out.println(">>>Make Computor : Finish<<<");
	}
}
