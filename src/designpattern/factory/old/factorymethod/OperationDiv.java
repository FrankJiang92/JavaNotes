package designpattern.factory.old.factorymethod;

/**
 * 除法运算类
 * @author jiangfan_sx
 *
 */
public class OperationDiv implements IOperation {

	@Override
	public double getResult(double a, double b) {
		return a / b;
	}

}
