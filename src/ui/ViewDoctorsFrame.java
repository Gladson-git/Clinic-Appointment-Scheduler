package ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

import service.AdminService;
import dto.DoctorDTO;

public class ViewDoctorsFrame extends JFrame {

    public ViewDoctorsFrame() {

        setTitle("Doctors");
        setSize(500, 300);
        setLocationRelativeTo(null);

        String[] cols = {"ID", "Name", "Specialization"};
        DefaultTableModel model = new DefaultTableModel(cols, 0);

        JTable table = new JTable(model);

        AdminService service = new AdminService();
        List<DoctorDTO> list = service.getAllDoctors();

        for (DoctorDTO d : list) {
            model.addRow(new Object[]{
                    d.getDoctorId(),
                    d.getName(),
                    d.getSpecialization()
            });
        }

        add(new JScrollPane(table));
        setVisible(true);
    }
}