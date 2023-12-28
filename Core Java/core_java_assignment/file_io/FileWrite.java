package file_io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWrite {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		File file = new File("file_io\\files\\read.txt");
		FileWriter fileWriter = new FileWriter(file);
		String text = "This is a text file written by a Java program.";
		fileWriter.write(text);
		fileWriter.close();
	}

}
