package collections_comparison;

import basics_of_java.Person;

public class Student extends Person implements Comparable<Person> {

	public String schoolName;
	public float totalMarks;
	int rollNo;

	public Student(String name, String dateOfBirth, String gender, String schoolName, int rollNo) {
		super(name, dateOfBirth, gender);
		this.schoolName = schoolName;
		this.rollNo = rollNo;
	}
	
	public Student(String name, String dateOfBirth, String gender, String schoolName, float totalMarks) {
		super(name, dateOfBirth, gender);
		this.schoolName = schoolName;
		this.totalMarks = totalMarks;
	}

	@Override
	public int compareTo(Person o) {
		return o.getAge() - getAge();
	}

	float getTotalMarks() {
		return this.totalMarks;
	}

	@Override
	public String toString() {
		if(this.totalMarks != 0) {
			return "{" + getName() + ", " + this.schoolName + ", " + getAge() + ", " + this.totalMarks + "}";
		}
		return "{" + getName() + ", " + this.schoolName + ", " + getAge() + ", " + this.rollNo + "}";
	}
}