package oops_concepts;

import java.util.Arrays;

/**
 * Inheritance
 * 1. super keyword
 * 2. instanceof 
 */

class Shape {
	
	int numberOfSides;
	double[] sides;
	double area;
	double perimeter;
	
	public Shape() {
		numberOfSides = 0;
	}
	
	public Shape(int numberOfSides) {
		this.numberOfSides = numberOfSides;  
	}
	
	public Shape(int numberOfSides, double[] sides) {
		this.numberOfSides = numberOfSides; 
		this.sides = sides; 
	}
	
	void calculatePerimeter() {
		try {
			perimeter = Arrays.stream(sides).sum();
		} catch (NullPointerException e) {
		}
	}
}

class Rectangle extends Shape {
	
	double length;
	double breadth;
	
	public Rectangle(double length, double breadth) {
		super(4, new double[] {length, length, breadth, breadth});
		this.length = length;
		this.breadth = breadth;
	}
	
	void calculateArea() {
		area = this.length * this.breadth;
	}
	
	@Override
	void calculatePerimeter() {
		perimeter = 2 * (this.length * this.breadth);
	}
	
}

public class OOPSInheritance {

	public static void main(String[] args) {

		Rectangle rectangle1 = new Rectangle(5, 8);
		rectangle1.calculateArea();
		System.out.println("Area of rectangle: " + rectangle1.area);
		rectangle1.calculatePerimeter();
		System.out.println("Perimeter of rectangle: " + rectangle1.perimeter);
		System.out.println("Is rectangle1 object instance of Shape class: " + (rectangle1 instanceof Shape));
	}
}
