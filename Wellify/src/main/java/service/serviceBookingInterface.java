package service;

import java.util.List;
import java.util.ArrayList;

import domain.docAppoint;
import domain.doctor;
//import serviceimpl.ArrayList;

public interface serviceBookingInterface {
	public List<docAppoint> serviceFetchDoctors(String disease, String symptom, String history);
	public int serviceBookAppointment(String disease, int doctorId, int patientId, String time, String date);
	public ArrayList<String> serviceFetchDisease();
}
