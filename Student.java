package serialization;

import java.io.Serializable;

public class Student implements Serializable{
	 int id;
	 String name;
	 String department;
	 public Student(int id, String name,String department) {
	  this.id = id;
	  this.name = name;
	  this.department=department;
	 }
	}

