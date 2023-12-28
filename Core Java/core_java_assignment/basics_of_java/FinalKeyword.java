package basics_of_java;

/** Final keyword usage in -
 * 1. class
 * 2. method
 * 3. variable
 */

// final class usage

//final class FinalClass {
//	
//}
//
//class SubClass extends FinalClass {
//	
//}

// final method usage 

//class FinalMethodClass {
//	
//	public final void finalMethod() {
//		System.out.println("This is a final method.");
//	}
//}
//
//class SubClass2 extends FinalMethodClass {
//	
//	@Override
//	public void finalMethod() {
//		System.out.println("This is a final method inherited from parent class.");
//	}
//}

public class FinalKeyword {

	public static void main(String[] args) {
		
		// final variable usage
		final int finalVariable = 10;
		System.out.println("Final variable declared and initialized: " + finalVariable);
		// changing value of a final variable gives error
		// finalVariable = 10;	
		
		// SubClass sc = new SubClass(); 
		
		// SubClass2 sc2 = new SubClass2();
		// sc2.finalMethod();
		
	}
}
