package MyWindowPackage;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class LoginForm extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnLogin, btnClear;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                LoginForm frame = new LoginForm();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public LoginForm() {
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(400, 150, 862, 647);
        setResizable(false);

        // Background Panel
        contentPane = new JPanel();
        contentPane.setForeground(new Color(0, 128, 192));
        contentPane.setLayout(null);
        contentPane.setBackground(new Color(245, 245, 245));
        setContentPane(contentPane);

        // Login Card Panel
        JPanel card = new JPanel();
        card.setLayout(null);
        card.setBounds(52, 36, 743, 525);
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        contentPane.add(card);

        // Title
        JLabel lblTitle = new JLabel("Login");
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 26));
        lblTitle.setForeground(new Color(50, 50, 50));
        lblTitle.setBounds(10, 11, 200, 40);
        card.add(lblTitle);

        // Username Label
        JLabel lblUser = new JLabel("Username:");
        lblUser.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblUser.setBounds(180, 163, 208, 20);
        card.add(lblUser);

        // Username Field
        txtUsername = new JTextField("put your username");
        txtUsername.setForeground(Color.GRAY);
        txtUsername.setBounds(257, 160, 250, 30);
        txtUsername.setBorder(BorderFactory.createLineBorder(new Color(180, 180, 180)));
        card.add(txtUsername);
        addPlaceholderBehavior(txtUsername, "put your username");

        // Password Label
        JLabel lblPass = new JLabel("Password:");
        lblPass.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblPass.setBounds(180, 228, 200, 20);
        card.add(lblPass);

        // Password Field
        txtPassword = new JPasswordField("put your password");
        txtPassword.setForeground(Color.GRAY);
        txtPassword.setEchoChar((char) 0);
        txtPassword.setBounds(257, 225, 250, 30);
        txtPassword.setBorder(BorderFactory.createLineBorder(new Color(180, 180, 180)));
        card.add(txtPassword);
        addPlaceholderBehaviorPassword(txtPassword, "put your password");

        // Login Button
        btnLogin = new JButton("Login");
        btnLogin.setBounds(257, 285, 110, 35);
        btnLogin.setBackground(new Color(66, 133, 244));
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setFocusPainted(false);
        btnLogin.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnLogin.setBorder(BorderFactory.createEmptyBorder());
        card.add(btnLogin);

        // Clear Button
        btnClear = new JButton("Clear");
        btnClear.setBounds(397, 285, 110, 35);
        btnClear.setBackground(new Color(200, 200, 200));
        btnClear.setForeground(Color.BLACK);
        btnClear.setFocusPainted(false);
        btnClear.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnClear.setBorder(BorderFactory.createEmptyBorder());
        card.add(btnClear);

        // Buttons Actions
        btnLogin.addActionListener(e -> loginAction());
        btnClear.addActionListener(e -> clearAction());
    }

    // Placeholder for username
    private void addPlaceholderBehavior(JTextField field, String placeholder) {
        field.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if (field.getText().equals(placeholder)) {
                    field.setText("");
                    field.setForeground(Color.BLACK);
                }
            }
            public void focusLost(FocusEvent e) {
                if (field.getText().isEmpty()) {
                    field.setText(placeholder);
                    field.setForeground(Color.GRAY);
                }
            }
        });
    }

    // Placeholder for password
    private void addPlaceholderBehaviorPassword(JPasswordField field, String placeholder) {
        field.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if (String.valueOf(field.getPassword()).equals(placeholder)) {
                    field.setText("");
                    field.setForeground(Color.BLACK);
                    field.setEchoChar('•');
                }
            }
            public void focusLost(FocusEvent e) {
                if (String.valueOf(field.getPassword()).isEmpty()) {
                    field.setText(placeholder);
                    field.setForeground(Color.GRAY);
                    field.setEchoChar((char) 0);
                }
            }
        });
    }

    private void loginAction() {
        String user = txtUsername.getText();
        String pass = String.valueOf(txtPassword.getPassword());

        if (user.equals("put your username") || pass.equals("put your password")) {
            JOptionPane.showMessageDialog(this, "Please enter your username and password.");
            return;
        }

        if (user.equals("bruh") && pass.equals("1234")) {
            JOptionPane.showMessageDialog(this, "Login Successful!");
        } else {
            JOptionPane.showMessageDialog(this,
                    "Invalid Username or Password!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearAction() {
        txtUsername.setText("put your username");
        txtUsername.setForeground(Color.GRAY);

        txtPassword.setText("put your password");
        txtPassword.setForeground(Color.GRAY);
        txtPassword.setEchoChar((char) 0);
    }
}
