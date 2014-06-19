package pj2014.dbservices.interfaces;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ejb.Remote;

import pj2014.doclocreg.implementations.Document;

@Remote
@Path("/DocumentDBService")
public interface DocumentDBServiceRemote {

	//CREATE
	@POST
	@Path("/createDoc")
	@Consumes("application/json")
	@Produces("application/json")
	public abstract Document createDocument(Document d);

	//READ
	@GET
	@Path("/readDoc")
	@Produces("application/json")
	public abstract Document readDocument(int docId);

	//UPDATE
	//docId ändert sich nicht, versId vermutlich auch nicht. Kann sich userId ändern und soll creation bei Änderung geändert werden??
	@PUT
	@Path("/updateDoc")
	@Consumes("application/json")
	public abstract boolean updateDocument(int docId, String filename,
			String docType, String category, String content);

	//DELETE
	@DELETE
	@Path("/deleteDoc")
	public abstract boolean deleteDocument(int docId);
	@DELETE
	@Path("/deleteAll")
	public abstract boolean deleteAllDocuments();
	//FIND
	@GET
	@Path("/findDocs")
	@Consumes("application/json")
	@Produces("application/json")
	public abstract ArrayList<Document> findDocuments(String file,
			String category, String dtFrom, String dtUntil);

}