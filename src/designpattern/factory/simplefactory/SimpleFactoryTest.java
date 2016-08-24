package designpattern.factory.simplefactory;

public class SimpleFactoryTest {

	public static void main(String[] args) {
		double a = 100.0;
		double b = 30.0;
		
		IOperation operation = OperationFactory.createOperation(Operator.ADD);
		double result = operation.getResult(a, b);
		System.out.println("---->Result: " + result);
	}

}
