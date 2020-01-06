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

public class MemberUpdate extends JFrame{

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
	private JButton btnDelete;
	private Member member;
	private ArrayList<Member> memberList;
	
	public MemberUpdate(Member mem, ArrayList<Member> memList) {
		member = mem;
		memberList = memList;
		initialize();
	}

	/**
	 * Initialize the contents of the 
	 */
	public void initialize() {
		setBounds(100, 100, 502, 460);
		setLocation((int)((Toolkit.getDefaultToolkit().getScreenSize().getWidth() - getWidth()) / 2), (int)((Toolkit.getDefaultToolkit().getScreenSize().getHeight() - getHeight()) / 2));
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
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
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				save();
				dispose();
			}
		});
		btnSave.setBounds(42, 350, 109, 46);
		getContentPane().add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(344, 350, 109, 46);
		getContentPane().add(btnCancel);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				memberList.remove(member);
				dispose();
			}
		});
		btnDelete.setBounds(193, 350, 109, 46);
		getContentPane().add(btnDelete);
		
		updateView();
		save();
	}
	
	public void updateView() {
		txtFieldMemberName.setText(member.getName());
		txtFieldGradeLevel.setText(member.getGrade() + "");
		txtFieldPersonalEmail.setText(member.getEmail());
		txtFieldPersonalPhoneNum.setText(member.getPhone());
		txtFieldHours.setText(member.getHours() + "");
		txtFieldStudentNames.setText(member.getStudents());
		txtFieldInstruments.setText(member.getInstruments());
	}
	
	private void save() {
		member.setName(txtFieldMemberName.getText());
		member.setGrade(Integer.parseInt(txtFieldGradeLevel.getText()));
		member.setEmail(txtFieldPersonalEmail.getText());
		member.setPhone(txtFieldPersonalPhoneNum.getText());
		member.setHours(Integer.parseInt(txtFieldHours.getText()));
		member.setStudents(txtFieldStudentNames.getText());
		member.setInstruments(txtFieldInstruments.getText());
	}
}
