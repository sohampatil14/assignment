package json_rw;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONRead {

	/**
	 * @param args
	 * @throws ParseException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
				
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObj = (JSONObject) jsonParser.parse(new FileReader("json\\read.json"));
		
		String name = (String) jsonObj.get("name");
		
		LocalDate birthDate = LocalDate.parse(
				(String) jsonObj.get("birthdate"), 
				DateTimeFormatter.ofPattern("M/d/y"));
		
		long phoneNumber = Long.parseLong((String) jsonObj.get("phone"));
		String country = (String) jsonObj.get("country");
		int age = Integer.parseInt((String) jsonObj.get("age"));
		String email = (String) jsonObj.get("email");
		
		System.out.println(name);
		System.out.println(age);
		System.out.println(email);
		System.out.println(phoneNumber);
		System.out.println(birthDate);
		System.out.println(country);
		
		
	}

}
