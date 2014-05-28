package pj2014.dbservices.implementations;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import pj2014.dbservices.interfaces.DocumentDBServiceRemote;
import pj2014.doclocreg.implementations.Document;

//Service-Klasse, die für die Kommunikation mit der Datenbank zuständig ist (Daten auslesen, speichern,...)
@Singleton
@Remote(DocumentDBServiceRemote.class)
public class DocumentDBService implements DocumentDBServiceRemote {

	@PersistenceContext(unitName = "patientenDB")
	EntityManager em;
	
	//CREATE
	/* (non-Javadoc)
	 * @see pj.mi.rest2014.services.DocumentDBServiceRemote#createDocument(pj.mi.rest2014.entities.Document)
	 */
	@Override
	public Document createDocument(Document d) 
	{
		em.persist(d);
		return d;
	}
	
	//READ
	/* (non-Javadoc)
	 * @see pj.mi.rest2014.services.DocumentDBServiceRemote#readDocument(int)
	 */
	@Override
	public Document readDocument(int docId)
	{
		return em.find(Document.class, docId);
	}
	
	//UPDATE
	//docId ändert sich nicht, versId vermutlich auch nicht. Kann sich userId ändern und soll creation bei Änderung geändert werden??
	/* (non-Javadoc)
	 * @see pj.mi.rest2014.services.DocumentDBServiceRemote#updateDocument(pj.mi.rest2014.entities.Document, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public boolean updateDocument(Document doc, String filename, String docType, String category, String content) 
	{
		Document aktDBDoc = em.find(Document.class, doc.getDocId()); //holt das aktuelle Dokument aus der DB 
			
			aktDBDoc.setFilename(filename);
			aktDBDoc.setDocType(docType);
			aktDBDoc.setCategory(category);
			aktDBDoc.setContent(content);

			return true;
	}
	
	//DELETE
	/* (non-Javadoc)
	 * @see pj.mi.rest2014.services.DocumentDBServiceRemote#deleteDocument(int)
	 */
	@Override
	public boolean deleteDocument(int docId)
	{
		em.remove(em.find(Document.class, docId));
		return true;
	}
	
	//FIND
	/* (non-Javadoc)
	 * @see pj.mi.rest2014.services.DocumentDBServiceRemote#findDocuments(java.lang.String, java.lang.String, java.util.Date, java.util.Date)
	 */

	public ArrayList<Document> findDocuments(String file, String category, String dtFrom, String dtUntil)
	{
		ArrayList<Document> docs= new ArrayList<Document>();
		try
		{
			em.getTransaction().begin();
			//To DO:Datenbank-Abfrage überprüfen und erweitern
			Query query= em.createQuery("SELECT doc FROM document doc WHERE filename=file");
			List list=query.getResultList();
			Iterator it=list.iterator();
			
			while (it.hasNext())
			{
				Document doc=(Document)it.next();
				docs.add(doc);
			}
			em.getTransaction().commit();
		}catch(Exception e)
		{ 
			System.out.println(e.getMessage()); //TO DO: sinnvolles Exception-Handling
		}
		finally 
		{
			em.close();
		}
		return docs;
	}

	@Override
	public boolean deleteAllDocuments() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
