import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.util.*;

public class ViewList extends JFrame {

	private ArrayList<Student> studentList;
	private ArrayList<Member> memberList;
	private JTable table;

	public ViewList(ArrayList<Student> slist, ArrayList<Member> mlist) {
		initialize(slist, mlist);
	}

	private void initialize(ArrayList<Student> students, ArrayList<Member> members) {
		studentList = students;
		memberList = members;
		setBounds(100, 100, 534, 431);
		setResizable(false);
		setLocation((int)((Toolkit.getDefaultToolkit().getScreenSize().getWidth() - getWidth()) / 2), (int)((Toolkit.getDefaultToolkit().getScreenSize().getHeight() - getHeight()) / 2));
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblSelect = new JLabel("Select a profile to view:");
		lblSelect.setBounds(26, 28, 229, 20);
		getContentPane().add(lblSelect);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//table.getSelectedCell().   //////////////////////////////////////////select a cell and get the student based on the name
				int row = table.getSelectedRow();
				String name = (String)table.getValueAt(row, 0);
				String type = (String)table.getValueAt(row, 1);
				if (type.equals("Member"))
				{
					for (Member member: memberList)	
					{
						if (member.getName().equals(name))
						{
							MemberView memView = new MemberView(member);
							memView.setVisible(true);
						}
					}
				}
				else
				{
					for (Student student: studentList)
					{
						if (student.getName().equals(name))
						{
							StudentView stuView = new StudentView(student);
							stuView.setVisible(true);
						}
					}
				}
			}
		});
		btnConfirm.setBounds(94, 337, 117, 34);
		getContentPane().add(btnConfirm);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(305, 337, 117, 34);
		getContentPane().add(btnCancel);
		
		String col[] = {"Name", "Title"};
		Object[][] arr = new Object[studentList.size() + memberList.size()][2];
		for (int i = 0; i < studentList.size(); i++)
		{
			arr[i][0] = studentList.get(i).getName();
			arr[i][1] = "Student";
		}
		for (int j = studentList.size(); j < arr.length; j++)
		{
			arr[j][0] = memberList.get(j-studentList.size()).getName();
			arr[j][1] = "Member";
		}
		table = new JTable(new DefaultTableModel(arr, col));
		table.setBounds(36, 59, 447, 257);
		getContentPane().add(table);
	}
}
