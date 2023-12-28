package json_rw;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;

public class JSONWrite {

	/**
	 * @param args
	 * @throws IOException 
	 */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		
		JSONObject jsonObject = new JSONObject();
		
		jsonObject.put("name", "Soham");
		jsonObject.put("age", "21");
		jsonObject.put("email", "soham@email.com");
		jsonObject.put("phone", "9876543210");
		jsonObject.put("birthdate", "11/12/2000");
		jsonObject.put("country", "India");
		
		JSONObject education = new JSONObject();
		
		education.put("High School", "St. George High");
		education.put("Diploma", "K. J. Somaiya Polytechnic");
		education.put("Degree", "K. J. Somaiya College of Engineering");
		
		jsonObject.put("education", education);
		
		FileWriter file = new FileWriter("json\\write.json", false);
		file.write(jsonObject.toJSONString());
		file.close();
	}

}
