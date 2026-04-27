package ui;

import javax.swing.*;
import java.awt.*;
import dto.PatientDTO;

public class PatientDashboardFrame extends JFrame {

    public PatientDashboardFrame(PatientDTO patient) {

        setTitle("Dashboard");
        setSize(400, 300);
        setLayout(new GridLayout(3, 1));
        setLocationRelativeTo(null);

        JButton viewDoctors = new JButton("View Doctors");
        JButton logout = new JButton("Logout");

        add(viewDoctors);
        add(logout);

        viewDoctors.addActionListener(e -> new ViewDoctorsFrame());

        logout.addActionListener(e -> {
            new MainFrame();
            dispose();
        });

        setVisible(true);
    }
}