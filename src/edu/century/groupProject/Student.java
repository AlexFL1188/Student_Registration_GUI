package edu.century.groupProject;

import java.io.Serializable;


import edu.century.groupProject.collections.CourseCollection;

public class Student implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//creating instances of a student object
	private String studentId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String birthDate;
	private String birthMonth;
	private String birthDay;
	private String birthYear;
	private CourseCollection courses;
	/**
	 * description:
	 * null constructor
	 * Precondition:
	 * takes no arguments
	 * Postcondition:
	 * assigns all the values of a student object to null
	 * Throws:
	 */
	public Student() {
		this.studentId = null;
		this.firstName = null;
		this.lastName = null;
		this.email = null;
		this.birthDate = null;
		this.password = null;
		this.courses = null;
	}
	/**
	 * description:
	 * two argument constructor designed to create a fullname and birthdate of a student object
	 * Precondition:
	 * takes in a fullname and birthdate of type gregorian calendar
	 * Postcondition:
	 * assigns and mutates values required to create the correct info for a required student object
	 * Throws:
	 */
	public Student(String fullName, String birthDate, String password, CourseCollection courses) {
		String[] name = fullName.split(" ");
		this.firstName = name[0];
		this.lastName = name[1];
		String firstInitials = name[0].substring(0, 2);
		String lastInitials = name[1].substring(0, 2);
		getBirthDateInfo(birthDate);
		this.email = firstInitials + birthYear + lastInitials +"@my.century.edu";
		this.studentId = firstInitials + birthYear + lastInitials;
		this.password = password;
		this.courses = courses;
	}
	
	public void getBirthDateInfo(String birthDate) {
		String[] birth = birthDate.split("/");
		this.birthMonth = birth[0];
		this.birthDay = birth[1];
		this.birthYear = birth[2];
		this.birthDate = birthDate;
	}

	/**
	 * description:
	 * below are getters and setter required for getting and setting values associated
	 * Precondition:
	 * getters take in no arguments, and setters take in appropriate values to set
	 * Postcondition:
	 * getters return the value requested, and setters return nothing but have set the appropriate values
	 * Throws:
	 */
	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	
	public String getBirthDate() {
		return birthDate;
	}
	
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public CourseCollection getCourses() {
		return courses;
	}
	
	public void setCourses(CourseCollection courses) {
		this.courses = courses;
	}
	/**
	 * description:
	 * clone method designed to create another pointer to the same object
	 * Precondition:
	 * takes in no arguments
	 * Postcondition:
	 * returns another pointer of type student
	 * Throws:
	 */
	public Student clone() {
		Student studentClone;
		try {
			studentClone = (Student)super.clone();
		}catch (CloneNotSupportedException e) {
			throw new RuntimeException("This Class doesnt Implement Cloneable");
		}
		return studentClone;
	}
	/**
	 * description:
	 * default equals method designed to compare two objects and see if equal
	 * Precondition:
	 * takes in an object or Student and compares it 
	 * Postcondition:
	 * see if its equal to another object
	 * Throws:
	 */
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	/**
	 * description:
	 * toString method designed to convert instances and values to string values
	 * Precondition:
	 * takes in no values
	 * Postcondition:
	 * returns all values inside converted to a string
	 * Throws:
	 */
	@Override
	public String toString() {
		String studentInfo = "\nFull Name: " + firstName + " " + lastName + "\nBirth Date: " + 
				birthMonth+"/"+birthDay+"/"+birthYear + "\nEmail: " + email +"\n" + "Password: " 
					+ password +"\n" + courses;
		return studentInfo;
	}

}
