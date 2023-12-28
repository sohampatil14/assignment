package oops_concepts;

/**
 * Polymorphism -
 * Compile time Polymorphism - Overloading functions in a single class 
 */

class Triangle extends Shape {
	
	double base;
	double height;
	
	public Triangle(double base, double height) {
		super(3);
		super.calculatePerimeter();
		this.base = base;
		this.height = height;
	}
	
	void calculateArea() {
		area = 0.5 * this.base * this.height;
	}
	
	void calculateArea(double[] sides) {
		super.sides = sides; 
		super.calculatePerimeter();
		double semiPerimeter = perimeter/2;
		area = Math.sqrt(semiPerimeter * (semiPerimeter - sides[0]) * (semiPerimeter - sides[1]) * (semiPerimeter - sides[2]));
	}
}

public class OOPSCompileTimePolymorphism {

	public static void main(String[] args) {

		Triangle triangle1 = new Triangle(3, 4);
		triangle1.calculateArea(new double[] {3, 4, 5} );
		System.out.println("Area of a triangle using semiperimeter formula: " + triangle1.area);
		triangle1.calculateArea();
		System.out.println("Area of a triangle with 0.5bh formual: " + triangle1.area);
	}

}
