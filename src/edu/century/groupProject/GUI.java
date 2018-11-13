package edu.century.groupProject;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUI extends JFrame implements ActionListener {

	private JFrame frame;
	private JPanel newStudent;
	private JPanel existingStudent;
	private JPanel intro;
	private JTextField fullNameTXTField;
	private JTextField birthDateTXTField;
	private JTextField newPasswordTXTField;
	private JTextField emailAddressTXTField;
	private JTextField passwordTXTField;
	private JTextArea outputArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 375);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0,0));
		
		JPanel intro = new JPanel();
		frame.getContentPane().add(intro);
		intro.setLayout(null);
		intro.setVisible(false);
		
		JPanel newStudent = new JPanel();
		frame.getContentPane().add(newStudent);
		newStudent.setLayout(null);
		newStudent.setVisible(true);
		
		JPanel existingStudent = new JPanel();
		frame.getContentPane().add(existingStudent);
		existingStudent.setLayout(null);
		existingStudent.setVisible(false);
		
		JLabel lblPleaseSelectFrom = new JLabel("Please Select From the Following:");
		lblPleaseSelectFrom.setBounds(77, 21, 316, 26);
		intro.add(lblPleaseSelectFrom);
		
		JButton btnNewStudent = new JButton("NEW STUDENT");
		btnNewStudent.addActionListener(this);
		btnNewStudent.setBounds(117, 80, 175, 35);
		intro.add(btnNewStudent);
		
		JButton btnExistingStudent = new JButton("EXISTING STUDENT");
		btnExistingStudent.addActionListener(this);
		btnExistingStudent.setBounds(91, 136, 232, 35);
		intro.add(btnExistingStudent);
		
		JLabel lblFullName = new JLabel("Full Name:");
		lblFullName.setBounds(0, 63, 101, 26);
		newStudent.add(lblFullName);
		
		fullNameTXTField = new JTextField();
		fullNameTXTField.setBounds(111, 60, 292, 32);
		newStudent.add(fullNameTXTField);
		fullNameTXTField.setColumns(10);
		
		JLabel lblBirthDatemmddyyyy = new JLabel("Birth Date (MM/DD/YYYY):");
		lblBirthDatemmddyyyy.setBounds(0, 116, 249, 26);
		newStudent.add(lblBirthDatemmddyyyy);
		
		birthDateTXTField = new JTextField();
		birthDateTXTField.setBounds(252, 113, 151, 32);
		newStudent.add(birthDateTXTField);
		birthDateTXTField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(0, 163, 101, 26);
		newStudent.add(lblPassword);
		
		newPasswordTXTField = new JTextField();
		newPasswordTXTField.setBounds(105, 163, 298, 29);
		newStudent.add(newPasswordTXTField);
		newPasswordTXTField.setColumns(10);
		
		JButton btnRegister = new JButton("REGISTER");
		btnRegister.addActionListener(this);
		btnRegister.setBounds(135, 198, 141, 35);
		newStudent.add(btnRegister);
		
		JLabel lblEnterTheFollowing = new JLabel("Enter The Following Information");
		lblEnterTheFollowing.setBounds(57, 10, 315, 32);
		newStudent.add(lblEnterTheFollowing);
		
		JTextArea outputArea = new JTextArea();
		outputArea.setBounds(0, 246, 414, 53);
		newStudent.add(outputArea);
		
		JLabel lblPleaseLogin = new JLabel("Please Login");
		lblPleaseLogin.setBounds(137, 21, 121, 26);
		existingStudent.add(lblPleaseLogin);
		
		JLabel lblNewLabel = new JLabel("EMail Address:");
		lblNewLabel.setBounds(0, 87, 137, 29);
		existingStudent.add(lblNewLabel);
		
		emailAddressTXTField = new JTextField();
		emailAddressTXTField.setBounds(147, 85, 246, 32);
		existingStudent.add(emailAddressTXTField);
		emailAddressTXTField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setBounds(0, 176, 104, 29);
		existingStudent.add(lblNewLabel_1);
		
		passwordTXTField = new JTextField();
		passwordTXTField.setBounds(109, 173, 284, 32);
		existingStudent.add(passwordTXTField);
		passwordTXTField.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(this);
		btnLogin.setBounds(129, 243, 141, 35);
		existingStudent.add(btnLogin);
	}
	
	//action method to determine what buttons do what
	public void actionPerformed(ActionEvent e) {
		String nameOfCallingBtn = e.getActionCommand();
		if(nameOfCallingBtn.equals("NEW STUDENT")) {
			System.out.print("new student");
			newStudent.setVisible(true);
			intro.setVisible(false);
		}
		else if(nameOfCallingBtn.equals("EXISTING STUDENT")) {
			existingStudent.setVisible(true);
			intro.setVisible(false);
		}
		else if(nameOfCallingBtn.equals("REGISTER")) {
			SimpleDateFormat format = new SimpleDateFormat("mm/DD/yyyy");
			GregorianCalendar cal1 = new GregorianCalendar();
			try {
				cal1.setTime(format.parse(birthDateTXTField.getText()));
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			Student s1 = new Student(fullNameTXTField.getText(), cal1, passwordTXTField.getText());
			outputArea.append("Thank you for your Registration!!");
			outputArea.append(s1.toString());
		} 
		else if (nameOfCallingBtn.equals("Clear Console")) {
			clearConsole();
		}
		else if (nameOfCallingBtn.equals("Login")) {
		//needs work, needs to open instance of that student logging in.
		}
		
	}
	
	//method to clear text output field
	private void clearConsole() {
		outputArea.setText("");
	}


}


