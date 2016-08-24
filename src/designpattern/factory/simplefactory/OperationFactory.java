package designpattern.factory.simplefactory;

public class OperationFactory {
	
	public static IOperation createOperation(Operator operator) {
		IOperation operation = null;
		switch (operator) {
			case ADD:
				operation = new OperationAdd();
				break;
			case SUB:
				operation = new OperationSub();		
				break;
			case MUL:
				operation = new OperationMul();
				break;
			case DIV:
				operation = new OperationDiv();
				break;
			
			default:
				break;
		}
		return operation;
	}
}
