package designpattern.factory.old.factorymethod;

public class FactoryMethodTest {

	public static void main(String[] args) {
		double a = 100.0;
		double b = 30.0;
		IOperationFactory factory = new OperationFactorySub();
		IOperation operation = factory.createOperation();
		double result = operation.getResult(a, b);
		System.out.println("------>Result: " + result);
	}

}
