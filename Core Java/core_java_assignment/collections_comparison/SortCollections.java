package collections_comparison;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

import basics_of_java.Person;

class Employee extends Person {

	String companyName;
	float salary;

	public Employee(String name, String dateOfBirth, String gender, String companyName, float salary) {
		super(name, dateOfBirth, gender);
		this.companyName = companyName;
		this.salary = salary; 
	}

	public float getSalary() {
		return this.salary;
	}
	
	@Override
	public String toString() {
		return "{" + getName() + ", " + this.companyName + ", " + this.salary + "}";
	}
}

class AgeCompare implements Comparator<Person> {
	@Override
	public int compare(Person o1, Person o2) {
		if (o1.getAge() < o2.getAge())
            return -1;
        if (o1.getAge() > o2.getAge())
            return 1;
        else
            return 0;
	}
}

class SalaryCompare implements Comparator<Employee> {
	@Override
	public int compare(Employee e1, Employee e2) {
		if (e1.getSalary() < e2.getSalary())
            return -1;
        if (e1.getSalary() > e2.getSalary())
            return 1;
        else
            return 0;
	}
}

class MarksCompare implements Comparator<Student> {
	@Override
	public int compare(Student s1, Student s2) {
		if (s1.getTotalMarks() < s2.getTotalMarks())
            return -1;
        if (s1.getTotalMarks() > s2.getTotalMarks())
            return 1;
        else
            return 0;
	}
}

public class SortCollections {

	public static void main(String[] args) {
		
		Random randFloat = new Random();
		
		ArrayList<Student> students = new ArrayList<Student>();
		
		students.add(new Student("Stephen D. Salvato", "13-11-2015", "Male", "Summers Institute", randFloat.nextFloat(45, 99)));
		students.add(new Student("Diana R. Schimmel", "16-12-2018", "Female", "Bear River Elementary", randFloat.nextFloat(45, 99)));
		students.add(new Student("Velma W. Lope", "14-01-2014", "Female", "Waterfalls Middle School", randFloat.nextFloat(45, 99)));
		students.add(new Student("Shawn N. Sparks", "25-02-2010", "Male", "Mountainview School", randFloat.nextFloat(45, 99)));
		students.add(new Student("David A. Booher", "09-11-2012", "Male", "Westside School", randFloat.nextFloat(45, 99)));
		
		System.out.println("Original Student List:\n" + students);
		Collections.sort(students);
		System.out.println("\nStudent List sorted based on age:\n" + students);
		Collections.sort(students, new MarksCompare());
		System.out.println("\nStudent List sorted based on marks:\n" + students);
		
		ArrayList<Employee> employees = new ArrayList<Employee>();
		
		employees.add(new Employee("Stephen D. Salvato", "13-11-2015", "Male", "Summers Institute", randFloat.nextFloat(40_000, 80_000)));
		employees.add(new Employee("Diana R. Schimmel", "16-12-2018", "Female", "Bear River Elementary", randFloat.nextFloat(40_000, 80_000)));
		employees.add(new Employee("Velma W. Lope", "14-01-2014", "Female", "Waterfalls Middle School", randFloat.nextFloat(40_000, 80_000)));
		employees.add(new Employee("Shawn N. Sparks", "25-02-2010", "Male", "Mountainview School", randFloat.nextFloat(40_000, 80_000)));
		employees.add(new Employee("David A. Booher", "09-11-2012", "Male", "Westside School", randFloat.nextFloat(40_000, 80_000)));
		
		System.out.println("\nOriginal Employee List:\n" + employees); 
		Collections.sort(employees, new AgeCompare());
		System.out.println("\nEmployee List sorted based on age:\n" + employees);
		Collections.sort(employees, new SalaryCompare());
		System.out.println("\nEmployee List sorted based on salary:\n" + employees);
	}

}
