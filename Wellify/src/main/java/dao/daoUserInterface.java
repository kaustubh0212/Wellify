package dao;

import java.util.ArrayList;

import domain.Appointment;
import domain.doctor;
import domain.doctorHistory;
import domain.patient;
import domain.patientHistory;

public interface daoUserInterface {
	public boolean daoRegisterPatient(patient p);
	public boolean daoRegisterDoctor(doctor d);
	public patient daoLoginPatient(String email, String password);
	public doctor daoLoginDoctor(String email, String password);
	public ArrayList<patientHistory> daoViewAppointment(int patientId);
	public ArrayList<doctorHistory> daoViewPatient(int doctorId);
	public String daoGetPrescription(int reportId);
	public boolean daoCancelAppointment(int AppointmentId);
}