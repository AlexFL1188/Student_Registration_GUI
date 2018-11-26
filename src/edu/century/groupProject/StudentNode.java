package edu.century.groupProject;

import java.io.Serializable;

public class StudentNode implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Student data;
	private StudentNode link;
	/**
	 * description:
	 * default constuctor for creating a StudentNode
	 * Precondition:
	 * takes in a object of type Student
	 * Postcondition:
	 * assigns the object of Student to data and leaves it link null
	 * Throws:
	 */
	public StudentNode(Student element) {
		this.data = element;
		this.link = null;
	}
	/**
	 * description:
	 * below are getters and setter required for getting and setting values associated
	 * Precondition:
	 * getters take in no arguments, and setters take in appropriate values to set
	 * Postcondition:
	 * getters return the value requested, and setters return nothing but have set the appropriate values
	 * or in this case links to the next value in the list
	 * Throws:
	 */
	public Student getData() {
		return data;
	}

	public void setData(Student data) {
		this.data = data;
	}

	public StudentNode getLink() {
		return link;
	}

	public void setLink(StudentNode link) {
		this.link = link;
	}
}

