package service;

import java.util.ArrayList;

import domain.Appointment;
import domain.doctor;
import domain.doctorHistory;
import domain.patient;
import domain.patientHistory;

public interface serviceUserInterface {
	public boolean registerPatient(patient p);
	public boolean registerDoctor(doctor d);
	public patient loginPatient(String email, String password);
	public doctor loginDoctor(String email, String password);
	public ArrayList<patientHistory> serviceViewAppointment(int patientId);
	public ArrayList<doctorHistory> serviceViewPatient(int patientId);
	public boolean serviceCreateReport(int appointmentId, int doctorId, String medication);
	public String serviceGetPrescription(int reportId);
	public boolean serviceCancelAppointment(int AppointmentId);
	
}
