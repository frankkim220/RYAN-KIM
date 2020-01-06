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

public class MemberView extends JFrame{

	private JTextField txtFieldMemberName;
	private JTextField txtFieldGradeLevel;
	private JTextField txtFieldPersonalEmail;
	private JTextField txtFieldPersonalPhoneNum;
	private JTextField txtFieldHours;
	private JTextField txtFieldStudentNames;
	private JTextField txtFieldInstruments;
	private JLabel lblMemberName;
	private JLabel lblGradeLevel;
	private JLabel lblPersonalEmail;
	private JLabel lblPersonalPhoneNum;
	private JLabel lblHours;
	private JLabel lblStudentNames;
	private JLabel lblInstruments;
	private Member member;
	
	/**
	 * Create the application.
	 */
	public MemberView(Member mem) {
		member = mem;
		initialize();
	}

	/**
	 * Initialize the contents of the 
	 */
	private void initialize() {
		setBounds(100, 100, 502, 460);
		setResizable(false);
		setLocation((int)((Toolkit.getDefaultToolkit().getScreenSize().getWidth() - getWidth()) / 2), (int)((Toolkit.getDefaultToolkit().getScreenSize().getHeight() - getHeight()) / 2));
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(null);
		
		txtFieldMemberName = new JTextField();
		txtFieldMemberName.setEditable(false);
		txtFieldMemberName.setColumns(10);
		txtFieldMemberName.setBounds(181, 25, 279, 20);
		getContentPane().add(txtFieldMemberName);
		
		txtFieldGradeLevel = new JTextField();
		txtFieldGradeLevel.setEditable(false);
		txtFieldGradeLevel.setColumns(10);
		txtFieldGradeLevel.setBounds(181, 70, 279, 20);
		getContentPane().add(txtFieldGradeLevel);
		
		txtFieldPersonalEmail = new JTextField();
		txtFieldPersonalEmail.setEditable(false);
		txtFieldPersonalEmail.setColumns(10);
		txtFieldPersonalEmail.setBounds(181, 115, 279, 20);
		getContentPane().add(txtFieldPersonalEmail);
		
		txtFieldPersonalPhoneNum = new JTextField();
		txtFieldPersonalPhoneNum.setEditable(false);
		txtFieldPersonalPhoneNum.setColumns(10);
		txtFieldPersonalPhoneNum.setBounds(181, 160, 279, 20);
		getContentPane().add(txtFieldPersonalPhoneNum);
		
		txtFieldHours = new JTextField();
		txtFieldHours.setEditable(false);
		txtFieldHours.setColumns(10);
		txtFieldHours.setBounds(181, 205, 279, 20);
		getContentPane().add(txtFieldHours);
		
		txtFieldStudentNames = new JTextField();
		txtFieldStudentNames.setEditable(false);
		txtFieldStudentNames.setColumns(10);
		txtFieldStudentNames.setBounds(181, 250, 279, 20);
		getContentPane().add(txtFieldStudentNames);
		
		txtFieldInstruments = new JTextField();
		txtFieldInstruments.setEditable(false);
		txtFieldInstruments.setColumns(10);
		txtFieldInstruments.setBounds(181, 295, 279, 20);
		getContentPane().add(txtFieldInstruments);
		
		lblMemberName = new JLabel("Member name:");
		lblMemberName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMemberName.setBounds(10, 25, 170, 20);
		getContentPane().add(lblMemberName);
		
		lblGradeLevel = new JLabel("Grade level:");
		lblGradeLevel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGradeLevel.setBounds(10, 70, 170, 20);
		getContentPane().add(lblGradeLevel);
		
		lblPersonalEmail = new JLabel("Personal email:");
		lblPersonalEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPersonalEmail.setBounds(10, 115, 170, 20);
		getContentPane().add(lblPersonalEmail);
		
		lblPersonalPhoneNum = new JLabel("Personal phone number:");
		lblPersonalPhoneNum.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPersonalPhoneNum.setBounds(10, 160, 170, 20);
		getContentPane().add(lblPersonalPhoneNum);
		
		lblHours = new JLabel("Community service hours:");
		lblHours.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHours.setBounds(10, 205, 170, 20);
		getContentPane().add(lblHours);
		
		lblStudentNames = new JLabel("Name(s) of student(s):");
		lblStudentNames.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStudentNames.setBounds(10, 250, 170, 20);
		getContentPane().add(lblStudentNames);
		
		lblInstruments = new JLabel("Instrument(s) teaching:");
		lblInstruments.setHorizontalAlignment(SwingConstants.RIGHT);
		lblInstruments.setBounds(10, 295, 170, 20);
		getContentPane().add(lblInstruments);
		
		JButton btnReturn = new JButton("Return to Main Menu");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnReturn.setBounds(163, 350, 170, 46);
		getContentPane().add(btnReturn);
		updateView();
	}
	
	private void updateView() {
		txtFieldMemberName.setText(member.getName());
		txtFieldGradeLevel.setText(member.getGrade() + "");
		txtFieldPersonalEmail.setText(member.getEmail());
		txtFieldPersonalPhoneNum.setText(member.getPhone());
		txtFieldHours.setText(member.getHours() + "");
		txtFieldStudentNames.setText(member.getStudents());
		txtFieldInstruments.setText(member.getInstruments());
	}
}
