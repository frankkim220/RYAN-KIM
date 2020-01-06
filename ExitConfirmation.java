import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ExitConfirmation extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExitConfirmation window = new ExitConfirmation();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ExitConfirmation() {
		initialize();
	}

	/**
	 * Initialize the contents of the 
	 */
	private void initialize() {
		setBounds(100, 100, 346, 215);
		setResizable(false);
		setLocation((int)((Toolkit.getDefaultToolkit().getScreenSize().getWidth() - getWidth()) / 2), (int)((Toolkit.getDefaultToolkit().getScreenSize().getHeight() - getHeight()) / 2));
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblAskFirstLine = new JLabel("Are you sure you would");
		lblAskFirstLine.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAskFirstLine.setHorizontalAlignment(SwingConstants.CENTER);
		lblAskFirstLine.setBounds(66, 23, 197, 34);
		getContentPane().add(lblAskFirstLine);
		
		JButton btnYes = new JButton("Yes");
		btnYes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnYes.setBounds(41, 101, 103, 43);
		getContentPane().add(btnYes);
		
		JButton btnNo = new JButton("No");
		btnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNo.setBounds(185, 101, 103, 43);
		getContentPane().add(btnNo);
		
		JLabel lblAskSecondLine = new JLabel("like to exit the program?");
		lblAskSecondLine.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAskSecondLine.setHorizontalAlignment(SwingConstants.CENTER);
		lblAskSecondLine.setBounds(66, 47, 197, 34);
		getContentPane().add(lblAskSecondLine);
	}
}
