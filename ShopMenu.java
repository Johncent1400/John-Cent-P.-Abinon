package MyWindowPackage;

import java.awt.EventQueue;
import javax.swing.*;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ShopMenu {

    private JFrame frame;

    // Checkboxes
    private JCheckBox chckbxOkinawa;
    private JCheckBox chckbxMatcha;
    private JCheckBox chckbxWM;
    private JCheckBox chckbxTaro;
    private JCheckBox chckbxRedVelvet;
    private JCheckBox chckbxChocolate;
    private JCheckBox chckbxThai;

    private JCheckBox chckbxHotdog;
    private JCheckBox chckbxBurger;
    private JCheckBox chckbxBugerWithCheese;
    private JCheckBox chckbxFries;
    private JCheckBox chckbxNuggets;
    private JCheckBox chckbxSandwich;

    // PAYMENT + ORDER TYPE
    private JComboBox<String> comboPayment;
    private JRadioButton rdbtnDineIn, rdbtnTakeOut;
    private ButtonGroup dineGroup;

    private JTextArea textArea;
    private JButton btnCheckOut;

    // Prices
    private final int OKINAWA_PRICE = 29;
    private final int MATCHA_PRICE = 29;
    private final int WINTERMELON_PRICE = 29;
    private final int TARO_PRICE = 35;
    private final int REDVELVET_PRICE = 35;
    private final int CHOCOLATE_PRICE = 30;
    private final int THAI_PRICE = 40;

    private final int BURGER_PRICE = 50;
    private final int BURGER_WITH_CHEESE_PRICE = 70;
    private final int HOTDOG_PRICE = 60;
    private final int FRIES_PRICE = 40;
    private final int NUGGETS_PRICE = 65;
    private final int SANDWICH_PRICE = 45;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                ShopMenu window = new ShopMenu();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public ShopMenu() {
        initialize();
        createEvent();
    }

    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 18));
        frame.setBounds(100, 100, 1100, 530);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblTitle = new JLabel("Milk Tea Shop");
        lblTitle.setBounds(155, -3, 200, 46);
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
        frame.getContentPane().add(lblTitle);

        // ========================
        // MILKTEA PANEL
        // ========================
        JPanel panel = new JPanel();
        panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        panel.setBounds(33, 54, 500, 140);
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        JLabel lblMilktea = new JLabel("Milktea");
        lblMilktea.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblMilktea.setBounds(220, 11, 80, 14);
        panel.add(lblMilktea);

        chckbxOkinawa = new JCheckBox("Okinawa 29");
        chckbxOkinawa.setBounds(6, 46, 120, 23);
        panel.add(chckbxOkinawa);

        chckbxMatcha = new JCheckBox("Matcha 29");
        chckbxMatcha.setBounds(126, 46, 120, 23);
        panel.add(chckbxMatcha);

        chckbxWM = new JCheckBox("Wintermelon 29");
        chckbxWM.setBounds(246, 46, 120, 23);
        panel.add(chckbxWM);

        chckbxTaro = new JCheckBox("Taro 35");
        chckbxTaro.setBounds(366, 46, 120, 23);
        panel.add(chckbxTaro);

        chckbxRedVelvet = new JCheckBox("Red Velvet 35");
        chckbxRedVelvet.setBounds(6, 80, 150, 23);
        panel.add(chckbxRedVelvet);

        chckbxChocolate = new JCheckBox("Chocolate 30");
        chckbxChocolate.setBounds(166, 80, 150, 23);
        panel.add(chckbxChocolate);

        chckbxThai = new JCheckBox("Thai Milk Tea 40");
        chckbxThai.setBounds(326, 80, 150, 23);
        panel.add(chckbxThai);

        // ========================
        // SNACKS PANEL
        // ========================
        JPanel panelSnacks = new JPanel();
        panelSnacks.setLayout(null);
        panelSnacks.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        panelSnacks.setBounds(554, 54, 500, 140);
        frame.getContentPane().add(panelSnacks);

        JLabel lblSnacks = new JLabel("Snacks");
        lblSnacks.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblSnacks.setBounds(220, 11, 80, 14);
        panelSnacks.add(lblSnacks);

        chckbxBurger = new JCheckBox("Burger 50");
        chckbxBurger.setBounds(6, 46, 120, 23);
        panelSnacks.add(chckbxBurger);

        chckbxBugerWithCheese = new JCheckBox("Burger w/ Cheese 70");
        chckbxBugerWithCheese.setBounds(126, 46, 160, 23);
        panelSnacks.add(chckbxBugerWithCheese);

        chckbxHotdog = new JCheckBox("Hotdog 60");
        chckbxHotdog.setBounds(296, 46, 120, 23);
        panelSnacks.add(chckbxHotdog);

        chckbxFries = new JCheckBox("Fries 40");
        chckbxFries.setBounds(6, 80, 120, 23);
        panelSnacks.add(chckbxFries);

        chckbxNuggets = new JCheckBox("Nuggets 65");
        chckbxNuggets.setBounds(126, 80, 120, 23);
        panelSnacks.add(chckbxNuggets);

        chckbxSandwich = new JCheckBox("Sandwich 45");
        chckbxSandwich.setBounds(246, 80, 120, 23);
        panelSnacks.add(chckbxSandwich);

        // PAYMENT METHOD
        JLabel lblPayment = new JLabel("Payment Method:");
        lblPayment.setBounds(33, 210, 150, 23);
        frame.getContentPane().add(lblPayment);

        comboPayment = new JComboBox<>();
        comboPayment.addItem("Cash");
        comboPayment.addItem("GCash");
        comboPayment.addItem("Maya");
        comboPayment.addItem("Credit Card");
        comboPayment.setBounds(150, 210, 150, 23);
        frame.getContentPane().add(comboPayment);

        // ORDER TYPE
        JLabel lblDine = new JLabel("Order Type:");
        lblDine.setBounds(33, 245, 150, 23);
        frame.getContentPane().add(lblDine);

        rdbtnDineIn = new JRadioButton("Dine In");
        rdbtnDineIn.setBounds(150, 245, 80, 23);

        rdbtnTakeOut = new JRadioButton("Take Out");
        rdbtnTakeOut.setBounds(230, 245, 100, 23);

        dineGroup = new ButtonGroup();
        dineGroup.add(rdbtnDineIn);
        dineGroup.add(rdbtnTakeOut);

        frame.getContentPane().add(rdbtnDineIn);
        frame.getContentPane().add(rdbtnTakeOut);

        // RESULT TEXT AREA
        textArea = new JTextArea();
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 13));
        textArea.setBounds(33, 300, 450, 160);
        frame.getContentPane().add(textArea);

        // CHECKOUT BUTTON
        btnCheckOut = new JButton("Check Out");
        btnCheckOut.setBounds(520, 300, 140, 35);
        frame.getContentPane().add(btnCheckOut);
    }

    private void createEvent() {

        btnCheckOut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                int total = 0;
                int totalItems = 0; // <--- Ito ang bagong variable
                StringBuilder order = new StringBuilder();

                order.append("========== RECEIPT ==========\n");

                // =======================
                // MILKTEA SELECTIONS
                // =======================
                if (chckbxOkinawa.isSelected()) {
                    total += OKINAWA_PRICE;
                    totalItems++;
                    order.append("Okinawa ............ 29\n");
                }
                if (chckbxMatcha.isSelected()) {
                    total += MATCHA_PRICE;
                    totalItems++;
                    order.append("Matcha ............. 29\n");
                }
                if (chckbxWM.isSelected()) {
                    total += WINTERMELON_PRICE;
                    totalItems++;
                    order.append("Wintermelon ........ 29\n");
                }
                if (chckbxTaro.isSelected()) {
                    total += TARO_PRICE;
                    totalItems++;
                    order.append("Taro ............... 35\n");
                }
                if (chckbxRedVelvet.isSelected()) {
                    total += REDVELVET_PRICE;
                    totalItems++;
                    order.append("Red Velvet ......... 35\n");
                }
                if (chckbxChocolate.isSelected()) {
                    total += CHOCOLATE_PRICE;
                    totalItems++;
                    order.append("Chocolate .......... 30\n");
                }
                if (chckbxThai.isSelected()) {
                    total += THAI_PRICE;
                    totalItems++;
                    order.append("Thai Milk Tea ...... 40\n");
                }

                // =======================
                // SNACKS
                // =======================
                if (chckbxBurger.isSelected()) {
                    total += BURGER_PRICE;
                    totalItems++;
                    order.append("Burger ............. 50\n");
                }
                if (chckbxBugerWithCheese.isSelected()) {
                    total += BURGER_WITH_CHEESE_PRICE;
                    totalItems++;
                    order.append("Burger w/ Cheese ... 70\n");
                }
                if (chckbxHotdog.isSelected()) {
                    total += HOTDOG_PRICE;
                    totalItems++;
                    order.append("Hotdog ............. 60\n");
                }
                if (chckbxFries.isSelected()) {
                    total += FRIES_PRICE;
                    totalItems++;
                    order.append("Fries .............. 40\n");
                }
                if (chckbxNuggets.isSelected()) {
                    total += NUGGETS_PRICE;
                    totalItems++;
                    order.append("Nuggets ............ 65\n");
                }
                if (chckbxSandwich.isSelected()) {
                    total += SANDWICH_PRICE;
                    totalItems++;
                    order.append("Sandwich ........... 45\n");
                }

                order.append("--------------------------------\n");
                
                String payment = comboPayment.getSelectedItem().toString();
                order.append("Payment: ").append(payment).append("\n");

                String orderType = "Not selected";
                if (rdbtnDineIn.isSelected()) orderType = "Dine In";
                if (rdbtnTakeOut.isSelected()) orderType = "Take Out";

                order.append("Order Type: ").append(orderType).append("\n");                
                order.append("Total Items: ").append(totalItems).append("\n");   
                order.append("TOTAL: ").append(total).append(" PHP\n");
                order.append("================================");
   
                textArea.setText(order.toString());                
            }
        });
    }
}
