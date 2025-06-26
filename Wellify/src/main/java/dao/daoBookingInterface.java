package dao;

import java.util.List;

import domain.docAppoint;
import domain.doctor;

public interface daoBookingInterface {
	public List<docAppoint> daoFetchDoctors(String disease);
	public int daoBookAppointment(String disease, int doctorId, int patientId, String time, String date, String symptom, String history);
}
