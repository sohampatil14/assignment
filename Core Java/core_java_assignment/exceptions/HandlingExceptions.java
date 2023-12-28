package exceptions;

import java.util.Arrays;

/**
 * Handling Exceptions -
 * 1. handling using try...catch blocks
 * 2. multiple catch blocks (specific to generalized)
 * 3. catching multiple exceptions using one catch block (Java 7)
 * 4. finally statement
 * 
 * throws and throw with UserDefinedException
 */

@SuppressWarnings("serial")
class DivideByZeroException extends RuntimeException {
	private double neumerator;
	private double denominator;
	
	public DivideByZeroException(double neumerator, double denominator) {
		this.neumerator = neumerator;
		this.denominator = denominator;
	}
	
	public double[] getOperands() {
		return new double[] {neumerator, denominator};
	}
	
	public String getLocalizedMessage() {
		return "Cannot Divide neumerator " + this.neumerator + " by denominator " + this.denominator;
	};
	
}

public class HandlingExceptions {
	
	public static double divideOperation(double neumerator, double denominator) throws DivideByZeroException {
		if(denominator == 0) {
			throw new DivideByZeroException(neumerator, denominator);
		}
		else {
			return neumerator/denominator;
		}
	}
	
	public static void main(String[] args) {
		double[] neumerators = {10, 2, 3, 8, 16};
		double[] denominators = {3, 8, 0, 4, 2};
		
		double[] results = new double[neumerators.length];
		
		for (int i = 0; i < neumerators.length; i++) {
			
			try {
				results[i] = Double.parseDouble(String.format("%.2f", divideOperation(neumerators[i], denominators[i])));
			} 
			catch(NullPointerException npe) {
				System.err.println("NullPointerException detected, numerator array length: " + neumerators.length + " denominator array length: " + denominators.length + " mismatch");
				System.err.println(npe.getCause());
				System.err.println(npe.getLocalizedMessage());
				npe.printStackTrace();
			}
			catch(DivideByZeroException dbze) {
				System.err.println(dbze.getLocalizedMessage());
				dbze.printStackTrace();
			}
			catch(ArithmeticException ae) {
				System.err.println(ae.getCause());
				System.err.println(ae.getLocalizedMessage());
				ae.printStackTrace();
			}
			finally {
				System.out.println("Operations performed: " + i);
				System.out.println(Arrays.toString(results));
			}
		}
		
	}

}
