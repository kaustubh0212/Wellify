package serviceimpl;

import java.util.ArrayList;
import java.util.List;

import daoimpl.daoBookingImplement;
import daoimpl.daoUserImplement;
import domain.docAppoint;
import domain.doctor;

public class serviceBookingImplementation {
	
	daoBookingImplement dbi = new daoBookingImplement();
	
	public List<docAppoint> serviceFetchDoctors(String disease)
	{
		System.out.println("inside serviceFetchDoctors()");
		List <docAppoint> d = dbi.daoFetchDoctors(disease);
		
		return d;
	}

	public int serviceBookAppointment(String disease, int doctorId, int patientId, String time, String date, String symptom, String history)
	{
		System.out.println("inside serviceBookAppointment()");
		int val = dbi.daoBookAppointment(disease, doctorId, patientId, time, date, symptom, history);
		
		return val;
	}
	
	public ArrayList<String> serviceFetchDisease()
	{
		System.out.println("inside serviceFetchDisease()");
		daoBookingImplement dbi = new daoBookingImplement();
		ArrayList<String> a = dbi.daoFetchDisease();
		return a;
	}
}
