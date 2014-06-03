package pj2014.dbservices.interfaces;

import java.util.ArrayList;
import java.util.Date;

import javax.ejb.Remote;

import pj2014.patrepo.entities.Patient;

@Remote
public interface PatientDBServiceRemote {

	// create
	public abstract Patient createPatient(Patient pat);

	//update
	public abstract Patient updatePatient(Patient pat, String firstName,
			String lastName, boolean gender, Date bBDay);

	public abstract Patient findPatientById(int patId);

	public abstract Patient[] getallPatients();
	
	public abstract ArrayList<Patient> findPatientByName(String firstname,String lastname,Date bday);
	
	public abstract boolean deleteAllPatients();

}