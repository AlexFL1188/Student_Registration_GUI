package edu.century.groupProject;

import java.util.GregorianCalendar;

import edu.century.groupProject.collections.CourseCollection;
import edu.century.groupProject.collections.StudentCollection;

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
		//creating instance of a collection of courses
		CourseCollection coursesStudent1 = new CourseCollection();
		//creating instance of a collection of students
		StudentCollection stmp = new StudentCollection();
		//creating a instance of a student
		Student s1 = new Student("", "Alex Reimer", new GregorianCalendar(1990, 07, 11),"",coursesStudent1);
		stmp.addStudent(s1);

		//creating classes and adding to student 1
		Course c1 = new Course(1000, "CSCI", 3, 2082, 1, "Open", "Zak");
		coursesStudent1.add(c1);
		Course c2 = new Course(2222, "MATH", 4, 1081, 1, "Pending", "Julie");
		coursesStudent1.add(c2);
		Course c3 = new Course(3111, "ENGL", 2, 1000, 1, "Open", "Tom");
		coursesStudent1.add(c3);
		Course c4 = new Course(4555, "ANTH", 3, 1021, 1, "Open", "John");
		coursesStudent1.add(c4);
		
		//creating another student and adding classes
		CourseCollection coursesStudent2 = new CourseCollection();
		Student s2 = new Student("", "John Davis", new GregorianCalendar(2000, 01, 17), "", coursesStudent2);
		stmp.addStudent(s2);
		coursesStudent2.add(c1);
		coursesStudent2.add(c2);
		
		//displaying and proving tests
		System.out.println("****Displaying Courses and Student****\n");
		System.out.println(stmp);
		System.out.println("****Removing Courses from Student(Removed from Alex Reimer Course c1 or CSCI)****\n");
		coursesStudent1.remove(c1);
		System.out.println(stmp);
		System.out.println("****Removing a Student(Alex Reimer)****\n");
		stmp.removeStudent(s1);
		System.out.println(stmp);
		System.out.println("****Checking if Student 2 has course ID(1000)****");
		ExistCourse(coursesStudent2.searchId(1000));
		System.out.println("****Checking if Student 2 has course ID(1001)****");
		ExistCourse(coursesStudent2.searchId(1001));
		System.out.println("****Checking if Student 2 has course by Subject(MATH)****");
		ExistCourse(coursesStudent2.searchSubject("MATH"));
		System.out.println("****Checking if Student 2 has course by Subject(ANTH)****");
		ExistCourse(coursesStudent2.searchSubject("ANTH"));
		System.out.println("****Checking if Student 2 exists by student ID(Jo2000Da)****");
		ExistStudent(stmp.searchId("Jo2000Da"));
		System.out.println("****Checking if Student 2 exists by student ID(Al1990Re)****");
		ExistStudent(stmp.searchId("Al1990Re"));	
		System.out.println("****Checking if Student 2 exists by student Last Name(Davis)****");
		ExistStudent(stmp.searchLastName("Davis"));	
		System.out.println("****Checking if Student 2 exists by student Last Name(Reimer)****");
		ExistStudent(stmp.searchLastName("Reimer"));	
	}
}
