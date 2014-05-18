package pj2014.dbservices.interfaces;

import java.util.ArrayList;
import java.util.Date;

import javax.ejb.Remote;

import pj.mi.rest2014.entities.Document;

@Remote
public interface DocumentDBServiceRemote {

	//CREATE
	public abstract Document createDocument(Document d);

	//READ
	public abstract Document readDocument(int docId);

	//UPDATE
	//docId ändert sich nicht, versId vermutlich auch nicht. Kann sich userId ändern und soll creation bei Änderung geändert werden??
	public abstract boolean updateDocument(Document doc, String filename,
			String docType, String category, String content);

	//DELETE
	public abstract boolean deleteDocument(int docId);
	public abstract boolean deleteAllDocuments();
	//FIND
	public abstract ArrayList<Document> findDocuments(String file,
			String category, String dtFrom, String dtUntil);

}