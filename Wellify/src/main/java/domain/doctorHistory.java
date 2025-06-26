package domain;

import java.sql.Date;
import java.sql.Time;

public class doctorHistory {
	private int appointmentId;
	private String disease;
	private Date appointmentDate;
	private Time appointmentTime;
	private String status;
	private int reportId;
	private String patientName;
	private String email;
	private int age;
	private int patientId;
	private String symptom;
	private String history;
	
	
	
	public doctorHistory()
	{
		super();
	}
	
	public doctorHistory(int appointmentId, String disease, Date appointmentDate, Time appointmentTime, String status,
			int reportId, String patientName, String email, int age, int patientId, String symptom, String history) {
		super();
		this.appointmentId = appointmentId;
		this.disease = disease;
		this.appointmentDate = appointmentDate;
		this.appointmentTime = appointmentTime;
		this.status = status;
		this.reportId = reportId;
		this.patientName = patientName;
		this.email = email;
		this.age = age;
		this.patientId = patientId;
		this.symptom = symptom;
		this.history = history;
	}
	
	
	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
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
	public int getReportId() {
		return reportId;
	}
	public void setReportId(int reportId) {
		this.reportId = reportId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSymptom() {
		return symptom;
	}
	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}
	public String getHistory() {
		return history;
	}
	public void setHistory(String history) {
		this.history = history;
	}
	
	
}
