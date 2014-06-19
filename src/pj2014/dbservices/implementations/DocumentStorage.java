package pj2014.dbservices.implementations;

import java.util.ArrayList;

import javax.ejb.EJB;
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

import pj2014.dbservices.interfaces.DocumentDBServiceRemote;
import pj2014.dbservices.interfaces.IDocumentStorage;
import pj2014.doclocreg.implementations.Document;


@Singleton
public class DocumentStorage implements IDocumentStorage{
	
	@EJB
	DocumentDBServiceRemote docServ;
	
	
	public Document getDocument(@PathParam("docId") int docId) {
		
		Document result = docServ.readDocument(docId);
		return result;
	}

	
	public Document createDocument(Document doc) 
	{ 	
		System.out.println("DocumentStorage: im create Doc");
		Document result = docServ.createDocument(doc);
		return result;
	}

	
	
	//docId �ndert sich nicht, versId vermutlich auch nicht. Kann sich userId �ndern und soll creation bei �nderung ge�ndert werden??
	public Document changeDocument(int docId, String filename, String docType, String category, String content) {
		Document result = new Document();
		docServ.updateDocument(docId, filename, docType, category, content);
		return result;
	}

	
	public boolean deleteDocument (int docId)
	{
		return docServ.deleteDocument(docId);
	}
	
	//http://localhost:8080/einstieg2014/rest/DocumentStorage/findDocs?filename=Arztbrief&category=Sonographie&DtFrom=2010-12-02%200000:00:00&DtUntil2010-12-04%200000:00:00
	//Wo ist der Fehler? :/
	
	public Document[] findDocuments (@QueryParam("filename") String filename, @QueryParam ("category") String category,@QueryParam ("dtFrom") String dtFrom, @QueryParam ("dtUntil") String dtUntil)
	{
		ArrayList<Document> docs= docServ.findDocuments(filename, category, dtFrom, dtUntil);
		return docs.toArray(new Document[docs.size()]);
	}


}
