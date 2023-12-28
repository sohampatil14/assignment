package collections_comparison;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;

import javax.swing.event.ListDataEvent;

import basics_of_java.Person;

/**
 * List -
 * 1. ArrayList
 * 2. LinkedList
 * 3.Vector
 * 4. Stack
 * 
 * Set -
 * 1. HashSet
 * 2. LinkedHashSet
 * 3. TreeSet
 * 
 * Map -
 * HashMap
 * LinkedHashMap
 * TreeMap
 */
public class BasicCollections {

	public static void main(String[] args) {
		
		Person Eugene = new Person("Eugene C. Guerin", "27-04-1987", "Male");
		Person Nicholas = new Person("Nicholas S. Brennan", "15-07-1968", "Male");
		Person Carolyn = new Person("Carolyn D. Cannon", "21-05-1979", "Female");
		Person Issac = new Person("Isaac J. McDonald", "02-02-1947", "Male");
		Person Betty = new Person("Betty M. Obrien", "21-01-1983", "Female");
		
		ArrayList<Person> personArrayList = new ArrayList<Person>();
		
		personArrayList.add(Betty);
		personArrayList.addFirst(Eugene);
		personArrayList.remove(Betty);
		personArrayList.add(0, Nicholas);
		personArrayList.clear();
		personArrayList.add(Issac);
		personArrayList.addLast(Carolyn);
		
		System.out.println("ArrayList:\n" + personArrayList);
		
		LinkedList<Person> personLinkedList = new LinkedList<Person>();
		
		personLinkedList.addAll(personArrayList);
		personLinkedList.add(Betty);
		personLinkedList.addFirst(Eugene);
		personLinkedList.add(0, Nicholas);
		
	    System.out.println("\nLinkedList\n" + personLinkedList);
		
		Vector<Person> personVector = new Vector<Person>(2);
		
		personVector.addAll(personLinkedList);
		personVector.removeAll(personArrayList);
		
		System.out.println("\nVector:\n" + personVector);
		
		Stack<Person> personStack = new Stack<Person>();
		
		personStack.push(Betty);
		personStack.push(Issac);
		personStack.pop();
		personStack.push(Nicholas);
		personStack.push(Eugene);
		personStack.pop();
		personStack.push(Carolyn);
		
		System.out.println("\nStack:\n" + personStack);
		
		HashSet<Person> personHSet = new HashSet<Person>();
		
		personHSet.add(Issac);
		personHSet.add(Betty);
		personHSet.add(Betty); // cannot insert duplicate objects in a set
		personHSet.add(Carolyn);
		personHSet.add(Eugene);
		personHSet.add(Nicholas);
		
		System.out.println("\nHashSet:\n" + personHSet); // HashSet doesn't maintain insertion order
		
		LinkedHashSet<Person> personLHSet = new LinkedHashSet<Person>();
		
		personLHSet.add(Issac);
		personLHSet.add(Betty);
		personLHSet.add(Carolyn);
		personLHSet.add(Eugene);
		personLHSet.add(Nicholas);
		
		System.out.println("\nLinkedHashSet:\n" + personLHSet); // LinkedHashSet maintains insertion order
		
		Student Stephen = new Student("Stephen D. Salvato", "13-11-2015", "Male", "Summers Institute", 103);
		Student Diana = new Student("Diana R. Schimmel", "16-12-2018", "Female", "Bear River Elementary", 102);
		Student Velma = new Student("Velma W. Lope", "14-01-2014", "Female", "Waterfalls Middle School", 101);
		Student Shawn = new Student("Shawn N. Sparks", "25-02-2010", "Male", "Mountainview School", 105);
		Student David = new Student("David A. Booher", "09-11-2012", "Male", "Westside School", 104);
		
		TreeSet<Student> studentTSet = new TreeSet<Student>();
		
		studentTSet.add(Stephen);
		studentTSet.add(Diana);
		studentTSet.add(Velma);
		studentTSet.add(Shawn);
		studentTSet.add(David);
		
		System.out.println("\nTreeSet:\n" + studentTSet); // TreeSet sorts the objects based on the compareTo() method overrided from Comparable interface
		
		HashMap<Integer, Student> studentHMap = new HashMap<Integer, Student>();
		
		studentHMap.put(Stephen.rollNo, Stephen);
		studentHMap.put(Velma.rollNo, Velma);
		studentHMap.put(David.rollNo, David);
		studentHMap.put(Shawn.rollNo, Shawn);
		studentHMap.put(Diana.rollNo, Diana);
		
		Set set = studentHMap.entrySet();
	    Iterator iterator = set.iterator();
	    
	    System.out.println("\nHashMap:\n");
	    
	    while(iterator.hasNext()) {
	      Map.Entry mEntry = (Map.Entry)iterator.next();
	      System.out.print("Roll No: "+ mEntry.getKey() + ", Value: ");
	      System.out.println(mEntry.getValue());
	    }
	    
	    System.out.println();
	    
	    TreeMap<Integer, Student> studentTMap = new TreeMap<Integer, Student>();
	    
	    studentTMap.put(Stephen.rollNo, Stephen);
		studentTMap.put(Diana.rollNo, Diana);
		studentTMap.put(Velma.rollNo, Velma);
		studentTMap.put(Shawn.rollNo, Shawn);
		studentTMap.put(David.rollNo, David);

		set = studentTMap.entrySet();
	    iterator = set.iterator();
	    
	    System.out.println("\nTreeMap:\n");
	    
	    while(iterator.hasNext()) {
	      Map.Entry mEntry = (Map.Entry)iterator.next();
	      System.out.print("Roll No: "+ mEntry.getKey() + ", Value: ");
	      System.out.println(mEntry.getValue());
	    }
	    
	    System.out.println();
	    
		LinkedHashMap<Integer, Student> studentLHMap = new LinkedHashMap<Integer, Student>();
		
		studentLHMap.put(Stephen.rollNo, Stephen);
		studentLHMap.put(Velma.rollNo, Velma);
		studentLHMap.put(David.rollNo, David);
		studentLHMap.put(Shawn.rollNo, Shawn);
		studentLHMap.put(Diana.rollNo, Diana);
		
		set = studentLHMap.entrySet();
	    iterator = set.iterator();
	    
	    System.out.println("\nLinkedHashMap:\n");
	    
	    while(iterator.hasNext()) {
	      Map.Entry mEntry = (Map.Entry)iterator.next();
	      System.out.print("Roll No: "+ mEntry.getKey() + ", Value: ");
	      System.out.println(mEntry.getValue());
	    }
	    System.out.println();
	}
}
