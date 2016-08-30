package designpattern.factory.old.factorymethod;

public class OperationFactorySub implements IOperationFactory {

	@Override
	public IOperation createOperation() {
		return new OperationSub();
	}

}
