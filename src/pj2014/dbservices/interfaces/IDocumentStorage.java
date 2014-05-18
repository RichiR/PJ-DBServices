package pj2014.dbservices.interfaces;

import javax.ejb.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;


@Singleton
@Path("/DocumentStorage")
public interface IDocumentStorage {
	
	@GET
	@Path("/{docId}")
	@Produces("application/json")
	public String getDocument(@PathParam("docId") int docId);
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	@Path("/createDoc")
	public Document createDocument(Document doc);
	
	@PUT
	@Path("/changeDoc")
	public Document changeDocument(Document doc, String filename, String docType, String category, String content);
	
	@DELETE
	@Path("/deleteDoc")
	public boolean deleteDocument (int docId);
	
	@GET
	@Path("/findDocs")
	@Produces ("application/json")
	public Document[] findDocuments (@QueryParam("filename") String filename, @QueryParam ("category") String category,@QueryParam ("dtFrom") String dtFrom, @QueryParam ("dtUntil") String dtUntil);
	
}