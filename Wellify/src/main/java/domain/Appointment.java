package domain;

import java.sql.Date;
import java.sql.Time;

public class Appointment {
	private int appointmentId;
	private String disease;
	private int patientId;
	private int doctorId;
	private Date appointmentDate;
	private Time appointmentTime;
	private String status;
	
	
	
	public Appointment()
	{
		super();
	}

	public Appointment(int appointmentId, String disease, int patientId, int doctorId, Date appointmentDate,
			Time appointmentTime, String status){
		super();
		this.appointmentId = appointmentId;
		this.disease = disease;
		this.patientId = patientId;
		this.doctorId = doctorId;
		this.appointmentDate = appointmentDate;
		this.appointmentTime = appointmentTime;
		this.status = status;
	}



	public int getAppointmentId() {
		return appointmentId;
	}


	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}


	public String getDisease() {
		return disease;
	}


	public void setDisease(String disease) {
		this.disease = disease;
	}


	public int getPatientId() {
		return patientId;
	}


	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}


	public int getDoctorId() {
		return doctorId;
	}


	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}


	public Date getAppointmentDate() {
		return appointmentDate;
	}


	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}


	public Time getAppointmentTime() {
		return appointmentTime;
	}


	public void setAppointmentTime(Time appointmentTime) {
		this.appointmentTime = appointmentTime;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
}