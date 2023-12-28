package jdbc_ms_sqlserver;

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
	int age; // Age will be calculated automatically from date of birth
	public String gender;
	String firstName;
	String lastName;
	String middleName;
	byte ratings;
	
	// Default Constructor assigning pre-defined values 
	Person() throws NoSuchAlgorithmException {
		this.prefix = "Mr.";
		this.name = "Person Pearson";
		this.splitName();
		this.username = "person";
		this.email = "person@mail.com";
		this.password = "12345678";
		this.hashPassword();
		this.dateOfBirth = LocalDate.of(2002, 01, 01);
		this.calculateAge();
		this.gender = "Male";
		this.ratings = 5;
	}
	
	private void hashPassword() throws NoSuchAlgorithmException {
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		byte[] hashedPassword = digest.digest(this.password.getBytes(StandardCharsets.UTF_8));
		password = "";
		for (byte b : hashedPassword) {
			password += Integer.toString((b & 0xFF) + 0x111, 16).substring(1);
		}
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
		this.email = email;
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
	
	String getEmail() {
		return this.email;
	}
	
	// A public static method which gives information on class
	public static String classInfo() {
		return "A Person Class which stores a person's name, age, gender, dob, phone number, email and nationality";
	}
}