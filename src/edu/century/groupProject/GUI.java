package edu.century.groupProject;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import edu.century.groupProject.collections.CourseCollection;
import edu.century.groupProject.collections.StudentCollection;
import edu.century.groupProject.Student;
import edu.century.groupProject.ClassList;

public class GUI extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	private JButton btnRegister;
	private StudentCollection sC = new StudentCollection();
	private Student s1 = new Student();
	private GregorianCalendar cal1 = new GregorianCalendar();


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
		sC = (StudentCollection) readStudents();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		intro = new JPanel();
		frame.getContentPane().add(intro, "name_1824609994943200");
		intro.setLayout(null);
		intro.setVisible(true);
		
		newStudent = new JPanel();
		frame.getContentPane().add(newStudent, "name_1824610007818800");
		newStudent.setLayout(null);
		newStudent.setVisible(false);
		
		existingStudent = new JPanel();
		frame.getContentPane().add(existingStudent, "name_1824610020971200");
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
		lblFullName.setBounds(10, 63, 101, 26);
		newStudent.add(lblFullName);
		
		fullNameTXTField = new JTextField();
		fullNameTXTField.setBounds(111, 60, 292, 32);
		newStudent.add(fullNameTXTField);
		fullNameTXTField.setColumns(10);
		
		JLabel lblBirthDatemmddyyyy = new JLabel("Birth Date (MM/DD/YYYY):");
		lblBirthDatemmddyyyy.setBounds(10, 116, 249, 26);
		newStudent.add(lblBirthDatemmddyyyy);
		
		birthDateTXTField = new JTextField();
		birthDateTXTField.setBounds(252, 113, 151, 32);
		newStudent.add(birthDateTXTField);
		birthDateTXTField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(10, 163, 101, 26);
		newStudent.add(lblPassword);
		
		newPasswordTXTField = new JTextField();
		newPasswordTXTField.setBounds(105, 163, 298, 29);
		newStudent.add(newPasswordTXTField);
		newPasswordTXTField.setColumns(10);
		
		btnRegister = new JButton("Register");
		btnRegister.addActionListener(this);
		btnRegister.setBounds(135, 198, 141, 35);
		newStudent.add(btnRegister);
		
		JLabel lblEnterTheFollowing = new JLabel("Enter The Following Information");
		lblEnterTheFollowing.setBounds(57, 10, 315, 32);
		newStudent.add(lblEnterTheFollowing);
		
		outputArea = new JTextArea();
		outputArea.setBounds(10, 250, 400, 75);
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
			newStudent.setVisible(true);
			intro.setVisible(false);
		}
		else if(nameOfCallingBtn.equals("EXISTING STUDENT")) {
			existingStudent.setVisible(true);
			intro.setVisible(false);
		}
		else if(nameOfCallingBtn.equals("Register")) {
			cal1 = new GregorianCalendar();
			SimpleDateFormat format = new SimpleDateFormat("mm/DD/yyyy");
			try {
				cal1.setTime(format.parse(birthDateTXTField.getText()));
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			s1 = new Student(fullNameTXTField.getText(), cal1, passwordTXTField.getText(), null);
			sC.add(s1);
			appendStudents(sC);
			outputArea.append("Thank you for your Registration!!");
			outputArea.append(sC.toString());
			btnRegister.setEnabled(false);
			
		} 
		else if (nameOfCallingBtn.equals("Clear Console")) {
			clearConsole();
		}
		else if (nameOfCallingBtn.equals("Login")) {
		//needs work, needs to open instance of that student logging in.
		}
		
	}
	
	//method to clear text output field
	public void clearConsole() {
		outputArea.setText("");
	}
	
	public static <S> void appendStudents(S input) {
		//write object to file serial
		FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream("Students.bin");
            out = new ObjectOutputStream(fos);
            out.writeObject(input);
            out.flush();
            out.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
	}
	
	public static <S> Object readStudents(){
        // read the object from file
        FileInputStream fis = null;
        ObjectInputStream in = null;
		StudentCollection output = new StudentCollection();

        try {
            fis = new FileInputStream("Students.bin");
            in = new ObjectInputStream(fis);
            output = (StudentCollection) in.readObject();
            in.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return output;
	}
}


