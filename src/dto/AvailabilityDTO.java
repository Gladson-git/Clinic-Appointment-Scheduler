package dto;

import java.sql.Date;
import java.sql.Time;

public class AvailabilityDTO {
    private int availId;
    private int doctorId;
    private Date availableDate;
    private Time availableTime;

    public AvailabilityDTO() {}

    public AvailabilityDTO(int doctorId, Date date, Time time) {
        this.doctorId = doctorId;
        this.availableDate = date;
        this.availableTime = time;
    }

    public int getAvailId() { return availId; }
    public void setAvailId(int availId) { this.availId = availId; }

    public int getDoctorId() { return doctorId; }
    public void setDoctorId(int doctorId) { this.doctorId = doctorId; }

    public Date getAvailableDate() { return availableDate; }
    public void setAvailableDate(Date availableDate) { this.availableDate = availableDate; }

    public Time getAvailableTime() { return availableTime; }
    public void setAvailableTime(Time availableTime) { this.availableTime = availableTime; }
}
