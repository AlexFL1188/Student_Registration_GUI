package edu.century.groupProject;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class DriverGUI extends JFrame implements ActionListener{
	/**

	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField fullNameTXTField;
	private JTextField birthDateTXTField;
	private JPanel contentPane;
	private JTextArea outputArea;
	
	/**
	 * description:
	 * void method to check if a course exists
	 * Precondition:
	 * takes in a boolean value from courseCollection equals method
	 * Postcondition:
	 * prints out to user if the course exists or not
	 * Throws:
	 */
	public static void ExistCourse(boolean value) {
		if(value == true) {
			System.out.println("The Course Exist!!\n");
			value = false;
		}
		else {
			System.out.println("The Course Doesn't Exist!!\n");
		}
	}
	/**
	 * description:
	 * void method to determine if a student exists
	 * Precondition:
	 * takes in a boolean value from studentCollection equals method
	 * Postcondition:
	 * prints out to user if the course exists or not
	 * Throws:
	 */
	public static void ExistStudent(boolean value) {
		if(value == true) {
			System.out.println("The Student Exist!!\n");
			value = false;
		}
		else {
			System.out.println("The Student Doesn't Exist!!\n");
		}
	}
	
	public int isStudent() {
    	String[] isStudent = {"RETURNING STUDENT", "NEW STUDENT"};
    	
    	//Display message to players if they would like to play again/see scores
    	int isStudentPane = JOptionPane.showOptionDialog(null,
   		"Please Select From the Following Options", "Student Registration",
   			JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, 
   				 null, isStudent, isStudent[0]);
		return isStudentPane;
	}
    //main method
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DriverGUI frame = new DriverGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public DriverGUI() {
		//display welcome message
    	if(isStudent() == 0) {//if existing student
    		//temp set to exit for building purposes
    		System.exit(0);
    	}else {//if new student create new JFrame for creating new student
    		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    		setExtendedState(JFrame.NORMAL); 
    		setBounds(500, 500, 500, 500);
    		contentPane = new JPanel();
    		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
    		setContentPane(contentPane);
    		contentPane.setLayout(new GridLayout(2, 0));
		
    		JPanel topPanel = new JPanel();
    		contentPane.add(topPanel);
    		topPanel.setLayout(new GridLayout(0,1,20,20));
    		
    		//label for fullName
    		JLabel fullNameLabel = new JLabel("Full Name:");
    		topPanel.add(fullNameLabel);
    		
    		//fullName text input area
    		fullNameTXTField = new JTextField();
    		GridBagConstraints fullNameGrid = new GridBagConstraints();
    		fullNameGrid.fill = GridBagConstraints.HORIZONTAL;
    		fullNameGrid.insets = new Insets(0, 0, 5, 5);
    		fullNameGrid.gridx = 1;
    		fullNameGrid.gridy = 0;
    		topPanel.add(fullNameTXTField, fullNameGrid);
    		fullNameTXTField.setColumns(10);
    		
    		//label for birthDate
    		JLabel birthDateLabel = new JLabel("BirthDate (MM/DD/YYYY) :");
    		topPanel.add(birthDateLabel);
    		
    		//birthDate text input area
    		birthDateTXTField = new JTextField();
    		GridBagConstraints birthDateGrid = new GridBagConstraints();
    		birthDateGrid.insets = new Insets(0, 0, 5, 0);
    		birthDateGrid.fill = GridBagConstraints.HORIZONTAL;
    		birthDateGrid.gridx = 3;
    		birthDateGrid.gridy = 0;
    		topPanel.add(birthDateTXTField, birthDateGrid);
    		birthDateTXTField.setColumns(10);
    		
    		//button to compute a user defined period of Pay Checks
    		JButton btnRegister = new JButton("Register");
    		btnRegister.addActionListener(this);
    		topPanel.add(btnRegister);
		
    		//text area to display info to user
    		JPanel bottomPanel = new JPanel();
    		contentPane.add(bottomPanel);
    		bottomPanel.setLayout(new BorderLayout(0, 0));
    		outputArea = new JTextArea();
    		bottomPanel.add(new JScrollPane(outputArea), BorderLayout.CENTER);
    	}
	}
	//action method to determine what buttons do what
		public void actionPerformed(ActionEvent e) {
			String nameOfCallingBtn = e.getActionCommand();
			if(nameOfCallingBtn.equals("Register")) {
			    SimpleDateFormat format = new SimpleDateFormat("mm/DD/yyyy");
			    GregorianCalendar cal1 = new GregorianCalendar();
			    try {
					cal1.setTime(format.parse(birthDateTXTField.getText()));
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Student s1 = new Student(fullNameTXTField.getText(), cal1);
				outputArea.append("Thank you for your Registration!!");
				outputArea.append(s1.toString());
			} 
			else if (nameOfCallingBtn.equals("Clear Console")) {
				clearConsole();
			}
		}
	
	//method to clear text output field
		private void clearConsole() {
			outputArea.setText("");
		}
}
