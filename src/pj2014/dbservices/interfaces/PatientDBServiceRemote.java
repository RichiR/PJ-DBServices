package pj2014.dbservices.interfaces;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import javax.ejb.Remote;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import pj2014.dbservices.implementations.*;
import pj2014.patrepo.entities.Patient;

@Remote
@Path("/PatientDBService")
public interface PatientDBServiceRemote {

	// create
	@POST
	@Path("/createPat")
	@Consumes("application/json")
	@Produces("application/json")
	public abstract Patient createPatient(Patient pat);

	//update
	@PUT
	@Path("/updatePat")
	@Consumes("application/json")
	@Produces("application/json")
	public abstract Patient updatePatient(Patient pat, String firstName,
			String lastName, String gender, String bBDay);

	@GET
	@Path("/findPatId")
	@Produces("application/json")
	@Consumes("application/json")
	public abstract Patient findPatientById(int patId);

	@GET
	@Path("/getAllPats")
	@Produces("application/json")
	public abstract Patient[] getallPatients();
	
	@GET
	@Path("/findPatsName")
	@Produces("application/json")
	@Consumes("application/json")
	public abstract ArrayList<Patient> findPatientByName(String firstname,String lastname,String bday);
	
	@DELETE
	@Path("/deleteAllPats")
	public abstract boolean deleteAllPatients();
	
	
}
