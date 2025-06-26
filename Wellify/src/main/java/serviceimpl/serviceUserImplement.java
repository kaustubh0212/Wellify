package serviceimpl;

import java.util.ArrayList;

import daoimpl.daoUserImplement;
import domain.Appointment;
import domain.doctor;
import domain.doctorHistory;
import domain.patient;
import domain.patientHistory;
import service.serviceUserInterface;

public class serviceUserImplement implements serviceUserInterface {
	
	daoUserImplement dui = new daoUserImplement();
	
	public boolean registerPatient(patient p)
	{
		System.out.println("inside registerPatient()");
		boolean f = dui.daoRegisterPatient(p);
		return f;
	}
	
	public boolean registerDoctor(doctor d)
	{
		System.out.println("inside registerDoctor()");
		boolean f = dui.daoRegisterDoctor(d);
		return f;
	}
	
	public patient loginPatient(String email, String password)
	{
		System.out.println("inside loginPatient()");
		patient p = dui.daoLoginPatient(email, password);
		return p;
	}
	
	public doctor loginDoctor(String email, String password)
	{
		System.out.println("inside loginDoctor()");
		doctor d = dui.daoLoginDoctor(email, password);
		return d;
	}
	
	public ArrayList<patientHistory> serviceViewAppointment(int patientId)
	{
		System.out.println("inside viewAppointment()");
		ArrayList<patientHistory> a = dui.daoViewAppointment(patientId);
		return a;
	}
	
	public ArrayList<doctorHistory> serviceViewPatient(int doctorId)
	{
		System.out.println("inside serviceViewPatient()");
		ArrayList<doctorHistory> a = dui.daoViewPatient(doctorId);
		return a;
	}
	
	public boolean serviceCreateReport(int appointmentId, int doctorId, String medication)
	{
		System.out.println("inside serviceCreateUser()");
		boolean f = dui.daoCreateReport(appointmentId, doctorId, medication);
		return f;
	}

	public String serviceGetPrescription(int reportId)
	{
		System.out.println("inside serviceGetPrescription()");
		String s = dui.daoGetPrescription(reportId);
		return s;
	}
	
	public boolean serviceCancelAppointment(int appointmentId)
	{
		System.out.println("inside serviceCancelAppointment()");
		boolean f = dui.daoCancelAppointment(appointmentId);
		return f;
	}
}
