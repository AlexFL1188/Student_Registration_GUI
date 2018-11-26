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
	
	public static void main(String[] args) {
		CourseCollection courseCollection = new CourseCollection();
		CourseCollection test = new CourseCollection();
		//creating instance of a collection of students
		StudentCollection stmp = new StudentCollection();
		
		//creating a instance of a student
		Student s1 = new Student("Alex Reimer", new GregorianCalendar(1990, 07, 11),"test", null);
		stmp.addStudent(s1);
		//creating another student and adding classes
		Student s2 = new Student("John Davis", new GregorianCalendar(2000, 01, 17), "temp", null);
		stmp.addStudent(s2);
		
		
		//creating classes and adding to student 1
		courseCollection.add(ClassList.course1);
		courseCollection.add(ClassList.course2);

		
		//write object to file serial
		FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream("Courses.txt");
            out = new ObjectOutputStream(fos);
            out.writeObject(courseCollection);
            out.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        // read the object from file
        FileInputStream fis = null;
        ObjectInputStream in = null;
        try {
            fis = new FileInputStream("Courses.txt");
            in = new ObjectInputStream(fis);
            test = (CourseCollection) in.readObject();
            in.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println(test);
	}
}
