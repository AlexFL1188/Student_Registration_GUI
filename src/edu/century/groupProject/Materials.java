package edu.century.groupProject;

import java.io.Serializable;

//this class hold the materials need for a class
//including if a lab is taken in accordance with the class
public class Materials implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String textBooks;
	private String equipment;
	private boolean needLab;
	//multi argument constructor
	public Materials(String books, String equipment, boolean needLab) {
		setTextBooks(books);
		setEquipment(equipment);
		setNeedLab(needLab);
	}

	// single argument constructor for course only requiring a book
	public Materials(String books) {
		setTextBooks(books);
		setEquipment("");
		setNeedLab(false);
	}

	// constructor for non lab classes with books and equipment
	public Materials(String books, String equipment) {
		setTextBooks(books);
		setEquipment(equipment);
		setNeedLab(false);
	}

	// setters and getters
	public String getTextBooks() {
		return textBooks;
	}

	public void setTextBooks(String textBooks) {
		this.textBooks = textBooks;
	}

	/**
	 * @return the needLab
	 */
	public boolean isNeedLab() {
		return needLab;
	}

	/**
	 * @param needLab
	 *            the needLab to set
	 */
	public void setNeedLab(boolean needLab) {
		this.needLab = needLab;
	}

	/**
	 * @return the equipment
	 */
	public String getEquipment() {
		return equipment;
	}

	/**
	 * @param equipment
	 *            the equipment to set
	 */
	public void setEquipment(String equipment) {
		this.equipment = equipment;
	}

	// returns a string of of the materials need for the course.
	public String toString() {

		if (needLab) {
			return "Class materials : \nTextbooks : " + getTextBooks() + "\nEquipment: " + getEquipment()
					+ "\nThis Class requires a Lab, you will need to signup for the Lab and the Lab book";
		} else {
			return "Class materials : \nTextbooks : " + getTextBooks() + "\nEquipment: " + getEquipment();
		}
	}
}
