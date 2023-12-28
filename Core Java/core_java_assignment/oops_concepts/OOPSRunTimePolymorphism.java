package oops_concepts;

/**
 * Polymorphism
 * Run time Polymorphism - Overriding a parent class method 
 */

class Square extends Rectangle {

	public Square(double side) {
		super(side, side);
	}
	
	@Override
	void calculateArea() {
		area = Math.pow(sides[0], 2);
	}
	
	@Override
	void calculatePerimeter() {
		perimeter = 4*sides[0]; 
	}
	
}

public class OOPSRunTimePolymorphism {

	public static void main(String[] args) {
		
		Square square1 = new Square(4);
		square1.calculateArea();
		square1.calculatePerimeter();
		System.out.println("Area of a square: " + square1.area);
		System.out.println("Perimeter of a square: " + square1.perimeter);
	}

}
