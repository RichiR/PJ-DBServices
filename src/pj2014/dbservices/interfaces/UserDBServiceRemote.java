package pj2014.dbservices.interfaces;


import pj2014.patrepo.entities.User;

public interface UserDBServiceRemote {

  public abstract User createUser(User user);

  public abstract User updateUser(User us, String firstName, String lastName,
      String password);

  public abstract boolean deleteUser(int Userid);
  
  public abstract boolean deleteAllUsers();

}