//Reimer, Alexander
//CSCI 2082
//Baani, Zakaria
//Due October 4th 2018
//This Program is designed to allow a admin to create and input student information into a system to keep
//track of classes a student registers for, add/remove classes, add/delete students, check if there are 
//duplicates classes/students, keep track of the number of students and display all students and classes.

package edu.century.groupProject;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.GregorianCalendar;
import edu.century.groupProject.collections.CourseCollection;
import edu.century.groupProject.collections.StudentCollection;
import edu.century.groupProject.Student;
import edu.century.groupProject.ClassList;

public class Driver {
	/**
	 * description:
	 * void method to check if a course exists
	 * Precondition:
	 * takes in a boolean value from courseCollection equals method
	 * Postcondition:
	 * prints out to user if the course exists or not
	 * Throws:
	 */
	public static void ExistCourse(boolean value) {
		if(value == true) {
			System.out.println("The Course Exist!!\n");
			value = false;
		}
		else {
			System.out.println("The Course Doesn't Exist!!\n");
		}
	}
	/**
	 * description:
	 * void method to determine if a student exists
	 * Precondition:
	 * takes in a boolean value from studentCollection equals method
	 * Postcondition:
	 * prints out to user if the course exists or not
	 * Throws:
	 */
	public static void ExistStudent(boolean value) {
		if(value == true) {
			System.out.println("The Student Exist!!\n");
			value = false;
		}
		else {
			System.out.println("The Student Doesn't Exist!!\n");
		}
	}
	public static <S> void writeStudents(S input) {
		//write object to file serial
		FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream("Students.bin");
            out = new ObjectOutputStream(fos);
            out.writeObject(input);
            out.flush();
            out.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
	}
	
	public static <S> Object readStudents(){
        // read the object from file
        FileInputStream fis = null;
        ObjectInputStream in = null;
		StudentCollection output = new StudentCollection();

        try {
            fis = new FileInputStream("Students.bin");
            in = new ObjectInputStream(fis);
            output = (StudentCollection) in.readObject();
            in.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return output;
	}
	
	public static void main(String[] args) {
		CourseCollection courseCollection = new CourseCollection();
		//creating instance of a collection of students
		StudentCollection stmp = new StudentCollection();
		//creating a instance of a student
		Student s1 = new Student("Alexander Reimer", new GregorianCalendar(1990, 07, 11),"test", courseCollection);
		stmp.add(s1);
				
		//creating classes and adding to student 1
		courseCollection.add(ClassList.ENGL1020);
		courseCollection.add(ClassList.CSCI1081);
		courseCollection.add(ClassList.CSCI2061);
		
		//creating another student and adding classes
		Student s2 = new Student("John Davis", new GregorianCalendar(2000, 01, 17), "temp", null);
		stmp.add(s2);

		
		writeStudents(stmp);
        System.out.println(readStudents());
	}
}
