package serialization;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Depersist {
 public static void main(String args[])throws Exception{
			  
			  ObjectInputStream in=new ObjectInputStream(new FileInputStream("E:\\serialization\\student.txt"));
			  Student s=(Student)in.readObject();
			  System.out.println(s.id+" "+s.name+" "+s.department);

			  in.close();
			 }

}
