package MyWindowPackage;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;

public class GuessTheNumber {

	private JFrame frame;
	private JPanel contentPane;
	private JButton btnCheckGuess;
	private JTextField txtGuessYourNumber;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuessTheNumber window = new GuessTheNumber();
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
	public GuessTheNumber() {
		initialize();
		createEvent();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 450, 300);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);

		 
		btnCheckGuess = new JButton("Check the number");
		btnCheckGuess.setBackground(SystemColor.activeCaption);
		btnCheckGuess.setBounds(158, 184, 131, 23);
		contentPane.add(btnCheckGuess);

		JLabel lblNewLabel = new JLabel("Guess the number from 1 to 10");
		lblNewLabel.setFont(new Font("NSimSun", Font.BOLD, 15));
		lblNewLabel.setLabelFor(frame);
		lblNewLabel.setBounds(107, 119, 255, 23);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("GUESS THE NUMBER");
		lblNewLabel_1.setFont(new Font("Cambria Math", Font.BOLD, 30));
		lblNewLabel_1.setBounds(81, 37, 292, 83);
		contentPane.add(lblNewLabel_1);

		txtGuessYourNumber = new JTextField();
		txtGuessYourNumber.setBackground(SystemColor.activeCaptionBorder);
		txtGuessYourNumber.setText("Guess Your Number Here");
		txtGuessYourNumber.setBounds(158, 153, 131, 20);
		contentPane.add(txtGuessYourNumber);
		txtGuessYourNumber.setColumns(10);
	}

	/**
	 * Events (Guess function)
	 */
	private void createEvent() {
	    txtGuessYourNumber.addMouseListener(new MouseAdapter() {
	        @Override
	        public void mouseClicked(MouseEvent e) {
	            if (txtGuessYourNumber.getText().equals("Guess Your Number Here")) {
	                txtGuessYourNumber.setText("");
	            }
	        }
	    });

	    btnCheckGuess.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            String input = txtGuessYourNumber.getText().trim();
	            if (input.equals("") || input.equals("Guess Your Number Here")) {
	                JOptionPane.showMessageDialog(null,
	                        "Please enter a number.",
	                        "Input Error",
	                        JOptionPane.INFORMATION_MESSAGE);
	                return;
	            }

	            try {
	                int guess = Integer.parseInt(input);	           
	                if (guess < 1 || guess > 10) {
	                    JOptionPane.showMessageDialog(null,
	                            "Number out of range! Enter a number between 1 and 10.",
	                            "Range Error",
	                            JOptionPane.INFORMATION_MESSAGE);
	                    return;
	                }
	                
	                Random r = new Random();
	                int low = 1;
	                int high = 11;
	                int result = r.nextInt(high - low) + low;

	                JOptionPane.showInternalMessageDialog(
	                        null,
	                        "Your guess: " + guess + "\nCorrect number: " + result,
	                        "Alert",
	                        JOptionPane.INFORMATION_MESSAGE);

	            } catch (Exception ex) {
	                JOptionPane.showMessageDialog(null, "Enter a valid number.");
	            }

	        }
	    });
	}
}

