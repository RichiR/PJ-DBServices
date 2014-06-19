package pj2014.dbservices.interfaces;

import java.util.ArrayList;

import javax.ejb.Remote;

import pj2014.doclocreg.implementations.Document;

@Remote
public interface DocumentDBServiceRemote {

	//CREATE
	public abstract Document createDocument(Document d);

	//READ
	public abstract Document readDocument(int docId);

	//UPDATE
	//docId �ndert sich nicht, versId vermutlich auch nicht. Kann sich userId �ndern und soll creation bei �nderung ge�ndert werden??
	public abstract boolean updateDocument(int docId, String filename,
			String docType, String category, String content);

	//DELETE
	public abstract boolean deleteDocument(int docId);
	public abstract boolean deleteAllDocuments();
	//FIND
	public abstract ArrayList<Document> findDocuments(String file,
			String category, String dtFrom, String dtUntil);

}