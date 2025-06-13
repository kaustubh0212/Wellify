package serviceimpl;

import daoimpl.daoUserImplement;
import domain.doctor;
import domain.patient;
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
}
