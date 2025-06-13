package dao;

import domain.doctor;
import domain.patient;

public interface daoUserInterface {
	public boolean daoRegisterPatient(patient p);
	public boolean daoRegisterDoctor(doctor d);
	public patient daoLoginPatient(String email, String password);
	public doctor daoLoginDoctor(String email, String password);
}