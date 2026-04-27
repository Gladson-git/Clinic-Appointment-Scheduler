package ui;

import javax.swing.*;
import java.awt.*;
import service.PatientService;
import dto.PatientDTO;

public class RegisterFrame extends JFrame {

    public RegisterFrame() {
        setTitle("Register");
        setSize(300, 250);
        setLayout(new GridLayout(4, 2));
        setLocationRelativeTo(null);

        JTextField name = new JTextField();
        JTextField email = new JTextField();
        JPasswordField pass = new JPasswordField();

        JButton btn = new JButton("Register");

        add(new JLabel("Name:"));
        add(name);
        add(new JLabel("Email:"));
        add(email);
        add(new JLabel("Password:"));
        add(pass);
        add(new JLabel());
        add(btn);

        btn.addActionListener(e -> {
            PatientService service = new PatientService();

            boolean success = service.registerPatient(
                    new PatientDTO(
                            name.getText(),
                            email.getText(),
                            new String(pass.getPassword())
                    )
            );

            if (success)
                JOptionPane.showMessageDialog(this, "Registered!");
            else
                JOptionPane.showMessageDialog(this, "Failed!");
        });

        setVisible(true);
    }
}