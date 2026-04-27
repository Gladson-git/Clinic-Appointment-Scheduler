package ui;

import javax.swing.*;
import java.awt.*;
import service.PatientService;
import dto.PatientDTO;

public class PatientLoginFrame extends JFrame {

    public PatientLoginFrame() {
        setTitle("Login");
        setSize(300, 200);
        setLayout(new GridLayout(3, 2));
        setLocationRelativeTo(null);

        JTextField email = new JTextField();
        JPasswordField pass = new JPasswordField();

        JButton loginBtn = new JButton("Login");

        add(new JLabel("Email:"));
        add(email);
        add(new JLabel("Password:"));
        add(pass);
        add(new JLabel());
        add(loginBtn);

        loginBtn.addActionListener(e -> {

            PatientService service = new PatientService();
            PatientDTO patient = service.loginPatient(
                    email.getText(),
                    new String(pass.getPassword())
            );

            if (patient != null) {
                JOptionPane.showMessageDialog(this, "Login Success");
                new PatientDashboardFrame(patient);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Login");
            }
        });

        setVisible(true);
    }
}