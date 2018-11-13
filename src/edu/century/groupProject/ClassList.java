package edu.century.groupProject;
/**
 * This is a static list of classes used to populate
 * the list
 * 
 * @author Eric Thompson
 *
 */
public interface ClassList {
	final Materials materials1 = new Materials("The Golden Compass");
	public final Course course1 = new Course(001234, "ENGL", 4, 1020, 1, "Composistion 1", "Melanie Richards", materials1);
	
	final Materials materials2 = new Materials("Intro to Programing");
	public final Course course2 = new Course(000723, "CSCI", 4, 1081, 1, "Introduction to Programming", "Zak Banni", materials2);
}
