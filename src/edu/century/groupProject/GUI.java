package edu.century.groupProject;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import edu.century.groupProject.collections.CourseCollection;
import edu.century.groupProject.collections.StudentCollection;
import edu.century.groupProject.Student;
import edu.century.groupProject.ClassList;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Font;

public class GUI extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JPanel newStudent;
	private JPanel existingStudent;
	private JPanel intro;
	private JPanel courseRegistration;
	private JPanel pagePanel;
	private JPanel outputScrollPanel;
	
	private JTextField fullNameTXTField;
	private JTextField birthDateTXTField;
	private JTextField newPasswordTXTField;
	private JTextField emailAddressTXTField;
	private JTextField passwordTXTField;
	
	private JTextArea outputArea;
	
	private JButton btnEnroll;
	private JButton btnLogin;
	private JButton btnAddCourse;
	private JButton btnRemoveCourse;
	private JButton btnGetWordDocument;
	private JButton btnGetClassMaterials; 
	private JComboBox<?> comboBox;
	
	private Student s1 = new Student();
	private StudentCollection sC = new StudentCollection();
	private CourseCollection cC = new CourseCollection();

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
		outputArea.append("Welcome!!!\nPlease Select from the following options above to continue.");
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 428, 560);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{424, 0};
		gridBagLayout.rowHeights = new int[]{340, 164, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		pagePanel = new JPanel();
		GridBagConstraints gbc_pagePanel = new GridBagConstraints();
		gbc_pagePanel.fill = GridBagConstraints.BOTH;
		gbc_pagePanel.insets = new Insets(0, 0, 5, 0);
		gbc_pagePanel.gridx = 0;
		gbc_pagePanel.gridy = 0;
		frame.getContentPane().add(pagePanel, gbc_pagePanel);
		pagePanel.setLayout(new CardLayout(0, 0));
		
		intro = new JPanel();
		pagePanel.add(intro, "name_1209706530643200");
		intro.setLayout(null);
		intro.setVisible(true);
		
		JLabel lblPleaseSelectFrom = new JLabel("Please Select From the Following:");
		lblPleaseSelectFrom.setBounds(105, 21, 316, 26);
		intro.add(lblPleaseSelectFrom);
		
		JButton btnNewStudent = new JButton("NEW STUDENT");
		btnNewStudent.addActionListener(this);
		btnNewStudent.setBounds(120, 80, 175, 75);
		intro.add(btnNewStudent);
		
		JButton btnExistingStudent = new JButton("EXISTING STUDENT");
		btnExistingStudent.addActionListener(this);
		btnExistingStudent.setBounds(91, 180, 232, 75);
		intro.add(btnExistingStudent);
		
		newStudent = new JPanel();
		pagePanel.add(newStudent, "name_1209706541749900");
		newStudent.setLayout(null);
		newStudent.setVisible(false);
		
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
		
		btnEnroll = new JButton("Enroll");
		btnEnroll.addActionListener(this);
		btnEnroll.setBounds(135, 240, 141, 75);
		newStudent.add(btnEnroll);
		
		JLabel lblEnterTheFollowing = new JLabel("Enter The Following Information");
		lblEnterTheFollowing.setBounds(115, 10, 315, 32);
		newStudent.add(lblEnterTheFollowing);
		
		existingStudent = new JPanel();
		pagePanel.add(existingStudent, "name_1209706517892700");
		existingStudent.setLayout(null);
		existingStudent.setVisible(false);
		
		JLabel lblPleaseLogin = new JLabel("Please Login");
		lblPleaseLogin.setBounds(150, 21, 121, 26);
		existingStudent.add(lblPleaseLogin);
		
		JLabel lblNewLabel = new JLabel("EMail Address:");
		lblNewLabel.setBounds(10, 87, 137, 29);
		existingStudent.add(lblNewLabel);
		
		emailAddressTXTField = new JTextField();
		emailAddressTXTField.setBounds(147, 85, 246, 32);
		existingStudent.add(emailAddressTXTField);
		emailAddressTXTField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setBounds(10, 176, 104, 29);
		existingStudent.add(lblNewLabel_1);
		
		passwordTXTField = new JTextField();
		passwordTXTField.setBounds(109, 173, 284, 32);
		existingStudent.add(passwordTXTField);
		passwordTXTField.setColumns(10);
		
		btnLogin = new JButton("Login");
		btnLogin.addActionListener(this);
		btnLogin.setBounds(129, 243, 141, 75);
		existingStudent.add(btnLogin);
		
		courseRegistration = new JPanel();
		pagePanel.add(courseRegistration, "name_1209706553262100");
		courseRegistration.setLayout(null);
		
		comboBox = new JComboBox(ClassList.courses);
		comboBox.setBounds(21, 80, 381, 81);
		courseRegistration.add(comboBox);
		
		btnAddCourse = new JButton("Add Course");
		btnAddCourse.addActionListener(this);
		btnAddCourse.setBounds(21, 180, 183, 60);
		courseRegistration.add(btnAddCourse);
		
		btnRemoveCourse = new JButton("Remove Course");
		btnRemoveCourse.addActionListener(this);
		btnRemoveCourse.setBounds(225, 180, 177, 60);
		courseRegistration.add(btnRemoveCourse);
		
		JLabel lblCourseRegistration = new JLabel("Course Registration");
		lblCourseRegistration.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblCourseRegistration.setHorizontalAlignment(SwingConstants.CENTER);
		lblCourseRegistration.setBounds(21, 21, 381, 35);
		courseRegistration.add(lblCourseRegistration);
		
		btnGetWordDocument = new JButton("Get Word Document");
		btnGetWordDocument.addActionListener(this);
		btnGetWordDocument.setBounds(21, 260, 183, 60);
		courseRegistration.add(btnGetWordDocument);
		
		btnGetClassMaterials = new JButton("Show Class Materials");
		btnGetClassMaterials.addActionListener(this);
		btnGetClassMaterials.setBounds(225, 260, 177, 60);
		courseRegistration.add(btnGetClassMaterials);
		
		outputScrollPanel = new JPanel();
		GridBagConstraints gbc_outputScrollPanel = new GridBagConstraints();
		gbc_outputScrollPanel.fill = GridBagConstraints.BOTH;
		gbc_outputScrollPanel.gridx = 0;
		gbc_outputScrollPanel.gridy = 1;
		frame.getContentPane().add(outputScrollPanel, gbc_outputScrollPanel);
		outputScrollPanel.setLayout(new BorderLayout(0, 0));
				
		outputArea = new JTextArea();
		outputArea.setEditable(false);
		outputScrollPanel.add(new JScrollPane(outputArea), BorderLayout.CENTER);
	}
	
	//action method to determine what buttons do what
	public void actionPerformed(ActionEvent e) {
		String nameOfCallingBtn = e.getActionCommand();
		//action for button if you are a new student
		if(nameOfCallingBtn.equals("NEW STUDENT")) {
			newStudent.setVisible(true);
			intro.setVisible(false);
			clearConsole();
			outputArea.append("Welcome New Student!\nPlease fill in the boxes above and click Enroll to continue\n");
		}
		//action for button to choose if your are an Existing Student
		else if(nameOfCallingBtn.equals("EXISTING STUDENT")) {
			existingStudent.setVisible(true);
			intro.setVisible(false);
			clearConsole();
			outputArea.append("Welcome Back!\nPlease fill in the boxes above and login to continue");
		}
		//action for button to enroll new student
		else if(nameOfCallingBtn.equals("Enroll")) {
			s1 = new Student(fullNameTXTField.getText(), birthDateTXTField.getText(), 
					newPasswordTXTField.getText(), null);
			clearConsole();
			outputArea.append("Thank you for your Registration!!");
			s1.setCourses(cC);
			outputArea.append("\nYour login Email is: " + s1.getEmail() + "\n");
			sC.add(s1);
			appendStudents(sC);
			btnEnroll.setEnabled(false);
			newEnrollOptions();	
		}
		
		//action for button to login
		else if (nameOfCallingBtn.equals("Login")) {
			Student s;
			s = sC.searchStudent(emailAddressTXTField.getText(), passwordTXTField.getText());
			if(s != null) {
				clearConsole();
				outputArea.append(s.toString());
				btnLogin.setEnabled(false);
	    		courseRegistration.setVisible(true);
	    		existingStudent.setVisible(false);
				s1 = s;
				cC = s.getCourses();
				s1.setCourses(cC);
			}else {
				outputArea.append("\nNo such login Found!!");
			}
		}
		//action for button to add a course to a student
		else if (nameOfCallingBtn.equals("Add Course")) {
			clearConsole();
			btnGetWordDocument.setEnabled(true);
			btnGetClassMaterials.setEnabled(true);
			btnAddCourse.setEnabled(false);
			btnRemoveCourse.setEnabled(false);
			Course course = (Course) comboBox.getSelectedItem();
			s1.courses.add(course);
			outputArea.append(s1.toString());
			sC.add(s1);
			appendStudents(sC);
			courseRegOptions();
		}
		//action for button to remove a course from a student
		else if (nameOfCallingBtn.equals("Remove Course")) {
			btnGetWordDocument.setEnabled(true);
			Course target = (Course) comboBox.getSelectedItem();
			Course c1 = s1.courses.searchCourseNumber(target);
			if(c1 != null) {
				clearConsole();
				btnAddCourse.setEnabled(false);
				btnRemoveCourse.setEnabled(false);
				btnGetClassMaterials.setEnabled(true);
				s1.courses.remove(c1);
				outputArea.append(s1.toString());
				sC.add(s1);
				appendStudents(sC);
				courseRegOptions();
			}else {
				outputArea.append("You are not registered for selected course!!\n");
			}
			
		}
		//action for button to give user a txt file of their instance of Student
		else if (nameOfCallingBtn.equals("Get Word Document")) {
			JFileChooser fc = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Word Document", "*.doc");
			fc.setFileFilter(filter);
			fc.setCurrentDirectory(new java.io.File("C:/Users"));
			fc.setDialogTitle("Save Student Information");
			int result = fc.showSaveDialog(null);
			fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			if(result == JFileChooser.APPROVE_OPTION) {
				File fi= fc.getSelectedFile();
				try {
					FileWriter fw = new FileWriter(fi.getPath()+".doc");
					fw.write(s1.studentInfoToDoc());
					fw.flush();
					fw.close();
					btnGetWordDocument.setEnabled(false);
				}catch(Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage());
				}
			}
		}
		else if(nameOfCallingBtn.equals("Show Class Materials")) {
				outputArea.append(s1.getCourses().getCourseMaterials());
				btnGetClassMaterials.setEnabled(false);
		}
	}
	
	//void method to show and decide what the next options are after registering for a course
	public void courseRegOptions() {
    	String[] options = {"Yes", "Quit"};
    	int optionsPane = JOptionPane.showOptionDialog(null,
    	   		"Would You like to Register for More Courses?", "Thank You!",
    	   			JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, 
    	   				null, options, options[0]);
    	if(optionsPane == 0) {
			btnAddCourse.setEnabled(true);
			btnRemoveCourse.setEnabled(true);
    	}
    	else {
    		System.exit(0);
    	}
	}
	//void method to display and decide what next options are after enrolling new student
	public void newEnrollOptions() {
    	String[] options = {"Yes", "Quit"};
    	int optionsPane = JOptionPane.showOptionDialog(null,
    	   		"Would You like to Register for Courses?", "Thank You!",
    	   			JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, 
    	   				null, options, options[0]);
    	if(optionsPane == 0) {
    		courseRegistration.setVisible(true);
    		newStudent.setVisible(false);
    	}
    	else {
    		System.exit(0);
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