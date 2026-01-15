 package MyWindowPackage;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BMI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtAge;
	private JTextField txtHeight;
	private JTextField txtWeight;
	private JLabel lblResult;
	private JTable table;
	private DefaultTableModel tableModel;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				BMI frame = new BMI();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public BMI() {
		setTitle("BMI Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Name
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(20, 20, 100, 25);
		contentPane.add(lblName);

		txtName = new JTextField();
		txtName.setBounds(120, 20, 180, 25);
		contentPane.add(txtName);

		// Age
		JLabel lblAge = new JLabel("Age:");
		lblAge.setBounds(20, 55, 100, 25);
		contentPane.add(lblAge);

		txtAge = new JTextField();
		txtAge.setBounds(120, 55, 80, 25);
		contentPane.add(txtAge);

		// Gender
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setBounds(20, 90, 100, 25);
		contentPane.add(lblGender);

		JRadioButton rbMale = new JRadioButton("Male");
		rbMale.setBounds(120, 90, 70, 25);
		contentPane.add(rbMale);

		JRadioButton rbFemale = new JRadioButton("Female");
		rbFemale.setBounds(200, 90, 90, 25);
		contentPane.add(rbFemale);

		ButtonGroup bgGender = new ButtonGroup();
		bgGender.add(rbMale);
		bgGender.add(rbFemale);

		// Height
		JLabel lblHeight = new JLabel("Height (cm):");
		lblHeight.setBounds(20, 125, 100, 25);
		contentPane.add(lblHeight);

		txtHeight = new JTextField();
		txtHeight.setBounds(120, 125, 100, 25);
		contentPane.add(txtHeight);

		// Weight
		JLabel lblWeight = new JLabel("Weight (kg):");
		lblWeight.setBounds(20, 160, 100, 25);
		contentPane.add(lblWeight);

		txtWeight = new JTextField();
		txtWeight.setBounds(120, 160, 100, 25);
		contentPane.add(txtWeight);

		// Buttons
		JButton btnCalculate = new JButton("Calculate BMI");
		btnCalculate.setBounds(120, 200, 150, 30);
		contentPane.add(btnCalculate);

		JButton btnClear = new JButton("Clear / New BMI");
		btnClear.setBounds(120, 240, 150, 30);
		contentPane.add(btnClear);

		// Result
		lblResult = new JLabel("Result:");
		lblResult.setBounds(20, 280, 300, 60);
		contentPane.add(lblResult);

		// ===== TABLE =====
		String[] columns = {
			"Name", "Age", "Gender", "Height(cm)", "Weight(kg)", "BMI", "Category"
		};

		tableModel = new DefaultTableModel(columns, 0);
		table = new JTable(tableModel);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(330, 20, 390, 350);
		contentPane.add(scrollPane);

		// CALCULATE BUTTON ACTION
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (txtName.getText().isEmpty() || txtAge.getText().isEmpty()
							|| txtHeight.getText().isEmpty() || txtWeight.getText().isEmpty()
							|| (!rbMale.isSelected() && !rbFemale.isSelected())) {

						JOptionPane.showMessageDialog(null, "Please complete all fields!");
						return;
					}

					String name = txtName.getText();
					int age = Integer.parseInt(txtAge.getText());
					String gender = rbMale.isSelected() ? "Male" : "Female";

					double heightCm = Double.parseDouble(txtHeight.getText());
					double height = heightCm / 100;
					double weight = Double.parseDouble(txtWeight.getText());

					double bmi = weight / (height * height);
					String category;

					if (bmi < 18.5)
						category = "Underweight";
					else if (bmi < 24.9)
						category = "Normal";
					else if (bmi < 29.9)
						category = "Overweight";
					else
						category = "Obese";

					lblResult.setText(
						"<html>Name: " + name +
						"<br>Age: " + age +
						"<br>Gender: " + gender +
						"<br>BMI: " + String.format("%.2f", bmi) +
						" (" + category + ")</html>"
					);

					tableModel.addRow(new Object[] {
						name, age, gender, heightCm, weight,
						String.format("%.2f", bmi), category
					});

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null,
						"Invalid input! Numbers only for Age, Height, and Weight.");
				}
			}
		});

		// CLEAR BUTTON ACTION
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtName.setText("");
				txtAge.setText("");
				txtHeight.setText("");
				txtWeight.setText("");
				bgGender.clearSelection();
				lblResult.setText("Result:");
				txtName.requestFocus();
			}
		});
	}
}
