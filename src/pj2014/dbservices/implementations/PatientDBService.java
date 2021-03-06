package pj2014.dbservices.implementations;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import javax.ws.rs.Produces;

import pj2014.dbservices.interfaces.PatientDBServiceRemote;
import pj2014.patrepo.interfaces.*;
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
	public Patient updatePatient(Patient pat, String firstName, String lastName, boolean gender, String bBDay)
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
		//return new Patient[42];
	    Query findPats=em.createQuery("SELECT p FROM " + Patient.class.getName() + " p");
	    ArrayList<Patient> foundPatients = new ArrayList<Patient>(findPats.getResultList());    
		    return (Patient[]) foundPatients.toArray();
	}


	@Override
	public ArrayList<Patient> findPatientByName(String firstname,
			String lastname, String bday) {
		Query foundPat=em.createQuery("SELECT p FROM Patient p WHERE p.firstName = :firstname AND p.name = :lastname AND p.birthDate = :bday ");
		foundPat.setParameter("firstname", firstname);
		foundPat.setParameter("lastname", lastname);
		foundPat.setParameter("bday", bday);
		ArrayList<Patient> foundPatients = new ArrayList<Patient>(foundPat.getResultList());
		
		return foundPatients;
	}

	@Override
	public boolean deleteAllPatients() {
		// TODO Auto-generated method stub
		return false;
	}

}
