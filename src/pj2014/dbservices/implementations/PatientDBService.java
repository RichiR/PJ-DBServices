package pj2014.dbservices.implementations;

import java.util.ArrayList;
import java.util.Date;

import javax.ejb.Remote;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import pj2014.dbservices.interfaces.PatientDBServiceRemote;
import pj2014.patrepo.entities.Patient;



/*
 *Patient C-R-U-D
 * */
@Singleton
@Remote(PatientDBServiceRemote.class)
public class PatientDBService implements PatientDBServiceRemote {

	@PersistenceContext(unitName = "patientenDB")
	EntityManager em;

	// create
	/* (non-Javadoc)
	 * @see pj.mi.rest2014.services.PatientDBServiceRemote#createPatient(pj.mi.rest2014.entities.Patient)
	 */
	@Override
	public Patient createPatient(Patient pat) {
	  em.persist(pat); // wirft NullPointerException; auch wenn pat valide ist
	  return pat;
	}
	
	//hier fehlt noch die read-Funktion, oder??

	//update
	/* (non-Javadoc)
	 * @see pj.mi.rest2014.services.PatientDBServiceRemote#updatePatient(pj.mi.rest2014.entities.Patient, java.lang.String, java.lang.String, boolean, java.util.Date)
	 */
	@Override
	public Patient updatePatient(Patient pat, String firstName, String lastName, boolean gender, Date bBDay)
	{	
		Patient aktDBPat = em.find(Patient.class, pat.getId());
		em.getTransaction().begin();
		aktDBPat.setFirstName(firstName);
		aktDBPat.setName(lastName);
		aktDBPat.setBirthDate(bBDay);
		aktDBPat.setGender(gender);
		em.getTransaction().commit();
		return aktDBPat;
		
	}

	
	/* (non-Javadoc)
	 * @see pj.mi.rest2014.services.PatientDBServiceRemote#findPatientById(int)
	 */
	@Override
	public Patient findPatientById(int patId)
	{
		return em.find(Patient.class, patId);
	}
	
	/* (non-Javadoc)
	 * @see pj.mi.rest2014.services.PatientDBServiceRemote#getallPatients()
	 */
	@Override
	public Patient[] getallPatients()
	{
		return new Patient[42];
	}

	@Override
	public ArrayList<Patient> findPatientByName(String firstname,
			String lastname, Date bday) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteAllPatients() {
		// TODO Auto-generated method stub
		return false;
	}

}
