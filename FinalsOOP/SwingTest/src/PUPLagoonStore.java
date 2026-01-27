import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PUPLagoonStore extends JFrame implements ActionListener {

    JLabel titleLabel;

    JLabel lblName, lblCourse, lblPass;
    JTextField nameField;
    JComboBox<String> courseBox;
    JPasswordField passwordField;
    JToggleButton togglePasswordBtn;

    JLabel lblItems;
    JCheckBox chkShake, chkFriedNoodles, chkFewa, chkHotcake,
            chkSiomaiRice, chkChickenRice, chkGulaman, chkWater;

    JLabel lblDiscount;
    JRadioButton rdoPWD, rdoSenior, rdoNoDisc;
    ButtonGroup discountGroup;

    JLabel lblTotal, lblMoney, lblChange, lblVat;
    JTextField totalField, moneyInsertedField, changeField, vatField;

    JButton btnCompute, btnCancel;

    final double PRICE_SHAKE = 30.0;
    final double PRICE_NOODLES = 35.0;
    final double PRICE_FEWA = 25.0;
    final double PRICE_HOTCAKE = 15.0;
    final double PRICE_SIOMAI_RICE = 45.0;
    final double PRICE_CHICKEN_RICE = 60.0;
    final double PRICE_GULAMAN = 10.0;
    final double PRICE_WATER = 15.0;

    public PUPLagoonStore() {
        setTitle("PUP Lagoon Store");
        setSize(420, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(null);

        titleLabel = new JLabel("PUP Lagoon Store");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        titleLabel.setBounds(100, 10, 250, 30); // x, y, width, height
        add(titleLabel);

        lblName = new JLabel("Name:");
        lblName.setBounds(30, 60, 80, 25);
        add(lblName);

        nameField = new JTextField();
        nameField.setBounds(100, 60, 250, 25);
        add(nameField);

        lblCourse = new JLabel("Course:");
        lblCourse.setBounds(30, 95, 80, 25);
        add(lblCourse);

        String[] courses = { "BSIT", "BSCS", "BSCpE", "BSA", "BSBA", "BSED", "OTHER" };
        courseBox = new JComboBox<>(courses);
        courseBox.setBounds(100, 95, 250, 25);
        add(courseBox);

        lblPass = new JLabel("Password:");
        lblPass.setBounds(30, 130, 80, 25);
        add(lblPass);

        passwordField = new JPasswordField();
        passwordField.setBounds(100, 130, 190, 25);
        add(passwordField);

        togglePasswordBtn = new JToggleButton("Show");
        togglePasswordBtn.setFont(new Font("Arial", Font.PLAIN, 10));
        togglePasswordBtn.setMargin(new Insets(0, 0, 0, 0));
        togglePasswordBtn.setBounds(300, 130, 50, 25);
        add(togglePasswordBtn);

        togglePasswordBtn.addActionListener(e -> {
            if (togglePasswordBtn.isSelected()) {
                passwordField.setEchoChar((char) 0);
                togglePasswordBtn.setText("Hide");
            } else {
                passwordField.setEchoChar('•');
                togglePasswordBtn.setText("Show");
            }
        });

        lblItems = new JLabel("ITEMS:");
        lblItems.setFont(new Font("Arial", Font.BOLD, 14));
        lblItems.setBounds(30, 180, 100, 20);
        add(lblItems);

        chkShake = new JCheckBox("Shake (" + PRICE_SHAKE + ")");
        chkShake.setBounds(30, 210, 160, 20);
        add(chkShake);

        chkFewa = new JCheckBox("Fewa (" + PRICE_FEWA + ")");
        chkFewa.setBounds(30, 240, 160, 20);
        add(chkFewa);

        chkSiomaiRice = new JCheckBox("Siomai w/Rice (" + PRICE_SIOMAI_RICE + ")");
        chkSiomaiRice.setBounds(30, 270, 160, 20);
        add(chkSiomaiRice);

        chkGulaman = new JCheckBox("Gulaman (" + PRICE_GULAMAN + ")");
        chkGulaman.setBounds(30, 300, 160, 20);
        add(chkGulaman);

        chkFriedNoodles = new JCheckBox("Fried Noodles (" + PRICE_NOODLES + ")");
        chkFriedNoodles.setBounds(200, 210, 180, 20);
        add(chkFriedNoodles);

        chkHotcake = new JCheckBox("Hotcake (" + PRICE_HOTCAKE + ")");
        chkHotcake.setBounds(200, 240, 180, 20);
        add(chkHotcake);

        chkChickenRice = new JCheckBox("Chicken w/Rice (" + PRICE_CHICKEN_RICE + ")");
        chkChickenRice.setBounds(200, 270, 180, 20);
        add(chkChickenRice);

        chkWater = new JCheckBox("Water (" + PRICE_WATER + ")");
        chkWater.setBounds(200, 300, 180, 20);
        add(chkWater);

        lblDiscount = new JLabel("DISCOUNT:");
        lblDiscount.setFont(new Font("Arial", Font.BOLD, 14));
        lblDiscount.setBounds(30, 340, 100, 20);
        add(lblDiscount);

        rdoPWD = new JRadioButton("PWD");
        rdoPWD.setBounds(30, 365, 80, 20);

        rdoSenior = new JRadioButton("SENIOR");
        rdoSenior.setBounds(120, 365, 90, 20);

        rdoNoDisc = new JRadioButton("NO DISC", true);
        rdoNoDisc.setBounds(220, 365, 100, 20);

        discountGroup = new ButtonGroup();
        discountGroup.add(rdoPWD);
        discountGroup.add(rdoSenior);
        discountGroup.add(rdoNoDisc);

        add(rdoPWD);
        add(rdoSenior);
        add(rdoNoDisc);

        lblTotal = new JLabel("TOTAL:");
        lblTotal.setBounds(30, 410, 120, 25);
        add(lblTotal);

        totalField = new JTextField();
        totalField.setEditable(false);
        totalField.setBounds(160, 410, 190, 25);
        add(totalField);

        lblMoney = new JLabel("MONEY INSERTED:");
        lblMoney.setBounds(30, 445, 120, 25);
        add(lblMoney);

        moneyInsertedField = new JTextField();
        moneyInsertedField.setBounds(160, 445, 190, 25);
        add(moneyInsertedField);

        lblChange = new JLabel("CHANGE:");
        lblChange.setBounds(30, 480, 120, 25);
        add(lblChange);

        changeField = new JTextField();
        changeField.setEditable(false);
        changeField.setBounds(160, 480, 190, 25);
        add(changeField);

        lblVat = new JLabel("VAT (12%):");
        lblVat.setBounds(30, 515, 120, 25);
        add(lblVat);

        vatField = new JTextField();
        vatField.setEditable(false);
        vatField.setBounds(160, 515, 190, 25);
        add(vatField);

        btnCompute = new JButton("COMPUTE");
        btnCompute.setBounds(80, 570, 100, 35);
        add(btnCompute);

        btnCancel = new JButton("CANCEL");
        btnCancel.setBounds(200, 570, 100, 35);
        add(btnCancel);

        btnCompute.addActionListener(this);
        btnCancel.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCompute) {
            computeOrder();
        } else if (e.getSource() == btnCancel) {
            clearFields();
        }
    }

    private void computeOrder() {
        double subtotal = 0.0;

        if (chkShake.isSelected())
            subtotal += PRICE_SHAKE;
        if (chkFriedNoodles.isSelected())
            subtotal += PRICE_NOODLES;
        if (chkFewa.isSelected())
            subtotal += PRICE_FEWA;
        if (chkHotcake.isSelected())
            subtotal += PRICE_HOTCAKE;
        if (chkSiomaiRice.isSelected())
            subtotal += PRICE_SIOMAI_RICE;
        if (chkChickenRice.isSelected())
            subtotal += PRICE_CHICKEN_RICE;
        if (chkGulaman.isSelected())
            subtotal += PRICE_GULAMAN;
        if (chkWater.isSelected())
            subtotal += PRICE_WATER;

        double discountRate = 0.0;
        if (rdoPWD.isSelected() || rdoSenior.isSelected()) {
            discountRate = 0.20;
        }

        double discountAmount = subtotal * discountRate;
        double finalTotal = subtotal - discountAmount;
        double vat = finalTotal * 0.12;

        try {
            String moneyText = moneyInsertedField.getText();
            if (moneyText.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter Money Inserted.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            double moneyInserted = Double.parseDouble(moneyText);

            if (moneyInserted < finalTotal) {
                JOptionPane.showMessageDialog(this, "Insufficient Payment!", "Error", JOptionPane.WARNING_MESSAGE);
                return;
            }

            double change = moneyInserted - finalTotal;

            totalField.setText(String.format("%.2f", finalTotal));
            vatField.setText(String.format("%.2f", vat));
            changeField.setText(String.format("%.2f", change));

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid Money format.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearFields() {
        nameField.setText("");
        courseBox.setSelectedIndex(0);
        passwordField.setText("");
        totalField.setText("");
        moneyInsertedField.setText("");
        changeField.setText("");
        vatField.setText("");

        chkShake.setSelected(false);
        chkFriedNoodles.setSelected(false);
        chkFewa.setSelected(false);
        chkHotcake.setSelected(false);
        chkSiomaiRice.setSelected(false);
        chkChickenRice.setSelected(false);
        chkGulaman.setSelected(false);
        chkWater.setSelected(false);

        rdoNoDisc.setSelected(true);

        togglePasswordBtn.setSelected(false);
        togglePasswordBtn.setText("Show");
        passwordField.setEchoChar('•');
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PUPLagoonStore());
    }
}