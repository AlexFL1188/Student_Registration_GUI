package edu.century.groupProject.collections;

import java.io.Serializable;

import edu.century.groupProject.Course;
import edu.century.groupProject.CourseNode;

public class CourseCollection implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// creating instances within the CourseCollection class
	private CourseNode head;
	private CourseNode tail;
	private int numberOfCourses;

	/**
	 * description: null constructor for a CourseCollection Precondition:
	 * Postcondition: all instance within the CourseCollection are set to a null or
	 * 0 state Throws:
	 */
	public CourseCollection() {
		this.head = null;
		this.tail = null;
		this.numberOfCourses = 0;
	}

	/**
	 * description: void method made to add a Course object to the CourseCollection
	 * Precondition: the method takes in a Course object or Course Postcondition:
	 * the course is added to the head of linklist Throws:
	 */
	public void add(Course element) {
		if (head == null) {
			head = new CourseNode(element);
			numberOfCourses++;
		} else {
			CourseNode tmp = new CourseNode(element);
			tmp.setLink(head);
			head = tmp;
			if (numberOfCourses == 0) {
				tail = head;
			}
			numberOfCourses++;
		}
	}

	/**
	 * description: void method created to remove a selected course from a
	 * CourseCollection Precondition: method takes in a Course object or course to
	 * search for Postcondition: if the course is found within the CourseCollection
	 * then its removed and the linklist is fixed Throws:
	 */
	public void remove(Course target) {
		if (numberOfCourses == 0)
			return;
		CourseNode cursor, precursor;
		for (cursor = head, precursor = null; cursor != null; precursor = cursor, cursor = cursor.getLink()) {
			if (target.equals(cursor.getData()) && cursor == head) {
				if (numberOfCourses == 1) {
					head = null;
					tail = null;
				} else {
					head = head.getLink();
				}
				numberOfCourses--;
			} else if (target.equals(cursor.getData()) && cursor == tail) {
				if (numberOfCourses == 1) {
					head = null;
					tail = null;
				} else {
					precursor.setLink(null);
					tail = precursor;
				}
				numberOfCourses--;
			} else if (target.equals(cursor.getData())) {
				precursor.setLink(cursor.getLink());
				numberOfCourses--;
			}
		}
	}

	/**
	 * description: boolean method to search for a courseSubject within a Course
	 * object Precondition: method takes in an String value or courseSubject to
	 * search for Postcondition: after execution the method returns a true or false
	 * value depending on if the courseSubject was found Throws:
	 */
	public boolean searchSubject(String target) {
		for (CourseNode cursor = head; cursor != null; cursor = cursor.getLink()) {
			if (target.equals(cursor.getData().getSubject())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * description: boolean method to search for a Course Number within a Course
	 * object Precondition: method takes in an int value or courseNumber to search
	 * for Postcondition: after execution the method returns a true or false value
	 * depending on if the courseId was found Throws:
	 */
	public Course searchCourseNumber(Course target) {
		for (CourseNode cursor = head; cursor != null; cursor = cursor.getLink()) {
			if (target.equals(cursor.getData())) {
				return cursor.getData();
			}
		}
		return null;
	}

	/**
	 * description: method that returns a string, made to convert values to a string
	 * Precondition: no argument constructor Postcondition: after execution the
	 * method returns a string value of the instances and values within the method
	 * Throws:
	 */
	@Override
	public String toString() {
		if (head == null) {
			return "No Courses Registered";
		}
		CourseNode cursor = head;
		String info = "Number of Courses Registered: " + numberOfCourses + "\n" + "Registered Courses: \n";
		for (cursor = head; cursor != null; cursor = cursor.getLink()) {
			info += cursor.getData() + "\n";
		}
		return info;
	}

	public String wishListToString() {
		if (head == null) {
			return "No Courses in wish list\n";
		}
		CourseNode cursor = head;
		String info = "Number in Wish list: " + numberOfCourses + "\n" + "Saved Courses: \n";
		for (cursor = head; cursor != null; cursor = cursor.getLink()) {
			info += cursor.getData() + "\n";
		}
		return info;
	}

	/**
	 * description: returns string of course's materials
	 * 
	 * @return String
	 * 
	 */
	public String getCourseMaterials() {
		if (head == null) {
			return "You are not registered for any Classes!!\n";
		}
		CourseNode cursor = head;
		String classMaterials = "Materials for Registered Courses:\n";
		for (cursor = head; cursor != null; cursor = cursor.getLink()) {
			classMaterials += cursor.getData().getCourseTitle() + "\n" + cursor.getData().getMaterials() + "\n";
		}
		return classMaterials;
	}
}