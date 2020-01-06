import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Ask extends JFrame {
	private ArrayList<Member> memberList;
	private ArrayList<Student> studentList;
	
	public Ask(ArrayList<Student> stuList, ArrayList<Member> memList) {
		memberList = memList;
		studentList = stuList;
		initialize();
	}

	/**
	 * Initialize the contents of the 
	 */
	private void initialize() {
		setBounds(100, 100, 450, 235);
		setResizable(false);
		setLocation((int)((Toolkit.getDefaultToolkit().getScreenSize().getWidth() - getWidth()) / 2), (int)((Toolkit.getDefaultToolkit().getScreenSize().getHeight() - getHeight()) / 2));
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblSelect = new JLabel("Select one of the following:");
		lblSelect.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSelect.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelect.setBounds(99, 26, 236, 48);
		getContentPane().add(lblSelect);
		
		JButton btnStudent = new JButton("Student");
		btnStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentCreate stuCre = new StudentCreate(studentList);
				stuCre.setVisible(true);
				dispose();
			}
		});
		btnStudent.setBounds(241, 95, 145, 69);
		getContentPane().add(btnStudent);
		
		JButton btnMember = new JButton("Member");
		btnMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MemberCreate memCre = new MemberCreate(memberList);
				memCre.setVisible(true);
				dispose();
			}
		});
		btnMember.setBounds(48, 95, 145, 69);
		getContentPane().add(btnMember);
	}
}
