package designpattern.factory.old.factorymethod;

/**
 * 加法运算工厂
 * @author jiangfan_sx
 *
 */
public class OperationFactoryAdd implements IOperationFactory {

	@Override
	public IOperation createOperation() {
		return new OperationAdd();
	}

}
