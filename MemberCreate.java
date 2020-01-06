import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class MemberCreate extends JFrame {
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
	
	private ArrayList<Member> memberList;

	public MemberCreate(ArrayList<Member> memList) {
		memberList = memList;
		initialize();
	}

	/**
	 * Initialize the contents of the 
	 */
	private void initialize() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 502, 460);
		setResizable(false);
		setLocation((int)((Toolkit.getDefaultToolkit().getScreenSize().getWidth() - getWidth()) / 2), (int)((Toolkit.getDefaultToolkit().getScreenSize().getHeight() - getHeight()) / 2));
		getContentPane().setLayout(null);
		
		txtFieldMemberName = new JTextField();
		txtFieldMemberName.setColumns(10);
		txtFieldMemberName.setBounds(181, 25, 279, 20);
		getContentPane().add(txtFieldMemberName);
		
		txtFieldGradeLevel = new JTextField();
		txtFieldGradeLevel.setColumns(10);
		txtFieldGradeLevel.setBounds(181, 70, 279, 20);
		getContentPane().add(txtFieldGradeLevel);
		
		txtFieldPersonalEmail = new JTextField();
		txtFieldPersonalEmail.setColumns(10);
		txtFieldPersonalEmail.setBounds(181, 115, 279, 20);
		getContentPane().add(txtFieldPersonalEmail);
		
		txtFieldPersonalPhoneNum = new JTextField();
		txtFieldPersonalPhoneNum.setColumns(10);
		txtFieldPersonalPhoneNum.setBounds(181, 160, 279, 20);
		getContentPane().add(txtFieldPersonalPhoneNum);
		
		txtFieldHours = new JTextField();
		txtFieldHours.setColumns(10);
		txtFieldHours.setBounds(181, 205, 279, 20);
		getContentPane().add(txtFieldHours);
		
		txtFieldStudentNames = new JTextField();
		txtFieldStudentNames.setColumns(10);
		txtFieldStudentNames.setBounds(181, 250, 279, 20);
		getContentPane().add(txtFieldStudentNames);
		
		txtFieldInstruments = new JTextField();
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
		
		JLabel lblIntError = new JLabel("Non-integer(s)!");
		lblIntError.setForeground(Color.RED);
		lblIntError.setHorizontalAlignment(SwingConstants.CENTER);
		lblIntError.setBounds(191, 321, 118, 16);
		getContentPane().add(lblIntError);
		lblIntError.setVisible(false);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				save();
			}
		});
		btnSave.setBounds(92, 350, 109, 46);
		getContentPane().add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(293, 350, 109, 46);
		getContentPane().add(btnCancel);
		
	}
	private void save() {
		try {
			String name = txtFieldMemberName.getText();
			int grade = Integer.parseInt(txtFieldGradeLevel.getText());
			String pEmail = txtFieldPersonalEmail.getText();
			String pNumber = txtFieldPersonalPhoneNum.getText();
			int hours = Integer.parseInt(txtFieldHours.getText());
			String stuNames = txtFieldStudentNames.getText();
			String instruments = txtFieldInstruments.getText();
			Member mem = new Member(name, grade, pEmail, pNumber, hours, stuNames, instruments);
			memberList.add(mem);
			JOptionPane.showMessageDialog(null, "Member Created");
			dispose();
		} catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Please Enter Integer for Grade and Community Service Hours");
		}		
	}
}
