package designpattern.factory.factorymethod;

/**
 * 减法运算类
 * @author jiangfan_sx
 *
 */
public class OperationSub implements IOperation {

	@Override
	public double getResult(double a, double b) {
		return a - b;
	}

}
