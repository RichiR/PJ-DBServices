package pj2014.dbservices.implementations;



import javax.ejb.Remote;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Singleton
@Remote(UserDBServiceRemote.class)
public class UserDBService implements UserDBServiceRemote {
	
	@PersistenceContext(unitName = "patientenDB")
	EntityManager em;
	
	
	/* (non-Javadoc)
   * @see pj.mi.rest2014.services.UserDBServiceRemote#createUser(pj.mi.rest2014.entities.User)
   */
	@Override
  public User createUser(User user) {
		em.persist(user);
		return user;
	}
	
	
	/* (non-Javadoc)
   * @see pj.mi.rest2014.services.UserDBServiceRemote#updateUser(pj.mi.rest2014.entities.User, java.lang.String, java.lang.String, java.lang.String)
   */
	@Override
  public User updateUser(User us, String firstName, String lastName, String password)
	{
		User aktDBUser = em.find(User.class, us.getUserId()); //gets the pat in the db
		em.getTransaction().begin();
		aktDBUser.setUserFirstName(firstName);
		aktDBUser.setUserName(lastName);
		aktDBUser.setPassword(password);
		em.getTransaction().commit();
		return aktDBUser;
	}
	
	/* (non-Javadoc)
   * @see pj.mi.rest2014.services.UserDBServiceRemote#deleteUser(int)
   */
	@Override
  public boolean deleteUser(int Userid) {
		em.remove(em.find(User.class, Userid));
		return true;
	}

}
