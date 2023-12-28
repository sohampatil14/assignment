/**
 * 
 */
package xml_io;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.Attributes;

/**
 * 
 */
class Handler extends DefaultHandler {
	
	boolean id = false;  
	boolean firstname = false;  
	boolean lastname = false;  
	boolean subject = false;  
	boolean marks = false;  
	
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException{  
		
		System.out.println("Start Element :" + qName);  
		
		if(qName.equalsIgnoreCase("Id")) {  
			id=true;  
		}  
		if (qName.equalsIgnoreCase("FIRSTNAME")) {  
			firstname = true;  
		}  
		if (qName.equalsIgnoreCase("LASTNAME")) {  
			lastname = true;  
		}  
		if (qName.equalsIgnoreCase("SUBJECT")) {  
			subject = true;  
		}  
		if (qName.equalsIgnoreCase("MARKS")) {  
			marks = true;  
		}  
	}
	
	public void endElement(String uri, String localName, String qName) throws SAXException {  
		
		System.out.println("End Element:" + qName);  
	}
	
	public void characters(char ch[], int start, int length) throws SAXException {  
	
		if (id) {  
			System.out.println("ID : " + new String(ch, start, length));  
			id = false;  
		}  
		if (firstname) {  
			System.out.println("First Name: " + new String(ch, start, length));  
			firstname = false;  
		}  
		if (lastname) {  
			System.out.println("Last Name: " + new String(ch, start, length));  
			lastname = false;  
		}  
		if (subject) {  
			System.out.println("Subject: " + new String(ch, start, length));  
			subject = false;  
		}  
		if (marks) {  
			System.out.println("Marks : " + new String(ch, start, length));  
			marks = false;  
		}  
	}  
}
	
public class XMLRead {  
	
	/**
	 * @param args
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */
	public static void main(String[] args) throws ParserConfigurationException, SAXException {
		
		try {		
			SAXParserFactory parserFactory = SAXParserFactory.newInstance();		
			SAXParser saxParser = parserFactory.newSAXParser();		
			Handler handler = new Handler();
//			File file = new File("xml\\read.xml")
//			saxParser.parse(file, handler);
//			FileReader file1 = new FileReader("xml\\read.xml");
			InputSource is = new InputSource("xml\\read.xml");
			saxParser.parse(is, handler);
		}  
		catch(Exception e) {  
			e.printStackTrace();  
		} 
	}
}
