package service;

import domain.doctor;
import domain.patient;

public interface serviceUserInterface {
	public boolean registerPatient(patient p);
	public boolean registerDoctor(doctor d);
	public patient loginPatient(String email, String password);
	public doctor loginDoctor(String email, String password);
	
}
