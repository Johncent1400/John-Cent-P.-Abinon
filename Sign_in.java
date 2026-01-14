package MyWindowPackage;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class sign_in extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtFirstName, txtLastName, txtUsername, txtAge;
    private JPasswordField txtPassword;
    private JTextArea txtOutput;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                sign_in frame = new sign_in();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public sign_in() {
        setTitle("Sign In");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1087, 658);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTitle = new JLabel("SIGN IN");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
        lblTitle.setBounds(480, 10, 200, 30);
        contentPane.add(lblTitle);

        // First Name
        JLabel lblFirstName = new JLabel("First Name:");
        lblFirstName.setBounds(30, 60, 100, 20);
        contentPane.add(lblFirstName);

        txtFirstName = new JTextField();
        txtFirstName.setBounds(96, 60, 150, 20);
        contentPane.add(txtFirstName);

        // Last Name
        JLabel lblLastName = new JLabel("Last Name:");
        lblLastName.setBounds(604, 60, 100, 20);
        contentPane.add(lblLastName);

        txtLastName = new JTextField();
        txtLastName.setBounds(669, 60, 150, 20);
        contentPane.add(txtLastName);

        // Username
        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setBounds(30, 99, 100, 20);
        contentPane.add(lblUsername);

        txtUsername = new JTextField();
        txtUsername.setBounds(96, 99, 150, 20);
        contentPane.add(txtUsername);

        // Password
        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setBounds(604, 99, 100, 20);
        contentPane.add(lblPassword);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(669, 99, 150, 20);
        contentPane.add(txtPassword);

        // Age
        JLabel lblAge = new JLabel("Age:");
        lblAge.setBounds(604, 130, 100, 20);
        contentPane.add(lblAge);

        txtAge = new JTextField();
        txtAge.setBounds(674, 130, 50, 20);
        contentPane.add(txtAge);

        // Sex
        JLabel lblSex = new JLabel("Sex:");
        lblSex.setBounds(30, 143, 100, 20);
        contentPane.add(lblSex);

        JRadioButton rdbMale = new JRadioButton("Male");
        rdbMale.setBounds(96, 143, 70, 20);
        contentPane.add(rdbMale);

        JRadioButton rdbFemale = new JRadioButton("Female");
        rdbFemale.setBounds(168, 143, 80, 20);
        contentPane.add(rdbFemale);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(rdbMale);
        genderGroup.add(rdbFemale);

        // Subscription
        JLabel lblSubscription = new JLabel("Subscription:");
        lblSubscription.setBounds(30, 174, 100, 20);
        contentPane.add(lblSubscription);

        JRadioButton rdbFree = new JRadioButton("Free");
        rdbFree.setBounds(136, 174, 60, 20);
        contentPane.add(rdbFree);

        JRadioButton rdbPremium = new JRadioButton("Premium");
        rdbPremium.setBounds(210, 174, 100, 20);
        contentPane.add(rdbPremium);

        ButtonGroup subGroup = new ButtonGroup();
        subGroup.add(rdbFree);
        subGroup.add(rdbPremium);

        // Output Box (Account Created Info)
        txtOutput = new JTextArea();
        txtOutput.setEditable(false);
        txtOutput.setFont(new Font("Monospaced", Font.PLAIN, 14));

        JScrollPane scrollPane = new JScrollPane(txtOutput);
        scrollPane.setBounds(30, 260, 1000, 330);
        contentPane.add(scrollPane);

        // Sign In Button
        JButton btnSignIn = new JButton("Sign In");
        btnSignIn.setBounds(604, 167, 120, 35);
        contentPane.add(btnSignIn);

        btnSignIn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String firstName = txtFirstName.getText();
                String lastName = txtLastName.getText();
                String username = txtUsername.getText();
                String password = new String(txtPassword.getPassword());
                String age = txtAge.getText();

                String sex = rdbMale.isSelected() ? "Male" :
                             rdbFemale.isSelected() ? "Female" : "Not Selected";

                String subscription = rdbFree.isSelected() ? "Free" :
                                      rdbPremium.isSelected() ? "Premium" : "Not Selected";

                if (firstName.isEmpty() || lastName.isEmpty() || username.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill in all required fields!");
                    return;
                }

                txtOutput.setText("");
                txtOutput.append("✅ ACCOUNT SUCCESSFULLY CREATED\n");
                txtOutput.append("--------------------------------------\n");
                txtOutput.append("First Name   : " + firstName + "\n");
                txtOutput.append("Last Name    : " + lastName + "\n");
                txtOutput.append("Username     : " + username + "\n");
                txtOutput.append("Age          : " + age + "\n");
                txtOutput.append("Sex          : " + sex + "\n");
                txtOutput.append("Subscription : " + subscription + "\n");
            }
        });
    }
}
