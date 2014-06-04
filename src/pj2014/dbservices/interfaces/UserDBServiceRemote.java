package pj2014.dbservices.interfaces;


public interface UserDBServiceRemote {

  public abstract User createUser(User user);

  public abstract User updateUser(User us, String firstName, String lastName,
      String password);

  public abstract boolean deleteUser(int Userid);
  
  public abstract boolean deleteAllUsers();

}