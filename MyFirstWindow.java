package MyWindowPackage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JToggleButton;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MyFirstWindow  {

	private JFrame frmMyFirstGui;//declare frame
	private JButton btnNewButton;
	private JButton myNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyFirstWindow window = new MyFirstWindow();
					window.frmMyFirstGui.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MyFirstWindow() {
		initialize(); 
		createEvent();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMyFirstGui = new JFrame();
		frmMyFirstGui.setTitle("My First GUI");
		frmMyFirstGui.setBounds(350, 250, 1200, 600);//x,y & width and height
		frmMyFirstGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMyFirstGui.getContentPane().setLayout(null);
		
		btnNewButton = new JButton("New button");// creation
		btnNewButton.setBounds(150, 63, 89, 23);// position dimension
		frmMyFirstGui.getContentPane().add(btnNewButton);// add to content pane
		
		myNewButton = new JButton("CLICK HERE");
		myNewButton.setBounds(500, 63, 89, 23);
		frmMyFirstGui.getContentPane().add(myNewButton);
	}
	
	private void createEvent() {
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "You have click the button", "Alert",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		myNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
	}
}

