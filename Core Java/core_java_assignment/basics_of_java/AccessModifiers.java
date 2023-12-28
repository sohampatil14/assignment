package basics_of_java;

/** Access Modifiers
 *  1. public - visible to everyone 
 *  2. private - only visible to class
 *  3. protected - only visible to the package and all subclasses
 *  4. default - only visible to the packages
 */

class DifferentAccessModifiers {
	
	private int privateVariable;
	public int publicVariable;
	int defaultVariable;

	void setPrivateVariable() {
		// accessing private variable from within class
		this.privateVariable = 10;
	}
	
	int getPrivateVariable() {
		// accessing private variable from within class
		return privateVariable;
	}
	
}

public class AccessModifiers {

	public static void main(String[] args) {
		
		DifferentAccessModifiers dam = new DifferentAccessModifiers();
		
		// accessing private variable from getter and setter methods
		dam.setPrivateVariable();
		System.out.println("Private Variable Value from getter method: " + dam.getPrivateVariable());
		
		// accessing private variable outside class
		System.out.println("Accessing private variable outside class:");
		// dam.privateVariable = 10;
		// System.out.println(dam.privateVariable);
		
		
		Operations ops = new Operations();
		// accessing public static operation variable from package basicsOfJava.Operations
		Operations.operation = "/";
		System.out.println("Accessing public static operation variable from package basicsOfJava.Operations: " + Operations.operation);
		
		ops.performOperations(10, 2);

		// accessing protected result variable from package basicsOfJava.Operations
		System.out.println("Accessing protected result variable from package basicsOfJava.Operations: " + ops.result);
				
		// accessing default access modifier name variable from package basicsOfJava.Person
		Person personObj = new Person();
		System.out.println("Accessing default access modifier name variable from package basicsOfJava.Person: " + personObj.name);
		
	}
}
