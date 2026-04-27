package main;

import javax.swing.SwingUtilities;
import ui.MainFrame;

public class ClinicMain {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new MainFrame();
        });
    }
}