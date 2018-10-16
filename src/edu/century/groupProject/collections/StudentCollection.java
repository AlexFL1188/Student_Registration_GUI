package edu.century.groupProject.collections;

import edu.century.groupProject.Student;

public class StudentCollection {
	//creating instances of a studentCollection
	private Student student[];
	private int numberOfStudents;
	
	/**
	 * description:
	 * method for default construction
	 * Precondition:
	 * Postcondition:
	 * Throws:
	 */
	public StudentCollection() {
		this.student = new Student[0];
		this.numberOfStudents = 0;
	}
	/**
	 * description:
	 * method for default construction to create a Student array of size
	 * Precondition:
	 * takes in an int value of size
	 * Postcondition:
	 * Throws:
	 */
	public StudentCollection(int size) {
		this.student = new Student[size];
		this.numberOfStudents = 0;
	}
	/**
	 * description:
	 * void method to add a Student object to a StudentCollection
	 * Precondition:
	 * takes in a Student object called student
	 * Postcondition:
	 * student object is added to an array inside of a StudentCollection
	 * Throws:
	 */
	public void addStudent(Student students) {
		if(numberOfStudents == student.length) {
			ensureCapacity(numberOfStudents);
		}
		student[numberOfStudents] = students;
		numberOfStudents++;
	}
	/**
	 * description:
	 * boolean method to remove a student object from a StudentCollection
	 * Precondition:
	 * takes in an object of Student to remove from the StudentCollection array
	 * Postcondition:
	 * after executed depending on if statement, student object maybe removed
	 * Throws:
	 */
	public boolean removeStudent(Student students) {
		int index = 0;
		while((index < numberOfStudents) && (students != student[index])) {
			index++;
		}
		if(index == numberOfStudents)
			return false;
		else {
			numberOfStudents--;
			student[index] = student[numberOfStudents];
			return true;
		}
	}
	/**
	 * description:
	 * void method to ensure the capacity of the StudentCollection array is large enough to
	 * Accommodate the incoming student objects
	 * Precondition:
	 * takes in an int value size, which is the current size of the array
	 * Postcondition:
	 * after execution the array is increased by two times it size plus 1
	 * Throws:
	 */
	public void ensureCapacity(int size) {
		int newSize = size *2 + 1;
		Student[] biggerArray = new Student[newSize];
		System.arraycopy(student, 0, biggerArray, 0, student.length);
		student = biggerArray;
	}
	/**
	 * description:
	 * boolean method to search for the lastName within a student object
	 * Precondition:
	 * the method takes in a string of a lastName to search for
	 * Postcondition:
	 * after the execution the method returns a true or false if the lastName exists
	 * Throws:
	 */
	public boolean searchLastName(String target) {
		for(int i = 0; i < numberOfStudents; i++) {
			if(target.equals(student[i].getLastName())) {
				return true;
			}
		}
		return false;
	}
	/**
	 * description:
	 * boolean method to search for a student Id within a student object
	 * Precondition:
	 * the method takes in a string of a student Id
	 * Postcondition:
	 * after execution the method returns a true or false if the Student Id is equal to id within a
	 * student object
	 * Throws:
	 */
	public boolean searchId(String target) {
		for(int i = 0; i < numberOfStudents; i++) {
			if(target.equals(student[i].getStudentId())) {
				return true;
			}
		}
		return false;
	}
	/**
	 * description:
	 * method that returns a string, made to convert values to a string
	 * Precondition:
	 * no argument constructor
	 * Postcondition:
	 * after execution the method returns a string value of the instances and values within the method
	 * Throws:
	 */
	@Override
	public String toString() {
		String studentInfo = "Number of Students: " + numberOfStudents +"\n";
		for(int i = 0; i < numberOfStudents; i++) {
			studentInfo+= "Student#"+(i+1)+""+ student[i] + "\n";
		}
		return studentInfo;
	}
}
