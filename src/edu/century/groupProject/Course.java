package edu.century.groupProject;

import java.io.Serializable;

public class Course implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//creating instances of a Course
	private String subject;
	private int credits;
	private int courseNumber;
	private int courseSection;
	private String courseTitle;
	private String instructor;
	private Materials materials;
	/**
	 * description:
	 * null constructor for a object of type Course
	 * Precondition:
	 * takes in no arguments
	 * Postcondition:
	 * after execution this constructor assigns all values to null or 0
	 * Throws:
	 */
	public Course() {
		this.subject = null;
		this.credits = 0;
		this.courseNumber = 0;
		this.courseSection = 0;
		this.courseTitle = null;
		this.instructor = null;
		this.setMaterials(null);
	}
	/**
	 * description:
	 * multi argument constructor used to create an object of Course
	 * Precondition:
	 * takes in multi arguments of different types
	 * Postcondition:
	 * assigns those arguments to create a object of type Course
	 * Throws:
	 */
	public Course(String subject, int credits, int courseNumber, int courseSection, String title, String instructor, Materials materials) {
		this.subject = subject;
		this.credits = credits;
		this.courseNumber = courseNumber;
		this.courseSection = courseSection;
		this.courseTitle = title;
		this.instructor = instructor;
		this.setMaterials(materials);
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
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public int getCourseNumber() {
		return courseNumber;
	}

	public void setCourseNumber(int courseNumber) {
		this.courseNumber = courseNumber;
	}

	public int getCourseSection() {
		return courseSection;
	}

	public void setCourseSection(int courseSection) {
		this.courseSection = courseSection;
	}

	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String status) {
		this.courseTitle = status;
	}

	public String getInstructor() {
		return instructor;
	}
	public Materials getMaterials() {
		return materials;
	}
	
	public void setMaterials(Materials materials) {
		this.materials = materials;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	/**
	 * description:
	 * default equals method designed to compare two objects and see if equal
	 * Precondition:
	 * takes in an object or Course and compares it 
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
		String courseInfo = "\tSubject: " + subject + " Credits: " + credits + " Course Number: "
				+ courseNumber + " Course Section: " + courseSection + " Title: " + courseTitle + " Instructor: "
				+ instructor;
		
		return courseInfo;
	}
	
	
}
