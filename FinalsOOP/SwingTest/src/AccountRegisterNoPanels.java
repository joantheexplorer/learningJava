import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AccountRegisterNoPanels extends JFrame {

    JLabel lblTitle, lblName, lblMobile, lblBday, lblEmail, lblCEmail, lblPass, lblCPass, lblCourse, lblSem;
    JTextField txtName, txtMobile, txtBirthday, txtEmail, txtConfirmEmail;
    JPasswordField txtPass, txtConfirmPass;
    JToggleButton btnShowPass;
    JComboBox<String> cmbCourse;
    JRadioButton rbtn1, rbtn2;
    ButtonGroup semGroup;
    DefaultListModel<String> listModel;
    JList<String> list;
    JScrollPane scroll;
    JButton btnAdd, btnReset, btnClear;

    public AccountRegisterNoPanels() {
        setTitle("Account Register");
        setSize(500, 750);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(null);

        lblTitle = new JLabel("ACCOUNT REGISTER");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 16));
        lblTitle.setBounds(160, 10, 200, 30);
        add(lblTitle);

        lblName = new JLabel("NAME:");
        lblName.setBounds(30, 50, 150, 25);
        add(lblName);

        txtName = new JTextField();
        txtName.setBounds(200, 50, 250, 25);
        add(txtName);

        lblMobile = new JLabel("MOBILE NUMBER:");
        lblMobile.setBounds(30, 90, 150, 25);
        add(lblMobile);

        txtMobile = new JTextField();
        txtMobile.setBounds(200, 90, 250, 25);
        add(txtMobile);

        lblBday = new JLabel("BIRTHDAY (YYYY-MM-DD):");
        lblBday.setBounds(30, 130, 160, 25);
        add(lblBday);

        txtBirthday = new JTextField();
        txtBirthday.setBounds(200, 130, 250, 25);
        add(txtBirthday);

        lblEmail = new JLabel("EMAIL ADDRESS:");
        lblEmail.setBounds(30, 170, 150, 25);
        add(lblEmail);

        txtEmail = new JTextField();
        txtEmail.setBounds(200, 170, 250, 25);
        add(txtEmail);

        lblCEmail = new JLabel("CONFIRM EMAIL:");
        lblCEmail.setBounds(30, 210, 150, 25);
        add(lblCEmail);

        txtConfirmEmail = new JTextField();
        txtConfirmEmail.setBounds(200, 210, 250, 25);
        add(txtConfirmEmail);

        lblPass = new JLabel("PASSWORD:");
        lblPass.setBounds(30, 250, 150, 25);
        add(lblPass);

        txtPass = new JPasswordField();
        txtPass.setEchoChar('*');
        txtPass.setBounds(200, 250, 180, 25);
        add(txtPass);

        btnShowPass = new JToggleButton("Show");
        btnShowPass.setMargin(new Insets(0, 0, 0, 0)); // make text fit tight
        btnShowPass.setFont(new Font("Arial", Font.PLAIN, 10));
        btnShowPass.setBounds(390, 250, 60, 25);
        add(btnShowPass);

        lblCPass = new JLabel("CONFIRM PASSWORD:");
        lblCPass.setBounds(30, 290, 150, 25);
        add(lblCPass);

        txtConfirmPass = new JPasswordField();
        txtConfirmPass.setEchoChar('*');
        txtConfirmPass.setBounds(200, 290, 250, 25);
        add(txtConfirmPass);

        lblCourse = new JLabel("COURSE:");
        lblCourse.setBounds(30, 330, 150, 25);
        add(lblCourse);

        String[] courses = { "BSCS", "BSIT", "BSIS" };
        cmbCourse = new JComboBox<>(courses);
        cmbCourse.setBounds(200, 330, 250, 25);
        add(cmbCourse);

        lblSem = new JLabel("SEMESTER:");
        lblSem.setBounds(30, 370, 150, 25);
        add(lblSem);

        rbtn1 = new JRadioButton("1ST SEMESTER");
        rbtn1.setBounds(200, 370, 120, 25);
        add(rbtn1);

        rbtn2 = new JRadioButton("2ND SEMESTER");
        rbtn2.setBounds(330, 370, 120, 25);
        add(rbtn2);

        semGroup = new ButtonGroup();
        semGroup.add(rbtn1);
        semGroup.add(rbtn2);

        listModel = new DefaultListModel<>();
        listModel.addElement("Juan Dela Cruz - BSIT");
        listModel.addElement("John Santos - BSCS");

        list = new JList<>(listModel);
        scroll = new JScrollPane(list);
        scroll.setBorder(BorderFactory.createTitledBorder("Student List"));
        scroll.setBounds(30, 410, 420, 180);
        add(scroll);

        btnAdd = new JButton("btnADD");
        btnAdd.setBounds(50, 610, 100, 30);
        add(btnAdd);

        btnReset = new JButton("btnRESET");
        btnReset.setBounds(190, 610, 100, 30);
        add(btnReset);

        btnClear = new JButton("btnCLEAR");
        btnClear.setBounds(330, 610, 100, 30);
        add(btnClear);

        btnShowPass.addActionListener(e -> {
            if (btnShowPass.isSelected()) {
                txtPass.setEchoChar((char) 0);
                txtConfirmPass.setEchoChar((char) 0);
                btnShowPass.setText("Hide");
            } else {
                txtPass.setEchoChar('*');
                txtConfirmPass.setEchoChar('*');
                btnShowPass.setText("Show");
            }
        });

        btnAdd.addActionListener(e -> {
            if (validateInputs()) {
                String name = txtName.getText();
                String course = cmbCourse.getSelectedItem().toString();
                listModel.addElement(name + " - " + course);
                JOptionPane.showMessageDialog(null, "Student Added!");
                resetFields();
            }
        });

        btnReset.addActionListener(e -> resetFields());

        btnClear.addActionListener(e -> {
            if (list.getSelectedIndex() != -1) {
                listModel.remove(list.getSelectedIndex());
            } else {
                JOptionPane.showMessageDialog(null, "Select item first.");
            }
        });
    }

    private boolean validateInputs() {
        String name = txtName.getText();
        String mobile = txtMobile.getText();
        String bday = txtBirthday.getText();
        String email = txtEmail.getText();
        String cEmail = txtConfirmEmail.getText();
        String pass = new String(txtPass.getPassword());
        String cPass = new String(txtConfirmPass.getPassword());

        if (name.isEmpty() || mobile.isEmpty() || bday.isEmpty() ||
                email.isEmpty() || pass.isEmpty() || (!rbtn1.isSelected() && !rbtn2.isSelected())) {
            JOptionPane.showMessageDialog(null, "All fields required!");
            return false;
        }
        if (!mobile.matches("\\d{11}")) {
            JOptionPane.showMessageDialog(null, "Mobile must be 11 digits!");
            return false;
        }
        if (!email.endsWith("@yahoo.com") && !email.endsWith("@gmail.com")) {
            JOptionPane.showMessageDialog(null, "Invalid Email Domain!");
            return false;
        }
        if (!email.equals(cEmail)) {
            JOptionPane.showMessageDialog(null, "Emails mismatch!");
            return false;
        }
        if (!pass.equals(cPass)) {
            JOptionPane.showMessageDialog(null, "Passwords mismatch!");
            return false;
        }
        return true;
    }

    private void resetFields() {
        txtName.setText("");
        txtMobile.setText("");
        txtBirthday.setText("");
        txtEmail.setText("");
        txtConfirmEmail.setText("");
        txtPass.setText("");
        txtConfirmPass.setText("");
        cmbCourse.setSelectedIndex(0);
        semGroup.clearSelection();
        btnShowPass.setSelected(false);
        btnShowPass.setText("Show");
        txtPass.setEchoChar('*');
        txtConfirmPass.setEchoChar('*');
    }

    public static void main(String[] args) {
        new AccountRegisterNoPanels().setVisible(true);
    }
}