package edu.century.groupProject;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;

public class GUI extends JFrame {

	private JPanel contentPane;
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
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JPanel intro = new JPanel();
		contentPane.add(intro, "introPanel");
		intro.setLayout(null);
		
		JLabel lblPleaseSelectFrom = new JLabel("Please Select From the Following:");
		lblPleaseSelectFrom.setBounds(77, 21, 316, 26);
		intro.add(lblPleaseSelectFrom);
		
		JButton btnNewStudent = new JButton("NEW STUDENT");
		btnNewStudent.setBounds(117, 80, 175, 35);
		intro.add(btnNewStudent);
		
		JButton btnExistingStudent = new JButton("EXISTING STUDENT");
		btnExistingStudent.setBounds(91, 136, 232, 35);
		intro.add(btnExistingStudent);
		
		JPanel newStudent = new JPanel();
		contentPane.add(newStudent, "name_1807846974319900");
		newStudent.setLayout(null);
		
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
		btnRegister.setBounds(135, 198, 141, 35);
		newStudent.add(btnRegister);
		
		JLabel lblEnterTheFollowing = new JLabel("Enter The Following Information");
		lblEnterTheFollowing.setBounds(57, 10, 315, 32);
		newStudent.add(lblEnterTheFollowing);
		
		JTextArea outputArea = new JTextArea();
		outputArea.setBounds(0, 246, 414, 53);
		newStudent.add(outputArea);
		
		JPanel existingStudent = new JPanel();
		contentPane.add(existingStudent, "name_1807848647054400");
		existingStudent.setLayout(null);
		
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
		btnLogin.setBounds(129, 243, 141, 35);
		existingStudent.add(btnLogin);
	}
	
	//action method to determine what buttons do what
	public void actionPerformed(ActionEvent e) {
		String nameOfCallingBtn = e.getActionCommand();
		if(nameOfCallingBtn.equals("NEW STUDENT")) {
			newStudent.setVisible(true);
			intro.setVisible(false);
			existingStudent.setVisible(false);
		}
		else if(nameOfCallingBtn.equals("EXISTING STUDENT")) {
			newStudent.setVisible(false);
			intro.setVisible(false);
			existingStudent.setVisible(true);
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
