package domain;

import java.sql.Date;
import java.sql.Time;

public class patientHistory {
	private int appointmentId;
	private String disease;
	private int doctorId;
	private Date appointmentDate;
	private Time appointmentTime;
	private String status;
	private String name;
	private String email;
	private String address;
	private int fees;
	private String specialization;
	private String phone;
	private int reportId;
	private String history;
	
	
	public patientHistory()
	{
		super();
	}
	
	
	public patientHistory(int appointmentId, String disease, int doctorId, Date appointmentDate, Time appointmentTime,
			String status, String name, String email, String address, int fees, String specialization, String phone,
			int reportId, String history) {
		super();
		this.appointmentId = appointmentId;
		this.disease = disease;
		this.doctorId = doctorId;
		this.appointmentDate = appointmentDate;
		this.appointmentTime = appointmentTime;
		this.status = status;
		this.name = name;
		this.email = email;
		this.address = address;
		this.fees = fees;
		this.specialization = specialization;
		this.phone = phone;
		this.reportId = reportId;
		this.history = history;
	}
	

	public String getHistory() {
		return history;
	}
	

	public void setHistory(String history) {
		this.history = history;
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


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public int getFees() {
		return fees;
	}


	public void setFees(int fees) {
		this.fees = fees;
	}


	public String getSpecialization() {
		return specialization;
	}


	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public int getReportId() {
		return reportId;
	}


	public void setReportId(int reportId) {
		this.reportId = reportId;
	}
	
	
}
