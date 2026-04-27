package ui;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public MainFrame() {
        setTitle("Clinic Scheduler");
        setSize(400, 300);
        setLayout(new GridLayout(3, 1, 10, 10));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel title = new JLabel("Clinic Scheduler", JLabel.CENTER);

        JButton loginBtn = new JButton("Patient Login");
        JButton registerBtn = new JButton("Register");

        add(title);
        add(loginBtn);
        add(registerBtn);

        loginBtn.addActionListener(e -> {
            new PatientLoginFrame();
            dispose();
        });

        registerBtn.addActionListener(e -> {
            new RegisterFrame();
            dispose();
        });

        setVisible(true);
    }
}