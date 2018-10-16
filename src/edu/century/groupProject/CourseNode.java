package edu.century.groupProject;

public class CourseNode {
	//creating instances of a course node
	private Course data;
	private CourseNode link;
	/**
	 * description:
	 * default constuctor for creating a CourseNode
	 * Precondition:
	 * takes in a object of type Course
	 * Postcondition:
	 * assigns the object of Course to data and leaves it link null
	 * Throws:
	 */
	public CourseNode(Course element) {
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
	public Course getData() {
		return data;
	}

	public void setData(Course data) {
		this.data = data;
	}

	public CourseNode getLink() {
		return link;
	}

	public void setLink(CourseNode link) {
		this.link = link;
	}
}
