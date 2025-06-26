package service;

import java.util.List;

import domain.docAppoint;
import domain.doctor;

public interface serviceBookingInterface {
	public List<docAppoint> serviceFetchDoctors(String disease, String symptom, String history);
	public boolean serviceBookAppointment(String disease, int doctorId, int patientId, String time, String date);
}
