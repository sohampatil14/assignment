package file_io;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileRead {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		int character;
		FileReader fileReader = new FileReader(new File("file_io\\files\\read.txt"));
		while((character=fileReader.read())!=-1) {
			System.out.print((char)character); 
		}
        fileReader.close(); 
	}

}
