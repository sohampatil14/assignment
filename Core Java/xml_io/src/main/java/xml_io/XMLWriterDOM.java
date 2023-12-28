package xml_io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Random;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import collections_comparison.Student;

public class XMLWriterDOM {

	public static void main(String[] args) throws ParserConfigurationException, TransformerException, FileNotFoundException {
		
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		
		Document document = docBuilder.newDocument();
		Element rootElement = document.createElement("class");
		document.appendChild(rootElement);
		
		ArrayList<Student> students = new ArrayList<Student>();
		
		Random randFloat = new Random();
		students.add(new Student("Stephen D. Salvato", "13-11-2015", "Male", "Summers Institute", randFloat.nextFloat(45, 99)));
		students.add(new Student("Diana R. Schimmel", "16-12-2018", "Female", "Bear River Elementary", randFloat.nextFloat(45, 99)));
		students.add(new Student("Velma W. Lope", "14-01-2014", "Female", "Waterfalls Middle School", randFloat.nextFloat(45, 99)));
		students.add(new Student("Shawn N. Sparks", "25-02-2010", "Male", "Mountainview School", randFloat.nextFloat(45, 99)));
		students.add(new Student("David A. Booher", "09-11-2012", "Male", "Westside School", randFloat.nextFloat(45, 99)));
		
		for (int i = 0; i < students.size(); i++) {
			
			Element student = document.createElement("student");
			rootElement.appendChild(student);
			student.setAttribute("rollno", "10"+i);
			
			Element birthDate = document.createElement("birthdate");
			birthDate.setTextContent(students.get(i).dateOfBirth.toString());
			student.appendChild(birthDate);
			
			Element gender = document.createElement("gender");
			gender.setTextContent(students.get(i).gender);
			student.appendChild(gender);
			
			Element school = document.createElement("school");
			school.setTextContent(students.get(i).schoolName);
			student.appendChild(school);
			
			Element marks = document.createElement("marks");
			marks.setTextContent(String.valueOf(students.get(i).totalMarks));
			student.appendChild(marks);
		}

		// https://mkyong.com/java/how-to-create-xml-file-in-java-dom/
		
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
	    Transformer transformer = transformerFactory.newTransformer();

	    // pretty print
	    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	    
	    FileOutputStream file = new FileOutputStream("xml\\write.xml", false);
	    transformer.transform(new DOMSource(document), new StreamResult(file));
		
	}

}
