package dto;

import java.sql.Date;
import java.sql.Time;

public class AppointmentDTO {

    private int appointmentId;
    private int patientId;
    private int doctorId;
    private Date appointmentDate;
    private Time appointmentTime;
    private String status;

    public AppointmentDTO() {}

    public AppointmentDTO(int patientId, int doctorId, Date date, Time time, String status) {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.appointmentDate = date;
        this.appointmentTime = time;
        this.status = status;
    }

    // ----- Getters -----
    public int getAppointmentId() { return appointmentId; }
    public int getPatientId() { return patientId; }
    public int getDoctorId() { return doctorId; }
    public Date getAppointmentDate() { return appointmentDate; }
    public Time getAppointmentTime() { return appointmentTime; }
    public String getStatus() { return status; }

    // ----- Setters -----
    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public void setAppointmentTime(Time appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
