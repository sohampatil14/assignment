package basics_of_java;

/**
 * Variable Types:
 * 1. Local Variables
 * 2. Instance Variables
 * 3. Class/Static Variables 
 */

class Operations {
	
	// instance variable
	protected int result;
	
	// static variables
	public static String operation = "";
	
	static void assignOperation(String operationInput) {
		operation = operationInput;
	}
	
	void addOperation(int num1, int num2) {
		this.result = num1 + num2;
	}
	
	void subtractOperation(int num1, int num2) {
		this.result = num1 - num2;
	}
	
	void multiplyOperation(int num1, int num2) {
		this.result = num1 * num2;
	}
	
	void divideOperation(int num1, int num2) {
		try {
			this.result = num1 / num2;
		}
		catch(ArithmeticException e) {
			this.result = 0;
			System.err.println("Exception: " + e.getLocalizedMessage());
		}
	}
	
	void performOperations(int num1, int num2) {
		switch(operation) {
			case "+": {
				addOperation(num1, num2);
				break;
			}
			case "-": {
				subtractOperation(num1, num2);
				break;
			}
			case "*": {
				multiplyOperation(num1, num2);
				break;
			}
			case "/": {
				divideOperation(num1, num2);
				break;
			}
			default: {
				System.out.println("Wrong Operation.");
				break;
			}
		}
	}
}

public class VariablesTypes {

	static double operations() {
		Operations.assignOperation("+");
		
		// addOp is a local variable of method VariablesType.operations
		// This cannot be accessed out of this method
		Operations addOp = new Operations();
		addOp.performOperations(15, 10);
		return addOp.result;
	}
	
	public static void main(String[] args) {
		double operationResult = VariablesTypes.operations();
		System.out.println("Operation " + Operations.operation + " result: " + operationResult);
	}

}
