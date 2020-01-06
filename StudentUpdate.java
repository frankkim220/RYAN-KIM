import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class StudentUpdate extends JFrame{

	private JTextField txtFieldStudentName;
	private JTextField txtFieldGradeLevel;
	private JTextField txtFieldParentEmail;
	private JTextField txtFieldParentPhoneNumber;
	private JTextField txtFieldInstrumentLearning;
	private JLabel lblStudentName;
	private JLabel lblGradeLevel;
	private JLabel lblParentEmail;
	private JLabel lblParentPhoneNumber;
	private JLabel lblInstrumentLearning;
	private JButton btnDelete;
	private Student student;
	private ArrayList<Student> studentList;

	public StudentUpdate(Student stu, ArrayList<Student> stuList) {
		student = stu;
		studentList = stuList;
		initialize();
	}

	private void initialize() {
		setBounds(100, 100, 502, 358);
		setResizable(false);
		setLocation((int)((Toolkit.getDefaultToolkit().getScreenSize().getWidth() - getWidth()) / 2), (int)((Toolkit.getDefaultToolkit().getScreenSize().getHeight() - getHeight()) / 2));
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(null);
		
		txtFieldStudentName = new JTextField();
		txtFieldStudentName.setColumns(10);
		txtFieldStudentName.setBounds(181, 25, 279, 20);
		getContentPane().add(txtFieldStudentName);
		
		txtFieldGradeLevel = new JTextField();
		txtFieldGradeLevel.setColumns(10);
		txtFieldGradeLevel.setBounds(181, 70, 279, 20);
		getContentPane().add(txtFieldGradeLevel);
		
		txtFieldParentEmail = new JTextField();
		txtFieldParentEmail.setColumns(10);
		txtFieldParentEmail.setBounds(181, 115, 279, 20);
		getContentPane().add(txtFieldParentEmail);
		
		txtFieldParentPhoneNumber = new JTextField();
		txtFieldParentPhoneNumber.setColumns(10);
		txtFieldParentPhoneNumber.setBounds(181, 160, 279, 20);
		getContentPane().add(txtFieldParentPhoneNumber);
		
		txtFieldInstrumentLearning = new JTextField();
		txtFieldInstrumentLearning.setBounds(181, 205, 279, 20);
		getContentPane().add(txtFieldInstrumentLearning);
		txtFieldInstrumentLearning.setColumns(10);
		
		lblStudentName = new JLabel("Student name:");
		lblStudentName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStudentName.setBounds(10, 25, 170, 20);
		getContentPane().add(lblStudentName);
		
		lblGradeLevel = new JLabel("Grade level:");
		lblGradeLevel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGradeLevel.setBounds(10, 70, 170, 20);
		getContentPane().add(lblGradeLevel);
		
		lblParentEmail = new JLabel("Parent email:");
		lblParentEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblParentEmail.setBounds(10, 115, 170, 20);
		getContentPane().add(lblParentEmail);
		
		lblParentPhoneNumber = new JLabel("Parent phone number:");
		lblParentPhoneNumber.setHorizontalAlignment(SwingConstants.RIGHT);
		lblParentPhoneNumber.setBounds(10, 160, 170, 20);
		getContentPane().add(lblParentPhoneNumber);
		
		lblInstrumentLearning = new JLabel("Instrument learning:");
		lblInstrumentLearning.setHorizontalAlignment(SwingConstants.RIGHT);
		lblInstrumentLearning.setBounds(10, 205, 170, 20);
		getContentPane().add(lblInstrumentLearning);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				save();
				dispose();
			}
		});
		btnSave.setBounds(42, 249, 109, 46);
		getContentPane().add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(344, 249, 109, 46);
		getContentPane().add(btnCancel);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				studentList.remove(student);
			}
		});
		btnDelete.setBounds(193, 249, 109, 46);
		getContentPane().add(btnDelete);
		
		updateView();
	}
	
	public void updateView() {
		txtFieldStudentName.setText(student.getName());
		txtFieldGradeLevel.setText(student.getGrade() + "");
		txtFieldParentEmail.setText(student.getParentEmail());
		txtFieldParentPhoneNumber.setText(student.getParentPhone());
		txtFieldInstrumentLearning.setText(student.getInstrument());
	}
	
	public void save() {
		student.setName(txtFieldStudentName.getText());
		student.setGrade(Integer.parseInt(txtFieldGradeLevel.getText()));
		student.setParentEmail(txtFieldParentEmail.getText());
		student.setParentPhone(txtFieldParentPhoneNumber.getText());
		student.setInstrument(txtFieldInstrumentLearning.getText());
	}
}
