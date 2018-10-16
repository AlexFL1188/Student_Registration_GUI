package edu.century.groupProject;

public class Course {
	//creating instances of a Course
	private int id;
	private String subject;
	private int credits;
	private int courseNumber;
	private int courseSection;
	private String status;
	private String instructor;
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
		this.id = 0;
		this.subject = null;
		this.credits = 0;
		this.courseNumber = 0;
		this.courseSection = 0;
		this.status = null;
		this.instructor = null;
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
	public Course(int id, String subject, int credits, int courseNumber, int courseSection, String status, String instructor) {
		this.id = id;
		this.subject = subject;
		this.credits = credits;
		this.courseNumber = courseNumber;
		this.courseSection = courseSection;
		this.status = status;
		this.instructor = instructor;
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
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getInstructor() {
		return instructor;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	/**
	 * description:
	 * boolean method created to determine if a Course Id is equal to another course id
	 * Precondition:
	 * takes in an value type int Id
	 * Postcondition:
	 * uses the value to determine if a courseId is equal to another courseId
	 * Throws:
	 */
	public boolean equals(int ID) {
		if(id == ID) {
			return true;
		}
		else
			return false;
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
		String courseInfo = "\t-ID: " + id + " Subject: " + subject + " Credits: " + credits + " Course Number: "
				+ courseNumber + " Course Section: " + courseSection + " Status: " + status + " Instructor: "
				+ instructor;
		
		return courseInfo;
	}
}
