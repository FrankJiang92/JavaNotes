package designpattern.factory.simplefactory;

/**
 * 加法运算类
 * @author jiangfan_sx
 *
 */
public class OperationAdd implements IOperation {

	@Override
	public double getResult(double a, double b) {
		return a + b;
	}

}
