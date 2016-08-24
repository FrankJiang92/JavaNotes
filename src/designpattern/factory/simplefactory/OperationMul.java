package designpattern.factory.simplefactory;

/**
 * 乘法运算类
 * @author jiangfan_sx
 *
 */
public class OperationMul implements IOperation {

	@Override
	public double getResult(double a, double b) {
		return a * b;
	}

}
