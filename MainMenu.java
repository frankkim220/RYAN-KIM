import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;

public class MainMenu extends JFrame {
	public static ArrayList<Student> studentList;
	public static ArrayList<Member> memberList;
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
		initialize();
		studentList = new ArrayList<Student>();
		memberList = new ArrayList<Member>();
	}

	/**
	 * Initialize the contents of the 
	 */
	private void initialize() {
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
}
