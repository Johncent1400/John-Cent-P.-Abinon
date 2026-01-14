package MyWindowPackage;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class grud extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private DefaultTableModel model;

    private JTextField txtName, txtAddress, txtAge, txtOccupation, txtSearch;
    private JComboBox<String> comboSex, comboPurpose;

    private ArrayList<BarangayRequest> requests = new ArrayList<>();
    private int nextId = 1;

    private String[] sexes = {"Male", "Female"};
    private String[] purposes = {
        "Clearance",
        "Indigency",
        "Certificate of Residency",
        "Business Permit",
        "Others"
    };

    public grud() {
        setTitle("Barangay Clearance CRUD System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 950, 550);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        // Labels
        addLabel("Name:", 10, 10);
        addLabel("Address:", 10, 40);
        addLabel("Sex:", 10, 70);
        addLabel("Age:", 10, 100);
        addLabel("Occupation:", 10, 130);
        addLabel("Purpose:", 10, 160);
        addLabel("Search Name:", 10, 420);

        // Inputs
        txtName = addTextField(100, 10);
        txtAddress = addTextField(100, 40);
        txtAge = addTextField(100, 100);
        txtOccupation = addTextField(100, 130);
        txtSearch = addTextField(110, 420);

        comboSex = new JComboBox<>(sexes);
        comboSex.setBounds(100, 70, 200, 25);
        contentPane.add(comboSex);

        comboPurpose = new JComboBox<>(purposes);
        comboPurpose.setBounds(100, 160, 200, 25);
        contentPane.add(comboPurpose);

        // Buttons
        addButton("Create", 320, 10, e -> createRequest());
        addButton("Update", 320, 40, e -> updateRequest());
        addButton("Delete", 320, 70, e -> deleteRequest());
        addButton("Approve", 430, 10, e -> changeStatus("Approved"));
        addButton("Release", 430, 40, e -> changeStatus("Released"));
        addButton("Reject", 430, 70, e -> changeStatus("Rejected"));
        addButton("Clear", 540, 10, e -> clearFields());
        addButton("Search", 320, 420, e -> searchRequests());

        // Table
        model = new DefaultTableModel(
            new String[]{"ID", "Name", "Address", "Sex", "Age", "Occupation", "Purpose", "Status"}, 0
        );
        table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 200, 910, 200);
        contentPane.add(scrollPane);

        table.getSelectionModel().addListSelectionListener(e -> fillFieldsFromTable());
    }

    // ===== CRUD METHODS =====

    private void createRequest() {
        if (txtName.getText().isEmpty() || txtAddress.getText().isEmpty()
                || txtAge.getText().isEmpty() || txtOccupation.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields");
            return;
        }

        BarangayRequest r = new BarangayRequest(
                nextId++, txtName.getText(), txtAddress.getText(),
                comboSex.getSelectedItem().toString(),
                txtAge.getText(), txtOccupation.getText(),
                comboPurpose.getSelectedItem().toString(), "Pending"
        );

        requests.add(r);
        model.addRow(new Object[]{
            r.id, r.name, r.address, r.sex,
            r.age, r.occupation, r.purpose, r.status
        });

        clearFields();
    }

    private void updateRequest() {
        int row = table.getSelectedRow();
        if (row == -1) return;

        int id = (int) model.getValueAt(row, 0);
        for (BarangayRequest r : requests) {
            if (r.id == id) {
                r.name = txtName.getText();
                r.address = txtAddress.getText();
                r.sex = comboSex.getSelectedItem().toString();
                r.age = txtAge.getText();
                r.occupation = txtOccupation.getText();
                r.purpose = comboPurpose.getSelectedItem().toString();
            }
        }

        model.setValueAt(txtName.getText(), row, 1);
        model.setValueAt(txtAddress.getText(), row, 2);
        model.setValueAt(comboSex.getSelectedItem(), row, 3);
        model.setValueAt(txtAge.getText(), row, 4);
        model.setValueAt(txtOccupation.getText(), row, 5);
        model.setValueAt(comboPurpose.getSelectedItem(), row, 6);

        clearFields();
    }

    //deletaRequast
    private void deleteRequest() {
        int row = table.getSelectedRow();
        if (row == -1) return;

        int id = (int) model.getValueAt(row, 0);
        requests.removeIf(r -> r.id == id);
        model.removeRow(row);
        clearFields();
    }

    //changeStatus
    private void changeStatus(String status) {
        int row = table.getSelectedRow();
        if (row == -1) return;

        int id = (int) model.getValueAt(row, 0);
        for (BarangayRequest r : requests) {
            if (r.id == id) r.status = status;
        }
        model.setValueAt(status, row, 7);
    }

    //searchRequaests
    private void searchRequests() {
        String key = txtSearch.getText().trim().toLowerCase();
        model.setRowCount(0); 
        if (key.isEmpty()) {
            for (BarangayRequest r : requests) {
                model.addRow(new Object[]{
                    r.id, r.name, r.address, r.sex,
                    r.age, r.occupation, r.purpose, r.status
                });
            }
            return;
        }
        for (BarangayRequest r : requests) {
            boolean matchName = r.name.toLowerCase().contains(key);
            boolean matchId = false;          
            try {
                int searchId = Integer.parseInt(key);
                matchId = r.id == searchId;
            } catch (NumberFormatException e) {               
            }
          
            if (matchName || matchId) {
                model.addRow(new Object[]{
                    r.id, r.name, r.address, r.sex,
                    r.age, r.occupation, r.purpose, r.status
                });
            }
        }
    }


    private void clearFields() {
        txtName.setText("");
        txtAddress.setText("");
        txtAge.setText("");
        txtOccupation.setText("");
        comboSex.setSelectedIndex(0);
        comboPurpose.setSelectedIndex(0);
        table.clearSelection();
    }

    private void fillFieldsFromTable() {
        int row = table.getSelectedRow();
        if (row != -1) {
            txtName.setText(model.getValueAt(row, 1).toString());
            txtAddress.setText(model.getValueAt(row, 2).toString());
            comboSex.setSelectedItem(model.getValueAt(row, 3));
            txtAge.setText(model.getValueAt(row, 4).toString());
            txtOccupation.setText(model.getValueAt(row, 5).toString());
            comboPurpose.setSelectedItem(model.getValueAt(row, 6));
        }
    }

    private void addLabel(String text, int x, int y) {
        JLabel lbl = new JLabel(text);
        lbl.setBounds(x, y, 100, 25);
        contentPane.add(lbl);
    }

    private JTextField addTextField(int x, int y) {
        JTextField tf = new JTextField();
        tf.setBounds(x, y, 200, 25);
        contentPane.add(tf);
        return tf;
    }

    private void addButton(String text, int x, int y, java.awt.event.ActionListener a) {
        JButton btn = new JButton(text);
        btn.setBounds(x, y, 120, 25);
        btn.addActionListener(a);
        contentPane.add(btn);
    }
}
