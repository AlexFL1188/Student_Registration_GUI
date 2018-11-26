package edu.century.groupProject;
/**
 * This is a static list of classes used to populate
 * the list
 * 
 * @author Eric Thompson
 *
 */
public interface ClassList {
	final Materials ENGL1020_Mat = new Materials("The Golden Compass");
	public final Course ENGL1020 = new Course(001234, "ENGL", 4, 1020, 1, "Composistion 1", "Melanie Richards", ENGL1020_Mat);
	
	final Materials CSCI1081_Mat = new Materials("Intro to Programing");
	public final Course CSCI1081 = new Course(000723, "CSCI", 4, 1081, 1, "Introduction to Programming", "Zak Banni", CSCI1081_Mat);

	final Materials CSCI2061_Mat = new Materials("Fundamentals of Python");
	public final Course CSCI2061 = new Course(001234, "CSCI", 2, 2081, 2, "Python For Programmers", "Robert Nienman", CSCI2061_Mat);
	
}
