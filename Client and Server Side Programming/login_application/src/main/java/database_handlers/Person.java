package database_handlers;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Person {
	
	/**
	 * A Person class to store person information
	 */
	
	String prefix;
	String name;
	String username;
	String email;
	String password;
	public LocalDate dateOfBirth;
	byte age; // Age will be calculated automatically from date of birth
	public String gender;
	String firstName;
	String lastName;
	String middleName;
	
	// Default Constructor assigning pre-defined values 
	public Person() throws NoSuchAlgorithmException {
		this.prefix = "Mr.";
		this.name = "Person";
		this.splitName();
		this.username = "person";
		this.email = "person@mail.com";
		this.password = hashPassword("12345678");
		this.dateOfBirth = LocalDate.of(2002, 01, 01);
		this.calculateAge();
		this.gender = "Male";
	}
	
	public static String hashPassword(String password) throws NoSuchAlgorithmException {
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		byte[] hashedPassword = digest.digest(password.getBytes(StandardCharsets.UTF_8));
		String password_hash = "";
		for (byte b : hashedPassword) {
			password_hash += Integer.toString((b & 0xFF) + 0x111, 16).substring(1);
		}
		return password_hash;
	}
	
	// Parameterized Constructor for assigning user values
	public Person(String prefix, String first_name, String middle_name, String last_name, 
			String username, String email, String password, String birthdate, byte age, 
			String gender) throws NoSuchAlgorithmException {
		this.prefix = prefix;
		this.firstName = first_name;
		this.middleName = middle_name;
		this.lastName = last_name;
		this.name = first_name + " " + middle_name + " " + last_name;
		this.username = username;
		this.email = email;
		this.dateOfBirth = LocalDate.parse(birthdate, DateTimeFormatter.ofPattern("y-M-d"));
		this.age = age;
		this.gender = gender;
		this.password = hashPassword(password);
	}
	
	void splitName() {
		String[] nameStrings = this.name.split(" ");
		try {
			this.firstName = nameStrings[0];
			this.lastName = (nameStrings[nameStrings.length-1] == this.firstName)? null : nameStrings[nameStrings.length-1];
			this.middleName = nameStrings[1];
		}
		catch (ArrayIndexOutOfBoundsException e) {
		}
	}
	
	// String representation of Person object
	@Override
	public String toString() {
		return "{" + this.name + ", " + this.age + ", " + this.gender + "}";
	}
	
	// private function which calculates date of birth from age
	private void calculateAge() {
		this.age = (byte) Period.between(this.dateOfBirth, LocalDate.now()).getYears();
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
	
	String getEmail() {
		return this.email;
	}
	
	// A public static method which gives information on class
	public static String classInfo() {
		return "A Person Class which stores a person's name, age, gender, dob, phone number, email and nationality";
	}
}