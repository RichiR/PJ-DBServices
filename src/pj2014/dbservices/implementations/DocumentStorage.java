package pj2014.dbservices.implementations;

import java.text.ParseException;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import pj2014.dbservices.interfaces.*;



public class DocumentStorage implements IDocumentStorage{
	
	@EJB
	DocumentDBServiceRemote docServ;
	
	@GET
	@Path("/getDoc/{docId}")
	@Produces("application/json")
	public Document getDocument(@PathParam("docId") int docId) {
		
		Document result = docServ.readDocument(docId);
		return result;
	}

	@POST
	@Consumes("application/json")
	@Produces("application/json")
	@Path("/createDoc")
	public Document createDocument(Document doc) 
	{ 
		Document result = docServ.createDocument(doc);
		return result;
	}

	
	@PUT
	@Path("/changeDoc")
	//docId �ndert sich nicht, versId vermutlich auch nicht. Kann sich userId �ndern und soll creation bei �nderung ge�ndert werden??
	public Document changeDocument(Document doc, String filename, String docType, String category, String content) {
		Document result = new Document();
		docServ.updateDocument(doc, filename, docType, category, content);
		return result;
	}

	@DELETE
	@Path("/deleteDoc")
	public boolean deleteDocument (int docId)
	{
		return docServ.deleteDocument(docId);
	}
	
	//http://localhost:8080/einstieg2014/rest/DocumentStorage/findDocs?filename=Arztbrief&category=Sonographie&DtFrom=2010-12-02%200000:00:00&DtUntil2010-12-04%200000:00:00
	//Wo ist der Fehler? :/
	@GET
	@Path("/findDocs")
	@Produces ("application/json")
	public Document[] findDocuments (@QueryParam("filename") String filename, @QueryParam ("category") String category,@QueryParam ("dtFrom") String dtFrom, @QueryParam ("dtUntil") String dtUntil) throws ParseException
	{
		ArrayList<Document> docs= docServ.findDocuments(filename, category, dtFrom, dtUntil);
		return docs.toArray(new Document[docs.size()]);
	}


}
