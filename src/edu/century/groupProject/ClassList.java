package edu.century.groupProject;
/**
 * This is a static list of classes used to populate
 * the list
 */
public interface ClassList {
	final Materials ANTH1022_Mat = new Materials("None Required");
	public final Course ANTH1022 = new Course("ANTH", 3, 1022, 2, "Introduction to Physical Anthropology", "Paul Roach", ANTH1022_Mat);
	
	final Materials ANTH1023_Mat = new Materials("None Required");
	public final Course ANTH1023 = new Course("ANTH", 3, 1023, 3, "Introduction to Cultural Anthropology", "Paul Roach", ANTH1023_Mat);
	
	final Materials CSCI1081_Mat = new Materials("Intro to Programing");
	public final Course CSCI1081 = new Course("CSCI", 4, 1081, 1, "Introduction to Programming", "Zak Banni", CSCI1081_Mat);

	final Materials CSCI2061_Mat = new Materials("Fundamentals of Python");
	public final Course CSCI2061 = new Course("CSCI", 2, 2081, 2, "Python For Programmers", "Robert Nienman", CSCI2061_Mat);
	
	final Materials ENGL1020_Mat = new Materials("None Required");
	public final Course ENGL1020 = new Course("ENGL", 3, 1020, 3, "Composistion 1", "Angela Coffee", ENGL1020_Mat);
	
	final Materials ENGL1022_Mat = new Materials("The Golden Compass");
	public final Course ENGL1022 = new Course("ENGL", 3, 1022, 1, "Composistion 2", "Melanie Richards", ENGL1022_Mat);
	
	final Materials MATH1081_Mat = new Materials("Calculus");
	public final Course MATH1081 = new Course("MATH", 5, 1081, 1, "Single Variable Calculus", "Angelia Simions", MATH1081_Mat);
	
	final Materials MATH1082_Mat = new Materials("Calculus II");
	public final Course MATH1082 = new Course("MATH", 5, 1082, 3, "Single Variable Calculus II", "Mark Lorken", MATH1082_Mat);
	
	final Materials PHIL1031_Mat = new Materials("Ethics");
	public final Course PHIL1031 = new Course("PHIL", 3, 1031, 1, "Ehtics", "Ida Baltikauskas", PHIL1031_Mat);
	
	final Materials PHIL1035_Mat = new Materials("Ethics HandBook");
	public final Course PHIL1035 = new Course("PHIL", 3, 1035, 4, "Biomedical Ethics", "Carl Chung", PHIL1035_Mat);

	final Materials PHYS1081_Mat = new Materials("Physics for Scientiest and Engieeners I", "Phys lab book", true);
	public final Course PHYS1081 = new Course("PHYS", 4, 1081, 1, "Physics I", "Bob Klinfworth", PHYS1081_Mat);
	
	final Materials PHYS1082_Mat = new Materials("Physics for Scientiest and Engieeners II", "Phys lab book", true);	
	public final Course PHYS1082 = new Course("PHYS", 4, 1082, 2, "Physics II", "David Mekela", PHYS1082_Mat);
	
	Course [] courses = {ANTH1022, ANTH1023, CSCI1081, CSCI2061, ENGL1020, ENGL1022, MATH1081, MATH1082, PHIL1031, PHIL1035, PHYS1081, PHYS1082};

	
}
