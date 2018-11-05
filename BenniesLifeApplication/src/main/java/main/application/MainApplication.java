package main.application;

import java.awt.EventQueue;

import javax.swing.JFrame;

//import javax.swing.JButton;
//import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;

public class MainApplication {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public void Load() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					MainApplication window = new MainApplication();
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
	public MainApplication() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
//		frame = new JFrame();
//		frame.setBounds(100, 100, 450, 300);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.getContentPane().setLayout(null);
//		
//		JButton btnCalender = new JButton("Calender");
//		btnCalender.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				MyCalender myCal = new MyCalender();
//				myCal.Load();
//			}
//		});
//		btnCalender.setBounds(82, 97, 89, 23);
//		frame.getContentPane().add(btnCalender);
//		
//		JButton btnPray = new JButton("Pray");
//		btnPray.setBounds(121, 165, 89, 23);
//		frame.getContentPane().add(btnPray);
	}
}
