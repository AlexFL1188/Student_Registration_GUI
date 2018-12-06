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
	
	final Materials PHYS1081_Mat = new Materials("Physics for Scientist and Engienerrs", "LabBook", true);
	public final Course PHYS1081 = new Course("PHYS", 4, 1081, 1, "Physics", "Bob Klindwroth", PHYS1081_Mat);
	
	final Materials MATH1081_Mat = new Materials("Intro: Calculus");
	public final Course MATH1081 = new Course("Math", 4, 1081, 1, "Calculus 1", "Greg Rosik", MATH1081_Mat);
	
	Course [] courses = {ENGL1020, CSCI1081, CSCI2061, PHYS1081, MATH1081};

}
