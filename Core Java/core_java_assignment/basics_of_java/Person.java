package basics_of_java;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.Period;
import java.util.Scanner;

/** Program which explores basics of class and objects in Java
 * TODO 
 * 1. Create a class
 * 2. Add instance variables and methods
 * 3. Add constructor
 * 4. Create an object
 */

public class Person {
	
	/**
	 * A Person class to store person information
	 */
	
	String name;
	int age; // Age will be calculated automatically from date of birth
	public String gender;
	public LocalDate dateOfBirth;
	long phoneNumber;
	String email;
	String nationality;
	
	// Default Constructor assigning pre-defined values 
	Person() {
		this.name = "Person";
		this.dateOfBirth = LocalDate.of(2002, 01, 01);
		this.calculateAge();
		this.gender = "Male";
		this.phoneNumber = 9876543210L;
		this.email = "person@mail.com";
		this.nationality = "Indian";
	}
	
	public Person(String name, String dateOfBirth, String gender) {
		this.name = name;
		this.dateOfBirth = LocalDate.parse(dateOfBirth, DateTimeFormatter.ofPattern("d-M-y"));
		this.calculateAge();
		this.gender = gender;
	}
	
	// Parameterized Constructor for assigning user values
	Person(String name, String dateOfBirth, String gender, long phone_number, String email, String nationality) {
		this.name = name;
		this.dateOfBirth = LocalDate.parse(dateOfBirth, DateTimeFormatter.ofPattern("d-M-y"));
		this.calculateAge();
		this.gender = gender;
		this.phoneNumber = phone_number;
		this.email = email;
		this.nationality = nationality;
	}
	
	// String representation of Person object
	@Override
	public String toString() {
		return "{" + this.name + ", " + this.age + ", " + this.gender + "}";
	}
	
	// private function which calculates date of birth from age
	private void calculateAge() {
		this.age = Period.between(this.dateOfBirth, LocalDate.now()).getYears();
	}
	
	protected String getName() {
		return this.name;
	}
	
	public int getAge() {
		return this.age;
	}
	
	String getGender() {
		return this.gender;
	}
	
	LocalDate getDateOfBirth() {
		return this.dateOfBirth;
	}
	
	long getPhoneNumber() {
		return this.phoneNumber;
	}
	
	String getEmail() {
		return this.email;
	}
	
	String getNationality() {
		return this.nationality;
	}
	
	// A public static method which gives information on class
	public static String classInfo() {
		return "A Person Class which stores a person's name, age, gender, dob, phone number, email and nationality";
	}
	
	public static void main(String[] args) {
		
		System.out.println("\n" + Person.classInfo() + "\n");
		
		// Default Constructor Person object
		Person personObjDefault = new Person();
		System.out.println("Default Person Object: " + personObjDefault + "\n");
		
		// Getting inputs for custom Person object
		Scanner scan = new Scanner(System.in);
				
		System.out.print("Enter name of the person: ");
		String name = scan.next();
		
		System.out.print("Enter date of birth of " + name + " separated by \'-\' in D-M-Y format: ");
		String dateOfBirth = scan.next();
		
		System.out.print("Enter gender of " + name + ": ");
		String gender = scan.next();
		
		System.out.print("Enter phone number of " + name + ": ");
		long phone_number = scan.nextLong();
		
		System.out.print("Enter email of " + name + ": ");
		String email = scan.next();
		
		System.out.print("Enter nationality of " + name + ": ");
		String nationality = scan.next();
		
		scan.close();

		// Parameterized Constructor Person object
		Person personObj = new Person(name, dateOfBirth, gender, phone_number, email, nationality);
		System.out.println("\n" + "Custom Input Person Object: " + personObj + "\n");
		
		// Class methods
		System.out.println(personObj.getName());
		System.out.println(personObj.getAge());
		System.out.println(personObj.getGender());
		System.out.println(personObj.getDateOfBirth());
		System.out.println(personObj.getPhoneNumber());
		System.out.println(personObj.getEmail());
		System.out.println(personObj.getNationality());
		
	}

}