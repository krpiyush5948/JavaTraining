package serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;



public class Persist {
	
	public static void main(String[] args) throws IOException {
		try {
			/**
			 * Creating the object
			 */
			
		Student s1 =new Student(211,"piyush","computer Science");
		/**
		 *  creating object and writing the object
		 */
		FileOutputStream fout = new FileOutputStream("E:\\serialization\\student.txt");
		ObjectOutputStream out =new ObjectOutputStream(fout);
		out.writeObject(s1);
		out.flush();
		
		//closing the stream
		out.close();
		System.out.println("Sucess");
		
		} catch(Exception e) {
			System.out.println(e);
		}
	}

}

