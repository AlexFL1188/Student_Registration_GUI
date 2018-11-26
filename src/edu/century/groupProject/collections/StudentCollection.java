package edu.century.groupProject.collections;

import java.io.Serializable;

import edu.century.groupProject.Student;
import edu.century.groupProject.StudentNode;
public class StudentCollection implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private StudentNode head;
	private StudentNode tail;
	private int numberOfStudents;
	
	/**
	 * description:
	 * null constructor for a StudentCollection
	 * Precondition:
	 * Postcondition:
	 * all instance within the StudentCollection are set to a null or 0 state
	 * Throws:
	 */
	public StudentCollection() {
		this.head = null;
		this.tail = null;
		this.numberOfStudents = 0;
	}
	/**
	 * description:
	 * void method made to add a Student object to the StudentCollection
	 * Precondition:
	 * the method takes in a Student object or Student
	 * Postcondition:
	 * the student is added to the head of linklist
	 * Throws:
	 */
	public void add(Student element) {
		if(head == null) {
			head = new StudentNode(element);
			numberOfStudents++;
		}else {
			StudentNode tmp = new StudentNode(element);
			tmp.setLink(head);
			head = tmp;
			if(numberOfStudents == 0) {
				tail = head;
			}
			numberOfStudents++;
		}
	}
	/**
	 * description:
	 * void method created to remove a selected student from a StudentCollection
	 * Precondition:
	 * method takes in a Student object or student to search for
	 * Postcondition:
	 * if the student is found within the StudentCollection then its removed and the linklist is fixed
	 * Throws:
	 */
	public void remove(Student target) {
		if(numberOfStudents == 0)
			return;
		StudentNode cursor, precursor;
		for(cursor = head, precursor = null; cursor!=null; precursor = cursor, cursor = cursor.getLink()) {
			if (target.equals(cursor.getData()) && cursor == head) {
				if (numberOfStudents == 1) {
					head = null;
					tail = null;
				} else {
					head = head.getLink();
				}
				numberOfStudents--;
			} else if (target.equals(cursor.getData()) && cursor == tail) {
				if (numberOfStudents == 1) {
					head = null;
					tail = null;
				} else {
					precursor.setLink(null);
					tail = precursor;
				}
				numberOfStudents--;
			} else if (target.equals(cursor.getData())) {
				precursor.setLink(cursor.getLink());
				numberOfStudents--;
			}
		}
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
		
		StudentNode cursor = head;
		String info = "Number of Students: " + numberOfStudents +"\n" + "Students: \n";
		for (cursor = head; cursor != null; cursor = cursor.getLink()) {
			info += cursor.getData() + "\n";
		}
		return info;
	}
}
