import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;

public class MainMenu extends JFrame {
	public static ArrayList<Student> studentList;
	public static ArrayList<Member> memberList;
	private File myMembersFile;
	private File myStudentsFile;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu window = new MainMenu();
					window.setVisible(true);
					FileWriter writer = new FileWriter("MyFile.txt", true);
					BufferedWriter buff = new BufferedWriter(writer);
					buff.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainMenu() {
		studentList = new ArrayList<Student>();
		memberList = new ArrayList<Member>();
		myMembersFile = new File("Members.txt");
		myStudentsFile = new File("Students.txt");
		initialize();
	}

	/**
	 * Initialize the contents of the 
	 */
	private void initialize() {
		
		try {
			if (myMembersFile.createNewFile()) 
			{
				myMembersFile.createNewFile();
				myStudentsFile.createNewFile();
			}
			loadMembers();
			loadStudents();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		getContentPane().setForeground(new Color(0, 0, 0));
		setSize(640, 360);
		setResizable(false);
		setLocation((int)((Toolkit.getDefaultToolkit().getScreenSize().getWidth() - getWidth()) / 2), (int)((Toolkit.getDefaultToolkit().getScreenSize().getHeight() - getHeight()) / 2));
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JButton btnCreateProfile = new JButton("Create Profile");
		btnCreateProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ask ask = new Ask(studentList, memberList);
				ask.setVisible(true);
			}
		});
		btnCreateProfile.setBounds(18, 183, 133, 87);
		getContentPane().add(btnCreateProfile);
		
		JButton btnUpdateProfile = new JButton("Update Profile");
		btnUpdateProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateList updateList = new UpdateList(studentList, memberList);
				updateList.setVisible(true);
			}
		});
		
		btnUpdateProfile.setBounds(169, 183, 133, 87);
		getContentPane().add(btnUpdateProfile);
		
		JButton btnViewProfile = new JButton("View Profile");
		btnViewProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewList viewList = new ViewList(studentList, memberList);
				viewList.setVisible(true);
			}
		});
		btnViewProfile.setBounds(320, 183, 133, 87);
		getContentPane().add(btnViewProfile);
		
		JButton btnQuitProgram = new JButton("Quit Program");
		btnQuitProgram.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExitConfirmation.NewScreen();
				writeMembers();
				writeStudents();
			}
		});
		btnQuitProgram.setBounds(471, 183, 133, 87);
		getContentPane().add(btnQuitProgram);
		
		JLabel lblTitle = new JLabel("Shekinah Music Academy Directory");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(59, 63, 505, 65);
		getContentPane().add(lblTitle);
	}
	
	public void loadMembers()
	{
		try {
			Scanner scan = new Scanner(myMembersFile);
			ArrayList<String[]> input = new ArrayList <String[]> ();
			while (scan.hasNextLine())
			{
				String str = scan.nextLine();
				String[] s = str.split(",");
				input.add(s);
			}
			for (int i = 0; i < input.size(); i++)
			{
				String[] array = input.get(i);
				Member mem = new Member(array[0], Integer.parseInt(array[1]), array[2], array[3], Integer.parseInt(array[4]), array[5], array[6]);
				memberList.add(mem);
			}
			scan.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void loadStudents()
	{
		try {
			Scanner scan = new Scanner(myStudentsFile);
			ArrayList<String[]> input = new ArrayList <String[]> ();
			while (scan.hasNextLine())
			{
				String str = scan.nextLine();
				String[] s = str.split(",");
				input.add(s);
			}
			for (int i = 0; i < input.size(); i++)
			{
				String[] array = input.get(i);
				Student stu = new Student(array[0], Integer.parseInt(array[1]), array[2], array[3], array[4]);
				studentList.add(stu);
			}
			scan.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void writeMembers()
	{
		try
		{
			PrintWriter pw = new PrintWriter(new FileWriter(myMembersFile));
			for (Member mem: memberList)
			{
				String s = mem.getName() + "," + mem.getGrade() + "," + mem.getEmail() + "," + mem.getPhone() + "," + mem.getHours() + 
						   "," + mem.getStudents() + "," + mem.getInstruments();
				pw.println(s);
			}
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void writeStudents()
	{
		try
		{
			PrintWriter pw = new PrintWriter(new FileWriter(myStudentsFile));
			for (Student stu: studentList)
			{
				String s = stu.getName() + "," + stu.getGrade() + "," + stu.getParentEmail()+ "," + stu.getParentPhone() + ","
						   + stu.getInstrument();
				pw.println(s);
			}
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
